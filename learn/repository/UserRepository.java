package com.example.learn.repository;

import com.example.learn.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<SysUser, Integer> {

    SysUser findByUsername(String username);

    List<SysUser> findByUsernameAndPassword(String uasername, String password);
}
