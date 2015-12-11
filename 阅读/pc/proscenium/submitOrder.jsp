<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String goodsIds = request.getParameter("goodsIds"); 
	String goodsNums = request.getParameter("goodsNums"); 
	String totalPrice = request.getParameter("totalPrice"); 
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		%>
  
    <meta charset="utf-8">
    <title>行伙伴-购物车</title>
    <meta name="description" content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version."/>

    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0">
	
    <link href="css/bootstrap.min.css" rel="stylesheet">
	
    <link href="css/flat-ui.min.css" rel="stylesheet">
    <link href="css/ehco.css" rel="stylesheet">
   <style type="text/css">
 	.carousel-indicators .active{
  margin-right:18px;
  border:0px;
  }
	.carousel-indicators li{
	border:0px;
	}
.header-logo {
  background-image: url(<%=basePath %>images/pc/echo_logo.png);
  background-repeat: no-repeat;
}
    </style>
  </head>
  <body style="background-color:#ebebeb;">
       <!--标题-->
       <header id="global-header" class="global-header">
        <div class="header-logo ht">echo</div>

        <nav class="header-nav">
            <ul class="cf" style="z-index:999">
<!--                <li class="active"><a href="/index/home" title="动态">动态</a></li>-->
                <li><a href="<%=basePath %>page_pageJump.html?pageName=travel" title="出行">出行</a></li>
                <li><a href="<%=basePath %>page_pageJump.html?pageName=preferential#" title="优惠专享">优惠专享</a></li>
                <li class="active"><a href="<%=basePath %>page_pageJump.html?pageName=personalCenter"  title="个人中心">个人中心</a></li>
              
            </ul>
        </nav>
        <div class="sub-nav" style="position:fixed;">
        	<nav >
	             <ul id="sub-nav" class="cf" style="z-index:999">
	                <li >
	                	<a href="<%=basePath %>page_pageJump.html?pageName=personalCenter" title="我的账户">我的账户</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=pcCustomerInfoDetail" title="我的信息">我的信息</a></li>
					<li class="active">
						<a href="<%=basePath %>page_pageJump.html?pageName=pcShoppingCart" title="我的购物车">我的购物车</a></li>
					<li >
						<a href="<%=basePath %>page_pageJump.html?pageName=pcOrderList" title="我的订单">我的订单</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=pcCardBag" title="我的卡包">我的卡包</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=complaintAdvice" title="投诉与建议">投诉与建议</a></li>
					
		              
		        </ul>
	        </nav>
        </div>
      

        <div class="header-panel cf">
