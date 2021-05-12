package com.te.accademy.webapi.model;

public class RestResponse {

	public String state;
	public String message;

	public RestResponse(String state, String message) {
		this.state = state;
		this.message = message;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
