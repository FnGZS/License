package com.license.controller.user.param;

import java.util.Map;

import com.license.validate.annotation.RequireAnno;

public class LoginParam {

	@RequireAnno
	private String platCode;
	
	private Map<String, String> platUserInfoMap;


	public String getPlatCode() {
		return platCode;
	}

	public void setPlatCode(String platCode) {
		this.platCode = platCode;
	}

	public Map<String, String> getPlatUserInfoMap() {
		return platUserInfoMap;
	}

	public void setPlatUserInfoMap(Map<String, String> platUserInfoMap) {
		this.platUserInfoMap = platUserInfoMap;
	}
	

	
}
