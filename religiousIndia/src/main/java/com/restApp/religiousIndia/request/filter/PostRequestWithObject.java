package com.restApp.religiousIndia.request.filter;

import java.util.Map;

public class PostRequestWithObject {

	private String requestType;
	private Map<String, Object> requestParam;

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Map<String, Object> getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(Map<String, Object> requestParam) {
		this.requestParam = requestParam;
	}

	
}
