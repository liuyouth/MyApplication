package com.rescam.xhb.common.util;

import java.security.MessageDigest;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;

public class MD5Utility {

	/**
	 * MD5加密
	 * 
	 * @param password 密码明码
	 * @return 密码暗码
	 */
	public static String encrypt(String password) {
		int i1 = new Random().nextInt(99999999);
		int i2 = new Random().nextInt(99999999);
		String s = String.valueOf(i1) + String.valueOf(i2);
		if (s.length() < 16) {
			for (int i = 0; i < 16 - s.length(); i++) {
				s += "0";
			}
		}
		password = md5Hex(password + s);
		char[] c1 = password.toCharArray();
		char[] c2 = s.toCharArray();
		char[] c = new char[48];
		for (int i = 0; i < 48; i += 3) {
			c[i] = c1[i / 3 * 2];
			c[i + 1] = c2[i / 3];
			c[i + 2] = c1[i / 3 * 2 + 1];
		}
		return new String(c);
	}

	/**
	 * 校验密码是否正确
	 * 
	 * @param password 密码明码
	 * @param md5 密码暗码
	 * @return boolean
	 */
	public static boolean verify(String password, String md5) {
		char[] c = md5.toCharArray();
		char[] c1 = new char[32];
		char[] c2 = new char[16];
		for (int i = 0; i < 48; i += 3) {
			c1[i / 3 * 2] = c[i];
			c1[i / 3 * 2 + 1] = c[i + 2];
			c2[i / 3] = c[i + 1];
		}
		String s = new String(c2);
		return md5Hex(password + s).equals(new String(c1));
	}

	/**
	 * 获取十六进制字符串形式的MD5摘要
	 * 
	 * @param string 原始字符串
	 */
	public static String md5Hex(String string) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] b = md5.digest(string.getBytes());
			return new String(new Hex().encode(b));
		} catch (Exception e) {
			return null;
		}
	}
}
