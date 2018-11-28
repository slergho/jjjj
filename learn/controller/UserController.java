package com.example.learn.controller;


import com.example.learn.entity.SysUser;
import com.example.learn.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.social.connect.web.ProviderSignInUtils;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    ProviderSignInUtils providerSignInUtils;

    @Autowired
    UserServiceImpl service;


    @GetMapping(value = "/all")
    public List<SysUser> findAll(){
        return service.findAll();
    }


    @PostMapping(value = "/add")
    public SysUser addUser(@Valid SysUser user){
        return service.addOneUser(user);
    }

    @DeleteMapping(value = "/del/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        service.deleteOneUser(id);
    }

    @PutMapping(value = "/up/{id}")
    public SysUser updateUser(
            @PathVariable("id") Integer id,
             @Valid SysUser user){
        return service.updateOneUser(user);
    }


}
