package com.example.login.repository;


import com.example.login.domain.SysRole;


public interface SysRoleRepository extends org.springframework.data.jpa.repository.JpaRepository<SysRole, String>, org.springframework.data.jpa.repository.JpaSpecificationExecutor<SysRole> {
}
