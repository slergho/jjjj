package com.example.learn.social.mobile;


import com.example.learn.properties.SecurityConstants;

public enum ValidateCodeType {
	
	/**
	 * 短信验证码
	 */
	SMS {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
		}
	};

	/**
	 * 校验时从请求中获取的参数的名字
	 */
	public abstract String getParamNameOnValidate();

}
