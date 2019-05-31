/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  5/30/2019
 * Time : 18 : 4
 * Project : bookstore
 * Class : RoleService
 * Last modified : 5/30/19 6:04 PM
 */

package com.kowama.bookstore.service;

import com.kowama.bookstore.domain.security.Role;

import java.util.Collection;

public interface RoleService {
    Role create(Role role);

    Role Save(Role role);

    Role findByName(String name);

    Collection<Role> findAll();

}
