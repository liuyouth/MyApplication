package com.rescam.xhb.framework.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.rescam.xhb.common.dao.BasicDaoImpl;
import com.rescam.xhb.framework.dao.OrderBatchDao;
import com.rescam.xhb.framework.entity.OrderBatch;

/**
 * 商品DAO实现
 * 
 * @author xueyang
 * 
 */
public class OrderBatchDaoImpl extends BasicDaoImpl<OrderBatch>implements OrderBatchDao {

	@Override
	public OrderBatch findById(Integer id) throws HibernateException {
		return super.findById(id);
	}

	@Override
	public void saveEntity(OrderBatch entity) throws HibernateException {
		super.saveEntity(entity);
	}

	@Override
	public void deleteEntity(OrderBatch entity) throws HibernateException {
		super.deleteEntity(entity);
	}

	@Override
	public void updateEntity(OrderBatch entity) throws HibernateException {
		super.updateEntity(entity);
	}

	@Override
	public List<OrderBatch> findByPage(String hql, int currentpage, int pageSize, Object... params) {
		return super.findByPage(hql, currentpage, pageSize, params);
	}

	@Override
	public List<OrderBatch> findByPage(int currentpage, int pageSize) {
		return super.findByPage(currentpage, pageSize);
	}

	@Override
	public Integer getCount(String hql, Object... params) {
		return super.getCount(hql, params);
	}

	@Override
	public Integer getCount() {
		return super.getCount();
	}

	// 根据批次号查批次详情
	@SuppressWarnings("rawtypes")
	@Override
	public Map<String, Object> getOrderBatchByOrderBatchCode(String orderBatchCode) {
		List list = new ArrayList();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		try {
			String sql = "SELECT order_batch.order_batch_id,order_batch.customer_id,"
					+ "order_batch.order_batch_code, order_batch.order_total, order_batch.valid_order_count,"
					+ "order_batch.order_time,order_batch.order_batch_status FROM order_batch " 
					+ "WHERE order_batch.order_batch_code = '"
					+ orderBatchCode + "'";

			Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql);

			list = query.list();
			for (int i = 0; i < list.size(); i++) {
				Object[] ob = (Object[]) list.get(i);
				dataMap = new HashMap<String, Object>();

				dataMap.put("orderBatchId", ob[0]);
				dataMap.put("customerId", ob[1]);
				dataMap.put("orderBatchCode", ob[2]);
				dataMap.put("orderTotal", ob[3]);
				dataMap.put("validOrderCount", ob[4]);
				dataMap.put("orderTime", ob[5]);
				dataMap.put("orderBatchStatus", ob[6]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMap;
	}

	// 根据客户id查订单批次列表
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map<String, Object>> getOrderBatchListByCustomerIdAndStatus(int customerId, String orderBatchStatus) {
		List list = new ArrayList();

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();

		try {
			String sql = "SELECT order_batch.order_batch_id,order_batch.customer_id,"
					+ "order_batch.order_batch_code, order_batch.order_total, order_batch.valid_order_count,"
					+ "order_batch.order_time,order_batch.order_batch_status FROM order_batch " 
					+ "WHERE order_batch.customer_id = "
					+ customerId + " AND order_batch.order_batch_status = " + orderBatchStatus;

			Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql);

			list = query.list();
			for (int i = 0; i < list.size(); i++) {
				Object[] ob = (Object[]) list.get(i);
				Map<String, Object> dataMap = new HashMap<String, Object>();
				
				dataMap.put("orderBatchId", ob[0]);
				dataMap.put("customerId", ob[1]);
				dataMap.put("orderBatchCode", ob[2]);
				dataMap.put("orderTotal", ob[3]);
				dataMap.put("validOrderCount", ob[4]);
				
				Date orderTime = (Date) ob[5];// 订单时间
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
				
				dataMap.put("orderTime", sdf.format(orderTime));
				dataMap.put("orderBatchStatus", ob[6]);

				listMap.add(dataMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMap;
	}
}
