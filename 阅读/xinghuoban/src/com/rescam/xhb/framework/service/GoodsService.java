package com.rescam.xhb.framework.service;

import java.util.List;
import java.util.Map;

import com.rescam.xhb.common.service.BasicService;
import com.rescam.xhb.framework.entity.Goods;

public interface GoodsService extends BasicService<Goods> {

	/**
	 * 按照商品种类、销售状态查询商品总数
	 * @return
	 */
	public int getGoodsTotalByTypeAndStatus(String goodsType, String goodsSalesStatus, int goodsCatalogId);
	
	/**
	 * 按照商品种类、销售状态查询商品列表(分页数据)
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List findGoodsListByTypeAndStatus(String goodsType, String goodsSalesStatus, int goodsCatalogId, int page);
	
	/**
	 * 按照商品id查询商品详情
	 * @return
	 */
	public Map<String ,Object> getGoodsDetailById(int goodsId);
	
	/**
	 * 按照商品id、商品种类、商品图片状态查询商品相关图片列表
	 * @return
	 */
	public List<Map<String ,Object>> getGoodsImageListByIdAndType(int goodsId, String goodsImageStatus);
	/**
	 * 后台管理商品查询总量
	 * @param goodsType
	 * @param goodsSalesStatus
	 * @param goodsCatalogId
	 * @return
	 */
	public int getGoodsTotalByNameAndSupplierId(Goods goods);
	/**
	 * 后台管理商品查询list
	 * @param goodsType
	 * @param goodsSalesStatus
	 * @param goodsCatalogId
	 * @param goodsName
	 * @param supplierId
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>> findGoodsListByNameAndSupplierId(Goods goods, int page);
}
