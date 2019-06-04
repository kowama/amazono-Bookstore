/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 7
 * Project : bookstore
 * Class : UserShippingRepository
 * Last modified : 1/7/17 8:16 PM
 */

package com.kowama.bookstore.repository;


import com.kowama.bookstore.domain.UserShipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserShippingRepository extends JpaRepository<UserShipping, Long> {
	
	

}
