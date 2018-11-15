package com.example.login.security;

import com.example.login.authentication.CustomAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomAuthenticationFailureHandler customAuthenticationFailureHandler;


    @Override
    protected void configure (HttpSecurity http)  throws Exception{
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/static/**","/ftl/login"
                                            ,"/ftl/","/authentication/register","/socialRegister", "/authentication/require").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index.html")
                .failureHandler(customAuthenticationFailureHandler)
                .and()
                .logout().logoutSuccessUrl("/index").permitAll();
            http.httpBasic().disable();
    }
}
