/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 1
 * Project : bookstore
 * Class : ShoppingCartService
 * Last modified : 1/8/17 10:00 PM
 */

package com.kowama.bookstore.service;


import com.kowama.bookstore.domain.ShoppingCart;

public interface ShoppingCartService {
	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
	
	void clearShoppingCart(ShoppingCart shoppingCart);
}
