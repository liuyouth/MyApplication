package com.rescam.xhb.framework.service.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.rescam.xhb.common.service.BasicServiceImpl;
import com.rescam.xhb.framework.dao.GoodsDao;
import com.rescam.xhb.framework.entity.Goods;
import com.rescam.xhb.framework.service.GoodsService;

/**
 * 商品service
 * 
 * @author xueyang
 *
 */
public class GoodsServiceImpl extends BasicServiceImpl<Goods>implements GoodsService {

	private GoodsDao goodsDao;

	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public Goods findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public void saveEntity(Goods entity) {
		// TODO Auto-generated method stub
		super.saveEntity(entity);
	}

	@Override
	public void deleteEntity(Goods entity) throws HibernateException {
		super.deleteEntity(entity);
	}

	@Override
	public void updateEntity(Goods entity) throws HibernateException {
		super.updateEntity(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> findByPage(String hql, int currentpage, int pageSize, Object... params) {
		return super.findBySqlPage(hql, currentpage, pageSize, params);
	}

	@Override
	public List<Goods> findByPage(int currentpage, int pageSize) {
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
	
	@Override
	public int getGoodsTotalByTypeAndStatus(String goodsType, String goodsSalesStatus, int goodsCatalogId) {
		// TODO Auto-generated method stub
		
		int total = goodsDao.getGoodsTotalByTypeAndStatus(goodsType, goodsSalesStatus, goodsCatalogId);
		
		return total;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List findGoodsListByTypeAndStatus(String goodsType, String goodsSalesStatus, int goodsCatalogId, int page) {
		// TODO Auto-generated method stub
		
		List list = goodsDao.findGoodsListByTypeAndStatus(goodsType, goodsSalesStatus, goodsCatalogId, page);
		
		return list;
	}
	
	@Override
	public Map<String ,Object> getGoodsDetailById(int goodsId) {
		// TODO Auto-generated method stub
		
		Map<String ,Object> dataMap = goodsDao.getGoodsDetailById(goodsId);
		
		return dataMap;
	}
	
	@Override
	public List<Map<String ,Object>> getGoodsImageListByIdAndType(int goodsId, String goodsImageStatus) {
		// TODO Auto-generated method stub
		
		List<Map<String ,Object>> dataList = goodsDao.getGoodsImageListByIdAndType(goodsId, goodsImageStatus);
		
		return dataList;
	}

	@Override
	public int getGoodsTotalByNameAndSupplierId(Goods goods) {
		return goodsDao.getGoodsTotalByNameAndSupplierId(goods);
	}

	@Override
	public List<Map<String, Object>> findGoodsListByNameAndSupplierId(Goods goods, int page) {
		return goodsDao.findGoodsListByNameAndSupplierId(goods, page);
	}
}
