package com.sha.springbootbookseller.security;

import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.services.IUserServices;
import com.sha.springbootbookseller.utill.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private IUserServices userServices;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userServices.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(username));
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAutority(user.getRole().name()));
        return UserPrincipal.builder()
                .user(user).id(user.getId())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }


}
