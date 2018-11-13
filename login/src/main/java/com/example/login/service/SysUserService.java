package com.example.login.service;

import com.example.login.domain.Result;
import com.example.login.domain.SysUser;
import com.example.login.dto.UserDto;

import java.util.List;

public interface SysUserService {

    SysUser save(SysUser user);

    SysUser findByUsername(String username);

    public List<UserDto> findAll();

    UserDto findOne(String id);

    Result save(String data);

    Result<String> delUsers(String ids);
}
