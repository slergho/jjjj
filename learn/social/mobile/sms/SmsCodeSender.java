package com.example.learn.social.mobile.sms;

public interface SmsCodeSender {

    /**
     * @param mobile 手机号
     * @param code 验证码内容
     */
    void send(String mobile, String code);
}
