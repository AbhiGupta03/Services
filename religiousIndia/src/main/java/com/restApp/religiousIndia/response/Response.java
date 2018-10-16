package com.restApp.religiousIndia.response;

import com.restApp.religiousIndia.response.status.ResponseStatus;

public class Response {
	private ResponseStatus status;
	private Object response;

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
}
