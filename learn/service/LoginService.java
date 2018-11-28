package com.example.learn.service;


import com.example.learn.entity.SysUser;

public interface LoginService {

    boolean verifyLogin(SysUser user);
}
