package com.home.expenses.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.home.expenses.model.User;

@Repository
@Mapper
public interface UserRepository {

    User findUser(String userId);
}
