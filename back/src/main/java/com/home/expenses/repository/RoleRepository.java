package com.home.expenses.repository;

import com.home.expenses.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Mapper
public interface RoleRepository {

    Optional<Role> findById(int id);
}
