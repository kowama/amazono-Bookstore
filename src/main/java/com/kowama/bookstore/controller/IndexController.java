/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/3/2019
 * Time : 13 : 55
 * Project : bookstore
 * Class : IndexController
 * Last modified : 6/1/19 12:01 PM
 */

package com.kowama.bookstore.controller;

import com.kowama.bookstore.domain.User;
import com.kowama.bookstore.service.RoleService;
import com.kowama.bookstore.service.UserService;
import com.kowama.bookstore.utils.RoleName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class IndexController {
    private Logger LOG = Logger.getLogger(IndexController.class.getName());

    private final UserService _userService;
    private final RoleService _roleService;

    public IndexController(UserService userService, RoleService roleService) {
        _userService = userService;
        _roleService = roleService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";

    }

    @GetMapping("/login")
    public String login() {
        return "redirect:/";
    }

    @PostMapping("/signup")
    public String singUp(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            LOG.info("validation errors for " + user.toString());
            model.addAttribute("signUpError", "* Information validation error");
            return "index";
        }
        try {
            user.addRole(_roleService.findByName(RoleName.USER));
            _userService.create(user);
        } catch (Exception e) {
            model.addAttribute("signUpError", e.getMessage());
            LOG.info(e.getMessage());
            return "index";
        }

        model.addAttribute("user", user);
        return "members/profile";
    }

    @GetMapping("/forget-password")
    public String forgetPassword(Model model) {
        model.addAttribute("user", new User());
        return "passwordReset";

    }

}
