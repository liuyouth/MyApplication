<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

 <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div>
	<span id="manageUser" class="glyphicon glyphicon-user">&nbsp;
		<input id="userId" name="userId" type="hidden" value="${sessionScope.se.manageUserId }" />  
		您好！ &nbsp;&nbsp;<a href="">${sessionScope.se.manageUserName }</a>
		<a href="javascript:void(0)" onclick="openUpdatePwdWin()">修改密码</a>
		<a href="manageUser_logout.html">退出</a>
	</span>
</div>
<div class="container">
	<table>
		<tr>
			<td>姓名</td><td><input type="text" id="manageUserName" name="manageUserName"/></td>
			<td>手机号</td><td><input type="text" id="manageUserPhone" name="manageUserPhone"/></td>
			<td><button onclick="searchData()">查询</button></td>
			<td style="padding-left: 50px;"><button onclick="javascript:openAddWin();">添加</button></td>
		</tr>
	</table>
	
	
	<table class="table table-hover" style="width: 900px; ">
	    <thead>
		    <tr>
		        <th>姓名</th>
				<th>手机号</th>
				<th>邮箱</th>
				<th>操作</th>
		    </tr>
	    </thead>
	    <tbody id="userData">

	    </tbody>
	</table>
	<!--分页-->
	<input type="hidden" id="nowPage" value="1">
	<div id="pagePanel" class="row pageNumDiv" style="text-align: center;width: 900px;">
	</div>
	<!--分页-->
	<table id="noData" >
		<tr><td>暂无数据！</td></tr>
	</table>
</div>
	<div id="addWin" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">添加用户</h4>
				</div>
				<form id="addForm" method="post">
					<div class="modal-body" style="max-height: 300px;overflow: auto;">
						
						<div class="form-group">
							<label style="width:20%;text-align: right;">姓名：</label>
							<input id="manageUserName_add" name="manageUser.manageUserName" type="text" class="form-control" style="width:60%;display: initial;" placeholder="">
							<font style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width:20%;text-align: right;">手机号：</label>
							<input id="manageUserPhone_add" name="manageUser.manageUserPhone" type="text" class="form-control" style="width:60%;display: initial;" placeholder="">
							<font style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width:20%;text-align: right;">邮箱：</label>
							<input id="manageUserMail_add" name="manageUser.manageUserMail" type="text" class="form-control" style="width:60%;display: initial;" placeholder="">
							<font style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width:20%;text-align: right;">权限：</label>
							<select id="authority_group_add" name="manageUser.authorityGroupId" class="form-control authority_group" style="width:60%;display: initial;">
							</select>
							<font style="color: red;">&nbsp;必填</font>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button id="submitBtn" type="button" class="btn btn-primary" onclick="javascript:addSubmit();">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<div id="updateWin" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">用户详情</h4>
				</div>
				<form id="updateForm">
					<div class="modal-body" style="max-height: 300px;overflow: auto;">
						
						<input type="hidden" id="manageUser_id" name="manageUser_id">
						<div class="form-group">
							<label style="width:20%;text-align: right;">姓名：</label>
							<input id="manageUserName_update" name="manageUser.manageUserName" type="text" class="form-control" style="width:60%;display: initial;" placeholder="">
							<font style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width:20%;text-align: right;">手机号：</label>
							<input id="manageUserPhone_update" name="manageUser.manageUserPhone" type="text" class="form-control" style="width:60%;display: initial;" placeholder="">
							<font style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width:20%;text-align: right;">邮箱：</label>
							<input id="manageUserMail_update" name="manageUser.manageUserMail" type="text" class="form-control" style="width:60%;display: initial;" placeholder="">
							<font style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width:20%;text-align: right;">权限：</label>
							<select id="authority_group_update" name="manageUser.authorityGroupId" class="form-control authority_group" style="width:60%;display: initial;">
							</select>
							<font style="color: red;">&nbsp;必填</font>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button id="submitBtn_update" type="button" class="btn btn-primary" onclick="javascript:updateSubmit();">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="updatePwdWin" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改密码</h4>
				</div>
				<form id="addForm" method="post">
					<div class="modal-body" style="max-height: 300px;overflow: auto;">
						<div class="form-group">
							<label style="width:20%;text-align: right;">新密码：</label>
							<input id="manageUserPassword_update" name="manageUserPassword_update" type="password" class="form-control" style="width:60%;display: initial;" placeholder="">
							<font style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width:20%;text-align: right;">重复新密码：</label>
							<input id="manageUserPasswordRep" type="password" class="form-control" style="width:60%;display: initial;" placeholder="">
							<font style="color: red;">&nbsp;必填</font>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button id="submitBtn" type="button" class="btn btn-primary" onclick="javascript:updatePwd();">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/validator/jquery.validate.js"></script>
