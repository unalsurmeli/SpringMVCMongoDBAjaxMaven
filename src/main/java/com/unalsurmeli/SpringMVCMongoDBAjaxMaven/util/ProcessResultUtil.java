package com.unalsurmeli.SpringMVCMongoDBAjaxMaven.util;

public class ProcessResultUtil {

	private boolean isSuccess;
	private String resultMessage;
	private Object object;

	public ProcessResultUtil(boolean isSuccess, String resultMessage, Object object) {
		this.isSuccess = isSuccess;
		this.resultMessage = resultMessage;
		this.object = object;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
