package com.license.dao.user.dataobject;

import java.util.Date;

/**
 * @Type UserLoginDO
 * @Desc 
 * @author luogm
 * @date 2016�?8�?20�?
 * @Version V1.0
 */
public class UserLoginDO {
	
	private Long id;
    
    private String openId;

    private String loginAccount;

    private String accessToken;
    
    private Integer signInCount;
    
    private Integer isBound;

    private Date gmtCreated;

    private Date gmtModified;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

	public Integer getSignInCount() {
		return signInCount;
	}

	public void setSignInCount(Integer signInCount) {
		this.signInCount = signInCount;
	}

	public Integer getIsBound() {
		return isBound;
	}

	public void setIsBound(Integer isBound) {
		this.isBound = isBound;
	}

	public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}