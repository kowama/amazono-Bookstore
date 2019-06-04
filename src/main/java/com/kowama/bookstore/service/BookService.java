/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/3/2019
 * Time : 13 : 55
 * Project : bookstore
 * Class : BookService
 * Last modified : 6/3/19 1:36 PM
 */

package com.kowama.bookstore.service;

import com.kowama.bookstore.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    Optional<Book> findById(Long id);
}
