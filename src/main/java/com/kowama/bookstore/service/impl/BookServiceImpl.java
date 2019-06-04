/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/3/2019
 * Time : 13 : 55
 * Project : bookstore
 * Class : BookServiceImpl
 * Last modified : 6/3/19 1:36 PM
 */

package com.kowama.bookstore.service.impl;

import com.kowama.bookstore.domain.Book;
import com.kowama.bookstore.repository.BookRepository;
import com.kowama.bookstore.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository _bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        _bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return _bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return _bookRepository.findAll();
    }
    public Page<Book> findAll(Pageable pageable){
        return _bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return _bookRepository.findById(id);
    }
}
