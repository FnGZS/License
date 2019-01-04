package com.license.dao.user;

import com.license.dao.user.dataobject.UserLoginDO;
import com.license.dao.user.dataobject.UserLoginPO;

/**
 * @Type UserLoginDao
 * @date 2018�?10�?5�?
 */
public interface UserLoginDao {

    UserLoginDO queryUserLogin(String openId);

	UserLoginDO seletUserByUnionid(String openId);

	void insert(UserLoginDO userLoginDO);

	void update(UserLoginDO userLoginDO);
}
