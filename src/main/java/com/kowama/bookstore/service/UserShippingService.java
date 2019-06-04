/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 1
 * Project : bookstore
 * Class : UserShippingService
 * Last modified : 1/7/17 8:27 PM
 */

package com.kowama.bookstore.service;


import com.kowama.bookstore.domain.UserShipping;

public interface UserShippingService {
    UserShipping findById(Long id);

    void removeById(Long id);
}
