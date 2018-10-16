package com.restApp.religiousIndia.payload;

public class UserSummary {
	private Integer userId;
	private String username;
	private String name;

	public UserSummary(Integer userId, String username, String name) {
		this.userId = userId;
		this.username = username;
		this.name = name;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}