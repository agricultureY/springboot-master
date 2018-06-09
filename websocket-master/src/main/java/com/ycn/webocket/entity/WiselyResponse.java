package com.ycn.webocket.entity;

/**
 * 后台发送消息实体
 * @author mobo
 *
 */
public class WiselyResponse {
	private String responseMessage;

	public WiselyResponse(String responseMessage){
	    this.responseMessage = responseMessage;
	}

	public String getResponseMessage() {
	    return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
	    this.responseMessage = responseMessage;
	}
}
