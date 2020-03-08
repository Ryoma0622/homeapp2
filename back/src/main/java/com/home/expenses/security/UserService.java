package com.home.expenses.security;

import com.home.expenses.model.Role;
import com.home.expenses.model.User;
import com.home.expenses.model.UserRole;
import com.home.expenses.repository.RoleRepository;
import com.home.expenses.repository.UserRepository;
import com.home.expenses.repository.UserRoleRepository;
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
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) {
        try {
            User user = userRepository.findByUserId(userId)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found for login id: " + userId));
            UserRole userRole = userRoleRepository.findById(user.getId()).get();
            Role role = roleRepository.findById(userRole.getRoleId()).get();

            return new LoginUser(user, role);
        } catch (Exception e) {
            throw new UsernameNotFoundException("It can not be acquired User");
        }
    }
}
