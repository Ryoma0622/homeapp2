package com.home.expenses.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.home.expenses.model.User;

import java.util.Optional;

@Repository
@Mapper
public interface UserRepository {

    Optional<User> findUser(String userId);
}
