/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  5/30/2019
 * Time : 12 : 51
 * Project : bookstore
 * Class : UserServiceImpl
 * Last modified : 1/5/17 6:15 PM
 */

package com.kowama.bookstore.service.impl;

import com.kowama.bookstore.domain.User;
import com.kowama.bookstore.repository.UserRepository;
import com.kowama.bookstore.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository _userRepository;
    private final PasswordEncoder _passwordEncoder;

    public UserServiceImpl(UserRepository _userRepository, PasswordEncoder _passwordEncoder) {
        this._userRepository = _userRepository;
        this._passwordEncoder = _passwordEncoder;
    }

    @Override
    public User create(User user) throws IllegalArgumentException {
        if (_userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username Already exist");
        }
        user.setPassword(_passwordEncoder.encode(user.getPassword()));

        return _userRepository.save(user);

    }

    @Override
    public User Save(User user) {
        return _userRepository.save(user);
    }

    @Override
    public User findByUsername(String name) {
        return _userRepository.findByUsername(name);
    }

    @Override
    public User findByEmail(String email) {
        return _userRepository.findByEmail(email);
    }
}
