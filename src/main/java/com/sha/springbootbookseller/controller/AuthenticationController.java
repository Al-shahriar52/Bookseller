package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.services.IAuthenticationService;
import com.sha.springbootbookseller.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication") //pre path
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserServices userServices ;

    @PostMapping("sign-up")

    public ResponseEntity<User> signUp(@RequestBody User user){if (userServices.findByUsername(user.getUsername()).isPresent())
    {
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
        return new ResponseEntity<>(userServices.saveUser(user), HttpStatus.CREATED);


    }

    @PostMapping("sign-in")

    public ResponseEntity<User> signIn(@RequestBody User user)
    {
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }

}
