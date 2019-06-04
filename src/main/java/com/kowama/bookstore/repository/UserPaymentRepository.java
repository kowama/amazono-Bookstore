/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 7
 * Project : bookstore
 * Class : UserPaymentRepository
 * Last modified : 1/7/17 5:55 PM
 */

package com.kowama.bookstore.repository;

import com.kowama.bookstore.domain.UserPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPaymentRepository extends JpaRepository<UserPayment, Long> {

}
