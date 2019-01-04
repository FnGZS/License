package com.license.controller.user.model;

import com.license.controller.base.AbstractFlagModel;

public class LoginModel extends AbstractFlagModel{
	
	private String userName;
	private String userKey;
	private String avatar;
	private String authorization;
	private Integer sex;
	private String unionId;
	private String openAccount;
	private Integer isbound; 
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAuthorization() {
		return authorization;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	public String getOpenAccount() {
		return openAccount;
	}
	public void setOpenAccount(String openAccount) {
		this.openAccount = openAccount;
	}

	public Integer getIsbound() {
		return isbound;
	}
	public void setIsbound(Integer isbound) {
		this.isbound = isbound;
	}
	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
}
