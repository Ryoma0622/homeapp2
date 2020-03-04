package com.home.expenses.model.request;

import lombok.Data;

@Data
public class LoginRequest {
    private final String userId;
    private final String password;
}
