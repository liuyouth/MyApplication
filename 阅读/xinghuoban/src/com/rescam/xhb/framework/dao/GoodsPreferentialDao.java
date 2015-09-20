package com.rescam.xhb.framework.dao;

import java.util.Map;

import com.rescam.xhb.common.dao.BasicDao;
import com.rescam.xhb.framework.entity.GoodsPreferential;

public interface GoodsPreferentialDao extends BasicDao<GoodsPreferential> {
	/**
	 * 按照商品id查询商品优惠详情
	 * @return
	 */
	public Map<String ,Object> getGoodsPreferentialDetailById(int goodsId);
	
}
