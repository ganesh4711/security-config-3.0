package com.demo.repository;

import com.demo.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepo extends JpaRepository<UserRole,Integer> {
}
