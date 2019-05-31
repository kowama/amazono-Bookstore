/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  5/30/2019
 * Time : 12 : 46
 * Project : bookstore
 * Class : UserService
 * Last modified : 5/30/19 12:46 PM
 */

package com.kowama.bookstore.service;

import com.kowama.bookstore.domain.User;

public interface UserService {

    User create(User user);

    User Save(User user);

    User findByUsername(String name);

    User findByEmail(String email);

}
