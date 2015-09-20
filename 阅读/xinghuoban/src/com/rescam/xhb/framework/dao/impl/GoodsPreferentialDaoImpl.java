package com.rescam.xhb.framework.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.rescam.xhb.common.dao.BasicDaoImpl;
import com.rescam.xhb.framework.dao.GoodsPreferentialDao;
import com.rescam.xhb.framework.entity.GoodsPreferential;

/**
 * 商品优惠DAO实现
 * 
 * @author xueyang
 * 
 */
public class GoodsPreferentialDaoImpl extends BasicDaoImpl<GoodsPreferential>implements GoodsPreferentialDao {

	@Override
	public GoodsPreferential findById(Integer id) throws HibernateException {
		return super.findById(id);
	}

	@Override
	public void saveEntity(GoodsPreferential entity) throws HibernateException {
		super.saveEntity(entity);
	}

	@Override
	public void deleteEntity(GoodsPreferential entity) throws HibernateException {
		super.deleteEntity(entity);
	}

	@Override
	public void updateEntity(GoodsPreferential entity) throws HibernateException {
		super.updateEntity(entity);
	}

	@Override
	public List<GoodsPreferential> findByPage(String hql, int currentpage, int pageSize, Object... params) {
		return super.findByPage(hql, currentpage, pageSize, params);
	}

	@Override
	public List<GoodsPreferential> findByPage(int currentpage, int pageSize) {
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

	/**
	 * 按照商品id查询商品优惠详情
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Map<String, Object> getGoodsPreferentialDetailById(int goodsId) {

		List list = new ArrayList();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		try {
			String sql = "SELECT goods_preferential.goods_preferential_id,goods_preferential.goods_id,"
					+ "goods_preferential.preferential_type,goods_preferential.discount,goods_preferential.group_price,"
					+ "goods_preferential.goods_preferential_status" 
					+ " FROM goods_preferential "
					+ " WHERE goods_preferential.goods_id = " + goodsId + " AND goods_preferential.goods_preferential_status = 1";

			Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql);

			list = query.list();
			for (int i = 0; i < list.size(); i++) {
				Object[] ob = (Object[]) list.get(i);
				dataMap = new HashMap<String, Object>();
				
				dataMap.put("goodsPreferentialId", ob[0]);
				dataMap.put("goodsId", ob[1]);
				dataMap.put("preferentialType", ob[2]);
				dataMap.put("discount", ob[3]);
				dataMap.put("groupPrice", ob[4]);
				dataMap.put("goodsPreferentialStatus", ob[5]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataMap;
	}

}
