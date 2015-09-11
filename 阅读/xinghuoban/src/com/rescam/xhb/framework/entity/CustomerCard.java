package com.rescam.xhb.framework.entity;

/**
 * 
 * @author liubo
 *
 */
public class CustomerCard {
	private Integer customerId;
	private Integer customerCardId;
	private String cardNumber;
	private String cardType;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getCustomerCardId() {
		return customerCardId;
	}

	public void setCustomerCardId(Integer customerCardId) {
		this.customerCardId = customerCardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public CustomerCard() {
		super();
	}

}
