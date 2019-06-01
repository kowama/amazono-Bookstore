/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/1/2019
 * Time : 2 : 33
 * Project : bookstore
 * Class : BookRepository
 * Last modified : 1/6/17 3:31 PM
 */

package com.kowama.bookstore.repository;

import com.kowama.bookstore.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
