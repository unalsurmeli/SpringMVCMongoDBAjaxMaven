package com.unalsurmeli.SpringMVCMongoDBAjaxMaven.model;

import java.util.List;

import com.unalsurmeli.SpringMVCMongoDBAjaxMaven.util.ResultCodes;

public class Result {
	private boolean successful;
	private String errorCode = "NOERROR";
	private String resultMessage = "NOERROR";
	private List<User> listUser;

	public Result() {
		super();
	}

	public Result(ResultCodes resultCodes) {
		super();

		this.errorCode = resultCodes.toString();

		if (resultCodes == ResultCodes.UMPC000) {
			this.successful = true;
		} else {
			this.successful = false;
		}

		switch (resultCodes) {
		case UMPC000:
			this.resultMessage = "The operation is successful.";
			break;
		case UMPI001:
			this.resultMessage = "The user is empty.";
			break;
		case UMPI002:
			this.resultMessage = "The user could not be saved.";
			break;
		case UMPU001:
			this.resultMessage = "The user is empty.";
			break;
		case UMPU002:
			this.resultMessage = "The user could not be updated.";
			break;
		case UMPD001:
			this.resultMessage = "The user is empty.";
			break;
		case UMPD002:
			this.resultMessage = "The user could not be deleted.";
			break;
		case UMPDA001:
			this.resultMessage = "The user is empty.";
			break;
		case UMPDA002:
			this.resultMessage = "The user collection could not be deleted.";
			break;
		case UMPGUA001:
			break;
		case UMPGUA002:
			break;
		default:
			break;
		}
	}

	public Result(ResultCodes resultCodes, String message) {
		super();
		this.errorCode = resultCodes.toString();
		this.resultMessage = message;

		if (resultCodes == ResultCodes.UMPC000) {
			this.successful = true;
		} else {
			this.successful = false;
		}
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
}
