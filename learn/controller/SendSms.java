package com.example.learn.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

@Controller
@RequestMapping("/sms")
public class SendSms {


	//初始化ascClient需要的几个参数
    final static String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
    final static String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
    //替换成你的AK
    final static String accessKeyId = "LTAISLlZ5jhhZ5XP";//你的accessKeyId,参考本文档步骤2
    final static String accessKeySecret = "d9RN09BoXDGF6jFjZ3WUOwDU8rl0s1";//你的accessKeySecret，参考本文档步骤2
	
	//发送短信
    @RequestMapping("/send")
    @ResponseBody
	public static String sendSms(HttpServletResponse response,String phone,HttpSession session) throws ClientException{
    	response.setContentType("application/json");
    	 JSONObject json = new JSONObject();
		//设置超时时间-可自行调整
	    System.setProperty("sun.net.client.defaultConnectTimeout", "10*60");
	    System.setProperty("sun.net.client.defaultReadTimeout", "10*60");
	    //初始化ascClient,暂时不支持多region（请勿修改）
	    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
	    accessKeySecret);
	    DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
	    IAcsClient acsClient = new DefaultAcsClient(profile);
	    //组装请求对象
	    SendSmsRequest request = new SendSmsRequest();
	    //使用post提交
	    request.setMethod(MethodType.POST);
	    //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
	    request.setPhoneNumbers("15313350963");
	    //必填:短信签名-可在短信控制台中找到
	    request.setSignName("啊哈");
	    //必填:短信模板-可在短信控制台中找到
	    request.setTemplateCode("SMS_150737842");
	    //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
	    //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
	    int code = (int)(Math.random()*90000+10000);
		System.out.println(code);
	    request.setTemplateParam("{\"code\":\""+code+"\"}");
	    //请求失败这里会抛ClientException异常
	    SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
	    if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
	    //请求成功
	    	json.put("ret", true);
	    	json.put("code", code);
	    	json.put("msg", "验证码已发送，请查收短信");
	    }else {
	    	json.put("ret", false);
	    	json.put("msg", "发送失败，请重新发送");
		}
	    String str = json.toJSONString();

	    session.setAttribute("SESSION_CODE",code);

	    return str;
	}
}
