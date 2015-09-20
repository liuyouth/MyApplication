package com.rescam.xhb.framework.service;

import java.util.List;
import java.util.Map;

import com.rescam.xhb.common.service.BasicService;
import com.rescam.xhb.framework.entity.DeliveryAddress;

public interface DeliveryAddressService extends BasicService<DeliveryAddress> {
	
	//根据客户id查询默认收货人信息
	public Map<String ,Object> getDefaultLinkPersonInfoByCustomerId(int customerId);
	
	//获取收货人信息列表
	public List<Map<String ,Object>> getLinkPersonInfoListByCustomerId(int customerId);
}
