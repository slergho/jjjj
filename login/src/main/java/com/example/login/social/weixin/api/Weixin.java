package com.example.login.social.weixin.api;


public interface Weixin {
    WeixinUserInfo getUserInfo(String openId);
}
