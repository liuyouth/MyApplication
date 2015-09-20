<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
<meta charset="utf-8" />
<title>行伙伴</title>
</head>
<body style="background:url(images/manage/mbg.jpg) round;margin:0;padding:0;text-align:center;">
    <div style="position:relative;min-width:999px;height:179px;background:#4B88C7;top:40%;">
      <div style="width:999px;margin:0 auto;text-align:left;">
        <div style="position:absolute;top:-200px;">
          <img src="images/manage/mlogo.png">
        <div>
        <div style="position:relative;margin-top:60px;">
          <img src="images/manage/mzs.png">
          <div style="position:absolute;text-align:center;top:80px;left:370px;">
            <div>
              <label>用户名：</label>
              <input type="text" size="20" id="supplierAccount" name="supplierAccount" >
            </div>
            <br/>
            <div>
              <label>密&nbsp;码：</label> 
              <input type="password" size="20" id="supplierPassword" name="supplierPassword">
            </div>
            <br/>
            <div>
              <button onclick="login()">登录</button>
            </div>
          </div>
        <div>
      </div>
    </div>

<script src="js/jquery.min.js"></script>
<script type="text/javascript">
function login(){
	if(loginValidate()){
		$.ajax({
			type : 'post',
			url : "supplier_loginSupplier.html",
			dataType : "json",
			data:{
				"supplier.supplierAccount":$("#supplierAccount").val(),
				"supplier.supplierPassword":$("#supplierPassword").val()
			},
			aysnc : false,
			success : function(data){
				if(!data.result){
					alert("用户名密码错误！");	
				}else{
					location.href = "supplier_toSupplierAdmin.html";
				}
			},
			error: function() {
				alert("系统错误,请重试.");
			},
		});
	}
}
function loginValidate(){
	if($.trim($("#supplierAccount").val())==""||$("#supplierAccount").val()==null){
		alert("用户名不能为空");
		return false;
	}
	if($.trim($("#supplierPassword").val())==""||$("#supplierPassword").val()==null){
		alert("密码不能为空");
		return false;
	}
	return true;
}
</script>
</body>
</html>