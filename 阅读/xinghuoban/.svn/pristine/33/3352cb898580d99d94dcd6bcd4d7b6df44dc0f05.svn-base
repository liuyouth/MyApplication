package com.rescam.xhb.framework.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.rescam.xhb.common.service.BasicServiceImpl;
import com.rescam.xhb.framework.dao.GoodsPreferentialDao;
import com.rescam.xhb.framework.entity.GoodsPreferential;
import com.rescam.xhb.framework.service.GoodsPreferentialService;

/**
 * 商品优惠service实现
 * 
 * @author xueyang
 *
 */
public class GoodsPreferentialServiceImpl extends BasicServiceImpl<GoodsPreferential>implements GoodsPreferentialService {

	private GoodsPreferentialDao goodsPreferentialDao;

	public GoodsPreferentialDao getGoodsPreferentialDao() {
		return goodsPreferentialDao;
	}

	public void setGoodsPreferentialDao(GoodsPreferentialDao goodsPreferentialDao) {
		this.goodsPreferentialDao = goodsPreferentialDao;
	}

	@Override
	public GoodsPreferential findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public void saveEntity(GoodsPreferential entity) {
		// TODO Auto-generated method stub
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

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsPreferential> findByPage(String hql, int currentpage, int pageSize, Object... params) {
		return super.findBySqlPage(hql, currentpage, pageSize, params);
	}

	@Override
	public List<GoodsPreferential> findByPage(int currentpage, int pageSize) {
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
	
	/**
	 * 按照商品id查询商品优惠详情
	 * @return
	 */
	@Override
	public Map<String ,Object> getGoodsPreferentialDetailById(int goodsId) {
		// TODO Auto-generated method stub
		
		Map<String ,Object> dataMap = goodsPreferentialDao.getGoodsPreferentialDetailById(goodsId);
		
		return dataMap;
	}
	
}
