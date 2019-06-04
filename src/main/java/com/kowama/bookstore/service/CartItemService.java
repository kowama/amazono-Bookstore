/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 1
 * Project : bookstore
 * Class : CartItemService
 * Last modified : 1/9/17 8:20 AM
 */

package com.kowama.bookstore.service;

import com.kowama.bookstore.domain.*;

import java.util.List;


public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addBookToCartItem(Book book, User user, int qty);
	
	CartItem findById(Long id);
	
	void removeCartItem(CartItem cartItem);
	
	CartItem save(CartItem cartItem);
	
	List<CartItem> findByOrder(Order order);
}
