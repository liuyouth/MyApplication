package com.rescam.xhb.framework.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.rescam.xhb.common.service.BasicServiceImpl;
import com.rescam.xhb.framework.dao.DeliveryAddressDao;
import com.rescam.xhb.framework.entity.DeliveryAddress;
import com.rescam.xhb.framework.service.DeliveryAddressService;

/**
 * 订单service
 * 
 * @author xueyang
 *
 */
public class DeliveryAddressServiceImpl extends BasicServiceImpl<DeliveryAddress>implements DeliveryAddressService {

	private DeliveryAddressDao deliveryAddressDao;

	public DeliveryAddressDao getDeliveryAddressDao() {
		return deliveryAddressDao;
	}

	public void setDeliveryAddressDao(DeliveryAddressDao deliveryAddressDao) {
		this.deliveryAddressDao = deliveryAddressDao;
	}

	@Override
	public DeliveryAddress findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public void saveEntity(DeliveryAddress entity) {
		// TODO Auto-generated method stub
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

	@SuppressWarnings("unchecked")
	@Override
	public List<DeliveryAddress> findByPage(String hql, int currentpage, int pageSize, Object... params) {
		return super.findBySqlPage(hql, currentpage, pageSize, params);
	}

	@Override
	public List<DeliveryAddress> findByPage(int currentpage, int pageSize) {
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
	
	//根据客户id查询默认收货人信息
	@Override
	public Map<String ,Object> getDefaultLinkPersonInfoByCustomerId(int customerId){
		
		Map<String ,Object> dataMap 
			= deliveryAddressDao.getDefaultLinkPersonInfoByCustomerId(customerId);
		
		return dataMap;
	}
	
	//获取收货人信息列表
	@Override
	public List<Map<String ,Object>> getLinkPersonInfoListByCustomerId(int customerId){
		
		List<Map<String ,Object>> dataList 
			= deliveryAddressDao.getLinkPersonInfoListByCustomerId(customerId);
		
		return dataList;
	}
}
