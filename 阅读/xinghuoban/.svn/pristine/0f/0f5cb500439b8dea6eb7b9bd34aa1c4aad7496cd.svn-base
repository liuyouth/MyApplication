package com.rescam.xhb.framework.action;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ModelDriven;
import com.rescam.xhb.common.action.BasicAction;
import com.rescam.xhb.framework.entity.CustomerCard;
import com.rescam.xhb.framework.service.CustomerService;

@SuppressWarnings("serial")
public class CustomerCardAction extends BasicAction implements
		ModelDriven<CustomerCard> {

	CustomerCard customerCard = new CustomerCard();

	@Override
	public CustomerCard getModel() {
		return customerCard;
	}

	private JSONObject jsonObj;

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	private CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String init() {
		return "init";
	}

	public String cardRegister() {
		//
		return SUCCESS;
	}
}
