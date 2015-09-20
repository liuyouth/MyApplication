package com.rescam.xhb.framework.action;

import com.opensymphony.xwork2.ActionSupport;
import com.rescam.xhb.framework.entity.Supplier;

public class PageAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String pageName;
	private String goodsId;
	private String isAdd;
	private String SupplierId;
	private Supplier supplier;
	private String goodsIds;
	private String goodsNums;
	private String orderBatchCode;
	private String totalPrice;
	private int orderBatchId;//批次号
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getSupplierId() {
		return SupplierId;
	}
	public void setSupplierId(String supplierId) {
		SupplierId = supplierId;
	}

	public String getIsAdd() {
		return isAdd;
	}
	public void setIsAdd(String isAdd) {
		this.isAdd = isAdd;
	}

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

	public String getGoodsIds() {
		return goodsIds;
	}
	public void setGoodsIds(String goodsIds) {
		this.goodsIds = goodsIds;
	}
	
	public String getGoodsNums() {
		return goodsNums;
	}
	public void setGoodsNums(String goodsNums) {
		this.goodsNums = goodsNums;
	}
	
	public String getOrderBatchCode() {
		return orderBatchCode;
	}
	public void setOrderBatchCode(String orderBatchCode) {
		this.orderBatchCode = orderBatchCode;
	}
	
	public int getOrderBatchId() {
		return orderBatchId;
	}
	public void setOrderBatchId(int orderBatchId) {
		this.orderBatchId = orderBatchId;
	}
	
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
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