<script type="text/javascript" src="js/validator/messages_zh.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script src="js/manage_page.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	$("#noData").hide();
	//$(".pageNumDiv").hide();
	showData();
})
//查询用户
function searchData(){
	$('#nowPage').val(1);
	showData();
}
//加载后台用户
function showData(){
	$("#noData").hide();
	//清空列表
	$("#userData").empty();
	$.ajax({
		type : 'post',
		url : "manageUser_getAllManageUser.html",
		dataType : "json",
		data:{
			"manageUser.manageUserName":$("#manageUserName").val(),
			"manageUser.manageUserPhone":$("#manageUserPhone").val(),
			"page" : $('#nowPage').val()
		},
		aysnc : false,
		success : function(data){
			//var result = eval('(' + data + ')');
			if(data.manageUserList.length != 0){
				for(var i=0;i<data.manageUserList.length;i++){
					var manageUser = data.manageUserList[i];		
					var manageUserName = manageUser[3];
					var manageUserPhone = manageUser[4];
					var manageUserMail = manageUser[1];
					
					var tr = document.createElement("tr");
					var tdName=document.createElement("td");
					$(tdName).text(manageUserName);
					
					var tdPhone=document.createElement("td");
					$(tdPhone).text(manageUserPhone);
					
					var tdMail=document.createElement("td");
					$(tdMail).text(manageUserMail);
					
					var tdOperate=document.createElement("td");
					var detail_a = document.createElement("a");
					$(detail_a).text("详情").attr("href","javascript:openInfoWin("+manageUser[0]+")");
					var del_a = document.createElement("a");
					$(del_a).text("删除").attr("href","javascript:del("+manageUser[0]+")");
					$(del_a).css("padding-left","20px");
					
					var rePwd_a = document.createElement("a");
					$(rePwd_a).text("重置密码").attr("href","javascript:rePwd("+manageUser[0]+")");
					$(rePwd_a).css("padding-left","20px");
					
					$(tdOperate).append(detail_a).append(del_a).append(rePwd_a);
					
					$(tr).append(tdName).append(tdPhone).append(tdMail).append(tdOperate);
					$("#userData").append(tr);
				}
				$(".pageNumDiv").show();
				pageShow(data.total);
			}else{
				$("#noData").show();//无数据
				$(".pageNumDiv").hide();
			}
		},
		error: function() {
			alert("系统错误,请重试.");
		},
	});
}
//打开添加窗口
function openAddWin(){
	//$('#addForm').form('clear');
	loadAuthorityGroup(null);//加载权限组下拉框
	$("#addWin").modal('show');
}
function addValidate(){
	if($.trim($("#manageUserName_add").val())==""||$("#manageUserName_add").val()==null){
		alert("姓名不能为空");
		return false;
	}
	if($.trim($("#manageUserPhone_add").val())==""||$("#manageUserPhone_add").val()==null){
		alert("手机号不能为空");
		return false;
	}
	if($.trim($("#manageUserMail_add").val())==""||$("#manageUserMail_add").val()==null){
		alert("邮箱不能为空");
		return false;
	}
	if($("#authority_group_add").val()=="-1"){
		alert("权限不能为空");
		return false;
	}
	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
    if(!myreg.test($("#manageUserPhone_add").val())){ 
        alert('请输入有效的手机号码！'); 
        return false; 
    }
    var regMail=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
    if(!regMail.test($("#manageUserMail_add").val())){
    	alert('请输入有效邮箱！'); 
    	return false; 
    }
	return true;
}
function updateValidate(){
	if($.trim($("#manageUserName_update").val())==""||$("#manageUserName_update").val()==null){
		alert("姓名不能为空");
		return false;
	}
	if($.trim($("#manageUserPhone_update").val())==""||$("#manageUserPhone_update").val()==null){
		alert("联系电话不能为空");
		return false;
	}
	if($.trim($("#manageUserMail_update").val())==""||$("#manageUserMail_update").val()==null){
		alert("邮箱不能为空");
		return false;
	}
	if($("#authority_group_update").val()=="-1"){
		alert("权限不能为空");
		return false;
	}
	var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
    if(!myreg.test($("#manageUserPhone_update").val())){ 
        alert('请输入有效的手机号码！'); 
        return false; 
    }
    var regMail=/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
    if(!regMail.test($("#manageUserMail_update").val())){
    	alert('请输入有效邮箱！'); 
    	return false; 
    }
	return true;
}
//提交添加
function addSubmit(){
	if (addValidate()) {
		$('#addForm').form('submit', {
			url : "manageUser_addManageUser.html",
			onSubmit : function() {
				return $(this).form('validate');
			},
			success : function(data) {
				var result = eval('(' + data + ')');
				if (result.result) {
					alert("添加成功");
					$("#addWin").modal('hide');
					showData();
				} else {
					alert("添加失败！");
				}
			}
		});
	}
}
//打开详情窗口
function openInfoWin(manageUser_id){
	$('#updateForm').form('clear');
	
	$("#manageUser_id").val(manageUser_id);
	$.ajax({
		url : 'manageUser_getManageUserInfo.html',
		data : {
			'manageUser.manageUserId' :manageUser_id,
		},
		dataType : 'json',
		success : function(data) {
			var manageUser=data.manageUser;
			$("#manageUserName_update").val(manageUser.manageUserName);
			$("#manageUserPhone_update").val(manageUser.manageUserPhone);
			$("#manageUserMail_update").val(manageUser.manageUserMail);
			loadAuthorityGroup(manageUser.authorityGroupId);//加载权限组下拉框
			$("#updateWin").modal('show');
		}
	});
}
//提交修改
function updateSubmit(){
	if (updateValidate()) {
		$('#updateForm').form('submit', {
			url : "manageUser_updateManageUser.html",
			success : function(data) {
				var result = eval('(' + data + ')');
				if (result.result) {
					alert("修改成功");
					$("#updateWin").modal('hide');
					showData();
				} else {
					alert("修改失败！");
				}
			}
		});
	}
}
//删除用户
function del(manageUser_id){
	$.ajax({
			url : "manageUser_delManageUser.html",
			data:{"manageUser.manageUserId":manageUser_id},
			success : function(data) {
				if (data.result) {
					alert("删除成功");
					showData();
				} else {
					alert("删除失败！");
				}
			}
	});
}
//加载权限字典
function loadAuthorityGroup(authorityGroupId){
	//$('#updateForm').form('clear');
	//资源语种
	$.ajax({
		url : 'manageUser_getAllAuthorityGroup.html',
		data : {
			
		},
		dataType : 'json',
		success : function(data) {
			var authorityGroupList=data.authorityGroupList;
			$(".authority_group").empty();
			var op = document.createElement("option");
			$(op).val("-1").text("请选择权限组");
			$(".authority_group").append(op);
			$.each(authorityGroupList, function(index, val) {
				var op = document.createElement("option");
				$(op).val(val[0]).text(val[1]);
				$(".authority_group").append(op);
			});
			if(authorityGroupId!=null){
				$("#authority_group_update option[value='"+authorityGroupId+"']").attr("selected", "selected");
			}
		}
	});
}
//打开修改密码窗口
function openUpdatePwdWin(){
	$("#updatePwdWin").modal('show');
}
//修改密码验证
function updatePwdValidate(){
	var pwd=$.trim($("#manageUserPassword_update").val());
	if(pwd==""||pwd==null){
		alert("新密码不能为空");
		return false;
	}
	if(pwd.length<6){
		alert("新密码不能少于6位");
		return false;
	}
	if($.trim($("#manageUserPasswordRep").val())==""||$("#manageUserPasswordRep").val()==null){
		alert("重复新密码不能为空");
		return false;
	}
	if($("#manageUserPassword_update").val()!=$("#manageUserPasswordRep").val()){
		alert("两次密码不一致，请重新输入！");
		return false;
	}
	return true;
}
//修改密码
function updatePwd(){
	if(updatePwdValidate()){
		$.ajax({
			url : "manageUser_updatePwd.html",
			data:{
				"manageUser.manageUserId":$("#userId").val(),
				"manageUser.manageUserPassword":$("#manageUserPassword_update").val()
			},
			success : function(data) {
				if (data.result) {
					alert("修改成功,请重新登录");
					$("#updatePwdWin").modal('hide');
					location.href="manageUser_toLoginUserPage.html";
				} else {
					alert("修改失败！");
				}
			}
		});
	}
}
//重置密码
function rePwd(manageUserId){
	$.ajax({
		url : "manageUser_updatePwd.html",
		data:{
			"manageUser.manageUserId":manageUserId,
			"pwdType":1
		},
		success : function(data) {
			if (data.result) {
				alert("密码重置成功");
			} else {
				alert("密码重置失败！");
			}
		}
	});
}
</script>
</body>
</html>