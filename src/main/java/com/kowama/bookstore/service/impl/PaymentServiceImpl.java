/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 4
 * Project : bookstore
 * Class : PaymentServiceImpl
 * Last modified : 1/8/17 7:02 PM
 */

package com.kowama.bookstore.service.impl;

import com.kowama.bookstore.domain.Payment;
import com.kowama.bookstore.domain.UserPayment;
import com.kowama.bookstore.service.PaymentService;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements PaymentService {

    public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
        payment.setType(userPayment.getType());
        payment.setHolderName(userPayment.getHolderName());
        payment.setCardNumber(userPayment.getCardNumber());
        payment.setExpiryMonth(userPayment.getExpiryMonth());
        payment.setExpiryYear(userPayment.getExpiryYear());
        payment.setCvc(userPayment.getCvc());

        return payment;
    }

}
