package com.home.expenses.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class Role implements Serializable {

    private int id;
    private String name;
}
