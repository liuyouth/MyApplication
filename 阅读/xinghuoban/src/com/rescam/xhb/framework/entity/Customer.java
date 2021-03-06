package com.rescam.xhb.framework.entity;

import java.sql.Date;

/**
 * 
 * @author liubo
 *
 */
public class Customer {
	private Integer customerId;
	private Integer cardCount;
	private Integer deliveryAddressCount;
	private String customerName;
	private String customerPhone;
	private String customerOpenId;
	private String customerAccount;
	private String weixinOpenId;
	private String walletAccount;
	private String customerSex;
	private Date customerBirthday;
	private String customerStatus;
	private Double walletBalance;
	private int walletWaring ;
	
	public int getWalletWaring() {
		return walletWaring;
	}

	public void setWalletWaring(int walletWaring) {
		this.walletWaring = walletWaring;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getCardCount() {
		return cardCount;
	}

	public void setCardCount(Integer cardCount) {
		this.cardCount = cardCount;
	}

	public Integer getDeliveryAddressCount() {
		return deliveryAddressCount;
	}

	public void setDeliveryAddressCount(Integer deliveryAddressCount) {
		this.deliveryAddressCount = deliveryAddressCount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerOpenId() {
		return customerOpenId;
	}

	public void setCustomerOpenId(String customerOpenId) {
		this.customerOpenId = customerOpenId;
	}

	public String getCustomerAccount() {
		return customerAccount;
	}

	public void setCustomerAccount(String customerAccount) {
		this.customerAccount = customerAccount;
	}

	public String getWeixinOpenId() {
		return weixinOpenId;
	}

	public void setWeixinOpenId(String weixinOpenId) {
		this.weixinOpenId = weixinOpenId;
	}

	public String getWalletAccount() {
		return walletAccount;
	}

	public void setWalletAccount(String walletAccount) {
		this.walletAccount = walletAccount;
	}

	public String getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	public Date getCustomerBirthday() {
		return customerBirthday;
	}

	public void setCustomerBirthday(Date customerBirthday) {
		this.customerBirthday = customerBirthday;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	public Double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(Double walletBalance) {
		this.walletBalance = walletBalance;
	}

	public Customer() {
		super();
	}
	
	
	
}
