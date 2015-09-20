package com.rescam.xhb.common.timer;

import java.util.List;
import java.util.TimerTask;

import com.rescam.xhb.framework.service.OrderBatchService;
import com.rescam.xhb.framework.service.OrderService;

public class OrderStatusTimer extends TimerTask {
	private OrderService orderService;

	private OrderBatchService orderBatchService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderBatchService getOrderBatchService() {
		return orderBatchService;
	}

	public void setOrderBatchService(OrderBatchService orderBatchService) {
		this.orderBatchService = orderBatchService;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void run() {
		List list = orderService
		        .findBySql("select order_id,order_batch_id from `order` where timestampdiff(MINUTE,order_time,NOW()) > 45 and order_status = '1'");
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Object[] obj = (Object[]) list.get(i);
				int oi = Integer.parseInt(String.valueOf(obj[0]));
				int obi = Integer.parseInt(String.valueOf(obj[1]));
				orderService
				        .saveOrUpdateBySql("update `order` set order_status = '2' where order_id = "
				                + oi);
				orderBatchService
				        .saveOrUpdateBySql("update `order_batch` set order_batch_status = '2' where order_batch_id = "
				                + obi);
			}
		}
	}

}
