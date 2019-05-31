/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  5/30/2019
 * Time : 10 : 22
 * Project : bookstore
 * Class : HomeController
 * Last modified : 5/30/19 10:20 AM
 */

package com.kowama.bookstore.controller;

import com.kowama.bookstore.domain.User;
import com.kowama.bookstore.service.RoleService;
import com.kowama.bookstore.service.UserService;
import com.kowama.bookstore.utils.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class HomeController {
    private Logger LOG = Logger.getLogger(HomeController.class.getName());

    private final UserService _userService;
    private final RoleService _roleService;

    @Autowired
    public HomeController(UserService _userService, RoleService roleService) {
        this._userService = _userService;
        this._roleService = roleService;
    }

    @RequestMapping("/")
    public String index(Model model)  {
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
            model.addAttribute("singUpErrors", true);
            LOG.info("validation errors for " + user.toString());

            return "index";
        }
        try {
            user.addRole(_roleService.findByName(RoleName.USER));
            _userService.create(user);
        } catch (Exception e) {
            model.addAttribute("error-msg", e.getMessage());
            LOG.info(e.getMessage());
            return "index";
        }


        model.addAttribute("user", user);
        return "members/profile";
    }

}
