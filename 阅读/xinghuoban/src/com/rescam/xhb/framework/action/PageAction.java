package com.rescam.xhb.framework.action;

import com.opensymphony.xwork2.ActionSupport;

public class PageAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String pageName;
	private String goodsId;
	
	public String getPageName() {
		return pageName;
	}
	
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * 页面跳转
	 * 
	 * @return
	 */
	public String pageJump() {
		return pageName;
	}
}
