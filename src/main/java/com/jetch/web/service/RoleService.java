package com.jetch.web.service;

import com.jetch.web.dao.RoleDao;
import com.jetch.web.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;
    public Role createRole(Role role){
        return roleDao.save(role);
    }
}
