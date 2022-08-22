package com.jetch.web.configuration;

import com.jetch.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private  UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.jetch.web.entity.User user= userDao.findById(username).get();

        return new User(user.getUserName(), user.getPassword(), Set.of());
    }
}
