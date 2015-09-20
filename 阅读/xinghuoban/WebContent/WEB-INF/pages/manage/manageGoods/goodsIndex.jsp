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
<!--标题-->
		<div class="row navbar-fixed-top" style="text-align:center;border-bottom:1px solid #999999;background-color:#FFFFFF;">
			商品列表
		</div>
		<!--标题-->
		
		<!--一级菜单-->
        <div class="row" style="margin-top:31px;">
			<ul class="nav nav-tabs" id="firstMenuUl" style="margin-top:5px;margin-left:5px;">
				
			</ul>
		</div>
		<!--一级菜单-->
		
		<!--内容-->
		<div class="row">
		
			<!--二级菜单-->
			<div class="col-xs-2" style="padding:0px 3px;">
				<ul class="list-group" id="secondMenuUl" style="font-size:14px;text-align:center;">
					
				</ul>
			</div>
			<!--二级菜单-->
			
			<!--商品列表-->
			<div class="col-xs-9 ">
				
				<div>
					<div class="row">
						<div class="form-group col-xs-4">
							<label style="width:40%;text-align: right;display: inline;">商品名称：</label>
							<input type="text" id="goodsName" name="goodsName" class="form-control" style="width:60%;display: initial;"/>
						</div>
						<div class="form-group col-xs-4">
							<label style="width:40%;text-align: right;display: inline;">供应商：</label>
							<select id="supplierId" name="goods.supplierId" class="form-control authority_group" style="width:60%;display: initial;">
							</select>
						</div>
						<div class="form-group col-xs-4">
							<label style="width:40%;text-align: right;display: inline;">销售状态：</label>
							<select id="goodsSalesStatus" name="goods.goodsSalesStatus" class="form-control authority_group" style="width:60%;display: initial;">
								<option value="2">已上架</option>
								<option value="1">未上架</option>
								<option value="0">已下架</option>
							</select>
						</div>
						<div class="form-group col-xs-2">
							<button onclick="showData()">查询</button>
						</div>
						<div class="form-group col-xs-2">
							<button onclick="javascript:openAddWin();">添加</button>
						</div>
					</div>
				</div>
				
				<input type="hidden" id="goodsType" value="1" >
				<input type="hidden" id="goodsCatalogId" value="4">
			    <div id="goodsData">
		
			    </div>
				
			</div>
			<!--商品列表-->
			
			<!--分页-->
			<input type="hidden" id="nowPage" value="1">
			<div id="pagePanel" class="row pageNumDiv" style="margin:20px auto 25px auto;">
			</div>
			<!--分页-->
			
			<!--无数据-->
			<div class="col-xs-9 noDataDiv">
				<div style="margin:10px auto;color:#999999;font-size:150%;font-weight:900;text-align:center;">
					暂无数据！
				</div>
			</div>
			<!--无数据-->
			
		</div>
		<!--内容-->
    </div> <!-- /container -->


</div>
	
	
	
<script src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript" src="js/validator/jquery.validate.js"></script>
<script type="text/javascript" src="js/validator/messages_zh.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script src="js/manage_page.js"></script>
<script src="js/subString.js"></script>