<!--            <form method="get" class="header-panel-search fl">-->
<!--                <input type="text" class="field br-2" placeholder="搜索内容">-->
<!--                <button type="submit" class="submit ht" title="搜索">搜索</button>-->
<!--            </form>-->
                            <nav class="header-panel-nav fr">
                    <ul>
					  <li class="register">
					  	<a href="<%=basePath %>page_pageJump.html?pageName=pcShoppingCart" style="margin-right: 20px;color: #F1707D;" >购物车</a></li>
                      <li class="register">
                        <a href="/index/login">登录</a></li>

                    </ul>
                </nav>
                    </div>
    </header>
     <!--标题-->
    <div class="container" style="margin-bottom:40px;margin-top: 10px;" align="center">
		<!--轮播图-->
    

	
	<div id="carousel-ad" class="carousel slide" data-ride="carousel">
	    <ol class="carousel-indicators">
	      <li data-target="#carousel-ad" data-slide-to="0" class="active"></li>
	      <li data-target="#carousel-ad" data-slide-to="1"></li>
	    </ol>
	    <div class="carousel-inner" role="listbox">
	      <div class="item active"><img class="img-responsive" src="http://echo-image.qiniucdn.com/Fs11cPZT0sTr5JVhS31k9X_hRnac"></div>
	      <div class="item"><img class="img-responsive" src="http://echo-image.qiniucdn.com/Ftv5BZ20zlTQ1YSPCbf0dpEegZza"></div>
	    </div>
	 </div>
	
     <!--轮播图-->
		
		<!--内容-->
		<div class="row" style="width: 100%;background-color: white;padding-top: 20px;  margin-top: 10px;">
			<div class="col-xs-12" style="=padding-top: 20px;"> 
				<span style="font-size:120%;font-weight:800;">确认收货地址</span>
			</div>
			<form class="form-horizontal" role="form" style="padding-top:30px;">
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-2 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						联系人
					</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" style="color:#666666;" id="linkman" 
							placeholder="联系人" readonly>
					</div>
				</div>
				
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-2 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						联系电话
					</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" style="color:#666666;" id="linkmanPhone" 
							placeholder="联系电话" readonly>
					</div>
				</div>
				
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-2 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						收货地址
					</label>
					<div class="col-xs-10">
						<textarea class="form-control" style="color:#666666;" rows="3" 
							id="linkmanAddress" placeholder="收货地址" readonly></textarea>
					</div>
				</div>
				
				<div class="form-group" style="margin:20px 10px;text-align:center;">
					<button type="button" id="submitOrderBtn" class="btn btn-info btn-lg" style="width:15%;" 
						onclick="javascript:submitOrder();">提交订单</button>
				</div>
			</form>
		</div>
		
		<div class="row" style="width: 100%;background-color: white;">
			<button type="button" class="btn btn-link" id="openMoreAddressBtn" style="width:50%;float:left;" 
				onclick="javascript:openMoreAddress();">更多地址</button>
			<button type="button" class="btn btn-link" id="openAddAddressBtn" style="width:50%;float:left;" 
				onclick="javascript:openAddNewAddress();">添加地址</button>
		</div>
		
		<!--更多地址-->
		<div class="row" id="moreAddressDiv" style="display:none;font-size:80%;  width: 100%;background-color:#fff;">
			<hr style="border:1px solid #999999;margin:3px 0px;height:1px;background-color:#999999;">
			<ul class="list-group" id="moreAddressUl">
				
			</ul>
		</div>
		<!--更多地址-->
		
		<!--添加新地址-->
		<div class="row" id="addNewAddressDiv" style="display:none;width: 100%;background-color: white;">
			<hr style="border:1px solid #999999;margin:3px 0px;height:1px;background-color:#999999;"/>
			
			<div class="col-xs-12"> 
				<span style="font-size:120%;font-weight:800;">添加地址</span>
			</div>
			<form class="form-horizontal" role="form" style="margin-top:35px;">
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-2 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						联系人
					</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" id="linkman_add" 
							placeholder="联系人">
					</div>
				</div>
				
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-2 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						联系电话
					</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" id="linkmanPhone_add" 
							placeholder="联系电话">
					</div>
				</div>
				
				<div class="form-group" style="margin:5px 10px;">
					<label for="inputEmail1" class="col-xs-2 control-label" 
						style="padding:5px 0px 0px 0px;text-align:center;">
						收货地址
					</label>
					<div class="col-xs-10">
						<textarea class="form-control" rows="3" id="linkmanAddress_add" 
							placeholder="收货地址"></textarea>
					</div>
				</div>
				
				<div class="form-group" style="margin:20px 10px;text-align:center;">
					<div class="col-xs-6">
						<button type="button" class="btn btn-danger" style="width:15%;" 
							onclick="javascript:closeAddNewAddressDiv();">取消</button>
					</div>
					<div class="col-xs-6">
						<button type="button" class="btn btn-info" style="width:15%;" 
							onclick="javascript:submitAddNewAddress();">确认</button>
					</div>
				</div>
			</form>
		</div>
		<!--添加新地址-->
		
		<!--内容-->
    </div> <!-- /container -->

   

    <script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
    <script src="js/application.js"></script>
	<script src="js/subString.js"></script>
	<script src="js/page.js"></script>
    <!-- 引入导航 TOP以及摇一摇 JS -->
	<script src="js/change_mark.js"></script> 
	<script type="text/javascript">
	
	var goodsIds = "<%=goodsIds%>";//选中的商品
	var goodsNums = "<%=goodsNums%>";//商品对应的数量
	var totalPrice = "<%=totalPrice%>";//选中的商品的总价格
	
	$(document).ready(function () {
		findAllChange();
		//获取默认收货人信息
		getLinkPersonInfo();
		
		//加载更多的收货人信息
		getMoreLinkPersonList();
	});
	
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
						
						var rowDiv = document.createElement("div");
						$(rowDiv).addClass("row").appendTo(li);
						
						var addressDiv = document.createElement("div");
						$(addressDiv).addClass("col-xs-6").appendTo(rowDiv);
						var addressSpan = document.createElement("span");
						$(addressSpan).text(dataMap.consigneeAddress)
							.attr("id","addressSpan_"+dataMap.deliveryAddressId)
							.appendTo(addressDiv);
						
						var nameDiv = document.createElement("div");
						$(nameDiv).addClass("col-xs-2").appendTo(rowDiv);
						var nameSpan = document.createElement("span");
						$(nameSpan).text(dataMap.consigneeName)
							.attr("id","nameSpan_"+dataMap.deliveryAddressId)
							.appendTo(nameDiv);
						
						var phoneDiv = document.createElement("div");
						$(phoneDiv).addClass("col-xs-2").appendTo(rowDiv);
						var phoneSpan = document.createElement("span");
						$(phoneSpan).text(dataMap.consigneePhone)
							.attr("id","phoneSpan_"+dataMap.deliveryAddressId)
							.appendTo(phoneDiv);
						
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
		$("#moreAddressUl li").each(function(){
			$(this).attr("style","background-color: #fff;color:#34495e;");
		})
		
		$("#addressId_"+deliveryAddressId).attr("style","background-color: rgb(46, 231, 70);color:#fff;");
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
			window.location.href="page_pageJump.html?pageName=serviceGoodsList"; //出行类商品
		}else if(type == 2){
			window.location.href="page_pageJump.html?pageName=activityList"; //活动列表
		}else if(type == 3){
			window.location.href="page_pageJump.html?pageName=accountCenter"; //账户中心
		}else if(type == 4){
			window.location.href="page_pageJump.html?pageName=shoppingCart"; //购物车
		}
	}
	
	//点击显示更多地址按钮
	function openMoreAddress(){
		
		if($("#openMoreAddressBtn").text() == "更多地址"){
			$("#openMoreAddressBtn").text("收起地址");
			$("#moreAddressDiv").removeAttr("style");
			$("#moreAddressDiv").attr("style","display:block;font-size:80%;width: 100%;background-color:#fff;")
		}else{
			$("#openMoreAddressBtn").text("更多地址");
			$("#moreAddressDiv").removeAttr("style");
			$("#moreAddressDiv").attr("style","display:none;font-size:80%;width: 100%;background-color:#fff;")
		}
		//关闭添加地址
		closeAddNewAddressDiv();
	}
	
	//点击添加地址按钮
	function openAddNewAddress(){
		$("#addNewAddressDiv").removeAttr("style");
		$("#addNewAddressDiv").attr("style","display:block;width: 100%;background-color: white;");
		
		//关闭更多地址
		$("#openMoreAddressBtn").text("更多地址");
		$("#moreAddressDiv").removeAttr("style");
		$("#moreAddressDiv").attr("style","display:none;font-size:80%;width: 100%;background-color:#fff;")
	}
	//点击添加地址取消按钮
	function closeAddNewAddressDiv(){
		
		$("#linkman_add").val("");
		$("#linkmanPhone_add").val("");
		$("#linkmanAddress_add").val("");
		
		$("#addNewAddressDiv").removeAttr("style");
		$("#addNewAddressDiv").attr("style","display:none;width: 100%;background-color: white;");
	}
	
	//点击添加地址确认按钮
	function submitAddNewAddress(){
		if($("#linkman_add").val() == null || $("#linkman_add").val() == "" || $("#linkman_add").val() == undefined){
			alert("联系人不能为空！");
			return;
		}
		if($("#linkmanPhone_add").val() == null || $("#linkmanPhone_add").val() == "" || $("#linkmanPhone_add").val() == undefined){
			alert("联系人电话不能为空！");
			return;
		}
		if($("#linkmanAddress_add").val() == null || $("#linkmanAddress_add").val() == "" || $("#linkmanAddress_add").val() == undefined){
			alert("收货地址不能为空！");
			return;
		}
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
					getMoreLinkPersonList();
				}
				
			}
		});
	}
	
	var intnumber;
	var myVar;//计时器
	
	//确认提交订单
	function submitOrder(){
		if(address()){
		intnumber = 60;
    	$("#submitOrderBtn").removeClass("btn-info");
		$("#submitOrderBtn").addClass("btn-default");
	    $("#submitOrderBtn").removeAttr("onclick");
	    startTimer();
	    
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
				if(data.success){
					var orderBatchCode = data.orderBatchCode;
					var orderBatchId = data.orderBatchId;
					
					window.location.href="page_pageJump.html?pageName=pcGoodsOrder&orderBatchId="+orderBatchId
							+"&orderBatchCode="+orderBatchCode
							+"&totalPrice="+totalPrice;
					
				}
				
			}
		});
		
	}
		}
	function address(){
		if($("#linkman").val() == null || $("#linkman").val() == "" ){
			alert("联系人不能为空！");
			return false;
		}
		if($("#linkmanPhone").val() == null || $("#linkmanPhone").val() == ""){
			alert("联系人电话不能为空！");
			return false;
		}
		if($("#linkmanAddress").val() == null || $("#linkmanAddress").val() == "" ){
			alert("收货地址不能为空！");
			return false;
		}	
		return true;
	}
	
	function startTimer(){ //计时器代码
	    /*setInterval() 间隔指定的毫秒数不停地执行指定的代码*/
	    myVar=setInterval(function(){
		$("#submitOrderBtn").text("请稍等"+intnumber+"s");
		    console.log(intnumber--);
			if(intnumber <= 0){
				$("#submitOrderBtn").removeClass("btn-default");
				$("#submitOrderBtn").addClass("btn-info");
			    $("#submitOrderBtn").text("提交订单");
			    $("#submitOrderBtn").attr("onclick","javascript:checkNum();");
			    
			    clearInterval(myVar);
			}
		},1000);
	}
	</script>
  </body>
</html>
