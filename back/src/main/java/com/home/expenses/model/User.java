package com.home.expenses.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private int id;
    private String userId;
    private String password;
    private String name;
    private Boolean isDeleted;
    private Date createdAt;
    private Date updatedAt;
}
