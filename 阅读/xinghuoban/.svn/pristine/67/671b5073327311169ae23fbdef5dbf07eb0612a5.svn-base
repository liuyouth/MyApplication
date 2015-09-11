package com.rescam.xhb.framework.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.dao.DataAccessException;

import com.rescam.xhb.common.dao.BasicDaoImpl;
import com.rescam.xhb.framework.dao.ManageUserDao;
import com.rescam.xhb.framework.entity.ManageUser;

public class ManageUserDaoImpl extends BasicDaoImpl<ManageUser> implements ManageUserDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ManageUser> userlogin(ManageUser user) {
		String hql="select manageUserMail from ManageUser where manageUserMail=:manageUserMail and manageUserPassword=:manageUserPassword";
		String[] paramNames=new String[]{"manageUserMail","manageUserPassword"};
		String[] values=new String[]{user.getManageUserMail(),user.getManageUserPassword()};
		List<ManageUser> list =new ArrayList<ManageUser>();
		try {
			if(user!=null){
				list=(List<ManageUser>)getHibernateTemplate().findByNamedParam(hql, paramNames, values);
			}
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 后台用户总数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public int getAllManageUserTotal(ManageUser user) {
		int total = 0;
		StringBuffer sql = new StringBuffer();  
		sql.append("select count(1) from manage_user m where manage_user_status='1'"); 
		try {
			if(user!=null){
				if(null !=user.getManageUserName() && !"".equals(user.getManageUserName())){  
					sql.append(" and m.manage_user_name like '%"+user.getManageUserName()+"%'");
				}
				if(null !=user.getManageUserPhone() && !"".equals(user.getManageUserPhone())){
					sql.append(" and m.manage_user_phone like '%"+user.getManageUserPhone()+"%'");
				}
				
				Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql.toString());
				//list=(List<ManageUser>)getHibernateTemplate().find(hql.toString());
				List list=query.list();
				BigInteger bi = (BigInteger) list.get(0);
				total = bi.intValue();
			}
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	@Override
	public List<ManageUser> getAllManageUser(ManageUser user,int page) {
		int rows = 10;
		int offset = (page - 1) * rows;
		StringBuffer sql = new StringBuffer();  
		List<ManageUser> list =new ArrayList<ManageUser>();
		sql.append("select * from manage_user m where manage_user_status='1'"); 
		try {
			if(user!=null){
				if(null !=user.getManageUserName() && !"".equals(user.getManageUserName())){  
					sql.append(" and m.manage_user_name like '%"+user.getManageUserName()+"%'");
				}
				if(null !=user.getManageUserPhone() && !"".equals(user.getManageUserPhone())){
					sql.append(" and m.manage_user_phone like '%"+user.getManageUserPhone()+"%'");
				}
				sql.append(" limit " + offset + " , " + rows);
				Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql.toString());
				//list=(List<ManageUser>)getHibernateTemplate().find(hql.toString());
				list=query.list();
			}
			
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int addManageUser(ManageUser user) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
}
