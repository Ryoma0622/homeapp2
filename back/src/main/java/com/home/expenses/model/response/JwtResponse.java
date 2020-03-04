package com.home.expenses.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtResponse {

    private final String jwt;
    private final String username;
    private final String password;
    private final List<String> roles;
}
