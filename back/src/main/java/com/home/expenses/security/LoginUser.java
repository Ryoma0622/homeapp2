package com.home.expenses.security;

import org.springframework.security.core.authority.AuthorityUtils;

import com.home.expenses.model.User;

public class LoginUser extends org.springframework.security.core.userdetails.User {

    public LoginUser(User user) {
        super(user.getUserId(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}