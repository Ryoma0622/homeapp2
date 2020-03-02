package com.home.expenses.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User implements Serializable {

    private int id;
    private String userId;
    private String password;
    private String name;
    private Boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;
}
