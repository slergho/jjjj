package com.example.learn.properties;

import lombok.Data;

/**
 * 短信验证码
 */
@Data
public class SmsCodeProperties {
    private int length = 6;
    private int expireIn = 60;
    private String url;
}
