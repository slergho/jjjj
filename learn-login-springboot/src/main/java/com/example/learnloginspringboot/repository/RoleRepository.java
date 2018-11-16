package com.example.learnloginspringboot.repository;

import com.example.learnloginspringboot.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<SysRole, Integer> {
}
