package com.rescam.xhb.framework.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.rescam.xhb.common.action.BasicAction;
import com.rescam.xhb.framework.entity.DeliveryAddress;
import com.rescam.xhb.framework.service.DeliveryAddressService;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class DeliveryAddressAction extends BasicAction implements ModelDriven<DeliveryAddress> {

	private DeliveryAddress deliveryAddress = new DeliveryAddress();

	public DeliveryAddress getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public DeliveryAddress getModel() {
		return deliveryAddress;
	}

	private JSONObject jsonObj;

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	private DeliveryAddressService deliveryAddressService;
	
	
	public DeliveryAddressService getDeliveryAddressService() {
		return deliveryAddressService;
	}
	public void setDeliveryAddressService(DeliveryAddressService deliveryAddressService) {
		this.deliveryAddressService = deliveryAddressService;
	}
	
	//根据客户id查询默认收货人信息
	public String getDefaultLinkPersonInfoByCustomerId(){
		int customerId = 1;//应从session中获取
		Map<String ,Object> dataMap = deliveryAddressService.getDefaultLinkPersonInfoByCustomerId(customerId);
		
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		if(!dataMap.containsKey("deliveryAddressId")){
			jsonMap.put("dataMap", "");
		}else{
			jsonMap.put("dataMap", dataMap);
		}
		jsonObj = JSONObject.fromObject(jsonMap);
		
		return SUCCESS;
	}
	
	//添加收货人信息
	public String addLinkPersonInfo(){
		int customerId = 1;//应从session中获取
		deliveryAddress.setCustomerId(customerId);
		
		//查询客户是否有默认
		Map<String ,Object> dataMap = deliveryAddressService.getDefaultLinkPersonInfoByCustomerId(customerId);
		if(!dataMap.containsKey("deliveryAddressId")){
			//证明客户没有默认收货人信息，也就是没有收货人信息
			deliveryAddress.setIsDefaultAddress("1");
		}else{
			deliveryAddress.setIsDefaultAddress("0");
		}
		deliveryAddressService.saveEntity(deliveryAddress);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("success", true);
		jsonMap.put("msg", "添加成功！");
		jsonObj = JSONObject.fromObject(jsonMap);
		
		return SUCCESS;
	}
	
	//获取收货人信息列表
	public String getLinkPersonInfoListByCustomerId(){
		int customerId = 1;//应从session中获取
		
		List<Map<String ,Object>> dataList 
			= deliveryAddressService.getLinkPersonInfoListByCustomerId(customerId);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("dataList", dataList);
		jsonObj = JSONObject.fromObject(jsonMap);
		
		return SUCCESS;
	}
}
