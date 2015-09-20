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
import com.rescam.xhb.framework.dao.OrderDao;
import com.rescam.xhb.framework.entity.Order;

/**
 * 商品DAO实现
 * 
 * @author xueyang
 * 
 */
public class OrderDaoImpl extends BasicDaoImpl<Order>implements OrderDao {

	@Override
	public Order findById(Integer id) throws HibernateException {
		return super.findById(id);
	}

	@Override
	public void saveEntity(Order entity) throws HibernateException {
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

	@Override
	public List<Order> findByPage(String hql, int currentpage, int pageSize, Object... params) {
		return super.findByPage(hql, currentpage, pageSize, params);
	}

	@Override
	public List<Order> findByPage(int currentpage, int pageSize) {
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

	// 根据批次号查询该批次下的所有订单详情
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map<String, Object>> getOrderListByOrderBatchId(int orderBatchId) {
		List list = new ArrayList();

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();

		try {
			String sql = "SELECT order.order_id, order.order_batch_id, order.customer_id, order.order_code, order.order_time, "
					+ "order.pay_status, order.pay_time, order.goods_id, order.goods_type, order.goods_name, "
					+ "order.goods_price, order.order_number, order.total_price, order.linkman, order.linkman_phone, "
					+ "order.linkman_address, order.trip_time, order.from_address, order.to_address, order.customer_message, "
					+ "order.electronic_goods_id, order.order_status FROM `order` " + " WHERE order.order_batch_id = "
					+ orderBatchId;

			Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql);

			list = query.list();
			for (int i = 0; i < list.size(); i++) {
				Object[] ob = (Object[]) list.get(i);
				Map<String, Object> dataMap = new HashMap<String, Object>();

				dataMap.put("orderId", ob[0]);
				dataMap.put("orderBatchId", ob[1]);
				dataMap.put("customerId", ob[2]);
				dataMap.put("orderCode", ob[3]);
				Date orderTime = (Date) ob[4];//订单时间
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
				dataMap.put("orderTime", sdf.format(orderTime));
				dataMap.put("payStatus", ob[5]);
				
				if(ob[6] == null){
					dataMap.put("payTime", "");
				}else{
					Date payTime = (Date) ob[6];//支付时间
					dataMap.put("payTime", sdf.format(payTime));
				}
				
				dataMap.put("goodsId", ob[7]);
				dataMap.put("goodsType", ob[8]);
				dataMap.put("goodsName", ob[9]);
				dataMap.put("goodsPrice", ob[10]);
				dataMap.put("orderNumber", ob[11]);
				dataMap.put("totalPrice", ob[12]);
				dataMap.put("linkman", ob[13]);
				dataMap.put("linkmanPhone", ob[14]);
				dataMap.put("linkmanAddress", ob[15]);
				if(ob[16] == null){
					dataMap.put("tripTime", "");
				}else{
					Date tripTime = (Date) ob[16];//出行时间
					dataMap.put("tripTime", sdf.format(tripTime));
				}
				dataMap.put("fromAddress", ob[17]);
				dataMap.put("toAddress", ob[18]);
				dataMap.put("customerMessage", ob[19]);
				dataMap.put("electronicGoodsId", ob[20]);
				dataMap.put("orderStatus", ob[21]);

				listMap.add(dataMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMap;
	}
}
