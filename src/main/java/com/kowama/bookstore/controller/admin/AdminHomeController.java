/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/3/2019
 * Time : 13 : 55
 * Project : bookstore
 * Class : AdminHomeController
 * Last modified : 6/1/19 9:59 PM
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
        return "admin/login";
    }
}
