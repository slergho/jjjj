package com.example.learn.service.impl;

import com.example.learn.entity.SysUser;
import com.example.learn.repository.UserRepository;
import com.example.learn.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean verifyLogin(SysUser user) {

        List<SysUser> userList = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        return userList.size()>0;
    }
}
