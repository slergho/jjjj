package com.example.login.repository;


import com.example.login.domain.SysUser;

public interface SysUserRepository extends org.springframework.data.jpa.repository.JpaRepository<SysUser, String>, org.springframework.data.jpa.repository.JpaSpecificationExecutor<SysUser> {
    /**
     * 用户名查找
     */
    SysUser findByUsername(String username);

    /**
     * 手机号查找
     */
    SysUser findByMobile(String mobile);

    /**
     * 用户名或手机号
     */
    SysUser findByUsernameOrMobile(String username, String mobile);

}
