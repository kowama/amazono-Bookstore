/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 1
 * Project : bookstore
 * Class : ShippingAddressService
 * Last modified : 1/8/17 6:54 PM
 */

package com.kowama.bookstore.service;


import com.kowama.bookstore.domain.ShippingAddress;
import com.kowama.bookstore.domain.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
