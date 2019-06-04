/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/3/2019
 * Time : 13 : 55
 * Project : bookstore
 * Class : BookstoreApplication
 * Last modified : 5/30/19 6:39 PM
 */

package com.kowama.bookstore;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication implements ApplicationRunner {


    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) {

    }
}
