package com.rescam.xhb.framework.action;
import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ModelDriven;
import com.rescam.xhb.common.action.BasicAction;
import com.rescam.xhb.framework.entity.GoodsImage;
import com.rescam.xhb.framework.entity.ManageUser;
import com.rescam.xhb.framework.service.GoodsImageService;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class GoodsImageAction extends BasicAction implements ModelDriven<ManageUser> {
	private GoodsImageService goodsImageService;
	private JSONObject jsonObj;
	private int page = 0;
	private GoodsImage goodsImage = new GoodsImage();
	private int goodsId;
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public GoodsImage getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(GoodsImage goodsImage) {
		this.goodsImage = goodsImage;
	}
	public GoodsImageService getGoodsImageService() {
		return goodsImageService;
	}
	public void setGoodsImageService(GoodsImageService goodsImageService) {
		this.goodsImageService = goodsImageService;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public JSONObject getJsonObj() {
		return jsonObj;
	}
	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	@Override
	public ManageUser getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 后台管理
	 * 删除商品图片
	 * @return
	 */
	public String delGoodsImageById(){
		jsonObj = new JSONObject();
		jsonObj.put("result", false);
		try {
			goodsImageService.saveOrUpdateBySql("update goods_image set goods_image_status='0' where goods_image_id="+goodsImage.getGoodsImageId());
			jsonObj.put("result", true);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 删除该商品的所有图片
	 * @return
	 */
	public String delGoodsImageByGoodsId(){
		jsonObj = new JSONObject();
		jsonObj.put("result", false);
		try {
			goodsImageService.saveOrUpdateBySql("update goods_image set goods_image_status='0' where goods_id="+goodsId);
			jsonObj.put("result", true);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
