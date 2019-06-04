/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 7
 * Project : bookstore
 * Class : ShoppingCartRepository
 * Last modified : 1/7/17 11:03 PM
 */

package com.kowama.bookstore.repository;

import com.kowama.bookstore.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
