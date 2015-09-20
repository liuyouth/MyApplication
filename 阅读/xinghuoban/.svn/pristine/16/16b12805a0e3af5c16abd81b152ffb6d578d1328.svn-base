package com.rescam.xhb.framework.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.dao.DataAccessException;

import com.rescam.xhb.common.dao.BasicDaoImpl;
import com.rescam.xhb.common.util.MD5Utility;
import com.rescam.xhb.framework.dao.SupplierDao;
import com.rescam.xhb.framework.entity.ManageUser;
import com.rescam.xhb.framework.entity.Supplier;

public class SupplierDaoImpl extends BasicDaoImpl<Supplier> implements SupplierDao {


	/**
	 * 后台用户总数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int getAllSupplierTotal(Supplier user) {
		int total = 0;
		StringBuffer sql = new StringBuffer();  
		sql.append("select count(1) from supplier m where supplier_status='1'"); 
		try {
			if(user!=null){
				if(null !=user.getSupplierName() && !"".equals(user.getSupplierName())){  
					sql.append(" and m.supplier_name like '%"+user.getSupplierName()+"%'");
				}
				if(null !=user.getSupplierPhone() && !"".equals(user.getSupplierPhone())){
					sql.append(" and m.supplier_phone like '%"+user.getSupplierPhone()+"%'");
				}
				
				
			}
			Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql.toString());
			//list=(List<ManageUser>)getHibernateTemplate().find(hql.toString());
			List list=query.list();
			BigInteger bi = (BigInteger) list.get(0);
			total = bi.intValue();
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public List<Supplier> getAllSupplier(Supplier user,int page) {
		int rows = 10;
		int offset = (page - 1) * rows;
		StringBuffer sql = new StringBuffer();  
		List<Supplier> list =new ArrayList<Supplier>();
		sql.append("select * from supplier m where supplier_status='1'"); 
		try {
			if(user!=null){
				if(null !=user.getSupplierName() && !"".equals(user.getSupplierName())){  
					sql.append(" and m.supplier_name like '%"+user.getSupplierName()+"%'");
				}
				if(null !=user.getSupplierPhone() && !"".equals(user.getSupplierPhone())){
					sql.append(" and m.supplier_phone like '%"+user.getSupplierPhone()+"%'");
				}
				
			}
			sql.append(" limit " + offset + " , " + rows);
			Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql.toString());
			//list=(List<ManageUser>)getHibernateTemplate().find(hql.toString());
			list=query.list();
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int addSupplier(Supplier user) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List findByAccount(String supplierAccount) {
		List list = new ArrayList();
		try {
			String sql = "select * from supplier where supplier_account = '"
					+ supplierAccount + "'";
			list = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list == null || list.size()==0) {
			return null;
		}else {
			
			return list;
		}
	}
	@Override
	public List<Supplier> supplierLogin(Supplier supplier) {
		String hqlMail="from Supplier where supplierAccount=:supplierAccount";
		String[] paramNames=new String[]{"supplierAccount"};
		String[] values=new String[]{supplier.getSupplierAccount()};
		List<Supplier> list =new ArrayList<Supplier>();
		list=(List<Supplier>)getHibernateTemplate().findByNamedParam(hqlMail, paramNames, values);
		if(list.size()==0){
			return null;
		}else{
			String pwdMd5=list.get(0).getSupplierPassword();
			boolean match=MD5Utility.verify(supplier.getSupplierPassword(), pwdMd5);
			if(!match){
				return null;
			}
		}
		return list;
	}

	

	
}
