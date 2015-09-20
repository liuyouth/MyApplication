package com.rescam.xhb.framework.dao;

import java.util.List;
import java.util.Map;

import com.rescam.xhb.common.dao.BasicDao;
import com.rescam.xhb.framework.entity.Order;

public interface OrderDao extends BasicDao<Order> {
	//根据批次号查询该批次下的所有订单详情
	public List<Map<String, Object>> getOrderListByOrderBatchId(int orderBatchId);
}
