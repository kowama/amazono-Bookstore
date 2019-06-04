/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 4
 * Project : bookstore
 * Class : UserShippingServiceImpl
 * Last modified : 1/7/17 8:28 PM
 */

package com.kowama.bookstore.service.impl;

import com.kowama.bookstore.domain.UserShipping;
import com.kowama.bookstore.repository.UserShippingRepository;
import com.kowama.bookstore.service.UserShippingService;
import org.springframework.stereotype.Service;


@Service
public class UserShippingServiceImpl implements UserShippingService {

    private final UserShippingRepository userShippingRepository;

    public UserShippingServiceImpl(UserShippingRepository userShippingRepository) {
        this.userShippingRepository = userShippingRepository;
    }


    @Override
    public UserShipping findById(Long id) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }
}
