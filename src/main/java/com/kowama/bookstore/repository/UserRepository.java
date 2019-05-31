/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  5/30/2019
 * Time : 12 : 16
 * Project : bookstore
 * Class : UserRepository
 * Last modified : 5/30/19 12:16 PM
 */

package com.kowama.bookstore.repository;

import com.kowama.bookstore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);
}
