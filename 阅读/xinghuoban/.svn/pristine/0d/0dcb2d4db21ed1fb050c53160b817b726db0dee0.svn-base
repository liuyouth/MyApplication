package com.rescam.xhb.framework.dao;

import java.util.List;

import com.rescam.xhb.common.dao.BasicDao;
import com.rescam.xhb.framework.entity.GoodsCatalog;

public interface GoodsCatalogDao extends BasicDao<GoodsCatalog> {

	/**
	 * 查找一级菜单列表
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List queryFirstMenuList();
	
	/**
	 * 根据一级菜单id查找二级菜单列表
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List querySecondMenuListByParentId(int parentCatalogId);
}
