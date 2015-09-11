package com.rescam.xhb.framework.service.impl;

import com.rescam.xhb.common.service.BasicServiceImpl;
import com.rescam.xhb.framework.dao.CustomerDao;
import com.rescam.xhb.framework.entity.Customer;
import com.rescam.xhb.framework.service.CustomerService;

/**
 * 商品service
 * 
 * @author xueyang
 *
 */
public class CustomerServiceImpl extends BasicServiceImpl<Customer>implements CustomerService {

	private CustomerDao customerDao;

	
	public CustomerDao getCustomerDao() {
		return customerDao;
	}


	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	public int createCustomer(Customer customer){
		int result;
		result = customerDao.createCustomer(customer);
		
		return result;
	}


	@Override
	public int findByWeixin(String weixinOpenId) {
		// TODO Auto-generated method stub
		int result = customerDao.findByWeuxin(weixinOpenId);
		return result;
	};
}