<script type="text/javascript">
	$(document).ready(function () {
		//无数据div隐藏
		$(".noDataDiv").hide();
		$("#goodsData").hide();
		$(".pageNumDiv").hide();
		loadSupplier();
		//加载菜单数据
		initMenu();
	});
	
	//加载菜单数据
	function initMenu(){
		//先加载一级菜单数据
		$.ajax({
			type : "post",
			url : "catalog_queryFirstMenuList.html",
			dataType : "json",
			aysnc : false,
			success : function(data){
				var firstMenuDataList = data.firstMenuList;
				if(firstMenuDataList.length != 0){
					$("#firstMenuUl").empty();
					
					var currentParentCatalogId = 0;
					for(var i=0;i<firstMenuDataList.length;i++){
						var firstMenuData = firstMenuDataList[i];
						
						var goodsCatalogId = firstMenuData[0];
						var parentCatalogId = firstMenuData[1];
						var goodsCatalogName = firstMenuData[2];
						var goodsCatalogStatus = firstMenuData[3];
						
						var li = document.createElement("li");
						if(i+1 == $("#goodsType").val()){
							$(li).addClass("active");
							currentParentCatalogId = goodsCatalogId;
						}
						var type=i+1;
						$(li).attr("id","firstMenu_"+goodsCatalogId)
							.attr("onclick","javascript:changeTopBtn("+type+");");
						var a = document.createElement("a");
						$(a).attr("href","javascript:void(0);").text(goodsCatalogName).appendTo(li);
						
						$("#firstMenuUl").append(li);
					}
					
					
					$("#firstMenuUl").append(li);
					
					//加载二级菜单
					$.ajax({
						type : "post",
						url : "catalog_querySecondMenuListByParentId.html",
						dataType : "json",
						data : {
							parentCatalogId : currentParentCatalogId
						},
						aysnc : false,
						success : function(data){
							var secondMenuDataList = data.secondMenuList;
							if(secondMenuDataList.length != 0){
								//有二级目录数据
								$("#secondMenuUl").empty();
								for(var i=0;i<secondMenuDataList.length;i++){
									var secondMenuData = secondMenuDataList[i];
									
									var goodsCatalogId = secondMenuData[0];
									var parentCatalogId = secondMenuData[1];
									var goodsCatalogName = secondMenuData[2];
									var goodsCatalogStatus = secondMenuData[3];
									
									var li = document.createElement("li");
									if(goodsCatalogId == $("#goodsCatalogId").val()){
										$("#getGoodsCatalogId").val(goodsCatalogId);
										$(li).addClass("active");
									}
									$(li).addClass("list-group-item secondList").attr("id","catalogId_"+goodsCatalogId)
										.attr("style","padding:3px 0px;cursor:pointer;")
										.attr("onclick","javascript:changeSecondList("+goodsCatalogId+");")
										.text(goodsCatalogName);
									$("#secondMenuUl").append(li);
								}
								
								//加载商品列表页面数据
								showData();
								
							}else{
								//无二级目录数据
								alert("系统错误，请稍后重试！");
							}
						}
					});
				}else{
					alert("系统错误，请稍后重试！");
				}
			}
		});
	}
	
	//加载商品列表页面数据
	function showData(){
		//清空之前显示的商品列表
		$("#goodsData").empty();
		$.ajax({
			type : "post",
			url : "goods_findGoodsListByNameAndSupplierId.html",
			dataType : "json",
			data:{
				"goods.goodsType" : $("#goodsType").val(),
				"goods.goodsSalesStatus" : $("#goodsSalesStatus").val(),
				"goods.goodsCatalogId" : $("#goodsCatalogId").val(),
				"goods.goodsName" : $("#goodsName").val(),
				"goods.supplierId" : $("#supplierId").val(),
				"page" : $('#nowPage').val()
			},
			aysnc : false,
			success : function(data){
				var total = data.total;
				var goodsList = data.goodsList;
				if(goodsList != null && goodsList != ""){
					//后台查询的数据不为空
					//页面显示商品列表
					$("#goodsData").show();
					$(".pageNumDiv").show();
					pageShow(total);
					
					//页面商品列表div隐藏
					$(".noDataDiv").hide();
					
					//页面加载
					for(var i=0;i<goodsList.length;i++){
						var goodsData = goodsList[i];
						var rowDiv = document.createElement("div");
						$(rowDiv).addClass("row").attr("onclick","javascript:jumpToDetail("+goodsData.goodsId+");")
							.attr("style","border:1px solid #999999;");
						
						var imgDiv = document.createElement("div");
						$(imgDiv).addClass("col-xs-2").attr("style","padding:5px;").appendTo(rowDiv);
						var img = document.createElement("img");
						$(img).attr("src",goodsData.imagePath).attr("style","width:80px;height:80px;")
							.appendTo(imgDiv);
						
						var dataDiv = document.createElement("div");
						$(dataDiv).addClass("col-xs-7").appendTo(rowDiv);
						
						var nameDiv = document.createElement("div");
						$(nameDiv).addClass("row").appendTo(dataDiv);
						var nameSpan = document.createElement("span");
						$(nameSpan).attr("style","font-size:80%;").text(goodsData.goodsName).appendTo(nameDiv);
						
						var introduceDiv = document.createElement("div");
						$(introduceDiv).addClass("row").appendTo(dataDiv);
						var introduceP = document.createElement("p");
						$(introduceP).attr("style","font-size:8px;color:#666666;margin:3px 0px;")
							.text(goodsData.goodsIntroduce).appendTo(introduceDiv);
						var goodsIntroduce = goodsData.goodsIntroduce;
						var length = goodsIntroduce.strLen();
						
						if(length > 20){
							goodsIntroduce = goodsIntroduce.subCHString(0, 18);
							$(introduceP).text(goodsIntroduce+"...");
						}else{
							$(introduceP).text(goodsIntroduce);
						}
						
						var priceDiv = document.createElement("div");
						$(priceDiv).addClass("row").appendTo(dataDiv);
						var priceSpan = document.createElement("span");
						$(priceSpan).attr("style","font-size:8px;color:#FA0B0B;")
							.text("￥"+goodsData.goodsPrice+"  "+goodsData.chargeUnit).appendTo(priceDiv);
						//操作
						var OperateDiv = document.createElement("div");
						$(OperateDiv).addClass("col-xs-3").appendTo(rowDiv);
						
						var OperateDiva = document.createElement("div");
						$(OperateDiva).addClass("row").css("padding-top","30px").appendTo(OperateDiv);
						
						var detail_a = document.createElement("a");
						$(detail_a).text("详情").attr("href","goods_getGoodsDetailById.html?goodsId="+goodsData.goodsId);
						$(OperateDiva).append(detail_a);
						//如果为已下架状态不显示删除
						if(goodsData.goodsSalesStatus!='0'){
							var del_a = document.createElement("a");
							$(del_a).text("删除").attr("href","javascript:del("+goodsData.goodsId+")");
							$(del_a).css("padding-left","20px");
							$(OperateDiva).append(del_a);
						}
						$("#goodsData").append(rowDiv);
					}
				}else{
					//后台查询的数据为空
					//页面提示商品信息为空
					$(".noDataDiv").show();
					//页面商品列表div隐藏
					$("#goodsData").hide();
					$(".pageNumDiv").hide();
				}
			}
		});
	}
	
	//点击顶部按钮
	function changeTopBtn(type){
		$("#goodsType").val(type);
		if(type==1){
			$("#goodsCatalogId").val(4);
		}else if(type==2){
			$("#goodsCatalogId").val(14);
		}else if(type==3){
			$("#goodsCatalogId").val(20);
		}
		initMenu();
		$("#supplierId option[value='-1']").attr("selected", "selected");
		$("#goodsSalesStatus option[value='2']").attr("selected", "selected");
		$("#goodsName").val("");
	}
	
	//点击二级菜单
	function changeSecondList(goodsCatalogId){
		$("#goodsCatalogId").val(goodsCatalogId);
		//然后根据分类去查询商品信息
		initMenu();
		$("#supplierId option[value='-1']").attr("selected", "selected");
		$("#goodsSalesStatus option[value='2']").attr("selected", "selected");
		$("#goodsName").val("");
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
					var op = document.createElement("option");
					$(op).val("-1").text("请选择供应商");
					$("#supplierId").append(op);
					for(var i=0;i<supplierList.length;i++){
						var supplier = supplierList[i];
						
						var supplierId = supplier[0];
						var supplierName = supplier[1];
						
						var op = document.createElement("option");
						$(op).val(supplierId).text(supplierName);
						$("#supplierId").append(op);
					}
				}else{
					//无供应商数据
					alert("系统错误，请稍后重试！");
				}
			}
		});
	}
	
	
	//点击底部按钮
	function changeBottomBtn(type){
		//根据type判断跳转页面
		if(type == 1){
			window.location.href="page_pageJump.html?pageName=travelGoodsList"; //出行类商品
		}else if(type == 2){
			window.location.href="page_pageJump.html?pageName=activityList"; //活动列表
		}else if(type == 3){
			window.location.href="page_pageJump.html?pageName=accountCenter"; //账户中心
		}
	}

	//跳转到商品详情页面
	function del(goodsId){
		$.ajax({
			url : "goods_delGoods.html",
			data:{"goods.goodsId":goodsId},
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
	//打开添加窗口
	function openAddWin(){
		window.location.href="page_pageJump.html?pageName=addGoods";
	}
</script>
</body>
</html>