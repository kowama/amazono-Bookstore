/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 7
 * Project : bookstore
 * Class : BookToCartItemRepository
 * Last modified : 1/8/17 10:00 AM
 */

package com.kowama.bookstore.repository;

import com.kowama.bookstore.domain.BookToCartItem;
import com.kowama.bookstore.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookToCartItemRepository extends JpaRepository<BookToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
