package com.rescam.xhb.framework.service.impl;

import java.util.List;

import org.hibernate.HibernateException;

import com.rescam.xhb.common.service.BasicServiceImpl;
import com.rescam.xhb.framework.dao.GoodsCatalogDao;
import com.rescam.xhb.framework.entity.GoodsCatalog;
import com.rescam.xhb.framework.service.GoodsCatalogService;

/**
 * 商品目录service
 * 
 * @author xueyang
 *
 */
public class GoodsCatalogServiceImpl extends BasicServiceImpl<GoodsCatalog>implements GoodsCatalogService {

	private GoodsCatalogDao goodsCatalogDao;

	public GoodsCatalogDao getGoodsCatalogDao() {
		return goodsCatalogDao;
	}

	public void setGoodsCatalogDao(GoodsCatalogDao goodsCatalogDao) {
		this.goodsCatalogDao = goodsCatalogDao;
	}

	@Override
	public GoodsCatalog findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public void saveEntity(GoodsCatalog entity) {
		// TODO Auto-generated method stub
		super.saveEntity(entity);
	}

	@Override
	public void deleteEntity(GoodsCatalog entity) throws HibernateException {
		super.deleteEntity(entity);
	}

	@Override
	public void updateEntity(GoodsCatalog entity) throws HibernateException {
		super.updateEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsCatalog> findByPage(String hql, int currentpage, int pageSize, Object... params) {
		return super.findBySqlPage(hql, currentpage, pageSize, params);
	}

	@Override
	public List<GoodsCatalog> findByPage(int currentpage, int pageSize) {
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
	
	//查找一级菜单列表
	@SuppressWarnings("rawtypes")
	@Override
	public List queryFirstMenuList() {
		// TODO Auto-generated method stub
		
		List list = goodsCatalogDao.queryFirstMenuList();
		
		return list;
	}
	
	/**
	 * 根据一级菜单id查找二级菜单列表
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List querySecondMenuListByParentId(int parentCatalogId){
		// TODO Auto-generated method stub
		
		List list = goodsCatalogDao.querySecondMenuListByParentId(parentCatalogId);
		
		return list;
	}
}
