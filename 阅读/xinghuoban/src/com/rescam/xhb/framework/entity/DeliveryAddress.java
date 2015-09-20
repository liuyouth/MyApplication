package com.rescam.xhb.framework.entity;
/**
 * 客户配送地址
 * @author xueyang
 *
 */
public class DeliveryAddress {
	
	//客户配送地址的属性
	private Integer deliveryAddressId;//配送地址id
	private Integer customerId;//客户id
	private String consigneeName;//收货人姓名
	private String consigneePhone;//收货人联系电话
	private String consigneeAddress;//配送地址
	private String isDefaultAddress;//是否为默认配送地址（0：否 ，1：是）
	

	public Integer getDeliveryAddressId() {
		return deliveryAddressId;
	}
	public void setDeliveryAddressId(Integer deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getIsDefaultAddress() {
		return isDefaultAddress;
	}
	public void setIsDefaultAddress(String isDefaultAddress) {
		this.isDefaultAddress = isDefaultAddress;
	}

	public DeliveryAddress(Integer deliveryAddressId, Integer customerId, 
			String consigneeName, String consigneePhone, String consigneeAddress,
			String isDefaultAddress) {
		super();
		this.deliveryAddressId = deliveryAddressId;
		this.customerId = customerId;
		this.consigneeName = consigneeName;
		this.consigneePhone = consigneePhone;
		this.consigneeAddress = consigneeAddress;
		this.isDefaultAddress = isDefaultAddress;
	}
	
	public DeliveryAddress() {
		super();
	}
	
	
}
