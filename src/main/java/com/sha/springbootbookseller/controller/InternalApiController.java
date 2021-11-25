package com.sha.springbootbookseller.controller;

import com.sha.springbootbookseller.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/internal")
public class InternalApiController {

    @Autowired
    private IUserServices userServices;

    public
}
