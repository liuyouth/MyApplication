<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String goodsIds = request.getParameter("goodsIds"); 
	String goodsNums = request.getParameter("goodsNums"); 
	String totalPrice = request.getParameter("totalPrice"); 
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>提交订单</title>
    <meta name="description" content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version."/>

    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0">
	
    <link href="css/bootstrap.min.css" rel="stylesheet">
	
    <link href="css/flat-ui.min.css" rel="stylesheet">
  </head>
  <body style="color:#000000;">
    <div class="container" style="margin-bottom:50px;">
		<!--标题-->
		<div class="row navbar-fixed-top" style="text-align:center;border-bottom:1px solid #999999;background-color:#FFFFFF;">
			提交订单
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
			<div class="col-xs-12"> 
				<span style="font-size:120%;font-weight:800;">收货信息</span>
			</div>
			<form class="form-horizontal" role="form" style="margin-top:80px;">
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-3 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						联系人
					</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" style="color:#666666;" id="linkman" 
							placeholder="联系人" readonly>
					</div>
				</div>
				
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-3 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						联系电话
					</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" style="color:#666666;" id="linkmanPhone" 
							placeholder="联系电话" readonly>
					</div>
				</div>
				
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-3 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						收货地址
					</label>
					<div class="col-xs-9">
						<textarea class="form-control" style="color:#666666;" rows="3" 
							id="linkmanAddress" placeholder="收货地址" readonly></textarea>
					</div>
				</div>
				
				<div class="form-group" style="margin:20px 10px;text-align:right;">
					<button type="button" class="btn btn-info btn-lg" style="width:50%;" 
						onclick="javascript:submitOrder();">提交订单</button>
				</div>
			</form>
		</div>
		
		<div class="row">
			<button type="button" class="btn btn-link" id="openMoreAddressBtn" style="width:50%;float:left;" 
				onclick="javascript:openMoreAddress();">更多地址</button>
			<button type="button" class="btn btn-link" id="openAddAddressBtn" style="width:50%;float:left;" 
				onclick="javascript:openAddNewAddress();">添加地址</button>
		</div>
		
		<!--更多地址-->
		<div class="row" id="moreAddressDiv" style="display:none;font-size:80%;">
			<ul class="list-group" id="moreAddressUl">
				
			</ul>
		</div>
		<!--更多地址-->
		
		<!--添加新地址-->
		<div class="row" id="addNewAddressDiv" style="display:none;">
		
			<hr style="border:1px solid #999999;margin:3px 0px;height:1px;background-color:#999999;"/>
			
			<div class="col-xs-12"> 
				<span style="font-size:120%;font-weight:800;">添加地址</span>
			</div>
			<form class="form-horizontal" role="form" style="margin-top:35px;">
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-3 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						联系人
					</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" id="linkman_add" 
							placeholder="联系人">
					</div>
				</div>
				
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-3 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						联系电话
					</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" id="linkmanPhone_add" 
							placeholder="联系电话">
					</div>
				</div>
				
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-3 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						收货地址
					</label>
					<div class="col-xs-9">
						<textarea class="form-control" rows="3" id="linkmanAddress_add" 
							placeholder="收货地址"></textarea>
					</div>
				</div>
				
				<div class="form-group" style="margin:20px 10px;text-align:center;">
					<div class="col-xs-6">
						<button type="button" class="btn btn-danger" style="width:80%;" 
							onclick="javascript:closeAddNewAddressDiv();">取消</button>
					</div>
					<div class="col-xs-6">
						<button type="button" class="btn btn-info" style="width:80%;" 
							onclick="javascript:submitAddNewAddress();">确认</button>
					</div>
				</div>
			</form>
		</div>
		<!--添加新地址-->
		
		<!--内容-->
    </div> <!-- /container -->

    <footer>
      <div class="container">
        <div class="navbar-fixed-bottom" style="background-color:#FFFFFF;padding:5px 0px 0px 0px;margin-bottom:-3px;">
			
			<div class="row" style="margin:0px auto;">
				<div class="btn-group" role="group" style="width:100%;margin:0px;padding:0px;">
					<button id="goodsBtn" type="button" class="btn btn-info bottomBtn" style="width:33%;" 
						onclick="javascript:changeBottomBtn(1);">
						商品
					</button>
					<button id="activityBtn" type="button" class="btn btn-primary bottomBtn" style="width:34%;" 
						onclick="javascript:changeBottomBtn(2);">
						活动
					</button>
					<button id="accountBtn" type="button" class="btn btn-primary bottomBtn" style="width:33%;" 
						onclick="javascript:changeBottomBtn(3);">
						账户
					</button>
				</div>
			</div>
        </div>
      </div>
    </footer>

    <script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
    <script src="js/application.js"></script>
	<script src="js/subString.js"></script>
	<script src="js/page.js"></script>
	
	<script type="text/javascript">
	
	var goodsIds = <%=goodsIds%>;//选中的商品
	var goodsNums = <%=goodsNums%>;//商品对应的数量
	var totalPrice = <%=totalPrice%>;//选中的商品的总价格
	
	$(document).ready(function () {
		//加载菜单数据
		initMenu();
		
		//获取默认收货人信息
		getLinkPersonInfo();
		
		//加载更多的收货人信息
		getMoreLinkPersonList();
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
					
					for(var i=0;i<firstMenuDataList.length;i++){
						var firstMenuData = firstMenuDataList[i];
						
						var goodsCatalogId = firstMenuData[0];
						var parentCatalogId = firstMenuData[1];
						var goodsCatalogName = firstMenuData[2];
						var goodsCatalogStatus = firstMenuData[3];
						
						var li = document.createElement("li");
						$(li).attr("id","firstMenu_"+goodsCatalogId)
							.attr("onclick","javascript:changeTopBtn("+i+");");
						var a = document.createElement("a");
						$(a).attr("href","javascript:void(0);").text(goodsCatalogName).appendTo(li);
						
						$("#firstMenuUl").append(li);
					}
					//购物车li
					var li = document.createElement("li");
					$(li).attr("id","shoppingCartBtn").addClass("active")
						.attr("onclick","javascript:changeTopBtn(3);");
					var a = document.createElement("a");
					$(a).attr("href","javascript:void(0);").text("购物车").appendTo(li);
					
					$("#firstMenuUl").append(li);
					
				}else{
					alert("系统错误，请稍后重试！");
				}
			}
		});
	}
	
	//获取默认联系人信息
	function getLinkPersonInfo(){
		$.ajax({
			type : "post",
			url : "deliveryAddress_getDefaultLinkPersonInfoByCustomerId.html",
			dataType : "json",
			aysnc : false,
			success : function(data){
				var dataMap = data.dataMap;
				if(dataMap != null){
					$("#linkman").val(dataMap.consigneeName);
					$("#linkmanPhone").val(dataMap.consigneePhone);
					$("#linkmanAddress").val(dataMap.consigneeAddress);
				}
			}
		});
	}
	
	//获取更多联系人信息
	function getMoreLinkPersonList(){
		$.ajax({
			type : "post",
			url : "deliveryAddress_getLinkPersonInfoListByCustomerId.html",
			dataType : "json",
			aysnc : false,
			success : function(data){
				$("#moreAddressUl").empty();
				
				var dataList = data.dataList;
				if(dataList.length != 0){
					for(var i=0;i<dataList.length;i++){
						var dataMap = dataList[i];
						var li = document.createElement("li");
						$(li).addClass("list-group-item")
							.attr("onclick","javascript:choiceAddress("+dataMap.deliveryAddressId+");")
							.attr("id","addressId_"+dataMap.deliveryAddressId);
						
						var nameDiv = document.createElement("div");
						$(nameDiv).addClass("row").appendTo(li);
						var nameSpan = document.createElement("span");
						$(nameSpan).text(dataMap.consigneeName)
							.attr("id","nameSpan_"+dataMap.deliveryAddressId)
							.appendTo(nameDiv);
						
						var phoneDiv = document.createElement("div");
						$(phoneDiv).addClass("row").appendTo(li);
						var phoneSpan = document.createElement("span");
						$(phoneSpan).text(dataMap.consigneePhone)
							.attr("id","phoneSpan_"+dataMap.deliveryAddressId)
							.appendTo(phoneDiv);
						
						var addressDiv = document.createElement("div");
						$(addressDiv).addClass("row").appendTo(li);
						var addressSpan = document.createElement("span");
						$(addressSpan).text(dataMap.consigneeAddress)
							.attr("id","addressSpan_"+dataMap.deliveryAddressId)
							.appendTo(addressDiv);
						
						$("#moreAddressUl").append(li);
					}
				}
			}
		});
	}
	
	//更多地址选择操作
	function choiceAddress(deliveryAddressId){
		$("#linkman").val($("#nameSpan_"+deliveryAddressId).text());
		$("#linkmanPhone").val($("#phoneSpan_"+deliveryAddressId).text());
		$("#linkmanAddress").val($("#addressSpan_"+deliveryAddressId).text());
	}
	
	//点击顶部按钮
	function changeTopBtn(type){
		//根据type判断跳转页面
		if(type == 0){
			//出行类商品
			window.location.href="page_pageJump.html?pageName=travelGoodsList";
		}else if(type == 1){
			//实体类商品
			window.location.href="page_pageJump.html?pageName=goodsList";
		}else if(type == 2){
			//服务类商品
			window.location.href="page_pageJump.html?pageName=serviceGoodsList";
		}else if(type == 3){
			//购物车
			window.location.href="page_pageJump.html?pageName=shoppingCart";
		}
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
	
	//点击显示更多地址按钮
	function openMoreAddress(){
		
		if($("#openMoreAddressBtn").text() == "更多地址"){
			$("#openMoreAddressBtn").text("收起地址");
			$("#moreAddressDiv").removeAttr("style");
			$("#moreAddressDiv").attr("style","display:block;font-size:80%;")
		}else{
			$("#openMoreAddressBtn").text("更多地址");
			$("#moreAddressDiv").removeAttr("style");
			$("#moreAddressDiv").attr("style","display:none;font-size:80%;")
		}
		//关闭添加地址
		closeAddNewAddressDiv();
	}
	
	//点击添加地址按钮
	function openAddNewAddress(){
		$("#addNewAddressDiv").removeAttr("style");
		$("#addNewAddressDiv").attr("style","display:block;");
		
		//关闭更多地址
		$("#openMoreAddressBtn").text("更多地址");
		$("#moreAddressDiv").removeAttr("style");
		$("#moreAddressDiv").attr("style","display:none;font-size:80%;")
	}
	//点击添加地址取消按钮
	function closeAddNewAddressDiv(){
		
		$("#linkman_add").val("");
		$("#linkmanPhone_add").val("");
		$("#linkmanAddress_add").val("");
		
		$("#addNewAddressDiv").removeAttr("style");
		$("#addNewAddressDiv").attr("style","display:none;");
	}
	
	//点击添加地址确认按钮
	function submitAddNewAddress(){
		$.ajax({
			type : "post",
			url : "deliveryAddress_addLinkPersonInfo.html",
			dataType : "json",
			aysnc : false,
			data : {
				consigneeName : $("#linkman_add").val(),
				consigneePhone : $("#linkmanPhone_add").val(),
				consigneeAddress : $("#linkmanAddress_add").val()
			},
			success : function(data){
				alert(data.msg);
				//将新添加的地址写在默认框中
				if(data.success){
					$("#linkman").val($("#linkman_add").val());
					$("#linkmanPhone").val($("#linkmanPhone_add").val());
					$("#linkmanAddress").val($("#linkmanAddress_add").val());
					
					closeAddNewAddressDiv();
				}
				
			}
		});
	}
	
	//确认提交订单
	function submitOrder(){
		var linkman = $("#linkman").val();
		var linkmanPhone = $("#linkmanPhone").val();
		var linkmanAddress = $("#linkmanAddress").val();
		
		$.ajax({
			type : "post",
			url : "order_markTheOrder.html",
			dataType : "json",
			aysnc : false,
			data : {
				linkman : linkman,
				linkmanPhone : linkmanPhone,
				linkmanAddress : linkmanAddress,
				goodsIds : goodsIds,
				goodsNums : goodsNums,
				totalPrice : totalPrice
			},
			success : function(data){
				//将新添加的地址写在默认框中
				if(data.success){
					var orderBatchCode = data.orderBatchCode;
					
					window.location.href="page_pageJump.html?pageName=goodsOrder&orderBatchCode="
							+orderBatchCode+"&totalPrice="+totalPrice;
					
				}
				
			}
		});
		
	}
	</script>
  </body>
</html>
