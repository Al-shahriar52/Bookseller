package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.model.Role;
import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements IUserServices {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override

    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreatTime(LocalDateTime.now());

        return userRepository.save(user);

    }
    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void makeAdmin(String username){
        userRepository.updateUserRole(username ,Role.ADMIN);
    }
}
