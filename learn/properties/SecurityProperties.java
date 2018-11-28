package com.example.learn.properties;

import com.example.learn.enums.LoginType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "merryyou.security")
public class SecurityProperties {

    private String signOutUrl = "/merryyou-signOut.html";

    private LoginType loginType = LoginType.JSON;

    /**
     * 验证码配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    /**
     * 记住我的有效时间秒
     */
    private int rememberMeSeconds = 60 * 60 * 24 * 7;

}
