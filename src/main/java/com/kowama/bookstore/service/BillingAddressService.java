/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 1
 * Project : bookstore
 * Class : BillingAddressService
 * Last modified : 1/8/17 7:02 PM
 */

package com.kowama.bookstore.service;


import com.kowama.bookstore.domain.BillingAddress;
import com.kowama.bookstore.domain.UserBilling;

public interface BillingAddressService {
    BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
