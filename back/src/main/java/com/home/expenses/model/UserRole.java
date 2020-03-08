package com.home.expenses.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class UserRole implements Serializable {

    private int id;
    private String userId;
    private int roleId;
    private Date createdAt;
    private Date updatedAt;
}
