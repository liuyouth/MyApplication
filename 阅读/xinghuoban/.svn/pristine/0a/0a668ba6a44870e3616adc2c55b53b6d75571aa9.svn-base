package com.rescam.xhb.framework.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ModelDriven;
import com.rescam.xhb.common.action.BasicAction;
import com.rescam.xhb.common.util.NumUtility;
import com.rescam.xhb.framework.entity.Order;
import com.rescam.xhb.framework.entity.OrderBatch;
import com.rescam.xhb.framework.service.GoodsPreferentialService;
import com.rescam.xhb.framework.service.GoodsService;
import com.rescam.xhb.framework.service.OrderBatchService;
import com.rescam.xhb.framework.service.OrderService;
import com.rescam.xhb.framework.service.ShoppingCartService;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class OrderAction extends BasicAction implements ModelDriven<Order> {

	private Order order = new Order();
	private int page = 0;
	private String goodsIds;// 购物车里选中结算的商品id组成的字符串
	private String goodsNums;// 购物车里选中结算的商品id对应的商品数量组成的字符串
	private String totalPrice;// 购物车里选中结算的商品总金额
	private String linkman;// 本次订单的收货人
	private String linkmanPhone;// 本次订单的收货人电话
	private String linkmanAddress;// 本次订单的收货人地址

	private String orderBatchCode;// 大订单（批次号）
	private String orderBatchStatus;// 大订单状态

	public String getGoodsIds() {
		return goodsIds;
	}

	public void setGoodsIds(String goodsIds) {
		this.goodsIds = goodsIds;
	}

	public String getGoodsNums() {
		return goodsNums;
	}

	public void setGoodsNums(String goodsNums) {
		this.goodsNums = goodsNums;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkmanPhone() {
		return linkmanPhone;
	}

	public void setLinkmanPhone(String linkmanPhone) {
		this.linkmanPhone = linkmanPhone;
	}

	public String getLinkmanAddress() {
		return linkmanAddress;
	}

	public void setLinkmanAddress(String linkmanAddress) {
		this.linkmanAddress = linkmanAddress;
	}

	public String getOrderBatchCode() {
		return orderBatchCode;
	}

	public void setOrderBatchCode(String orderBatchCode) {
		this.orderBatchCode = orderBatchCode;
	}

	public String getOrderBatchStatus() {
		return orderBatchStatus;
	}

	public void setOrderBatchStatus(String orderBatchStatus) {
		this.orderBatchStatus = orderBatchStatus;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public Order getModel() {
		return order;
	}

	private JSONObject jsonObj;

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	private OrderService orderService;
	private OrderBatchService orderBatchService;
	private GoodsService goodsService;
	private GoodsPreferentialService goodsPreferentialService;
	private ShoppingCartService shoppingCartService;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderBatchService getOrderBatchService() {
		return orderBatchService;
	}

	public void setOrderBatchService(OrderBatchService orderBatchService) {
		this.orderBatchService = orderBatchService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public GoodsPreferentialService getGoodsPreferentialService() {
		return goodsPreferentialService;
	}

	public void setGoodsPreferentialService(GoodsPreferentialService goodsPreferentialService) {
		this.goodsPreferentialService = goodsPreferentialService;
	}

	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	// 生成订单
	public String markTheOrder() {
		int customerId = 1;// 应从session中获取

		String[] goodsIdArr = goodsIds.split(",");// 商品id数组
		String[] goodsNumArr = goodsNums.split(",");// 商品id对应的数量数组

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		Date nowTime = new Date();
		String str = sdf.format(nowTime.getTime());// 订单时间

		// 获取这一批次的订单编号
		String orderNo = NumUtility.getOrderNo();

		// 生成大批次
		orderBatchCode = "D" + orderNo;// 批次编号

		try {
			OrderBatch orderBatch = new OrderBatch();
			orderBatch.setOrderBatchCode(orderBatchCode);// 批次编号
			orderBatch.setCustomerId(customerId);// 客户id
			orderBatch.setOrderTotal(goodsIdArr.length);// 订单总数
			orderBatch.setValidOrderCount(goodsIdArr.length);// 有效订单数量
			orderBatch.setOrderTime(str);// 订单时间
			orderBatch.setOrderBatchStatus("0");// 状态

			orderBatchService.saveEntity(orderBatch);// 生成大订单（批次）

			// 获取刚插入的批次的id(根据批次号查批次详情)
			Map<String, Object> orderbatchMap = orderBatchService.getOrderBatchByOrderBatchCode(orderBatchCode);
			int orderBatchId = (int) orderbatchMap.get("orderBatchId");

			// 生成小订单
			// 查找订单中的商品信息
			for (int i = 0; i < goodsIdArr.length; i++) {
				Map<String, Object> orderMap = new HashMap<String, Object>();// 订单map

				int goodsId = Integer.parseInt(goodsIdArr[i]);
				String orderCode = "X" + orderNo + goodsId;// 订单编号

				orderMap.put("orderBatchId", orderBatchId);// 批次id
				order.setOrderBatchId(orderBatchId);
				orderMap.put("customerId", customerId);// 客户id
				order.setCustomerId(customerId);
				orderMap.put("orderCode", orderCode);// 订单编号
				order.setOrderCode(orderCode);
				orderMap.put("orderTime", str);// 订单时间
				order.setOrderTime(str);
				orderMap.put("payStatus", "1");// 支付状态（未支付）
				order.setPayStatus("1");

				// 取当前商品详情数据
				Map<String, Object> detailData = goodsService.getGoodsDetailById(goodsId);// (商品id)

				orderMap.put("goodsId", goodsId);// 商品id
				order.setGoodsId(goodsId);
				orderMap.put("goodsType", detailData.get("goodsType"));// 商品种类
				order.setGoodsType(detailData.get("goodsType") + "");
				orderMap.put("goodsName", detailData.get("goodsName"));// 商品名称
				order.setGoodsName((String) detailData.get("goodsName"));
				float goodsPrice = (float) detailData.get("goodsPrice");

				// 取商品优惠信息
				Map<String, Object> preferentialMap = goodsPreferentialService.getGoodsPreferentialDetailById(goodsId);
				if (null == preferentialMap || !preferentialMap.containsKey("goodsPreferentialId")) {
					// 没有优惠信息
					orderMap.put("goodsPrice", goodsPrice);// 单价
					order.setGoodsPrice(goodsPrice + "");
				} else {
					char preferentialType = (char) preferentialMap.get("preferentialType");// 优惠类型（0：打折，1：团购）
					if (preferentialType == '0') {
						// 打折
						float discount = (float) preferentialMap.get("discount");
						goodsPrice = goodsPrice * discount;// 打折之后的价格
						orderMap.put("goodsPrice", goodsPrice);// 单价
						order.setGoodsPrice(goodsPrice + "");
					} else {
						// 团购
						goodsPrice = (float) preferentialMap.get("groupPrice");
						orderMap.put("goodsPrice", preferentialMap.get("groupPrice"));// 单价
						order.setGoodsPrice(preferentialMap.get("groupPrice") + "");
					}
				}
				orderMap.put("orderNumber", goodsNumArr[i]);// 购买数量
				order.setOrderNumber(Integer.parseInt(goodsNumArr[i]));
				orderMap.put("totalPrice", goodsPrice * Integer.parseInt(goodsNumArr[i]));// 总金额
				order.setTotalPrice((goodsPrice * Integer.parseInt(goodsNumArr[i]))+"");
				orderMap.put("linkman", linkman);// 联系人
				order.setLinkman(linkman);
				orderMap.put("linkmanPhone", linkmanPhone);// 联系人电话
				order.setLinkmanPhone(linkmanPhone);
				orderMap.put("linkmanAddress", linkmanAddress);// 配送地址
				order.setLinkmanAddress(linkmanAddress);

				orderMap.put("orderStatus", "0");// 状态
				order.setOrderStatus("0");

				// 生成订单
				orderService.saveEntity(order);

			}
			// 删除购物车中已经生成订单的数据的数据
			shoppingCartService.deleteShoppingCartGoodsByGoodsId(goodsIds, customerId);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("success", true);
		jsonMap.put("orderBatchCode", orderBatchCode);
		jsonObj = JSONObject.fromObject(jsonMap);

		return SUCCESS;
	}

	// 根据客户id、订单状态查订单批次列表
	public String getOrderBatchListByCustomerIdAndStatus() {
		int customerId = 1;// 应从session中获取

		List<Map<String, Object>> orderBatchList = orderBatchService.getOrderBatchListByCustomerIdAndStatus(customerId,
				orderBatchStatus);
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		//根据批次号查询该批次下的所有订单详情
		for(int i=0;i<orderBatchList.size();i++){
			float totalMoney = 0;//订单总金额
			Map<String, Object> orderBatchMap = orderBatchList.get(i);
			int orderBatchId = (int) orderBatchMap.get("orderBatchId");
			List<Map<String, Object>> orderList = orderService.getOrderListByOrderBatchId(orderBatchId);
			//算出订单总金额
			
			for(int j=0;j<orderList.size();j++){
				float totalPrice = (float) orderList.get(j).get("totalPrice");
				totalMoney = totalMoney + totalPrice;
			}
			orderBatchMap.put("totalMoney", totalMoney);
			returnList.add(orderBatchMap);
		}
		
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("listMap", returnList);
		jsonObj = JSONObject.fromObject(jsonMap);

		return SUCCESS;
	}
	
	//根据订单批次id查询订单批次详情及订单列表
	public String getOrderBatchDetailAndOrderListByOrderBatchId(){
		
		return SUCCESS;
	}
}
