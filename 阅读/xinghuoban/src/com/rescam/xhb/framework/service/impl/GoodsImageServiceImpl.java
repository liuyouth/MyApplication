package com.rescam.xhb.framework.service.impl;


import com.rescam.xhb.common.service.BasicServiceImpl;
import com.rescam.xhb.framework.dao.GoodsImageDao;
import com.rescam.xhb.framework.entity.GoodsImage;
import com.rescam.xhb.framework.service.GoodsImageService;

public class GoodsImageServiceImpl extends BasicServiceImpl<GoodsImage> implements GoodsImageService {
	private GoodsImageDao goodsImageDao ;

	public GoodsImageDao getGoodsImageDao() {
		return goodsImageDao;
	}

	public void setGoodsImageDao(GoodsImageDao goodsImageDao) {
		this.goodsImageDao = goodsImageDao;
	}
	

}
