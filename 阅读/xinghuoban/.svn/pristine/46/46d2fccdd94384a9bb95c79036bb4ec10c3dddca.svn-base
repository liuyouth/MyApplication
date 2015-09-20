<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.rescam.xhb.framework.entity.Goods" %>
<%@ page import="com.rescam.xhb.framework.entity.GoodsPreferential" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update</title>
<%
String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 
 Goods goods = (Goods)request.getAttribute("goods");
 GoodsPreferential goodsPreferential = (GoodsPreferential)request.getAttribute("goodsPreferential");
 %>

 <link href="css/bootstrap.min.css" rel="stylesheet">
 <style type="text/css">
 	.imgBorder img{
 		border: 2px red solid;
 	}
 </style>
</head>
<body>
<div id="updateWin" style="width: 600px;">
	<form id="updateForm" action="goods_updateGoods.html" method="post">
		<div style="">
			
			<div class="form-group">
				<label style="width:20%;text-align: right;">商品名称：</label>
				<input type="text" name="goods.goodsName" value="<%=goods.getGoodsName() %>" id="goodsName" class="form-control" style="width:60%;display: initial;" placeholder=""/>
				<font style="color: red;">&nbsp;必填</font>
			</div>
			<div class="form-group">
				<label style="width:20%;text-align: right;">商品介绍：</label>
				<textarea rows="5" cols="47" id="goodsIntroduce" name="goods.goodsIntroduce" class="form-control" style="width:60%;display: initial;" placeholder=""><%=goods.getGoodsIntroduce() %></textarea>
				<font style="color: red;">&nbsp;必填</font>
			</div>
			<div class="form-group">
				<label style="width:20%;text-align: right;">商品种类：</label>
				<input type="hidden" name="goodsTypeHid" id="goodsTypeHid" value="<%=goods.getGoodsType() %>" class="form-control" style="width:60%;display: initial;" placeholder=""/> 
				<select id="goodsType" name="goods.goodsType" onchange="changeGoodsType()" class="form-control"  style="width:60%;display: initial;">
					<option value="1">交通</option>
					<option value="2">商品</option>
					<option value="3">服务</option>
				</select>
				<font style="color: red;">&nbsp;必填</font>
			</div>
			<div class="form-group">
				<label style="width:20%;text-align: right;">目录：</label>
				<input type="hidden" id="goodsCatalogIdHid" value="<%=goods.getGoodsCatalogId() %>"/>
				<select id="goodsCatalogId" name="goods.goodsCatalogId" class="form-control authority_group" style="width:60%;display: initial;">
				</select>
				<font style="color: red;">&nbsp;必填</font>
			</div>
			<div class="form-group">
				<label style="width:20%;text-align: right;">单价：</label>
				<input id="goodsPrice" name="goods.goodsPrice" value="<%=goods.getGoodsPrice() %>"  class="form-control" style="width:60%;display: initial;" placeholder=""/>
				<font style="color: red;">&nbsp;必填</font>
			</div>
			<div class="form-group">
				<label style="width:20%;text-align: right;">计价单位：</label>
				<input id="chargeUnit" name="goods.chargeUnit" value="<%=goods.getChargeUnit() %>" class="form-control" style="width:60%;display: initial;" placeholder=""/>
				<font style="color: red;">&nbsp;必填</font>
			</div>
			<div class="form-group">
				<label style="width:20%;text-align: right;">服务热线：</label>
				<input id="serviceHotline" name="goods.serviceHotline" value="<%=goods.getServiceHotline() %>" class="form-control" style="width:60%;display: initial;" placeholder=""/>
				<font style="color: red;">&nbsp;必填</font>
			</div>
			<div class="form-group">
				<label style="width:20%;text-align: right;">销售状态：</label>
				<input type="hidden" id="goodsSalesStatusHid" value="<%=goods.getGoodsSalesStatus() %>"/>
				<select id="goodsSalesStatus" name="goods.goodsSalesStatus" class="form-control" style="width:60%;display: initial;">
					<option value="2">已上架</option>
					<option value="1">未上架</option>
					<option value="0">已下架</option>
				</select>
			</div>
			<div class="form-group">
				<label style="width:20%;text-align: right;"> 总量：</label>
				<input id="total" name="goods.total" value="<%=goods.getTotal() %>" class="form-control" style="width:60%;display: initial;" placeholder=""/>
				<font style="color: red;">&nbsp;必填</font>
			</div>
			<div class="form-group">
				<label style="width:20%;text-align: right;">商品优惠：</label>
				<input type="hidden" id="preferentialTypeHid" value="<%=goodsPreferential.getPreferentialType() %>"/>
				<select id="preferentialType" name="goodsPreferential.preferentialType" onchange="changePreferential()" class="form-control" style="width:60%;display: initial;" >
					<option value="-1">无优惠</option>
					<option value="0">打折</option>
					<option value="1">团购</option>
				</select>
			</div>
			<input type="hidden" id="preferentialId" name="goodsPreferential.goodsPreferentialId" value="<%=goodsPreferential.getGoodsPreferentialId()==null?-1:goodsPreferential.getGoodsPreferentialId() %>"/>
			<div class="form-group" id="zhekouDiv" style="display: none" >
				<label style="width:20%;text-align: right;">折扣率：</label>
				<input id="discount" name="goodsPreferential.discount" value="<%=goodsPreferential.getDiscount() %>" class="form-control" style="width:60%;display: initial;" placeholder=""/>
			</div>
			<div class="form-group" id="tuangouDiv" style="display: none">
				<label style="width:20%;text-align: right;">团购价：</label>
				<input id="groupPrice" name="goodsPreferential.groupPrice" value="<%=goodsPreferential.getGroupPrice() %>" class="form-control" style="width:60%;display: initial;" placeholder=""/>
			</div>
			<div class="form-group">
				<label style="width:20%;text-align: right;">展示图片：</label>
			 	<input type="file" name="upload_file" id="upload_file" class="form-control" style="width:60%;display: initial;"/>  
			</div>
			<!-- 已有图片 -->
			<input type="hidden" id="defaultImgId" name="defaultImgId" > 
			<div id="imgExist" class="form-group" style="margin-left: 130px; width: 600px; height: 80px;">
				<%  
					List<Map<String, Object>> imageListData = (List<Map<String, Object>>)request.getAttribute("imageListData");
					if(imageListData.size()>0){
						for(int i=0; i<imageListData.size();i++){
							Map<String, Object> map=imageListData.get(i);
							if(map.get("isDefault").toString().equals("1")){
								%>
									<div id="<%=map.get("goodsImageId")%>" style="display: inline;" class="imgBorder" onclick="changeDefaultImg(this)">
										<img src="<%=map.get("imagePath")%>" width="80px"/>
										<a href="javascript:void(0);" onclick="delImg(<%=map.get("goodsImageId")%>)">删除</a>
									</div>
								<%
							}else{
								%>
									<div id="<%=map.get("goodsImageId")%>" style="display: inline;" onclick="changeDefaultImg(this)">
										<img src="<%=map.get("imagePath")%>" width="80px"/>
										<a href="javascript:void(0);" onclick="delImg(<%=map.get("goodsImageId")%>)">删除</a>
									</div>
								<%
							}
				
						}
					}
					
				%>
			</div>
			<!-- 新上传图片 -->
			<input type="hidden" id="isUpload" name="isUpload" value="0">
			<div id="imgUpload" class="form-group" style="margin-left: 130px; width: 600px; height: 80px;">
				
			</div>
			<div class="form-group">
				<label style="width:20%;text-align: right;">供应商：</label>
				<input type="hidden" id="supplierIdHid" value="<%=goods.getSupplierId() %>"/>
				<select id="supplierId" name="goods.supplierId" class="form-control" style="width:60%;display: initial;"></select>
				<font style="color: red;">&nbsp;必填</font>
			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" >取消</button>
			<button id="submitBtn" type="button" class="btn btn-primary" onclick="javascript:updateSubmit();">保存</button>
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
<script src="js/fileupload/jquery.ui.widget.js"></script>
<script src="js/fileupload/jquery.fileupload.js"></script>

