package com.rescam.xhb.framework.pojo;


public class SessionObj {
	private Integer manageUserId;
	private String manageUserName;
	private Integer authorityGroupId;
	private Integer customerId;
	private String weixinOpenId;
	private int supplierId;
	private String supplierAccount;
	private String supplierName;

	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int i) {
		this.supplierId = i;
	}
	public String getSupplierAccount() {
		return supplierAccount;
	}
	public void setSupplierAccount(String supplierAccount) {
		this.supplierAccount = supplierAccount;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Integer getAuthorityGroupId() {
		return authorityGroupId;
	}
	public void setAuthorityGroupId(Integer authorityGroupId) {
		this.authorityGroupId = authorityGroupId;
	}
	public Integer getManageUserId() {
		return manageUserId;
	}
	public void setManageUserId(Integer manageUserId) {
		this.manageUserId = manageUserId;
	}
	public String getManageUserName() {
		return manageUserName;
	}
	public void setManageUserName(String manageUserName) {
		this.manageUserName = manageUserName;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getWeixinOpenId() {
		return weixinOpenId;
	}
	public void setWeixinOpenId(String weixinOpenId) {
		this.weixinOpenId = weixinOpenId;
	}
	
	
}
