package com.sha.springbootbookseller.services;

import com.sha.springbootbookseller.model.User;

public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
