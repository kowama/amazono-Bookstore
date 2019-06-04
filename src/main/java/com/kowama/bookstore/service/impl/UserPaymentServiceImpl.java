/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 4
 * Project : bookstore
 * Class : UserPaymentServiceImpl
 * Last modified : 1/7/17 6:14 PM
 */

package com.kowama.bookstore.service.impl;

import com.kowama.bookstore.domain.UserPayment;
import com.kowama.bookstore.repository.UserPaymentRepository;
import com.kowama.bookstore.service.UserPaymentService;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl implements UserPaymentService {

    private final UserPaymentRepository userPaymentRepository;

    public UserPaymentServiceImpl(UserPaymentRepository userPaymentRepository) {
        this.userPaymentRepository = userPaymentRepository;
    }


    @Override
    public UserPayment findById(Long id) {
        return userPaymentRepository.getOne(id);
    }

    @Override
    public void removeById(Long id) {

    }
}
