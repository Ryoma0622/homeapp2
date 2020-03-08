package com.home.expenses.repository;

import com.home.expenses.model.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Mapper
public interface UserRoleRepository {

    Optional<UserRole> findById(int id);
}
