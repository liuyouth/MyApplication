package com.rescam.xhb.framework.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.rescam.xhb.common.dao.BasicDaoImpl;
import com.rescam.xhb.framework.dao.DeliveryAddressDao;
import com.rescam.xhb.framework.entity.DeliveryAddress;

/**
 * 商品DAO实现
 * 
 * @author xueyang
 * 
 */
public class DeliveryAddressDaoImpl extends BasicDaoImpl<DeliveryAddress>implements DeliveryAddressDao {

	@Override
	public DeliveryAddress findById(Integer id) throws HibernateException {
		return super.findById(id);
	}

	@Override
	public void saveEntity(DeliveryAddress entity) throws HibernateException {
		super.saveEntity(entity);
	}

	@Override
	public void deleteEntity(DeliveryAddress entity) throws HibernateException {
		super.deleteEntity(entity);
	}

	@Override
	public void updateEntity(DeliveryAddress entity) throws HibernateException {
		super.updateEntity(entity);
	}

	@Override
	public List<DeliveryAddress> findByPage(String hql, int currentpage, int pageSize, Object... params) {
		return super.findByPage(hql, currentpage, pageSize, params);
	}

	@Override
	public List<DeliveryAddress> findByPage(int currentpage, int pageSize) {
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
	
	//根据客户id查询默认收货人信息
	@SuppressWarnings("rawtypes")
	@Override
	public Map<String ,Object> getDefaultLinkPersonInfoByCustomerId(int customerId){
		
		List list = new ArrayList();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		try {
			String sql = "SELECT delivery_address.delivery_address_id, "
					+"delivery_address.customer_id, delivery_address.consignee_name, "
					+"delivery_address.consignee_phone, delivery_address.consignee_address, "
					+"delivery_address.is_default_address "
					+"FROM delivery_address "
					+"WHERE delivery_address.customer_id = " + customerId
					+" AND delivery_address.is_default_address = 1";
			
			Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql);
			
			list = query.list();
			for (int i = 0; i < list.size(); i++) {
				Object[] ob = (Object[]) list.get(i);
				dataMap = new HashMap<String, Object>();
				
				dataMap.put("deliveryAddressId", ob[0]);
				dataMap.put("customerId", ob[1]);
				dataMap.put("consigneeName", ob[2]);
				dataMap.put("consigneePhone", ob[3]);
				dataMap.put("consigneeAddress", ob[4]);
				dataMap.put("isDefaultAddress", ob[5]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMap;
	}
	
	//获取收货人信息列表
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map<String ,Object>> getLinkPersonInfoListByCustomerId(int customerId){
		
		List list = new ArrayList();
		List<Map<String ,Object>> dataList = new ArrayList<Map<String ,Object>>();
		
		try {
			String sql = "SELECT delivery_address.delivery_address_id, "
					+"delivery_address.customer_id, delivery_address.consignee_name, "
					+"delivery_address.consignee_phone, delivery_address.consignee_address, "
					+"delivery_address.is_default_address "
					+"FROM delivery_address "
					+"WHERE delivery_address.customer_id = " + customerId;
			
			Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql);
			
			list = query.list();
			for (int i = 0; i < list.size(); i++) {
				Object[] ob = (Object[]) list.get(i);
				Map<String, Object> dataMap = new HashMap<String, Object>();
				
				dataMap.put("deliveryAddressId", ob[0]);
				dataMap.put("customerId", ob[1]);
				dataMap.put("consigneeName", ob[2]);
				dataMap.put("consigneePhone", ob[3]);
				dataMap.put("consigneeAddress", ob[4]);
				dataMap.put("isDefaultAddress", ob[5]);
				
				dataList.add(dataMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dataList;
	}
}
