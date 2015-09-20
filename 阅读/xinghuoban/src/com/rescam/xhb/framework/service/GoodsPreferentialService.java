package com.rescam.xhb.framework.service;

import java.util.Map;

import com.rescam.xhb.common.service.BasicService;
import com.rescam.xhb.framework.entity.GoodsPreferential;

public interface GoodsPreferentialService extends BasicService<GoodsPreferential> {
	
	/**
	 * 按照商品id查询商品优惠详情
	 * @return
	 */
	public Map<String ,Object> getGoodsPreferentialDetailById(int goodsId);
	
}
