/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/1/2019
 * Time : 2 : 32
 * Project : bookstore
 * Class : HomeController
 * Last modified : 1/5/17 8:19 PM
 */

package com.kowama.bookstore.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    @RequestMapping("")
    public String index() {
        return "redirect:/admin/home";
    }

    @RequestMapping("/home")
    public String home() {
        return "admin/home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
