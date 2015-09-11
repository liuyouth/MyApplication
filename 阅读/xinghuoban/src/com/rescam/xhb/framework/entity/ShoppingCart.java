package com.rescam.xhb.framework.entity;
/**
 * 购物车
 * @author xueyang
 *
 */
public class ShoppingCart {
	
	//购物车的属性
	private Integer shoppingCartId;//购物车id
	private Integer customerId;//客户id
	private String shoppingGoods;//购物车数据
	
	//购物车的属性
	public Integer getShoppingCartId() {
		return shoppingCartId;
	}
	public void setShoppingCartId(Integer shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	public String getShoppingGoods() {
		return shoppingGoods;
	}
	public void setShoppingGoods(String shoppingGoods) {
		this.shoppingGoods = shoppingGoods;
	}
	
	public ShoppingCart(Integer shoppingCartId, Integer customerId, String shoppingGoods) {
		super();
		this.shoppingCartId = shoppingCartId;
		this.customerId = customerId;
		this.shoppingGoods = shoppingGoods;
	}
	
	public ShoppingCart() {
		super();
	}
	
}
