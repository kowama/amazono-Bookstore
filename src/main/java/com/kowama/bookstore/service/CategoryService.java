/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 8 : 13
 * Project : bookstore
 * Class : CategoryService
 * Last modified : 6/4/19 8:13 AM
 */

package com.kowama.bookstore.service;

import com.kowama.bookstore.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category create(Category category);

    Optional<Category> findById(int id);

    Category findByName(String name);

    List<Category> findAll();
}
