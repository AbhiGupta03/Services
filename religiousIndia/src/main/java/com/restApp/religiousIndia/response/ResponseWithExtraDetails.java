package com.restApp.religiousIndia.response;

import com.restApp.religiousIndia.response.status.ResponseStatus;

public class ResponseWithExtraDetails {

	private ResponseStatus status;
	private Object response;

	private Object commonResponseData;

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public Object getCommonResponseData() {
		return commonResponseData;
	}

	public void setCommonResponseData(Object commonResponseData) {
		this.commonResponseData = commonResponseData;
	}

}
