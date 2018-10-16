package com.restApp.religiousIndia.request.filter;

import java.util.Map;

public class PostRequestWithOutArray {

	private String requestType;
	private Map<String, String> requestParam;

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Map<String, String> getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(Map<String, String> requestParam) {
		this.requestParam = requestParam;
	}

}
