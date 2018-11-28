package com.example.learn.controller;

import com.example.learn.social.weixin.constanst.Constanst;
import com.example.learn.utils.AesUtil;
import com.example.learn.utils.Base64Util;
import com.example.learn.utils.DateUtils;
import com.example.learn.utils.PropertiesUtil;
import com.example.learn.social.weixin.pojo.WeChatAccessToken;
import com.example.learn.social.weixin.pojo.WeChatHttpParame;
import com.example.learn.social.weixin.pojo.WechatUserInfo;
import com.example.learn.service.WechatScanLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 *
 *  微信扫码登录
 */
@Controller
@RequestMapping("/wechat")
public class WechatScanLoginController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private WechatScanLoginService wechatScanLoginService;

	/**
	 *
	 * 重定向到微信扫码登录二维码页面
	 * 此处显示要微信要扫描的二维码
	 */
	@GetMapping(value = "/list")
		public String list(Model model) throws UnsupportedEncodingException {
			Map<String, String> wechatLoginUrl = wechatScanLoginService.wechatLoginUrl();
			String url = wechatLoginUrl.get("url");

			return "redirect:" + url;

		}

	/**
	 *
	 * 回调地址处理
	 */
	//@SuppressWarnings("unused")
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
	}*/

	/**
	 * Description: 跳转到绑定用户系统帐号页面
	 */
	/*@GetMapping(value = "/bind")
	public String bindUserMac() {
		return "sysSetting/wxbinding";
	}*/
}
