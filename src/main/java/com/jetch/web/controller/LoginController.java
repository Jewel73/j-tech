package com.jetch.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    public String Login(){
        String value = "manyame";
        int roll = 12;
        return "Login Success";
    }
}
