package com.rescam.xhb.framework.dao;

import java.util.List;

import com.rescam.xhb.common.dao.BasicDao;
import com.rescam.xhb.framework.entity.ManageUser;
import com.rescam.xhb.framework.entity.Supplier;

public interface SupplierDao extends BasicDao<Supplier> {

	
	/**
	 * 加载后台用户
	 * @param user
	 * @return
	 */
	public List<Supplier> getAllSupplier(Supplier user,int page);
	/**
	 * 新增后台用户
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public int addSupplier(Supplier user);
	
	/**
	 * 后台用户总数
	 * @return
	 */
	public int getAllSupplierTotal(Supplier user);
	/**
	 * 根据账号查找
	 * @return
	 */
	public List findByAccount(String supplierAccount);
	/**
	 * 账号登录
	 * @return
	 */
	public List<Supplier> supplierLogin(Supplier supplier);

}
