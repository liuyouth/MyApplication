package com.rescam.xhb.framework.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.rescam.xhb.common.service.BasicServiceImpl;
import com.rescam.xhb.framework.dao.ShoppingCartDao;
import com.rescam.xhb.framework.entity.ShoppingCart;
import com.rescam.xhb.framework.service.ShoppingCartService;

/**
 * 商品购物车service
 * 
 * @author xueyang
 *
 */
public class ShoppingCartServiceImpl extends BasicServiceImpl<ShoppingCart>implements ShoppingCartService {

	private ShoppingCartDao shoppingCartDao;

	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}

	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}

	@Override
	public ShoppingCart findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public void saveEntity(ShoppingCart entity) {
		// TODO Auto-generated method stub
		super.saveEntity(entity);
	}

	@Override
	public void deleteEntity(ShoppingCart entity) throws HibernateException {
		super.deleteEntity(entity);
	}

	@Override
	public void updateEntity(ShoppingCart entity) throws HibernateException {
		super.updateEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCart> findByPage(String hql, int currentpage, int pageSize, Object... params) {
		return super.findBySqlPage(hql, currentpage, pageSize, params);
	}

	@Override
	public List<ShoppingCart> findByPage(int currentpage, int pageSize) {
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
	
	//添加商品进购物车
	@Override
	public void addGoodsToShoppingCart(String goodsId, String goodsNum, int customerId){
		
		shoppingCartDao.addGoodsToShoppingCart(goodsId, goodsNum, customerId);
	}
	
	//查询购物车中商品总数据数量
	@Override
	public int getShoppingCartGoodsNum(int customerId){
		
		int dataNum = shoppingCartDao.getShoppingCartGoodsNum(customerId);
		
		return dataNum;
	}
	
	//查询购物车中商品数据列表
	@Override
	public List<Map<String ,Object>> getShoppingCartGoodsList(int customerId){
		
		List<Map<String ,Object>> dataList = shoppingCartDao.getShoppingCartGoodsList(customerId);
		
		return dataList;
	}
	
	//删除购物车里对应的商品数据
	@Override
	public void deleteShoppingCartGoodsByGoodsId(String goodsIds, int customerId){
		
		shoppingCartDao.deleteShoppingCartGoodsByGoodsId(goodsIds, customerId);
		
	}
}
