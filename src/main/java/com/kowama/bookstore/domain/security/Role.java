/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/3/2019
 * Time : 13 : 55
 * Project : bookstore
 * Class : Role
 * Last modified : 6/2/19 7:05 PM
 */

package com.kowama.bookstore.domain.security;

import com.kowama.bookstore.domain.User;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role() {

    }

    public Role(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
