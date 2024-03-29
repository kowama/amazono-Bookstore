/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/3/2019
 * Time : 13 : 55
 * Project : bookstore
 * Class : UserServiceImpl
 * Last modified : 5/31/19 10:35 PM
 */

package com.kowama.bookstore.service.impl;

import com.kowama.bookstore.domain.User;
import com.kowama.bookstore.repository.UserRepository;
import com.kowama.bookstore.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {
    private Logger LOG = Logger.getLogger(UserServiceImpl.class.getName());

    private final UserRepository _userRepository;
    private final PasswordEncoder _passwordEncoder;

    public UserServiceImpl(UserRepository _userRepository, PasswordEncoder _passwordEncoder) {
        this._userRepository = _userRepository;
        this._passwordEncoder = _passwordEncoder;
    }

    @Override
    public User create(User user) throws IllegalArgumentException {
        if (_userRepository.findByUsername(user.getUsername()) != null) {
            LOG.warning("* Username already exist"+user.getUsername());
            throw new IllegalArgumentException("* Username already exist");
        }
        if (_userRepository.findByEmail(user.getEmail()) != null) {
            LOG.warning("* Email already exist"+user.getEmail());
            throw new IllegalArgumentException("* Email already exist");
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
