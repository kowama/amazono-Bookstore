/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 8 : 12
 * Project : bookstore
 * Class : DbInit
 * Last modified : 6/3/19 1:55 PM
 */

package com.kowama.bookstore.utils;

import com.kowama.bookstore.domain.Category;
import com.kowama.bookstore.domain.security.Role;
import com.kowama.bookstore.service.CategoryService;
import com.kowama.bookstore.service.RoleService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DbInit implements ApplicationRunner {
    private static final Logger LOG = Logger.getLogger(DbInit.class.getName());
    private final RoleService _roleService;
    private final CategoryService _categoryService;

    public DbInit(RoleService roleService, CategoryService categoryService) {
        _roleService = roleService;
        _categoryService = categoryService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            _roleService.create(new Role(RoleName.USER));
            _roleService.create(new Role(RoleName.MANAGER));
            _roleService.create(new Role(RoleName.ADMIN));

        } catch (Exception e) {
            LOG.warning(e.getMessage());

        }

        try {
            _categoryService.create(new Category("Art,Music & Photography", ""));
            _categoryService.create(new Category("Biography", ""));
            _categoryService.create(new Category("Business", ""));
            _categoryService.create(new Category("Computers & Tech", ""));
            _categoryService.create(new Category("Cooking", ""));
            _categoryService.create(new Category("Hobbies & Craft", ""));
            _categoryService.create(new Category("Edu & Reference", ""));
            _categoryService.create(new Category("Health & Fitness", ""));
            _categoryService.create(new Category("History", ""));
            _categoryService.create(new Category("Home & Garden", ""));
            _categoryService.create(new Category("Horror", ""));
            _categoryService.create(new Category("Literature & Fiction", ""));
            _categoryService.create(new Category("Kids", ""));
            _categoryService.create(new Category("Medical", ""));
            _categoryService.create(new Category("Mysteries", ""));
            _categoryService.create(new Category("Parenting", ""));
            _categoryService.create(new Category("Religion", ""));
            _categoryService.create(new Category("Romance", ""));
            _categoryService.create(new Category("Social Science", ""));
            _categoryService.create(new Category("Sport", ""));
            _categoryService.create(new Category("Science & Math", ""));
            _categoryService.create(new Category("Sci-Fi & Fantasy", ""));
            _categoryService.create(new Category("Travel", ""));
            _categoryService.create(new Category("Teen", ""));
            _categoryService.create(new Category("Western", ""));
            _categoryService.create(new Category("Other", ""));
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }
    }
}