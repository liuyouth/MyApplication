package com.rescam.xhb.framework.entity;
/**
 * 订单批次
 * @author xueyang
 *
 */
public class OrderBatch {
	
	//订单的属性
	private Integer orderBatchId;//批次id
	private Integer customerId;//客户id
	private String orderBatchCode;//批次编号
	private Integer orderTotal;//订单总数
	private Integer validOrderCount;//有效订单数量
	private String OrderTime;//订单时间
	private String orderBatchStatus;//状态(0：未支付，1：支付，2：过期)
	

	public Integer getOrderBatchId() {
		return orderBatchId;
	}
	public void setOrderBatchId(Integer orderBatchId) {
		this.orderBatchId = orderBatchId;
	}

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	public String getOrderBatchCode() {
		return orderBatchCode;
	}
	public void setOrderBatchCode(String orderBatchCode) {
		this.orderBatchCode = orderBatchCode;
	}
	
	public Integer getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Integer orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	public Integer getValidOrderCount() {
		return validOrderCount;
	}
	public void setValidOrderCount(Integer validOrderCount) {
		this.validOrderCount = validOrderCount;
	}
	
	public String getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}
	
	public String getOrderBatchStatus() {
		return orderBatchStatus;
	}
	public void setOrderBatchStatus(String orderBatchStatus) {
		this.orderBatchStatus = orderBatchStatus;
	}
	
	public OrderBatch(Integer orderBatchId, Integer customerId, String orderBatchCode, Integer orderTotal,
			Integer validOrderCount, String orderBatchStatus) {
		super();
		this.orderBatchId = orderBatchId;
		this.customerId = customerId;
		this.orderBatchCode = orderBatchCode;
		this.orderTotal = orderTotal;
		this.validOrderCount = validOrderCount;
		this.orderBatchStatus = orderBatchStatus;
	}
	
	public OrderBatch() {
		super();
	}
	
	
}
