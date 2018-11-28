package com.example.learn.controller;


import com.example.learn.service.WechatScanLoginService;
import com.example.learn.social.weixin.constanst.Constanst;
import com.example.learn.social.weixin.pojo.WeChatAccessToken;
import com.example.learn.social.weixin.pojo.WeChatHttpParame;
import com.example.learn.social.weixin.pojo.WechatUserInfo;
import com.example.learn.utils.AesUtil;
import com.example.learn.utils.Base64Util;
import com.example.learn.utils.DateUtils;
import com.example.learn.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Controller
@RequestMapping("/weixin")
public class WeixinController {
    @Autowired
    private WechatScanLoginService wechatScanLoginService;

    Logger logger = LoggerFactory.getLogger(WeixinController.class);
    /*@GetMapping("/auth")
    public void auth(@RequestParam(value = "code", required = false) String code){
        logger.info("进去了哦~~~");
        logger.info("code={}:", code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx2df661e7290a5e2e&secret=c06b9e43977ac9852ee41eb9ed118db0&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        logger.info("response={}",response);
        System.out.println(response);
    }*/
    @GetMapping("/auth")
    public String list(@RequestParam(value = "code", required = false) String code) throws UnsupportedEncodingException {
        logger.info("code={}:", code);
        String url = "https://api.weixin.qq.com/sns/userinfo?access_token=15_7k6lIA_i4dDbo7HcoN7Cj1sADcTKmqXLBu8drbRd0JER-2XUSnHxWUlOMqd086PP17Y7vuEllmC3OiIFWPqu1g&openid=oHmFb0-ar76nQLWMG16Nknu-eHeg&lang=zh_CN";
                //WeChatHttpParame.ACCESS_TOKEN_URL;
                //"https://api.weixin.qq.com/sns/userinfo?access_token=15_j6dJR5oZXw8xo3dERM6nYHRJiKv1OdkUPSfH5_g91WwmqS46vNjT4EWpjiBcWu_qgy3_B1uMLJbmXXb9Q325OyvSJe0W7-08p0fFeP2AguE&openid=oHmFb0-ar76nQLWMG16Nknu-eHeg&lang=zh_CN";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(url, String.class);
        //Map<String, String> wechatLoginUrl = wechatScanLoginService.wechatLoginUrl();
       // String url = wechatLogin
        // Url.get("url");
        System.out.println(url);
        Base64Util.decodeStr(url);
        return "redirect:" + url;
    }
  //  @SuppressWarnings("unused")
    /*@GetMapping(value = "/callback")
    public String callback(String code, String state) {
        if (code != null && state != null) {
            // 验证state为了用于防止跨站请求伪造攻击
            String decrypt = AesUtil.decrypt(AesUtil.parseHexStr2Byte(state), AesUtil.PASSWORD_SECRET_KEY, 16);
            if (!decrypt.equals(Constanst.PWD_MD5 + DateUtils.getYYYYMMdd())) {
                return "redirect:/security/login";
            }
            WeChatAccessToken access = wechatScanLoginService.getAccessToken(code);
            if (access != null) {
                // 把获取到的OPENID和ACCESS_TOKEN写到Properties文件中
                PropertiesUtil.writeProperties(WeChatHttpParame.OPENID, access.getOpenid());
                PropertiesUtil.writeProperties(WeChatHttpParame.ACCESS_TOKEN, access.getAccess_token());
                // 根据OPENID去当前用户数据库进行查询是否存在
                if (false) {		*//*不存在*//*
                    return "redirect:/wechat/bind";
                } else {
                    // 存在则把当前账号信息授权给扫码用户
                    // 拿到openid获取微信用户的基本信息
                    WechatUserInfo userUnionID = wechatScanLoginService.getUserUnionID();
                    return "主页";
                }
            }
        }
        return null;
    }

    @GetMapping(value = "/bind")
    public String bindUserMac() {
        return "sysSetting/wxbinding";
    }*/
}
