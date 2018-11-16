package com.example.learnloginspringboot.service;

import com.example.learnloginspringboot.entity.SysUser;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

    List<SysUser> findAll();

    SysUser addOneUser(@Valid SysUser user);

    SysUser updateOneUser(@Valid SysUser user);

    void deleteOneUser(Integer id);

    SysUser findOneByUsername(String username);
}
