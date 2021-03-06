package com.rescam.xhb.common.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public class WeiXinUtility {
	// private static Logger logger = Logger.getLogger(WeiXinUtility.class);
	private static String token;
	private static Date getTime;// 取token的时间
	private static String appid;
	private static String appSecret;
	private static JSONObject jsonObj;

	/**
	 * 取Page access_token(特殊的网页授权access_token)
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject getPageAccess_token(String type, String code)
			throws Exception {
		Properties properties = GetPropertiesFile.getPropObjFromBundle("path");
		appid = (String) properties.get("appid");
		appSecret = (String) properties.get("appSecret");

		URL url = new URL(
				"https://api.weixin.qq.com/sns/oauth2/access_token?appid="
						+ appid + "&secret=" + appSecret + "&code=" + code
						+ "&grant_type=authorization_code");

		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,
				"UTF-8"));

		StringBuilder sb = new StringBuilder("");
		String res;

		while ((res = reader.readLine()) != null) {

			sb.append(res.trim());
		}
		String resultStr = sb.toString();

		JSONObject jsonObject = JSONObject.fromObject(resultStr);
		Map<String, Object> dataMap = (Map<String, Object>) JSONObject.toBean(
				jsonObject, Map.class);

		String access_token = (String) dataMap.get("access_token");// 特殊的网页授权access_token
		String openid = (String) dataMap.get("openid");// 特殊的网页授权access_token
		if ("0".equals(type)) {
			// 龙头取微信用户信息
			jsonObj = getUserInfoOnPC(openid);
		} else {
			// 龙身取微信用户信息
			jsonObj = getUserInfoOnPage(access_token, openid);
		}

		return jsonObj;
	}

	/**
	 * 取微信的用户信息(普通)
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static JSONObject getUserInfoOnPC(String openid) throws Exception {
		Date nowTime = new Date();// 查询当前时间
		// 比较当前时间和getTime之间相差是否大于6500秒
		long nowTimeLong = nowTime.getTime() - 6500 * 1000;
		if (getTime != null) {
			long getTimeLong = getTime.getTime();

			if (nowTimeLong > getTimeLong) {
				getAccess_token();
			}
		} else {
			getAccess_token();
		}

		URL url = new URL(
				"https://api.weixin.qq.com/cgi-bin/user/info?access_token="
						+ token + "&openid=" + openid + "&lang=zh_CN");

		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,
				"UTF-8"));

		StringBuilder sb = new StringBuilder("");
		String res;

		while ((res = reader.readLine()) != null) {

			sb.append(res.trim());
		}
		String resultStr = sb.toString();

		JSONObject jsonObject = JSONObject.fromObject(resultStr);
		Map<String, Object> dataMap = (Map<String, Object>) JSONObject.toBean(
				jsonObject, Map.class);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (dataMap.containsKey("nickname")) {
			resultMap = new HashMap<String, Object>();
			openid = (String) dataMap.get("openid");// 用户的唯一标识
			String nickname = (String) dataMap.get("nickname");// 用户昵称
			int sex = (Integer) dataMap.get("sex");// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
			String headimgurl = (String) dataMap.get("headimgurl");// 用户头像
			resultMap.put("type", true);
			resultMap.put("openid", openid);
			resultMap.put("nickname", nickname);
			resultMap.put("sex", sex);
			resultMap.put("headimgurl", headimgurl);
		} else {
			resultMap = new HashMap<String, Object>();
			resultMap.put("type", false);
		}

		jsonObj = JSONObject.fromObject(resultMap);
		return jsonObj;
	}

	/**
	 * 取微信的用户信息(网页授权取)
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private static JSONObject getUserInfoOnPage(String access_token,
			String openid) throws Exception {

		URL url = new URL(
				"https://api.weixin.qq.com/sns/userinfo?access_token="
						+ access_token + "&openid=" + openid + "&lang=zh_CN");

		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,
				"UTF-8"));

		StringBuilder sb = new StringBuilder("");
		String res;

		while ((res = reader.readLine()) != null) {

			sb.append(res.trim());
		}
		String resultStr = sb.toString();

		JSONObject jsonObject = JSONObject.fromObject(resultStr);
		Map<String, Object> dataMap = (Map<String, Object>) JSONObject.toBean(
				jsonObject, Map.class);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (dataMap.containsKey("openid")) {
			resultMap = new HashMap<String, Object>();
			openid = (String) dataMap.get("openid");// 用户的唯一标识
			String nickname = (String) dataMap.get("nickname");// 用户昵称
			int sex = (Integer) dataMap.get("sex");// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
			String headimgurl = (String) dataMap.get("headimgurl");// 用户头像
			resultMap.put("type", true);
			resultMap.put("openid", openid);
			resultMap.put("nickname", nickname);
			resultMap.put("sex", sex);
			resultMap.put("headimgurl", headimgurl);
		} else {
			resultMap = new HashMap<String, Object>();
			resultMap.put("type", false);
		}

		jsonObj = JSONObject.fromObject(resultMap);
		return jsonObj;
	}

	/**
	 * 获取JS-SDK使用权限签名jsapi_ticket
	 * 
	 * @param parms
	 * @return
	 * @throws Exception
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public static JSONObject queryJsapiTicket(HttpServletRequest request,
			String openId, String code, String state) throws Exception {
		String host = request.getHeader("Host");

		Date nowTime = new Date();// 查询当前时间
		// 比较当前时间和getTime之间相差是否大于6500秒
		long nowTimeLong = nowTime.getTime() - 6500 * 1000;
		if (getTime != null) {
			long getTimeLong = getTime.getTime();

			if (nowTimeLong > getTimeLong) {
				getAccess_token();
			}
		} else {
			getAccess_token();
		}

		URL url = new URL(
				"https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="
						+ token + "&type=jsapi");
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,
				"UTF-8"));

		StringBuilder sb = new StringBuilder("");
		String res;

		while ((res = reader.readLine()) != null) {

			sb.append(res.trim());
		}

		String resultStr = sb.toString();

		JSONObject jsonObject = JSONObject.fromObject(resultStr);
		Map<String, Object> dataMap = (Map<String, Object>) JSONObject.toBean(
				jsonObject, Map.class);
		String jsapi_ticket = "";
		int errcode = (Integer) dataMap.get("errcode");
		if (errcode == 0) {
			jsapi_ticket = (String) dataMap.get("ticket");
		} else {
			jsapi_ticket = "error";
		}

		String nonce_str = create_nonce_str();
		String timestamp = create_timestamp();
		String taskUrl = "http://" + host
				+ "/xinghuoban/customer_init.html?openId=" + openId + "&code="
				+ code + "&state=" + state;

		String signature = "";
		// 注意这里参数名必须全部小写，且必须有序
		String string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr="
				+ nonce_str + "&timestamp=" + timestamp + "&url=" + taskUrl;
		MessageDigest crypt = MessageDigest.getInstance("SHA-1");
		crypt.reset();
		crypt.update(string1.getBytes("UTF-8"));
		signature = byteToHex(crypt.digest());

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("signature", signature);
		resultMap.put("nonceStr", nonce_str);
		resultMap.put("timestamp", timestamp);
		resultMap.put("appid", appid);
		jsonObj = JSONObject.fromObject(resultMap);
		return jsonObj;
	}

	private static String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	private static String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	/**
	 * 取access_token(基础支持中的access_token)
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private static void getAccess_token() throws Exception {
		getTime = new Date();// 设置取token的时间
		Properties properties = GetPropertiesFile.getPropObjFromBundle("path");
		appid = (String) properties.get("appid");
		appSecret = (String) properties.get("appSecret");

		URL url = new URL(
				"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
						+ appid + "&secret=" + appSecret);
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,
				"UTF-8"));

		StringBuilder sb = new StringBuilder("");
		String res;

		while ((res = reader.readLine()) != null) {

			sb.append(res.trim());
		}
		String[] arr1 = sb.toString().split(",");
		String[] arr2 = arr1[0].split(":");
		token = arr2[1].replace("\"", "");
	}

}
