package com.jetch.web.controller;

import com.jetch.web.entity.User;
import com.jetch.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initUserRoles(){
        userService.initUserRoles();
    }

    @GetMapping({"/log"})
    public String test(){
        return "Testing controller";
    }

    @GetMapping({"/createNewUser"})
    public User createNewUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
