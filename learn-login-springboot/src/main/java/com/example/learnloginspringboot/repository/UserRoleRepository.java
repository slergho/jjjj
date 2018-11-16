package com.example.learnloginspringboot.repository;

import com.example.learnloginspringboot.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<SysUserRole, Integer> {
}
