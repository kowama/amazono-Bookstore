/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  5/30/2019
 * Time : 18 : 53
 * Project : bookstore
 * Class : MembersController
 * Last modified : 5/30/19 6:53 PM
 */

package com.kowama.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MembersController {
    @GetMapping("/profile")
    public String profile() {
        return "members/profile";
    }
}
