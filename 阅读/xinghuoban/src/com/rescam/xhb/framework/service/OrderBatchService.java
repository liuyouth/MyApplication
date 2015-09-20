package com.rescam.xhb.framework.service;

import java.util.List;
import java.util.Map;

import com.rescam.xhb.common.service.BasicService;
import com.rescam.xhb.framework.entity.OrderBatch;

public interface OrderBatchService extends BasicService<OrderBatch> {

	// 根据批次号查批次详情
	public Map<String, Object> getOrderBatchByOrderBatchCode(String orderBatchCode);

	// 根据客户id、订单状态查订单批次列表
	public List<Map<String, Object>> getOrderBatchListByCustomerIdAndStatus(int customerId, String orderBatchStatus);
}
