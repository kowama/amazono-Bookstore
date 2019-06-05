/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 8 : 18
 * Project : bookstore
 * Class : CategoryRepository
 * Last modified : 6/4/19 8:18 AM
 */

package com.kowama.bookstore.repository;

import com.kowama.bookstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}
