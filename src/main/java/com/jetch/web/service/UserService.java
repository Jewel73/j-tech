package com.jetch.web.service;

import com.jetch.web.dao.RoleDao;
import com.jetch.web.dao.UserDao;
import com.jetch.web.entity.Role;
import com.jetch.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User createUser(User user){
        return userDao.save(user);
    }

    public void initUserRoles(){
        Role adminRole = new Role("ADMIN", "Admin role");
        Role userRole = new Role("USER", "User role default");
        roleDao.saveAll(List.of(adminRole, userRole));

        User adminUser = new User("jewel","jewel", "rana", "jewel123", Set.of(adminRole, userRole));
        User user = new User("sohel","sohel", "islam", "sohel", Set.of(userRole));

        userDao.saveAll(List.of(adminUser, user));
//        User admin = new User();
//        admin.setUserName("adminUser");
//        admin.setFirstName("jewel");
//        admin.setLastName("rana");
//        admin.setPassword("abcd");
//        Set<Role> roles = new HashSet<>();
//        roles.add(adminRole);
//        admin.setRoles(roles);
//
//        userDao.save(admin);
    }
}
