package com.rescam.xhb.framework.dao;

import java.util.List;
import java.util.Map;

import com.rescam.xhb.common.dao.BasicDao;
import com.rescam.xhb.framework.entity.ShoppingCart;

public interface ShoppingCartDao extends BasicDao<ShoppingCart> {
	
	//添加商品进购物车
	public void addGoodsToShoppingCart(String goodsId, String goodsNum, int customerId);
	
	//查询购物车中商品总数据数量
	public int getShoppingCartGoodsNum(int customerId);
		
	//查询购物车中商品数据列表
	public List<Map<String ,Object>> getShoppingCartGoodsList(int customerId);
	
	//删除购物车里对应的商品数据
	public void deleteShoppingCartGoodsByGoodsId(String goodsIds, int customerId);
}
