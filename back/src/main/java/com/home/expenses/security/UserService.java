package com.home.expenses.security;

import com.home.expenses.model.User;
import com.home.expenses.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) {
        User user;
        try {
            user = userRepository.findUser(userId)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found for login id: " + userId));
        } catch (Exception e) {
            throw new UsernameNotFoundException("It can not be acquired User");
        }

        return new LoginUser(user);
    }
}
