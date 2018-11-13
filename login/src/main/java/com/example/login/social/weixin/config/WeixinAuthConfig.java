package com.example.login.social.weixin.config;

import com.example.login.properties.SecurityConstants;
import com.example.login.social.SocialConnectView;
import com.example.login.social.weixin.connect.WeixinConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.social.autoconfigure.SocialAutoConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

import static com.example.login.properties.SecurityConstants.DEFAULT_SOCIAL_WEIXIN_PROVIDER_ID;



@Configuration
public class WeixinAuthConfig extends SocialAutoConfigurerAdapter {

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new WeixinConnectionFactory(DEFAULT_SOCIAL_WEIXIN_PROVIDER_ID, SecurityConstants.DEFAULT_SOCIAL_WEIXIN_APP_ID,
                SecurityConstants.DEFAULT_SOCIAL_WEIXIN_APP_SECRET);
    }

    /**
     * /connect/weixin POST请求,绑定微信返回connect/weixinConnected视图
     * /connect/weixin DELETE请求,解绑返回connect/weixinConnect视图
     * @return
     */
    @Bean({"connect/weixinConnect", "connect/weixinConnected"})
    @ConditionalOnMissingBean(name = "weixinConnectedView")
    public View weixinConnectedView() {
        return new SocialConnectView();
    }

}
