package com.rescam.xhb.framework.dao;

import java.util.List;

import com.rescam.xhb.common.dao.BasicDao;
import com.rescam.xhb.framework.entity.Customer;
import com.rescam.xhb.framework.entity.Goods;

public interface CustomerDao extends BasicDao<Customer> {
	
	public int createCustomer(Customer customer);

	public int findByWeuxin(String weixinOpenId);

}
