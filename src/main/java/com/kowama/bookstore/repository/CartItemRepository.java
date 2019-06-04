/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 7
 * Project : bookstore
 * Class : CartItemRepository
 * Last modified : 1/9/17 8:21 AM
 */

package com.kowama.bookstore.repository;

import com.kowama.bookstore.domain.CartItem;
import com.kowama.bookstore.domain.Order;
import com.kowama.bookstore.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	List<CartItem> findByOrder(Order order);
}
