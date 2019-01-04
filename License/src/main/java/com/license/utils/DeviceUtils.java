package com.license.utils;

import org.apache.commons.lang3.StringUtils;

import com.license.model.enums.DeviceTypeEnum;

/**
 * @Type DeviceUtils.java
 * @Desc 
 */
public class DeviceUtils {

	/**
	 * 根据操作系统获取设备类型
	 * @param os
	 * @return
	 */
	public static Integer getDeviceTypeFromOS(String os) {
		if(StringUtils.contains(os, "APP")) { // APP
			return DeviceTypeEnum.APP.getCode();
		}
		if(StringUtils.containsIgnoreCase(os, "Unknown") || StringUtils.containsIgnoreCase(os, "iphone") || StringUtils.containsIgnoreCase(os, "Android")) { // 小程�?
			return DeviceTypeEnum.WEIXIN_APP.getCode();
		}
		return DeviceTypeEnum.WEB.getCode(); // web
	}
}