<script type="text/javascript">
$(document).ready(function () {
	loadGoodsCatalog($("#goodsTypeHid").val());
	loadSupplier();
	loadPreferential();
	$("#goodsType option[value='"+$("#goodsTypeHid").val()+"']").attr("selected", "selected");//商品种类
	$("#goodsSalesStatus option[value='"+$("#goodsSalesStatusHid").val()+"']").attr("selected", "selected");//销售状态
	//alert(str);
	
});
function changeGoodsType(){
	loadGoodsCatalog($("#goodsType").val());
}
//加载二级菜单
function loadGoodsCatalog(goodsType){
	$.ajax({
		type : "post",
		url : "catalog_querySecondMenuListByParentId.html",
		dataType : "json",
		data : {
			parentCatalogId : goodsType
		},
		aysnc : false,
		success : function(data){
			var secondMenuDataList = data.secondMenuList;
			if(secondMenuDataList.length != 0){
				//有二级目录数据
				$("#goodsCatalogId").empty();
				for(var i=0;i<secondMenuDataList.length;i++){
					var secondMenuData = secondMenuDataList[i];
					
					var goodsCatalogId = secondMenuData[0];
					var parentCatalogId = secondMenuData[1];
					var goodsCatalogName = secondMenuData[2];
					var goodsCatalogStatus = secondMenuData[3];
					
					var op = document.createElement("option");
					$(op).val(goodsCatalogId).text(goodsCatalogName);
					$("#goodsCatalogId").append(op);
					
					$("#goodsCatalogId option[value='"+$("#goodsCatalogIdHid").val()+"']").attr("selected", "selected");
				}
			}else{
				//无二级目录数据
				alert("系统错误，请稍后重试！");
			}
		}
	});
}
//加载供应商下拉框
function loadSupplier(){
	$.ajax({
		type : "post",
		url : "supplier_getSupplierKV.html",
		dataType : "json",
		data : {
			
		},
		aysnc : false,
		success : function(data){
			var supplierList = data.supplierList;
			if(supplierList.length != 0){
				//有供应商数据
				$("#supplierId").empty();
				for(var i=0;i<supplierList.length;i++){
					var supplier = supplierList[i];
					
					var supplierId = supplier[0];
					var supplierName = supplier[1];
					
					var op = document.createElement("option");
					$(op).val(supplierId).text(supplierName);
					$("#supplierId").append(op);
					
					$("#supplierId option[value='"+$("#supplierIdHid").val()+"']").attr("selected", "selected");
					
				}
			}else{
				//无供应商数据
				alert("系统错误，请稍后重试！");
			}
		}
	});
}
//加载该商品的优惠信息
function loadPreferential(){
	var preferentialType=$("#preferentialTypeHid").val();
	//alert(preferentialType);
	$("#preferentialType option[value='"+$("#preferentialTypeHid").val()+"']").attr("selected", "selected");
	preferential(preferentialType,1);
}
function preferential(preferentialType,type){
	if(type==2){
		$("#discount").val("");
		$("#groupPrice").val("");
	}
	if(preferentialType==0){
		$("#zhekouDiv").css("display","block");
		$("#tuangouDiv").css("display","none");
		
	}else if(preferentialType==1){
		$("#tuangouDiv").css("display","block");
		$("#zhekouDiv").css("display","none");
	}else{
		$("#tuangouDiv").css("display","none");
		$("#zhekouDiv").css("display","none");
	}
}
//选择折扣或是团购
function changePreferential(){
	preferential($("#preferentialType").val(),2);
}
function updateSubmit(){
	$("#defaultImgId").val($(".imgBorder").attr("id"));
	$('#updateForm').form('submit', {
		url : "goods_updateGoods.html",
		success : function(data) {
			var result = eval('(' + data + ')');
			if (result.result) {
				alert("修改成功");
			} else {
				alert("修改失败！");
			}
		},
		error:function(){
			alert("系统错误，请稍后重试！");
		}
	}); 
}

