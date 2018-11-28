package com.example.learn.social.weixin.pojo;

/**
 *
 * 返回结果包装对象使用
 */
public class WeChatResult {
	/**
	 * 状态
	 */
	private Object status;
	/**
	 * 结果
	 */
	private Object result;
	/**
	 * 消息
	 */
	private String message;

	public WeChatResult() {
	}

	public WeChatResult(Object status, String message) {
		this.status = status;
		this.message = message;
	}

	public WeChatResult(Object status, Object result) {
		this.status = status;
		this.result = result;
	}

	public WeChatResult(Object status, Object result, String message) {
		this.status = status;
		this.result = result;
		this.message = message;
	}

	public Object getStatus() {
		return status;
	}

	public void setStatus(Object status) {
		this.status = status;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
