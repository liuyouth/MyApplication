package com.rescam.xhb.framework.service;

import java.util.List;
import java.util.Map;

import com.rescam.xhb.common.service.BasicService;
import com.rescam.xhb.framework.entity.Order;

public interface OrderService extends BasicService<Order> {
	//根据批次号查询该批次下的所有订单详情
	public List<Map<String, Object>> getOrderListByOrderBatchId(int orderBatchId);
}
