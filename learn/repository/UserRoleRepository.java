package com.example.learn.repository;

import com.example.learn.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<SysUserRole, Integer> {
}