/*---------------------图片上传  ---------------------*/            
$('#upload_file').fileupload({
    url : 'goods_uploadGoodsImage.html',
    dataType: 'json',
    add: function(e, data) {
        var uploadErrors = [];
        var acceptFileTypes = /(\.|\/)(jpg|png|jpeg|gif)$/i;
        if(data.originalFiles[0]['type'].length && !acceptFileTypes.test(data.originalFiles[0]['type'])) {
         	uploadErrors.push('您只能上传jpg、png、jpeg、gif格式的图片');
        }
        if(data.originalFiles[0]['size'].length && data.originalFiles[0]['size'] > 2000000) {
         	uploadErrors.push('你的文件过大超过了2MB');
        }
        if(uploadErrors.length > 0) {
         	alert(uploadErrors.join("\n"));
        } else {
         	data.submit();
        }
    },
    done: function (e,data) {
         //上传文件成功后响应
         alert("上传成功")
    },
    fail:function (e,data) {
         //发送返回失败后响应
         alert('上传失败');
    },
    success:function(data){
    	$("#isUpload").val("1");
    	alert($("#isUpload").val());
    	
    	alert(data.imgPath);
    	
    	var divImg="<div id='' style='display: inline;' onclick='changeDefaultImg(this)'>"+
						"<img src='"+data.imgPath+"' width='80px'/></div>";
		
		$("#imgUpload").append(divImg);
    	//上传成功之后删除所有图片
    	$.ajax({
		type : "post",
		url : "goodsImage_delGoodsImageById.html",
		dataType : "json",
		data : {
			"goodsImage.goodsImageId":imgId
		},
		aysnc : false,
		success : function(data) {
			if (data.result) {
				alert("删除成功");
				location.reload();
			} else {
				alert("删除失败！");
			}
		}
	});
    	
        //$("#imgUpload").append(img);
    }
});
//点击图片后为选中状态
function changeDefaultImg(obj){
	$("#imgExist > div").each(function(){
		$(this).removeClass("imgBorder");
	});
	$(obj).addClass("imgBorder");
// 	alert($("#defaultImgId").val());
// 	if($("#defaultImgId").val()==""){
		
// 	}
	
}
//删除已上传的图片
function delImg(imgId){
	$.ajax({
		type : "post",
		url : "goodsImage_delGoodsImageById.html",
		dataType : "json",
		data : {
			"goodsImage.goodsImageId":imgId
		},
		aysnc : false,
		success : function(data) {
			if (data.result) {
				alert("删除成功");
				location.reload();
			} else {
				alert("删除失败！");
			}
		}
	});
}

</script>
</html>