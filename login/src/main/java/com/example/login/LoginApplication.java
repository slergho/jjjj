package com.example.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("com.example.login.repository")

public class LoginApplication  {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }
}