package com.license.utils;

import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

public class TokenUtils {
	private static final String Union_AES_KEY = "FengNiao21";
	
	/**
	 * 创建用户token
	 * @param userId
	 * @return
	 * */
	
	public static String creatAesStr(String openId,Long schoolNum) {
		if(openId == null) {
			return "";
		}
		UUID uuid = UUID.randomUUID();
		String data = uuid.toString() + "|" +schoolNum.toString()+"|"+ openId;
		String key = new String(Base64.encodeBase64(Union_AES_KEY.getBytes()));
		return AesUtils.encrypt(data, key);
	}
	
	/**
	 * 根据token获取用户ID
	 * @param token
	 * @return
	 * @throws Exception 
	 */
	public static String getIdFromAesStr(String str) throws Exception {
		if(StringUtils.isBlank(str)) {
			return null;
		}
		String key = new String(Base64.encodeBase64(Union_AES_KEY.getBytes()));
		String originStr;
		originStr = AesUtils.decrypt(str, key);
		String openId = originStr.split("\\|")[2];
		if(StringUtils.isBlank(openId)) {
			return null;
		}
		return openId;
	}
	
	
	/**
	 * 根据token获取学号
	 * @param token
	 * @return
	 * @throws Exception 
	 * */
	
	public static Long getSchoolNumFromAesStr(String str) throws Exception{
		if(StringUtils.isBlank(str)) {
			return null;
		}
		String key = new String(Base64.encodeBase64(Union_AES_KEY.getBytes()));
		String originStr;
		originStr = AesUtils.decrypt(str, key);
		String schoolNum = originStr.split("\\|")[1];
		if(StringUtils.isBlank(schoolNum)) {
			return null;
		}
		return Long.parseLong(schoolNum);
	}
}
