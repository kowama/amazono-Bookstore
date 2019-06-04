/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 1
 * Project : bookstore
 * Class : PaymentService
 * Last modified : 1/8/17 6:59 PM
 */

package com.kowama.bookstore.service;


import com.kowama.bookstore.domain.Payment;
import com.kowama.bookstore.domain.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
