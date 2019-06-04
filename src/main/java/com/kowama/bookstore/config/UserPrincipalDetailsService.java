/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/3/2019
 * Time : 13 : 55
 * Project : bookstore
 * Class : UserPrincipalDetailsService
 * Last modified : 5/31/19 10:12 AM
 */

package com.kowama.bookstore.config;

import com.kowama.bookstore.domain.User;
import com.kowama.bookstore.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UserRepository _userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        _userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = _userRepository.findByUsername(name);

        if (user == null)
            throw new UsernameNotFoundException(name);


        UserPrincipal userPrincipal = new UserPrincipal(user);

        return userPrincipal;
    }
}
