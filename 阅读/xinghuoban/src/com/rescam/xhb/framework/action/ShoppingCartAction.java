package com.rescam.xhb.framework.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.rescam.xhb.common.action.BasicAction;
import com.rescam.xhb.framework.entity.ShoppingCart;
import com.rescam.xhb.framework.service.GoodsPreferentialService;
import com.rescam.xhb.framework.service.GoodsService;
import com.rescam.xhb.framework.service.ShoppingCartService;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class ShoppingCartAction extends BasicAction implements ModelDriven<ShoppingCart> {

	private ShoppingCart shoppingCart = new ShoppingCart();
	private String goodsId;
	private String goodsNum;

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	
	@Override
	public ShoppingCart getModel() {
		return shoppingCart;
	}
	
	private JSONObject jsonObj;

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	private ShoppingCartService shoppingCartService;

	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}
	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	
	public GoodsPreferentialService getGoodsPreferentialService() {
		return goodsPreferentialService;
	}
	public void setGoodsPreferentialService(GoodsPreferentialService goodsPreferentialService) {
		this.goodsPreferentialService = goodsPreferentialService;
	}
	
	private GoodsService goodsService;
	private GoodsPreferentialService goodsPreferentialService;
	
	public GoodsService getGoodsService() {
		return goodsService;
	}
	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}
	//添加商品进购物车
	public String addGoodsToShoppingCart(){
		
		int customerId = 1;//先默认，随便写
		
		shoppingCartService.addGoodsToShoppingCart(goodsId, goodsNum, customerId);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("success", true);
		jsonObj = JSONObject.fromObject(jsonMap);
		
		return SUCCESS;
	}
	
	//查询购物车中商品数据列表
	public String getShoppingCartGoodsList(){
		
		int customerId = 1;//先默认，随便写
		
		//先查询购物车中商品总数据数量
		int total = shoppingCartService.getShoppingCartGoodsNum(customerId);
		
		//查询购物车中商品数据列表（分页）
		List<Map<String ,Object>> dataList = shoppingCartService.getShoppingCartGoodsList(customerId);
		
		List<Map<String ,Object>> returnList = new ArrayList<Map<String ,Object>>();
		//循环list,根据里面的商品id查询商品信息
		for(int i=0;i<dataList.size();i++){
			Map<String ,Object> dataMap = dataList.get(i);
			String goodsId = (String) dataMap.get("goodsId");
			String goodsNum = (String) dataMap.get("goodsNum");
			
			//根据商品id取商品详情
			Map<String ,Object> goodsMap = goodsService.getGoodsDetailById(Integer.parseInt(goodsId));
			
			//取当前商品关联图片的详情数据（商品信息详情展示使用）
			List<Map<String ,Object>> imageListData = goodsService.getGoodsImageListByIdAndType(Integer.parseInt(goodsId), "1");//(商品id，商品图片状态)
			if(imageListData.size() == 0){
				goodsMap.put("imagePath", null);
			}else{
				for(int j=0;j<imageListData.size();j++){
					Map<String ,Object> imageData = imageListData.get(j);
					char isDefault = (char) imageData.get("isDefault");
					if('1' == isDefault){
						//是否认图片
						goodsMap.put("imagePath", imageData.get("imagePath"));
					}
				}
			}
			
			goodsMap.put("goodsNum", goodsNum);
			
			//根据商品id取商品优惠详情
			Map<String, Object> preferentialMap = goodsPreferentialService.getGoodsPreferentialDetailById(Integer.parseInt(goodsId));
			if(null == preferentialMap || !preferentialMap.containsKey("goodsPreferentialId")){
				goodsMap.put("goodsPreferentialId", "");
				goodsMap.put("preferentialType", "");
				goodsMap.put("discount", "");
				goodsMap.put("groupPrice", "");
				goodsMap.put("goodsPreferentialStatus", "");
			}else{
				goodsMap.put("goodsPreferentialId", preferentialMap.get("goodsPreferentialId"));
				goodsMap.put("preferentialType", preferentialMap.get("preferentialType"));
				goodsMap.put("discount", preferentialMap.get("discount"));
				goodsMap.put("groupPrice", preferentialMap.get("groupPrice"));
				goodsMap.put("goodsPreferentialStatus", preferentialMap.get("goodsPreferentialStatus"));
			}
			
			returnList.add(goodsMap);
		}
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("goodsList", returnList);
		jsonObj = JSONObject.fromObject(jsonMap);
		
		return SUCCESS;
	}
}
