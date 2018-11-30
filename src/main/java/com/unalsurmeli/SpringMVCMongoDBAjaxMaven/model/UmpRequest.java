package com.unalsurmeli.SpringMVCMongoDBAjaxMaven.model;

public class UmpRequest {

	private User user;
	private String processName;

	public UmpRequest() {
		super();
	}

	public UmpRequest(User user, String processName) {
		super();
		this.user = user;
		this.processName = processName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String proccessName) {
		this.processName = proccessName;
	}

}
