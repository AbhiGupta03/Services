package com.restApp.religiousIndia.request.filter;

import java.util.List;
import java.util.Map;

public class PostRequest {

	private String requestType;
	private Map<String, List<String>> requestParam;

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public Map<String, List<String>> getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(Map<String, List<String>> requestParam) {
		this.requestParam = requestParam;
	}
}
