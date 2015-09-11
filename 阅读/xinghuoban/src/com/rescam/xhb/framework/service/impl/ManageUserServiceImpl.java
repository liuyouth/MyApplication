package com.rescam.xhb.framework.service.impl;

import java.util.List;

import org.hibernate.HibernateException;

import com.rescam.xhb.common.service.BasicServiceImpl;
import com.rescam.xhb.framework.dao.ManageUserDao;
import com.rescam.xhb.framework.entity.Goods;
import com.rescam.xhb.framework.entity.ManageUser;
import com.rescam.xhb.framework.service.ManageUserService;

public class ManageUserServiceImpl extends BasicServiceImpl<ManageUser> implements ManageUserService {
	private ManageUserDao manageUserDao;
	

	public ManageUserDao getManageUserDao() {
		return manageUserDao;
	}

	public void setManageUserDao(ManageUserDao manageUserDao) {
		this.manageUserDao = manageUserDao;
	}

	@Override
	public List<ManageUser> userlogin(ManageUser user) {
		return manageUserDao.userlogin(user);
	}
	@Override
	public List<ManageUser> getAllManageUser(ManageUser user,int page) {
		return manageUserDao.getAllManageUser(user,page);
	}
	@Override
	public int addManageUser(ManageUser user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllManageUserTotal(ManageUser user) {
		return manageUserDao.getAllManageUserTotal(user);
	}

	

}
