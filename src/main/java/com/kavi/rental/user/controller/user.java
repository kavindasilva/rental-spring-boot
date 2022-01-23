package com.kavi.rental.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class user {
    @RequestMapping("/")
    public String hello()
    {
        return "Demo User";
    }
}

