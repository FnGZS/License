package com.license.service.user;


import com.license.dao.user.dataobject.AdminDO;
import com.license.dao.user.dataobject.BindingDO;
import com.license.dao.user.dataobject.LoginDO;
import com.license.dao.user.dataobject.UserLoginDO;
import com.license.service.base.ResponseDO;


public interface UserLoginService {
	
	ResponseDO<UserLoginDO> getUserLogin(String unionId);
//	ResponseDO<UserLoginDO> getUserLogin(Long userId, Integer deviceType);
//	ResponseDO<UserLoginDTO> doPasswordLogin(PasswordLoginPO loginPO);

	ResponseDO<UserLoginDO> userLogin(LoginDO wxUser);

	ResponseDO<String> userBinding(BindingDO binding);

	ResponseDO<AdminDO> adminLogin(AdminDO admin);

//	ResponseDO<UserLoginDTO> doPlatLogin(PlatLoginPO platLoginPO);
	
//	void doLoginOut(UserLoginPO userLoginPO);

	//ResponseDO<UserLoginDTO> login(UserAccountDO user, LoginPO loginPO);
	
	//String updateAccessToken(Long userId, String account, String agent);
}
