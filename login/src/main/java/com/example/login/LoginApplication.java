package com.example.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@ComponentScan("com.example.login.repository")

public class LoginApplication  {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }
}