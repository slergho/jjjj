package com.example.learnloginspringboot.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "role")
public class SysRole {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleid;

    @Column(name = "role_name")
    private String rolename;


}
