/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/1/2019
 * Time : 2 : 35
 * Project : bookstore
 * Class : BookService
 * Last modified : 1/6/17 3:29 PM
 */

package com.kowama.bookstore.service;

import com.kowama.bookstore.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    Page<Book> findAll(Pageable pageable);
}
