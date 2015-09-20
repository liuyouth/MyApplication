package com.rescam.xhb.common.action.weixin;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.rescam.xhb.common.action.BasicAction;
import com.rescam.xhb.common.util.WeiXinUtility;

@SuppressWarnings("serial")
public class WeiXinAction extends BasicAction {

	private static Logger logger = Logger.getLogger(WeiXinAction.class);
	private JSONObject jsonObj;
	private String type;
	private String code;
	private String state;
	private String openId;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	// 取网页授权取用户信息
	public String getUserInfo() {

		try {
			jsonObj = WeiXinUtility.getPageAccess_token(type, code);
		} catch (Exception e) {
			logger.error(e);
		}
		return SUCCESS;
	}

	// 取签名
	public String getSignature() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();

			jsonObj = WeiXinUtility.queryJsapiTicket(request, openId, code,
					state);
		} catch (Exception e) {
			logger.error(e);
		}
		return SUCCESS;
	}

}
