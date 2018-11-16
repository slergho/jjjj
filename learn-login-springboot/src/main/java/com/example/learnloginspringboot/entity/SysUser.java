package com.example.learnloginspringboot.entity;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "users")
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private  Integer userid;
    @NotNull
    @Column(name = "user_name")
    private  String username;
    @NotNull
    @Column(name = "user_password")
    private String password;
    private String age;
}
