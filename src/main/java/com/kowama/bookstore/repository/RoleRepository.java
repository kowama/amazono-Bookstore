/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  5/30/2019
 * Time : 18 : 1
 * Project : bookstore
 * Class : RoleRepository
 * Last modified : 5/30/19 6:01 PM
 */

package com.kowama.bookstore.repository;

import com.kowama.bookstore.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
