package com.jetch.web.controller;

import com.jetch.web.entity.Role;
import com.jetch.web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role){
        return roleService.createRole(role);
    }
}
