/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  5/30/2019
 * Time : 18 : 7
 * Project : bookstore
 * Class : RoleServiceImpl
 * Last modified : 5/30/19 6:07 PM
 */

package com.kowama.bookstore.service.impl;

import com.kowama.bookstore.domain.security.Role;
import com.kowama.bookstore.repository.RoleRepository;
import com.kowama.bookstore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository _roleRepository;


    @Override
    public Role create(Role role) {
        if (findByName(role.getName()) != null) {
            throw new IllegalArgumentException("Role name Exist : "+ role.getName());
        }
        return _roleRepository.save(role);
    }

    @Override
    public Role Save(Role role) {
        return _roleRepository.save(role);
    }

    @Override
    public Role findByName(String name) {
        return _roleRepository.findByName(name);
    }

    @Override
    public Collection<Role> findAll() {
        return _roleRepository.findAll();
    }
}
