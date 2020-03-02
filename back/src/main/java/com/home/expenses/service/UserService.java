package com.home.expenses.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.home.expenses.LoginUser;
import com.home.expenses.model.User;
import com.home.expenses.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) {
        User user;
        try {
            user = userRepository.findUser(userId);
        } catch (Exception e) {
            throw new UsernameNotFoundException("It can not be acquired User");
        }

        if(user == null){
            throw new UsernameNotFoundException("User not found for login id: " + userId);
        }

        return new LoginUser(user);
    }
}
