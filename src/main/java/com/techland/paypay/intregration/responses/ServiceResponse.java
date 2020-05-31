package com.techland.paypay.intregration.responses;

import org.springframework.stereotype.Component;

@Component
public class ServiceResponse {

	private boolean success;
	private int responseCode;
	private String messaged;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessaged() {
		return messaged;
	}

	public void setMessaged(String messaged) {
		this.messaged = messaged;
	}

}
