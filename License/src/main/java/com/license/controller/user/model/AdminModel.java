package com.license.controller.user.model;

import com.license.controller.base.AbstractFlagModel;

public class AdminModel extends AbstractFlagModel{

	private Long adminUser;
	private String adminName;
	
	
	public Long getAdminUser() {
		return adminUser;
	}
	public void setAdminUser(Long adminUser) {
		this.adminUser = adminUser;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
}
