package com.example.login.controller;

import com.example.login.domain.Result;
import com.example.login.domain.SysUser;
import com.example.login.dto.UserDto;
import com.example.login.properties.SecurityConstants;
import com.example.login.service.SysUserService;
import com.example.login.social.SocialUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private SysUserService sysUserService;


    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @PostMapping(SecurityConstants.DEFAULT_REGISTER_URL)
    public ModelAndView register(@RequestParam("username") String username,
                                 @RequestParam("password") String pasword, HttpServletRequest request, Map<String, Object> map) {
        log.info("【UserController】register username={},password={}", username, pasword);
//        //不管是注册用户还是绑定用户
//        providerSignInUtils.doPostSignUp(username, new ServletWebRequest(request));
        return new ModelAndView("login", map);
    }

    /**
     * 获取第三方用户信息
     */
    @GetMapping("/social/info")
    public @ResponseBody
    SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
        SocialUserInfo userInfo = new SocialUserInfo();
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadImg(connection.getImageUrl());
        return userInfo;
    }

    @GetMapping("/user/me")
    public Object getCurrentUser1(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

    @PostMapping("/user/register")
    public String register(SysUser user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = user.getUsername();
        SysUser result = sysUserService.findByUsername(userId);
        if (result == null) {
            //注册用户
            sysUserService.save(user);
        }
        //将业务系统的用户与社交用户绑定
        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
        //跳转到index
        return "redirect:/index";
    }

    @GetMapping("/user/showUser")
    public ModelAndView userListView() {
        return new ModelAndView("/user/userList");
    }

    @GetMapping("/user/addUser")
    public ModelAndView addUserView() {
        return new ModelAndView("/user/userAdd");
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDto findUser(@PathVariable("id") String id) {
        return sysUserService.findOne(id);
    }

    @PreAuthorize("hasAuthority('user:del')")
    @RequestMapping("/user/del/{ids}")
    @ResponseBody
    public Result<String> delUsers(@PathVariable("ids") String ids) {
        return sysUserService.delUsers(ids);
    }

    @PreAuthorize("hasAnyAuthority('user:select','user:update')")
    @PostMapping(value = "/user/saveUser")
    @ResponseBody
    public Result saveUser(@RequestParam String data) {
        log.info(data);
        return sysUserService.save(data);
    }

}
