/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  5/30/2019
 * Time : 18 : 14
 * Project : bookstore
 * Class : DbInit
 * Last modified : 5/30/19 6:13 PM
 */

package com.kowama.bookstore.service.impl;

import com.kowama.bookstore.domain.security.Role;
import com.kowama.bookstore.service.RoleService;
import com.kowama.bookstore.utils.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DbInit implements ApplicationRunner {
    public static final Logger LOG = Logger.getLogger(DbInit.class.getName());
    private RoleService _roleService;

    @Autowired
    public DbInit(RoleService roleService) {
        this._roleService = roleService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            _roleService.create(new Role(RoleName.USER));
            _roleService.create(new Role(RoleName.MANAGER));
            _roleService.create(new Role(RoleName.ADMIN));
        } catch (Exception e) {
            LOG.warning(e.getMessage());

        }
    }
}