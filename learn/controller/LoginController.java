package com.example.learn.controller;

import com.example.learn.entity.SysUser;
import com.example.learn.properties.SecurityConstants;
import com.example.learn.security.WebSecurityConfig;
import com.example.learn.service.impl.LoginServiceImpl;
import com.example.learn.social.mobile.ValidateCode;
import com.example.learn.social.mobile.ValidateCodeProcessorHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

@Controller
@RequestMapping(value = "/user")
public class LoginController {

    private ValidateCode validateCode;

    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;


    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoginServiceImpl loginServiceImpl;

    @GetMapping(value = "/index")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY)String account, Model model){

        return "index";
    }
    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }


    @GetMapping(value = "/loginVerify")
    public String loginVerify(String username,String password,HttpSession session){
        SysUser user = new SysUser();
        user.setUsername(username);
        log.info(username);
        boolean verify = loginServiceImpl.verifyLogin(user);
        if (verify) {
            session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
            log.info(username);
            log.info(WebSecurityConfig.SESSION_KEY);
            return "index";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping(value = "/mobile")
    @ResponseBody
    public String mobileLogin(HttpSession session, String code){
        if (session.getAttribute("SESSION_CODE").equals(code)){
            log.info("登录验证码：{}"+code);
            return "index";
        }else {
            return "redirect:/user/login";
        }
    }



    @GetMapping(value = "/logout")
    public String logout(HttpSession session){
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/user/login";
    }



}
