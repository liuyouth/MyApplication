package com.rescam.xhb.common.util;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class NumUtility {

	/**
	 * 获取订单号
	 * 
	 * @return 订单号
	 */
	public static synchronized String getOrderNo() {
		StringBuffer sb = new StringBuffer();
		sb.append(new Date().getTime());
		sb.append(RandomStringUtils.randomNumeric(20));
		return sb.toString();
	}

	/**
	 * 获取16位优惠码
	 * 
	 * @return 16位优惠码
	 */
	public static synchronized String getCouponNo() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			sb.append(RandomStringUtils.randomNumeric(4));
			sb.append(" ");
		}
		return sb.toString().trim();
	}

	/**
	 * 获取20位虚拟账号
	 * 
	 * @return 20位虚拟账号
	 */
	public static synchronized String getAccountNo() {
		StringBuffer sb = new StringBuffer();
		sb.append(new Date().getTime());
		sb.append(RandomStringUtils.randomNumeric(7));
		return sb.toString();
	}

	/**
	 * 获取6位短信验证码
	 * 
	 * @return 6位短信验证码
	 */
	public static synchronized String getPinNo() {
		return String.valueOf(RandomStringUtils.randomNumeric(6));
	}
}
