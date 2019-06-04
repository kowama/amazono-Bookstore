/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 7
 * Project : bookstore
 * Class : OrderRepository
 * Last modified : 1/8/17 9:20 PM
 */

package com.kowama.bookstore.repository;

import com.kowama.bookstore.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
