package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.model.User;

import java.util.Optional;

public interface IUserServices {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);
}
