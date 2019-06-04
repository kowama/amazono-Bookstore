/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 1
 * Project : bookstore
 * Class : OrderService
 * Last modified : 1/8/17 9:18 PM
 */

package com.kowama.bookstore.service;


import com.kowama.bookstore.domain.*;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart,
					  ShippingAddress shippingAddress,
					  BillingAddress billingAddress,
					  Payment payment,
					  String shippingMethod,
					  User user);
	
	Order findOne(Long id);
}
