package com.rescam.xhb.framework.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.rescam.xhb.common.service.BasicServiceImpl;
import com.rescam.xhb.framework.dao.OrderDao;
import com.rescam.xhb.framework.entity.Order;
import com.rescam.xhb.framework.service.OrderService;

/**
 * 订单service
 * 
 * @author xueyang
 *
 */
public class OrderServiceImpl extends BasicServiceImpl<Order>implements OrderService {

	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public Order findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public void saveEntity(Order entity) {
		// TODO Auto-generated method stub
		super.saveEntity(entity);
	}

	@Override
	public void deleteEntity(Order entity) throws HibernateException {
		super.deleteEntity(entity);
	}

	@Override
	public void updateEntity(Order entity) throws HibernateException {
		super.updateEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findByPage(String hql, int currentpage, int pageSize, Object... params) {
		return super.findBySqlPage(hql, currentpage, pageSize, params);
	}

	@Override
	public List<Order> findByPage(int currentpage, int pageSize) {
		// TODO Auto-generated method stub
		return super.findByPage(currentpage, pageSize);
	}

	@Override
	public Integer getCount(String hql, List<Object> params) {
		// TODO Auto-generated method stub
		return super.getCount(hql, params);
	}

	@Override
	public Integer getCount() {
		// TODO Auto-generated method stub
		return super.getCount();
	}
	
	//根据批次号查询该批次下的所有订单详情
	@Override
	public List<Map<String, Object>> getOrderListByOrderBatchId(int orderBatchId){
		List<Map<String, Object>> dataList = orderDao.getOrderListByOrderBatchId(orderBatchId);
		return dataList;
	}

}
