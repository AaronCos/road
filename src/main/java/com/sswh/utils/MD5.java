package com.sswh.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	
	/**
	 * md5加密工具类
	 * @param source
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String md5(String source) {
		//创建消息摘要，
		MessageDigest md;
		String md5 = null;
		try {
			md = MessageDigest.getInstance("md5");
			//获取摘要
			byte[] digest = md.digest(source.getBytes());
			//重组为16进制的字符串
			md5 = new BigInteger(1,digest).toString(16);
			//补充为32位
			for(int i=0;i<32-md5.length();i++){
				md5="0"+md5;
			}
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("not support md5");
		}
			return md5;
	}

}
