package com.rescam.xhb.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.rescam.xhb.common.dao.BasicDaoImpl;
import com.rescam.xhb.framework.dao.CustomerDao;
import com.rescam.xhb.framework.dao.GoodsDao;
import com.rescam.xhb.framework.entity.Customer;
import com.rescam.xhb.framework.entity.Goods;

/**
 * 用户Dao实现
 * 
 * @author liubo
 * 
 */
public class CustomerDaoImpl extends BasicDaoImpl<Customer> implements CustomerDao {

	public int createCustomer(Customer customer){
		int result = 0;
		
		
		
		return result;
	}

	@Override
	public int findByWeuxin(String weixinOpenId) {
		
		List list = new ArrayList();
		try {
			String sql = "select customer_id from customer where weixin_openid = '"
					+ weixinOpenId + "'";
			list = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list == null || list.size()==0) {
			return 0;
		}else {
			
			return (int) list.get(0);
		}
		
		
	}

}
