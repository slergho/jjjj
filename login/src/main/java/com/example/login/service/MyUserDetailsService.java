package com.example.login.service;

import com.example.login.domain.SysUser;
import com.example.login.repository.SysUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private SysUserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 从数据库查询用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("【MyUserDetailsService】 loadUserByUsername 表单登录用户名  username={}", username);
        String permissions = "";

        SysUser user = repository.findByUsernameOrMobile(username, username);
        if (user != null) {
            permissions = sysMenuService.getPermissions(user.getUsername());
            log.info(permissions);
            return new SysUser(user.getUsername(), user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
        }else{
            throw new BadCredentialsException("用户名不存在！");
        }
    }

    /**
     * 社交登录查询用户信息
     *
     */
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        SysUser user = repository.findByUsername(userId);
        return user;
    }
}
