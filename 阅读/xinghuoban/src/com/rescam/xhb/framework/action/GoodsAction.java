package com.rescam.xhb.framework.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.rescam.xhb.common.action.BasicAction;
import com.rescam.xhb.framework.entity.Goods;
import com.rescam.xhb.framework.service.GoodsService;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class GoodsAction extends BasicAction implements ModelDriven<Goods> {

	private Goods goods = new Goods();
	private int page = 0;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public Goods getModel() {
		return goods;
	}
	
	private JSONObject jsonObj;

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	private GoodsService goodsService;

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	/**
	 * 按照商品种类、销售状态查询商品列表
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String findGoodsListByTypeAndStatus() {
		//取当前条件的所有商品总数
		int total = goodsService.getGoodsTotalByTypeAndStatus(goods.getGoodsType(), 
				goods.getGoodsSalesStatus(), goods.getGoodsCatalogId());
		
		//取当前页面商品列表数据
		List list = goodsService.findGoodsListByTypeAndStatus(goods.getGoodsType(), 
						goods.getGoodsSalesStatus(), goods.getGoodsCatalogId(),page);
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("goodsList", list);
		jsonObj = JSONObject.fromObject(jsonMap);
		
		return SUCCESS;
	}
	
	/**
	 * 按照商品id、商品种类查询商品详情
	 * 
	 * @return
	 */
	public String getGoodsDetailByIdAndType() {
		
		//取当前商品详情数据
		Map<String ,Object> detailData = goodsService.getGoodsDetailById(goods.getGoodsId());//(商品id)
		
		//取当前商品关联图片的详情数据（商品信息详情展示使用）
		List<Map<String ,Object>> imageListData = goodsService.getGoodsImageListByIdAndType(goods.getGoodsId(), "1");//(商品id，商品图片状态)
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("goodsImageList", imageListData);
		jsonMap.put("goodsDetail", detailData);
		jsonObj = JSONObject.fromObject(jsonMap);
		
		return SUCCESS;
	}
}
