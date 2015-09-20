package com.rescam.xhb.framework.entity;
/**
 * 订单
 * @author xueyang
 *
 */
public class Order {
	
	//订单的属性
	private Integer orderId;//订单id
	private Integer orderBatchId;//批次id
	private Integer customerId;//客户id
	private String orderCode;//订单编号
	private String orderTime;//订单时间
	private String payStatus;//支付状态
	private String payTime;//支付时间
	private Integer goodsId;//商品id
	private String goodsType;//商品种类
	private String goodsName;//商品名称
	private String goodsPrice;//单价
	private Integer orderNumber;//购买数量
	private String totalPrice;//总金额
	private String linkman;//联系人
	private String linkmanPhone;//联系人电话
	private String linkmanAddress;//配送地址
	private String tripTime;//出行时间
	private String fromAddress;//出发地
	private String toAddress;//目的地
	private String customerMessage;//客户留言
	private Integer electronicGoodsId;//电子商品id
	private String orderStatus;//状态（0：未支付，1：支付，2：过期，3：退货，4：退款）
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

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
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmanPhone() {
		return linkmanPhone;
	}
	public void setLinkmanPhone(String linkmanPhone) {
		this.linkmanPhone = linkmanPhone;
	}

	public String getLinkmanAddress() {
		return linkmanAddress;
	}
	public void setLinkmanAddress(String linkmanAddress) {
		this.linkmanAddress = linkmanAddress;
	}

	public String getTripTime() {
		return tripTime;
	}
	public void setTripTime(String tripTime) {
		this.tripTime = tripTime;
	}

	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getCustomerMessage() {
		return customerMessage;
	}
	public void setCustomerMessage(String customerMessage) {
		this.customerMessage = customerMessage;
	}

	public Integer getElectronicGoodsId() {
		return electronicGoodsId;
	}
	public void setElectronicGoodsId(Integer electronicGoodsId) {
		this.electronicGoodsId = electronicGoodsId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order(Integer orderId, Integer orderBatchId, Integer customerId, 
			String orderCode, String orderTime, String payStatus, String payTime, 
			Integer goodsId, String goodsType, String goodsName, String goodsPrice, 
			Integer orderNumber, String totalPrice, String linkman, String linkmanPhone, 
			String linkmanAddress, String tripTime, String fromAddress, String toAddress, 
			String customerMessage, Integer electronicGoodsId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderBatchId = orderBatchId;
		this.customerId = customerId;
		this.orderCode = orderCode;
		this.orderTime = orderTime;
		this.payStatus = payStatus;
		this.payTime = payTime;
		this.goodsId = goodsId;
		this.goodsType = goodsType;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.orderNumber = orderNumber;
		this.totalPrice = totalPrice;
		this.linkman = linkman;
		this.linkmanPhone = linkmanPhone;
		this.linkmanAddress = linkmanAddress;
		this.tripTime = tripTime;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.customerMessage = customerMessage;
		this.electronicGoodsId = electronicGoodsId;
		this.orderStatus = orderStatus;
	}
	
	public Order() {
		super();
	}
	
	
}
