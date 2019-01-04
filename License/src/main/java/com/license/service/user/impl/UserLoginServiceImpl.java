package com.license.service.user.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.license.dao.user.AdminDao;
import com.license.dao.user.UserDao;
import com.license.dao.user.UserLoginDao;
import com.license.dao.user.dataobject.AdminDO;
import com.license.dao.user.dataobject.BindingDO;
import com.license.dao.user.dataobject.LoginDO;
import com.license.dao.user.dataobject.UserDO;
import com.license.dao.user.dataobject.UserLoginDO;
import com.license.dao.user.dataobject.UserLoginPO;
import com.license.service.base.ResponseCode;
import com.license.service.base.ResponseDO;
import com.license.service.user.UserLoginService;
import com.license.utils.Md5Utils;
import com.license.utils.TokenUtils;


@Component("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserLoginDao userLoginDao;

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public ResponseDO<UserLoginDO> getUserLogin(String unionId) {
		ResponseDO<UserLoginDO> responseDO = new ResponseDO<UserLoginDO>();
		UserLoginDO userLoginDO = userLoginDao.queryUserLogin(unionId);
		if(userLoginDO != null) {
			responseDO.setDataResult(userLoginDO);
		} else {
			responseDO.setCode(ResponseCode.ERROR);
			responseDO.setMessage("该用户不存在!");
		}
		return responseDO;
	}
	
	@Override
	public ResponseDO<UserLoginDO> userLogin(LoginDO wxUser) {
		ResponseDO<UserLoginDO> responseDO= new ResponseDO<UserLoginDO>();
		UserDO user = userDao.seletUser(wxUser.getOpenId());
		if(user != null) {
			UserLoginDO userLoginDO = userLoginDao.seletUserByUnionid(wxUser.getOpenId());
			if(userLoginDO == null) {
				userLoginDO = new UserLoginDO();
				try {
					userLoginDO.setOpenId(Md5Utils.getMD5(wxUser.getOpenId()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//以后加密
				userLoginDO.setLoginAccount(wxUser.getNickName());
				userLoginDO.setAccessToken(TokenUtils.creatAesStr(user.getOpenId(), user.getSchoolNum()));
				userLoginDO.setIsBound(1);
				userLoginDao.insert(userLoginDO);
			}else {
				userLoginDO = new UserLoginDO();
				try {
					userLoginDO.setOpenId(Md5Utils.getMD5(wxUser.getOpenId()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//以后加密
				userLoginDO.setAccessToken(TokenUtils.creatAesStr(user.getOpenId(), user.getSchoolNum()));
				userLoginDO.setIsBound(1);
				userLoginDao.update(userLoginDO);	
			}
			responseDO.setDataResult(userLoginDO);
		}else {
			UserLoginDO unbound = new UserLoginDO();
			try {
				unbound.setOpenId(Md5Utils.getMD5(wxUser.getOpenId()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//以后加密
			unbound.setAccessToken(wxUser.getOpenId());
			unbound.setLoginAccount(wxUser.getNickName());
			unbound.setIsBound(2);
			userLoginDao.insert(unbound);
			responseDO.setMessage("未绑定学�?");
			responseDO.setDataResult(unbound);
		}
		return responseDO;
	}


	@Override
	public ResponseDO<String> userBinding(BindingDO binding) {
		ResponseDO<String> responseDO = new ResponseDO<String>();
		String isBinding = userDao.seletIsBinding(binding.getUnionId());
		if(isBinding == null) {
			userDao.updateBinding(binding);
			responseDO.setDataResult(isBinding);
			return responseDO;
		}
		responseDO.setCode(ResponseCode.ERROR);
		return responseDO;
	}

	@Override
	public ResponseDO<AdminDO> adminLogin(AdminDO admin) {
		ResponseDO<AdminDO> responseDO = new ResponseDO<AdminDO>();
		AdminDO adminUser = adminDao.getAdmin(admin.getAdminName());
		if(adminUser.getPassword().equals(admin.getPassword())) {
			responseDO.setDataResult(adminUser);
			return responseDO;
		}
		responseDO.setCode(ResponseCode.ERROR);
		return responseDO;
	}


	
}
