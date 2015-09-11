package com.rescam.xhb.framework.action;

import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;
import com.rescam.xhb.common.action.BasicAction;
import com.rescam.xhb.common.util.GetPropertiesFile;
import com.rescam.xhb.common.util.NumUtility;
import com.rescam.xhb.common.util.WeiXinUtility;
import com.rescam.xhb.framework.entity.Customer;
import com.rescam.xhb.framework.entity.CustomerCard;
import com.rescam.xhb.framework.service.CustomerCardService;
import com.rescam.xhb.framework.service.CustomerService;

@SuppressWarnings("serial")
public class CustomerAction extends BasicAction implements
		ModelDriven<Customer> {

	private Customer customer = new Customer();
	private int cardType;
	private String cardNumber, yanzhengma;
	private String appId;
	private String openId;
	private CustomerService customerService;
	private CustomerCardService customerCardService;
	private NumUtility numUtility;
	private String code;

	private JSONObject jsonObj;

	public String getYanzhengma() {
		return yanzhengma;
	}

	public void setYanzhengma(String yanzhengma) {
		this.yanzhengma = yanzhengma;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Override
	public Customer getModel() {
		return customer;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CustomerCardService getCustomerCardService() {
		return customerCardService;
	}

	public void setCustomerCardService(CustomerCardService customerCardService) {
		this.customerCardService = customerCardService;
	}

	public String wx() {
		Properties properties = GetPropertiesFile.getPropObjFromBundle("path");
		appId = (String) properties.get("appid");
		return "wx";
	}

	public String init() {
		try {
			JSONObject jobj = WeiXinUtility.getPageAccess_token("1", code);
			String type = String.valueOf(jobj.get("type"));
			openId = String.valueOf(jobj.get("openid"));
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("openid",openId);
			String state = "xinghuoban";
			if(type.equals("true")){
				int result = customerService.findByWeixin(openId);
				if(result == 0){
					return "init";
				} else {
					return "goodsList";
				}
			} else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "init";
	}

	public String dispatch() {
		// 1、根据微信号判断用户是否已经存在
		// 如果存在，直接登录token
		// 如果不存在，跳转到注册页
		int wCustomer;
		wCustomer = customerService.findByWeixin(customer.getWeixinOpenId());
		if (wCustomer == 0) {
			return "init";
		}

		return "goodsList";

	}

	@SuppressWarnings("rawtypes")
	public String register() {
		JSONObject jobj;
		
	
		jsonObj = new JSONObject();  
		customer.setCustomerStatus("0"); // 账户状态
		customer.setWalletAccount(numUtility.getAccountNo()); // 虚拟账户
		customer.setWalletBalance(0.0); // 余额
		customer.setDeliveryAddressCount(0); // 保存地址数量
		HttpSession session=ServletActionContext.getRequest().getSession();
	   openId=(String) session.getAttribute("openid");
		customer.setWeixinOpenId(openId);
		customerService.saveEntity(customer);
		if (cardType != 0) {
			System.out.println(cardType + "----" + cardNumber);
			List list = customerService
					.findBySql("select customer_id from customer where customer_phone = '"
							+ customer.getCustomerPhone() + "'");
			if (list == null || list.size() == 0) {
				jsonObj.put("result", "init");
				return SUCCESS;
			}
			System.out.println(customer.getCustomerId());
			int id = Integer.parseInt(String.valueOf(list.get(0)));
			CustomerCard card = new CustomerCard();
			card.setCustomerId(id);
			card.setCardNumber(cardNumber);
			card.setCardType(String.valueOf(cardType));
			customerCardService.saveEntity(card);

		}
		jsonObj.put("result", "page_pageJump.html?pageName=goodsList");
		return SUCCESS;
	}
}
