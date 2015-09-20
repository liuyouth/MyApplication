package com.rescam.xhb.framework.service;

import java.util.List;

import com.rescam.xhb.common.service.BasicService;
import com.rescam.xhb.framework.entity.ManageUser;
import com.rescam.xhb.framework.entity.Supplier;

public interface SupplierService extends BasicService<Supplier> {

	/**
	 * 后台用户总数
	 * @return
	 */
	public int getAllSupplierTotal(Supplier user);
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
	 * 根据账号查找
	 * @param user
	 * @return
	 */
	public List findByAccount(String supplierAccount);
	
	public List<Supplier> supplierLogin(
			Supplier supplier);
}

