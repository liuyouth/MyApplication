package com.rescam.xhb.framework.service.impl;

import java.util.List;

import com.rescam.xhb.common.service.BasicServiceImpl;
import com.rescam.xhb.framework.dao.SupplierDao;
import com.rescam.xhb.framework.entity.ManageUser;
import com.rescam.xhb.framework.entity.Supplier;
import com.rescam.xhb.framework.service.SupplierService;

public class SupplierServiceImpl extends BasicServiceImpl<Supplier> implements SupplierService {
	private SupplierDao supplierDao;
	

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao SupplierDao) {
		this.supplierDao = SupplierDao;
	}

	
	@Override
	public List<Supplier> getAllSupplier(Supplier user,int page) {
		return supplierDao.getAllSupplier(user,page);
	}
	@Override
	public int addSupplier(Supplier user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllSupplierTotal(Supplier user) {
		return supplierDao.getAllSupplierTotal(user);
	}

	@Override
	public List findByAccount(String supplierAccount) {
		// TODO Auto-generated method stub
		return supplierDao.findByAccount(supplierAccount);
	}

	@Override
	public List<Supplier> supplierLogin(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDao.supplierLogin(supplier);
	}

	

}
