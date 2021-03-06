package com.rescam.xhb.framework.entity;
/**
 * 商品
 * @author xueyang
 *
 */
public class Goods {
	
	//商品的属性
	private Integer goodsId;//商品id
	private Integer supplierId;//供应商id
	private String goodsType;//商品种类 0：实物商品 1：电子商品 2：出行服务
	private Integer goodsCatalogId;//目录id
	private String goodsName;//商品名称
	private String goodsIntroduce;//商品介绍
	private String serviceHotline;//服务热线
	private String goodsPrice;//单价
	private String chargeUnit;//计价单位
	private String goodsSalesStatus;//销售状态 0：已下架1：未上架2：已上架
	private Integer total;//总量
	private Integer sold;//已售
	private Integer inventories;//库存
	private String inputTime;//录入时间
	private String onSaleTime;//上架时间
	private String offSaleTime;//下架时间
	private String validTime;//上架时间
	private String invalidTime;//下架时间
	
	//商品图片属性
	/*private Integer goodsImageId;//图片id
	private String imagePath;//图片路径
	private String goodsImageStatus;//图片状态 0:已删除 1:未删除*/
	
	//商品优惠属性
	/*private Integer goodsPreferentialId;//优惠id
	private Integer preferentialType;//优惠类型
	private Integer discount;//折扣
	private Integer goodsPreferentialStatus;//状态  0:无效  1:有效*/
	
	//商品的属性
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public Integer getGoodsCatalogId() {
		return goodsCatalogId;
	}
	public void setGoodsCatalogId(Integer goodsCatalogId) {
		this.goodsCatalogId = goodsCatalogId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsIntroduce() {
		return goodsIntroduce;
	}
	public void setGoodsIntroduce(String goodsIntroduce) {
		this.goodsIntroduce = goodsIntroduce;
	}
	public String getServiceHotline() {
		return serviceHotline;
	}
	public void setServiceHotline(String serviceHotline) {
		this.serviceHotline = serviceHotline;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getChargeUnit() {
		return chargeUnit;
	}
	public void setChargeUnit(String chargeUnit) {
		this.chargeUnit = chargeUnit;
	}
	public String getGoodsSalesStatus() {
		return goodsSalesStatus;
	}
	public void setGoodsSalesStatus(String goodsSalesStatus) {
		this.goodsSalesStatus = goodsSalesStatus;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getSold() {
		return sold;
	}
	public void setSold(Integer sold) {
		this.sold = sold;
	}
	public Integer getInventories() {
		return inventories;
	}
	public void setInventories(Integer inventories) {
		this.inventories = inventories;
	}
	public String getInputTime() {
		return inputTime;
	}
	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
	}
	public String getOnSaleTime() {
		return onSaleTime;
	}
	public void setOnSaleTime(String onSaleTime) {
		this.onSaleTime = onSaleTime;
	}
	public String getOffSaleTime() {
		return offSaleTime;
	}
	public void setOffSaleTime(String offSaleTime) {
		this.offSaleTime = offSaleTime;
	}
	public String getValidTime() {
		return validTime;
	}
	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}
	public String getInvalidTime() {
		return invalidTime;
	}
	public void setInvalidTime(String invalidTime) {
		this.invalidTime = invalidTime;
	}
	
	//商品图片属性
	/*public Integer getGoodsImageId() {
		return goodsImageId;
	}
	public void setGoodsImageId(Integer goodsImageId) {
		this.goodsImageId = goodsImageId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getGoodsImageStatus() {
		return goodsImageStatus;
	}
	public void setGoodsImageStatus(String goodsImageStatus) {
		this.goodsImageStatus = goodsImageStatus;
	}*/
	
	//商品优惠属性
	/*public Integer getGoodsPreferentialId() {
		return goodsPreferentialId;
	}
	public void setGoodsPreferentialId(Integer goodsPreferentialId) {
		this.goodsPreferentialId = goodsPreferentialId;
	}
	public Integer getPreferentialType() {
		return preferentialType;
	}
	public void setPreferentialType(Integer preferentialType) {
		this.preferentialType = preferentialType;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getGoodsPreferentialStatus() {
		return goodsPreferentialStatus;
	}
	public void setGoodsPreferentialStatus(Integer goodsPreferentialStatus) {
		this.goodsPreferentialStatus = goodsPreferentialStatus;
	}*/
	
	public Goods(Integer goodsId, Integer supplierId, String goodsType, Integer goodsCatalogId,
			String goodsName, String goodsIntroduce, String serviceHotline, String goodsPrice, 
			String goodsSalesStatus, Integer total, Integer sold, Integer inventories, 
			String inputTime, String onSaleTime, String offSaleTime) {
		super();
		this.goodsId = goodsId;
		this.supplierId = supplierId;
		this.goodsType = goodsType;
		this.goodsCatalogId = goodsCatalogId;
		this.goodsName = goodsName;
		this.goodsIntroduce = goodsIntroduce;
		this.serviceHotline = serviceHotline;
		this.goodsPrice = goodsPrice;
		this.goodsSalesStatus = goodsSalesStatus;
		this.total = total;
		this.sold = sold;
		this.inventories = inventories;
		this.inputTime = inputTime;
		this.onSaleTime = onSaleTime;
		this.offSaleTime = offSaleTime;
		
		/*this.goodsImageId = goodsImageId;
		this.imagePath = imagePath;
		this.goodsImageStatus = goodsImageStatus;
		
		this.goodsPreferentialId = goodsPreferentialId;
		this.preferentialType = preferentialType;
		this.discount = discount;
		this.goodsPreferentialStatus = goodsPreferentialStatus;*/
	}
	
	public Goods() {
		super();
	}
	
	
}
