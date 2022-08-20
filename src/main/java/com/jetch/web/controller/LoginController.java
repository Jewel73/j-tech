package com.jetch.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String Login(){
        return "Login Success";
    }

    @GetMapping("/logout")
    public String logout(){
        return "Login Success";
    }
}
