package com.rescam.xhb.framework.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.rescam.xhb.common.dao.BasicDaoImpl;
import com.rescam.xhb.framework.dao.ShoppingCartDao;
import com.rescam.xhb.framework.entity.ShoppingCart;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 商品购物车DAO实现
 * 
 * @author xueyang
 * 
 */
public class ShoppingCartDaoImpl extends BasicDaoImpl<ShoppingCart>implements ShoppingCartDao {

	@Override
	public ShoppingCart findById(Integer id) throws HibernateException {
		return super.findById(id);
	}

	@Override
	public void saveEntity(ShoppingCart entity) throws HibernateException {
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

	@Override
	public List<ShoppingCart> findByPage(String hql, int currentpage, int pageSize, Object... params) {
		return super.findByPage(hql, currentpage, pageSize, params);
	}

	@Override
	public List<ShoppingCart> findByPage(int currentpage, int pageSize) {
		return super.findByPage(currentpage, pageSize);
	}

	@Override
	public Integer getCount(String hql, Object... params) {
		return super.getCount(hql, params);
	}

	@Override
	public Integer getCount() {
		return super.getCount();
	}

	// 添加商品进购物车
	@SuppressWarnings("rawtypes")
	@Override
	public void addGoodsToShoppingCart(String goodsId, String goodsNum, int customerId) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		try {
			String shoppingGoods = "";
			// 先根据当前登录的客户Id查询其购物车里的商品信息，得到其shopping_goods字段
			String selectSql = "SELECT shopping_cart_id, customer_id, shopping_goods FROM shopping_cart WHERE customer_id = "
					+ customerId;
	
			Query query = session.createSQLQuery(selectSql);
	
			List list = query.list();
			for (int i = 0; i < list.size(); i++) {
				Object[] ob = (Object[]) list.get(i);
				shoppingGoods = (String) ob[2];
			}
	
			// 其次再插入将组合的新的shopping_goods字段放在数据库中(insert/update)
			String sql = "";
			if (list.size() == 0) {
				shoppingGoods = "{\"list\":[{\"goodsId\":\"" + goodsId + "\",\"goodsNum\":\"" + goodsNum + "\"}]}";
	
				// 原来没有购物车数据，执行insert
				sql = "INSERT INTO shopping_cart (customer_id,shopping_goods) VALUES (" + customerId + ",'" + shoppingGoods
						+ "')";
			} else {
				//数据库中的购物车商品json数据
				JSONObject oldGoodsStrJSON = new JSONObject();
				oldGoodsStrJSON = JSONObject.fromObject(shoppingGoods);
				JSONArray oldGoodsArr = oldGoodsStrJSON.getJSONArray("list");
				
				boolean ifHave = false;//原购物车里是否有相同的产品
				
				//新的商品json数据
				JSONArray newGoodsArr = new JSONArray();
				
				for(int i=0;i<oldGoodsArr.size();i++){
					JSONObject oldGoods = oldGoodsArr.getJSONObject(i);
					
					String oldGoodsId = (String) oldGoods.get("goodsId");
					String oldGoodNum = (String) oldGoods.get("goodsNum");
					
					// 新的商品信息
					int newGoodsNum = 0;
					JSONObject newGoods = new JSONObject();
					newGoods.put("goodsId", goodsId);
					
					if(goodsId.equals(oldGoodsId)){
						//如果当前商品与购物车中商品id相同，则直接增加商品数量
						ifHave = true;
						newGoodsNum = Integer.parseInt(oldGoodNum) + Integer.parseInt(goodsNum);
						
						newGoods.put("goodsNum", newGoodsNum+"");
					}else{
						newGoods.put("goodsNum", oldGoodNum);
					}
					
					newGoodsArr.add(newGoods);
					
				}
				
				if(ifHave){
					//当前商品已在购物车中存在，用新的newGoodsArr修改数据库
					oldGoodsStrJSON.put("list", newGoodsArr);
				}else{
					JSONObject newGoods = new JSONObject();// 新的商品信息
					newGoods.put("goodsId", goodsId);
					newGoods.put("goodsNum", goodsNum);
					
					oldGoodsArr.add(newGoods);
					oldGoodsStrJSON.put("list", oldGoodsArr);
				}
				// 原来没有购物车数据，执行update
				sql = "UPDATE shopping_cart SET shopping_goods = '" + oldGoodsStrJSON.toString() + "' WHERE customer_id = " + customerId;
			}
			session.createSQLQuery(sql).executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//查询购物车中商品总数据数量
	@SuppressWarnings("rawtypes")
	@Override
	public int getShoppingCartGoodsNum(int customerId){
		int total = 0;
		try{
			String sql = "SELECT COUNT(*) FROM shopping_cart WHERE customer_id = " + customerId;
			List list = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql).list();
			
			BigInteger bi = (BigInteger) list.get(0);
			total = bi.intValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	//查询购物车中商品数据列表（分页）
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map<String ,Object>> getShoppingCartGoodsList(int customerId){
		List<Map<String ,Object>> dataList = new ArrayList<Map<String ,Object>>();
		String shoppingGoods = "";
		try{
			String sql = "SELECT shopping_cart_id, customer_id, shopping_goods FROM shopping_cart WHERE customer_id = " + customerId;
	
			Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql);
	
			List list = query.list();
			for (int i = 0; i < list.size(); i++) {
				Object[] ob = (Object[]) list.get(i);
				shoppingGoods = (String) ob[2];
			}
			
			JSONObject goodsStrJSON = new JSONObject();
			goodsStrJSON = JSONObject.fromObject(shoppingGoods);
			
			JSONArray goodsArr = goodsStrJSON.getJSONArray("list");
			for(int i=0;i<goodsArr.size();i++){
				JSONObject goods = goodsArr.getJSONObject(i);
				
				String goodsId = (String) goods.get("goodsId");
				String goodsNum = (String) goods.get("goodsNum");
				
				Map<String ,Object> dataMap = new HashMap<String ,Object>();
				dataMap.put("goodsId", goodsId);
				dataMap.put("goodsNum", goodsNum);
				dataList.add(dataMap);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataList;
	}
}
