package com.pawpaw.fishinghome.usercenter.controller.vo;

public class RegistUserResp {
	public RegistUserResp() {

	}

	public RegistUserResp(long userId) {
		this.userId = userId;
	}

	private long userId;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "[userId=" + this.userId + "]";
	}

}
