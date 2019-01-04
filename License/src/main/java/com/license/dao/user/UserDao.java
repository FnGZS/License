package com.license.dao.user;

import com.license.dao.user.dataobject.BindingDO;
import com.license.dao.user.dataobject.UserDO;

public interface UserDao {

	UserDO seletUser(String openId);

	String seletIsBinding(String openId);

	void updateBinding(BindingDO binding);

	String getName(Long id);


}
