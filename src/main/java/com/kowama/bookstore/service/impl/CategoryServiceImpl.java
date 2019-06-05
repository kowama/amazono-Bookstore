/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 8 : 16
 * Project : bookstore
 * Class : CategoryServiceImpl
 * Last modified : 6/4/19 8:16 AM
 */

package com.kowama.bookstore.service.impl;

import com.kowama.bookstore.domain.Category;
import com.kowama.bookstore.repository.CategoryRepository;
import com.kowama.bookstore.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger LOG = Logger.getLogger(BillingAddressServiceImpl.class.getName());
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        if (findByName(category.getName()) != null) {
            String msg = "Category with name: " + category.getName() + " already exist";
            LOG.warning(msg);
            throw new IllegalArgumentException(msg);
        }

        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
