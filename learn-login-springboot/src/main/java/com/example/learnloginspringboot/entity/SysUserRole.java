package com.example.learnloginspringboot.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_role")
public class SysUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "rid")
    private Integer rid;
}
