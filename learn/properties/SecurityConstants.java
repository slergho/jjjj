package com.example.learn.properties;

public interface SecurityConstants {

    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";

    String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/authentication/form";

    String DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE = "/authentication/mobile";

    String DEFAULT_SIGN_IN_URL_MOBILE_PAGE = "/authentication/mobilePage";

    String DEFAULT_REGISTER_URL = "/authentication/register";

    /**
     * weixin appID
     */
    String DEFAULT_SOCIAL_WEIXIN_APP_ID = "wx2df661e7290a5e2e";

    /**
     * weixin appsECRET
     */
    String DEFAULT_SOCIAL_WEIXIN_APP_SECRET = "c06b9e43977ac9852ee41eb9ed118db0";



    /**
     *自定义社交social拦截地址  默认/auth  (SocialAuthenticationFilter)
     */
    String DEFAULT_SOCIAL_PROCESS_URL = "/login";

    /**
     * 提供商的ID
     */
    String DEFAULT_SOCIAL_WEIXIN_PROVIDER_ID = "weixin";



    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    /**
     * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_MOBILE = "phone";


    /**
     * 默认用户密码
     */
    String DEFAULT_PASSWORD="123456";
}
