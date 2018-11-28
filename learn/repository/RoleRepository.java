package com.example.learn.repository;

import com.example.learn.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<SysRole, Integer> {
}
