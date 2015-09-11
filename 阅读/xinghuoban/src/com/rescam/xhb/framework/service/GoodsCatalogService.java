package com.rescam.xhb.framework.service;

import java.util.List;

import com.rescam.xhb.common.service.BasicService;
import com.rescam.xhb.framework.entity.GoodsCatalog;

public interface GoodsCatalogService extends BasicService<GoodsCatalog> {

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
