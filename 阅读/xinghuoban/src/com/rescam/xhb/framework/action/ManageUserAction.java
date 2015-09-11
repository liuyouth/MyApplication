package com.rescam.xhb.framework.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ModelDriven;
import com.rescam.xhb.common.action.BasicAction;
import com.rescam.xhb.framework.entity.AuthorityGroup;
import com.rescam.xhb.framework.entity.ManageUser;
import com.rescam.xhb.framework.service.ManageUserService;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class ManageUserAction extends BasicAction implements ModelDriven<ManageUser> {
	private ManageUserService manageUserService;
	private ManageUser manageUser;
	private JSONObject jsonObj;
	private int page = 0;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public ManageUser getManageUser() {
		return manageUser;
	}

	public void setManageUser(ManageUser manageUser) {
		this.manageUser = manageUser;
	}

	public ManageUserService getManageUserService() {
		return manageUserService;
	}

	public void setManageUserService(ManageUserService manageUserService) {
		this.manageUserService = manageUserService;
	}

	public JSONObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JSONObject jsonObj) {
		this.jsonObj = jsonObj;
	}

	@Override
	public ManageUser getModel() {
		return manageUser;
	}

	/**
	 * 跳转到后台用户登录页面
	 * 
	 * @return
	 */
	public String toLoginUserPage() {
		return "login";
	}

	/**
	 * 后台用户登录
	 * 
	 * @return
	 */
	public String loginUser() {
		jsonObj = new JSONObject();
		if (manageUser != null) {
			List<ManageUser> list = manageUserService.userlogin(manageUser);
			if (list == null || list.size() == 0) {
				jsonObj.put("result", false);
			} else {
				jsonObj.put("result", true);
			}
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 登录成功后跳转页面
	 * 
	 * @return
	 */
	public String toManageUserIndexPage() {
		return "manageUserIndex";
	}

	/**
	 * 加载后台用户
	 * 
	 * @return
	 */
	public String getAllManageUser() {
		
		jsonObj = new JSONObject();
		int count = manageUserService.getAllManageUserTotal(manageUser);
		List<ManageUser> list = manageUserService.getAllManageUser(manageUser, page);
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", count);
		jsonMap.put("manageUserList", list);
		jsonObj = JSONObject.fromObject(jsonMap);
		return SUCCESS;
	}
	/**
	 * 添加用户
	 * @return
	 */
	public String addManageUser(){
		manageUser.setManageUserStatus("1");
		jsonObj = new JSONObject();
		jsonObj.put("result", false);
		try {
			manageUserService.saveEntity(manageUser);
			jsonObj.put("result", true);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 获取用户详情
	 * @return
	 */
	public String getManageUserInfo(){
		manageUser=manageUserService.findById(manageUser.getManageUserId());
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("manageUser", manageUser);
		jsonObj = JSONObject.fromObject(jsonMap);
		return SUCCESS;
	}
	/**
	 * 修改用户信息
	 * @return
	 */
	public String updateManageUser(){
		jsonObj = new JSONObject();
		jsonObj.put("result", false);
		try {
			manageUserService.updateEntity(manageUser);
			jsonObj.put("result", true);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 删除用户信息
	 * @return
	 */
	public String delManageUser(){
		jsonObj = new JSONObject();
		jsonObj.put("result", false);
		try {
			manageUserService.saveOrUpdateBySql("update manage_user set manage_user_status='0' where manage_user_id="+manageUser.getManageUserId());
			jsonObj.put("result", true);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 获取所有权限字典
	 * @return
	 */
	public String getAllAuthorityGroup(){
		jsonObj = new JSONObject();
		List<AuthorityGroup> list=new ArrayList() ;
		try {
			list=(List<AuthorityGroup>)manageUserService.findBySql("select * from authority_group");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("authorityGroupList", list);
		jsonObj = JSONObject.fromObject(jsonMap);
		return SUCCESS;
	}
}
