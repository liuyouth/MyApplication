<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String isAdd = request.getParameter("isAdd");
%>
<%
	String supplier_id = request.getParameter("supplier_id");
%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<link href="css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div id="addWin" style="width: 600px; margin: 0 auto;">

		<form id="addForm" method="post">
			<input type="hidden" id="isAdd" name="isAdd">
			<div style="">
				<div class="modal-footer" ; style="text-align: center">

					<label id="title" style="text-align: center;">请填写要添加供应商的信息</label>
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">供应商名称：</label> <input
						id="supplierName" name="supplier.supplierName" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder=""> <font style="color: red;">&nbsp;必填</font>
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">联系电话：</label> <input
						id="supplierPhone" name="supplier.supplierPhone" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder=""> <font style="color: red;">&nbsp;必填</font>
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">邮箱账号：</label> <input
						id="supplierAccount" name="supplier.supplierAccount" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder=""> <font style="color: red;">&nbsp;必填</font>
				</div>

				<div class="form-group">
					<label style="width: 20%; text-align: right;">注册号：</label> <input
						id="registerCode" name="supplier.registerCode" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">类型：</label> <input
						id="supplierType" name="supplier.supplierType" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">注册资本：</label> <input
						id="registerCapital" name="supplier.registerCapital" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">住所：</label> <input
						id="supplierAddress" name="supplier.supplierAddress" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">经营期限：</label> <input
						id="operatingPeriod" name="supplier.operatingPeriod" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">经营范围：</label> <input
						id="operatingRange" name="supplier.operatingRange" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">法定代表人：</label> <input
						id="legalRepresentative" name="supplier.legalRepresentative"
						type="text" class="form-control"
						style="width: 60%; display: initial;" placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">成立日期：</label> <input
						id="foundDate" name="supplier.foundDate" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">营业执照：</label> <input
						id="businessLicence" name="supplier.businessLicence" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">组织机构代码证：</label> <input
						id="organizationCode" name="supplier.organizationCode" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">税务登记证：</label> <input
						id="taxRegistrationCertificate"
						name="supplier.taxRegistrationCertificate" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">安全生产许可证:</label> <input
						id="safetyProductionLicense"
						name="supplier.safetyProductionLicense" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">经营许可证：</label> <input
						id="businessCertificate" name="supplier.businessCertificate"
						type="text" class="form-control"
						style="width: 60%; display: initial;" placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">生产/加工许可证：</label> <input
						id="productionProcessingLicense"
						name="supplier.productionProcessingLicense" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">产品安全证明：</label> <input
						id="productSafetyCertificate"
						name="supplier.productSafetyCertificate" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">产品保障证明：</label> <input
						id="productSupportCertificate"
						name="supplier.productSupportCertificate" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>
				<div class="form-group">
					<label style="width: 20%; text-align: right;">运输流通证：</label> <input
						id="transportCirculationCard"
						name="supplier.transportCirculationCard" type="text"
						class="form-control" style="width: 60%; display: initial;"
						placeholder="">
				</div>

				<div class="form-group">
					<label style="width: 20%; text-align: right;">状态：</label> <select
						id="supplierStatus" name="supplier.supplierStatus"
						onchange="loadGoodsCatalog()" class="form-control authority_group"
						style="width: 60%; display: initial;">
						<option value="1">正常使用</option>
						<option value="0">禁止使用</option>
					</select> <font style="color: red;">&nbsp;必填</font>
				</div>


				<div class="modal-footer">
					<button type="button" class="btn btn-default"
						onclick="javascript:pageBack();">取消</button>
					<button id="submitBtn" type="button" class="btn btn-primary"
						onclick="javascript:addSubmit();">保存</button>
				</div>
		</form>
	</div>

</body>
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/validator/jquery.validate.js"></script>
<script type="text/javascript" src="js/validator/messages_zh.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script src="js/manage_page.js"></script>
<script type="text/javascript">
	var isAdd =
<%=isAdd%>
	;
	var supplier_id =
