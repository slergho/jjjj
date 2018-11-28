package com.example.learn.social.mobile.sms;

import com.example.learn.controller.SendSms;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 默认的短信验证码发送器
 */
public class DefaultSmsCodeSender implements SmsCodeSender{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void send(String mobile, String code) {
        logger.warn("请配置真实的短信验证码发送器(SmsCodeSender)");

        //SendSms.sendSms(mobile,code);

        System.out.println("向手机"+mobile+"发送短信验证码"+code);
    }
}
