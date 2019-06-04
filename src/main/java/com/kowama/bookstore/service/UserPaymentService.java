/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 21
 * Project : bookstore
 * Class : UserPaymentService
 * Last modified : 1/7/17 6:14 PM
 */

package com.kowama.bookstore.service;


import com.kowama.bookstore.domain.UserPayment;

public interface UserPaymentService {
    UserPayment findById(Long id);

    void removeById(Long id);
}