<%=supplier_id%>
	;
	$(document)
			.ready(
					function() {
						isAdd =
<%=isAdd%>
	;
						if (isAdd == 1) {

						} else {
							$("#title").text("请修改完数据后点击保存");
							$
									.ajax({
										type : 'POST',
										url : 'supplier_getSupplierInfo.html',
										data : {
											'supplier.supplierId' : supplier_id,
										},
										dataType : 'json',
										aysnc : false,
										success : function(data) {
											if (data) {
												$("#supplierName")
														.val(
																data.result.supplierName);
												$("#supplierPhone")
														.val(
																data.result.supplierPhone);
												$("#supplierAccount")
														.val(
																data.result.supplierAccount);
												$("#supplierCode")
														.val(
																data.result.supplierCode);
												$("#registerCode")
														.val(
																data.result.registerCode);
												$("#supplierType")
														.val(
																data.result.supplierType);
												$("#registerCapital")
														.val(
																data.result.registerCapital);
												$("#supplierCapital")
														.val(
																data.result.supplierCapital);
												$("#supplierAddress")
														.val(
																data.result.supplierAddress);
												$("#supplierPeriod")
														.val(
																data.result.supplierPeriod);
												$("#supplierRange")
														.val(
																data.result.supplierRange);
												$("#legalRepresentative")
														.val(
																data.result.legalRepresentative);
												$("#foundDate").val(
														data.result.foundDate);
												$("#operatingRange")
														.val(
																data.result.operatingRange);
												$("#operatingPeriod")
														.val(
																data.result.operatingPeriod);
												$("#businessLicence")
														.val(
																data.result.businessLicence);
												$("#organizationCode")
														.val(
																data.result.organizationCode);
												$("#taxRegistrationCertificate")
														.val(
																data.result.taxRegistrationCertificate);
												$("#safetyProductionLicense")
														.val(
																data.result.safetyProductionLicense);
												$("#businessCertificate")
														.val(
																data.result.businessCertificate);
												$(
														"#productionProcessingLicense")
														.val(
																data.result.productionProcessingLicense);
												$("#productSafetyCertificate")
														.val(
																data.result.productSafetyCertificate);
												$("#productSupportCertificate")
														.val(
																data.result.productSupportCertificate);
												$("#transportCirculationCard")
														.val(
																data.result.transportCirculationCard);
												$("#supplierStatus")
														.val(
																data.result.supplierStatus);
											} else {
												alert("系统错误，请稍后再试！");
											}

										},
										error : function() {
											alert("系统错误,请稍后再试。");
										}
									});
							$("#submitBtn").removeAttr("onclick");
							$("#submitBtn").bind('click', function() {
								upDateSubmit()
							});
						}

					});

	function addSubmit() {

		if (addValidate()) {
			$('#addForm').form('submit', {
				url : "supplier_addSupplier.html",
				success : function(data) {
					var result = eval('(' + data + ')');
					if (result.result) {
						alert("添加成功");
						pageBack();
					} else {
						alert("添加失败,此账号已存在");
					}
				}
			});
		}
	}
	function upDateSubmit() {
		if (updateValidate()) {
			$('#addForm').form('submit', {
				url : "supplier_updateSupplier.html",
				success : function(data) {
					var result = eval('(' + data + ')');
					if (result.result) {
						alert("修改成功");

						pageBack();
						showData();
					} else {
						alert("修改失败！");
					}
				}
			});
		}

	}
	function updateValidate() {
		if ($.trim($("#supplierName").val()) == ""
				|| $("#supplierName").val() == null) {
			alert("供应商名称不能为空");
			return false;
		}
		if ($.trim($("#supplierPhone").val()) == ""
				|| $("#supplierPhone").val() == null) {
			alert("联系电话不能为空");
			return false;
		}
		if ($.trim($("#supplierAccount").val()) == ""
				|| $("#supplierAccount").val() == null) {
			alert("邮箱账号不能为空");
			return false;
		}

		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (!myreg.test($("#supplierPhone").val())) {
			alert('请输入有效的手机号码！');
			return false;
		}
		var regMail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if (!regMail.test($("#supplierAccount").val())) {
			alert('请输入有效邮箱账号！');
			return false;
		}
		return true;
	}
	function addValidate() {
		if ($.trim($("#supplierName").val()) == ""
				|| $("#supplierName").val() == null) {
			alert("供应商名称不能为空");
			return false;
		}
		if ($.trim($("#supplierPhone").val()) == ""
				|| $("#supplierPhone").val() == null) {
			alert("联系电话不能为空");
			return false;
		}
		if ($.trim($("#supplierAccount").val()) == ""
				|| $("#supplierAccount").val() == null) {
			alert("邮箱账号不能为空");
			return false;
		}

		var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
		if (!myreg.test($("#supplierPhone").val())) {
			alert('请输入有效的手机号码！');
			return false;
		}
		var regMail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if (!regMail.test($("#supplierAccount").val())) {
			alert('请输入有效邮箱账号！');
			return false;
		}
		return true;
	}
	function pageBack() {
		location.href = "supplier_toSupplierIndexPage.html";
	}
</script>
</html>