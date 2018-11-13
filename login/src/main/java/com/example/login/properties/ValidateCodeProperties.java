package com.example.login.properties;

import lombok.Data;

@Data
public class ValidateCodeProperties {
    /**
     * 短信验证码配置
     */
    private SmsCodeProperties sms = new SmsCodeProperties();
}
