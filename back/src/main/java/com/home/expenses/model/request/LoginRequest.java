package com.home.expenses.model.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String userId;
    private String password;
}
