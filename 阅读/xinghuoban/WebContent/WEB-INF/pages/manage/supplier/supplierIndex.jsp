<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div>
		<span id="supplier" class="glyphicon glyphicon-user">&nbsp; <input
			id="userId" name="userId" type="hidden"
			value="${sessionScope.se.manageUserId }" /> 您好！ &nbsp;&nbsp;<a
			href="">${sessionScope.se.manageUserName }</a> <a
			href="manageUser_logout.html">退出</a>
		</span>
	</div>
	<div class="container">
		<table>
			<tr>
				<td>姓名</td>
				<td><input type="text" id="supplierName" name="supplierName" /></td>
				<td>手机号</td>
				<td><input type="text" id="supplierPhone" name="supplierPhone" /></td>
				<td><button onclick="searchData()">查询</button></td>
				<td style="padding-left: 50px;"><button
						onclick="javascript:openAddWin();">添加</button></td>
			</tr>
		</table>


		<table class="table table-hover" style="width: 900px;">
			<thead>
				<tr>
					<th>供应商名称</th>
					<th>手机号</th>
					<th>账号</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="userData">

			</tbody>
		</table>
		<!--分页-->
		<input type="hidden" id="nowPage" value="1">
		<div id="pagePanel" class="row pageNumDiv"
			style="text-align: center; width: 900px;"></div>
		<!--分页-->
		<table id="noData">
			<tr>
				<td>暂无数据！</td>
			</tr>
		</table>
	</div>
	<div id="addWin" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">添加用户</h4>
				</div>
				<form id="addForm" method="post">
					<div class="modal-body" style="max-height: 300px; overflow: auto;">

						<div class="form-group">
							<label style="width: 20%; text-align: right;">供应商名称：</label> <input
								id="supplierName_add" name="supplier.supplierName" type="text"
								class="form-control" style="width: 60%; display: initial;"
								placeholder=""> <font style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width: 20%; text-align: right;">手机号：</label> <input
								id="supplierPhone_add" name="supplier.supplierPhone" type="text"
								class="form-control" style="width: 60%; display: initial;"
								placeholder=""> <font style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width: 20%; text-align: right;">账号：</label> <input
								id="supplierMail_add" name="supplier.supplierMail" type="text"
								class="form-control" style="width: 60%; display: initial;"
								placeholder=""> <font style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width: 20%; text-align: right;">权限：</label> <select
								id="authority_group_add" name="supplier.authorityGroupId"
								class="form-control authority_group"
								style="width: 60%; display: initial;">
							</select> <font style="color: red;">&nbsp;必填</font>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button id="submitBtn" type="button" class="btn btn-primary"
							onclick="javascript:addSubmit();">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div id="updateWin" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">用户详情</h4>
				</div>
				<form id="updateForm">
					<div class="modal-body" style="max-height: 300px; overflow: auto;">

						<input type="hidden" id="supplier_id" name="supplier_id">
						<div class="form-group">
							<label style="width: 20%; text-align: right;">供应商名称：</label> <input
								id="supplierName_update" name="supplier.supplierName"
								type="text" class="form-control"
								style="width: 60%; display: initial;" placeholder=""> <font
								style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width: 20%; text-align: right;">手机号：</label> <input
								id="supplierPhone_update" name="supplier.supplierPhone"
								type="text" class="form-control"
								style="width: 60%; display: initial;" placeholder=""> <font
								style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width: 20%; text-align: right;">账号：</label> <input
								id="supplierMail_update" name="supplier.supplierMail"
								type="text" class="form-control"
								style="width: 60%; display: initial;" placeholder=""> <font
								style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width: 20%; text-align: right;">权限：</label> <select
								id="authority_group_update" name="supplier.authorityGroupId"
								class="form-control authority_group"
								style="width: 60%; display: initial;">
							</select> <font style="color: red;">&nbsp;必填</font>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button id="submitBtn_update" type="button"
							class="btn btn-primary" onclick="javascript:updateSubmit();">保存</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="updatePwdWin" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">修改密码</h4>
				</div>
				<form id="addForm" method="post">
					<div class="modal-body" style="max-height: 300px; overflow: auto;">
						<div class="form-group">
							<label style="width: 20%; text-align: right;">新密码：</label> <input
								id="supplierPassword_update" name="supplierPassword_update"
								type="password" class="form-control"
								style="width: 60%; display: initial;" placeholder=""> <font
								style="color: red;">&nbsp;必填</font>
						</div>
						<div class="form-group">
							<label style="width: 20%; text-align: right;">重复新密码：</label> <input
								id="supplierPasswordRep" type="password" class="form-control"
								style="width: 60%; display: initial;" placeholder=""> <font
								style="color: red;">&nbsp;必填</font>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button id="submitBtn" type="button" class="btn btn-primary"
							onclick="javascript:updatePwd();">保存</button>
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
		$(document).ready(function() {
			$("#noData").hide();
			showData();
		})
		//加载后台用户
		function showData() {
			$("#noData").hide();
			//清空列表
			$("#userData").empty();
			$.ajax({
				type : 'post',
				url : "supplier_getAllSupplier.html",
				dataType : "json",
				data : {
					"supplier.supplierName" : $("#supplierName").val(),
					"supplier.supplierPhone" : $("#supplierPhone").val(),
					"page" : $('#nowPage').val()
				},
				aysnc : false,
				success : function(data) {
					if (data.supplierList.length != 0) {
						for (var i = 0; i < data.supplierList.length; i++) {
							var supplier = data.supplierList[i];
							var supplierName = supplier[1];
							var supplierPhone = supplier[2];
							var supplierMail = supplier[3];

							var tr = document.createElement("tr");
							var tdName = document.createElement("td");
							$(tdName).text(supplierName);

							var tdPhone = document.createElement("td");
							$(tdPhone).text(supplierPhone);

							var tdMail = document.createElement("td");
							$(tdMail).text(supplierMail);

							var tdOperate = document.createElement("td");
							var detail_a = document.createElement("a");
							$(detail_a).text("详情").attr(
									"href",
									"javascript:openInfoWin(" + supplier[0]
											+ ")");
							var del_a = document.createElement("a");
							$(del_a).text("删除").attr("href",
									"javascript:del(" + supplier[0] + ")");
							$(del_a).css("padding-left", "20px");

							var rePwd_a = document.createElement("a");
							$(rePwd_a).text("重置密码").attr("href",
									"javascript:rePwd(" + supplier[0] + ")");
							$(rePwd_a).css("padding-left", "20px");

							$(tdOperate).append(detail_a).append(del_a).append(
									rePwd_a);

							$(tr).append(tdName).append(tdPhone).append(tdMail)
									.append(tdOperate);
							$("#userData").append(tr);
						}
						$(".pageNumDiv").show();
						pageShow(data.total);
					} else {
						$("#noData").show();//无数据
						$(".pageNumDiv").hide();
					}
				},
				error : function() {
					alert("系统错误,请重试.");
				},
			});
		}
		//打开添加窗口
		function openAddWin() {
			window.location.href = "page_pageJump.html?pageName=toAddSupplier&isAdd=1";

		}
		function addValidate() {
			if ($.trim($("#supplierName_add").val()) == ""
					|| $("#supplierName_add").val() == null) {
				alert("姓名不能为空");
				return false;
			}
			if ($.trim($("#supplierPhone_add").val()) == ""
					|| $("#supplierPhone_add").val() == null) {
				alert("手机号不能为空");
				return false;
			}
			if ($.trim($("#supplierMail_add").val()) == ""
					|| $("#supplierMail_add").val() == null) {
				alert("邮箱不能为空");
				return false;
			}
			if ($("#authority_group_add").val() == "-1") {
				alert("权限不能为空");
				return false;
			}
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if (!myreg.test($("#supplierPhone_add").val())) {
				alert('请输入有效的手机号码！');
				return false;
			}
			var regMail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
			if (!regMail.test($("#supplierMail_add").val())) {
				alert('请输入有效邮箱！');
				return false;
			}
			return true;
		}
		function updateValidate() {
			if ($.trim($("#supplierName_update").val()) == ""
					|| $("#supplierName_update").val() == null) {
				alert("姓名不能为空");
				return false;
			}
			if ($.trim($("#supplierPhone_update").val()) == ""
					|| $("#supplierPhone_update").val() == null) {
				alert("联系电话不能为空");
				return false;
			}
			if ($.trim($("#supplierMail_update").val()) == ""
					|| $("#supplierMail_update").val() == null) {
				alert("邮箱不能为空");
				return false;
			}
			if ($("#authority_group_update").val() == "-1") {
				alert("权限不能为空");
				return false;
			}
			var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
			if (!myreg.test($("#supplierPhone_update").val())) {
				alert('请输入有效的手机号码！');
				return false;
			}
			var regMail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
			if (!regMail.test($("#supplierMail_update").val())) {
				alert('请输入有效邮箱！');
				return false;
			}
			return true;
		}

		//打开详情窗口
		function openInfoWin(supplier_id) {

		window.location.href = "page_pageJump.html?pageName=toAddSupplier&isAdd=0&supplier_id="
					+ supplier_id;

		}
		//提交修改
		function updateSubmit() {
			if (updateValidate()) {
				$('#updateForm').form('submit', {
					url : "supplier_updateSupplier.html",
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
		function del(supplier_id) {
			$.ajax({
				url : "supplier_delSupplier.html",
				data : {
					"supplier.supplierId" : supplier_id
				},
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

		//打开修改密码窗口
		function rePwd(supplier_id) {
			//alert(supplier_id);
			$.ajax({
				url : "supplier_updateSupplierPassword.html",
				data : {
					"supplier.supplierId" : supplier_id
				},
				success : function(data) {
					if (data.result) {
						alert("修改成功");
						showData();
					} else {
						alert("修改失败！");
					}
				}
			});
		}
	    function searchData(){
			$('#nowPage').val(1);
			showData();
		}
	</script>
</body>
</html>