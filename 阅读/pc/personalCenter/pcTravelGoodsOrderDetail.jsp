<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  <% 
	String orderBatchId = request.getParameter("orderBatchId");
%>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    <meta charset="utf-8">
    <title>行伙伴-我的订单</title>
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
	td{
		line-height:50px;
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
                <li><a href="<%=basePath %>page_pageJump.html?pageName=preferential" title="优惠专享">优惠专享</a></li>
                <li class="active"><a href="<%=basePath %>page_pageJump.html?pageName=personalCenter" title="个人中心">个人中心</a></li>
              
            </ul>
        </nav>
        
        
        <div id="top" class="top">
        	<img style="margin: 5px;width: 80%;" alt="" src="images/top.png">
        </div>
        

        <div class="header-panel cf">
<!--            <form method="get" class="header-panel-search fl">-->
<!--                <input type="text" class="field br-2" placeholder="搜索内容">-->
<!--                <button type="submit" class="submit ht" title="搜索">搜索</button>-->
<!--            </form>-->
                            <nav class="header-panel-nav fr">
                    <ul>
					  <li class="register">
					  	<a href="/index/login" style="margin-right: 20px;color: #F1707D;" >购物车</a></li>
                      <li class="register">
                        <a href="/index/login">登录</a></li>

                    </ul>
                </nav>
                    </div>
    </header>
     <!--标题-->
    <div class="container" style="margin-top:10px;margin-bottom:40px;">
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
     
     <div class="container ppt-12">
     	
     	<!--商品列表-->
		<div class="row" style="margin-top:10px;background-color: #fff;border-radius: 5px;margin-left: 0px;">
			<div class="col-xs-12">
				<div class="row" >
					<div class="col-xs-12" style="">
					
<span style="font-size: 140%;" id="orderBatchCodeShow">D144973001343872757</span>
  	
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;" id="linkmanShow">收货人：木木</span>
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;" id="orderBatchStatusShow">已支付</span>
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;" id="totalMoneyShow">总金额：850.0元</span>
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;" id="orderTimeShow">2015-12-10 14:46:53</span>
					</div>
				</div>
				
				<div id="orderListShowDiv" class="row" style="margin: 10px;">
					
				</div>
					<!--商品信息-->
					
					<div class="kefu col-xs-6" style="margin: 5px 0px; display: none;">
						<button type="button" class="btn btn-link" style="padding:5px 10px;">联系客服</button>
					</div>
					
					<div class="tuihuo col-xs-6" style="margin: 5px 0px; display: none;">
						<button type="button" id="tuikuanBtn" class="btn" style="margin:0px auto;padding:5px 10px;">退款</button>
					</div>
					
					<div class="col-xs-12">
						<div class="col-xs-12"> 
							<span style="font-size:120%;font-weight:800;">订单信息</span>
						</div>
						<form class="form-horizontal" role="form">
							<div class="form-group" style="margin:5px 10px;">
								<label for="linkman" class="col-xs-3 control-label" style="padding:5px 0px 0px 0px;text-align:center;">
									联系人
								</label>
								<div class="col-xs-9">
									<input type="text" class="form-control" id="linkman" placeholder="联系人" readonly="" style="border-color:#bdc3c7;color:#34495e;opacity:1;">
								</div>
							</div>
							<div class="form-group" style="margin:5px 10px;">
								<label for="linkmanPhone" class="col-xs-3 control-label" style="padding:5px 0px 0px 0px;text-align:center;">
									联系电话
								</label>
								<div class="col-xs-9">
									<input type="text" class="form-control" id="linkmanPhone" placeholder="联系电话" readonly="" style="border-color:#bdc3c7;color:#34495e;opacity:1;">
								</div>
							</div>
							<div class="form-group" style="margin:5px 10px;">
								<label for="tripTime" class="col-xs-3 control-label" style="padding:5px 0px 0px 0px;text-align:center;">
									出行时间
								</label>
								<div class="col-xs-9">
									<input type="text" class="form-control" id="tripTime" placeholder="出行时间" readonly="" style="border-color:#bdc3c7;color:#34495e;opacity:1;">
								</div>
							</div>
							<div class="form-group" style="margin:5px 10px;">
								<label for="fromAddress" class="col-xs-3 control-label" style="padding:5px 0px 0px 0px;text-align:center;">
									出发地
								</label>
								<div class="col-xs-9">
									<input type="text" class="form-control" id="fromAddress" placeholder="出发地" readonly="" style="border-color:#bdc3c7;color:#34495e;opacity:1;">
								</div>
							</div>
							<div class="form-group" style="margin:5px 10px;">
								<label for="toAddress" class="col-xs-3 control-label" style="padding:5px 0px 0px 0px;text-align:center;">
									目的地
								</label>
								<div class="col-xs-9">
									<input type="text" class="form-control" id="toAddress" placeholder="目的地" readonly="" style="border-color:#bdc3c7;color:#34495e;opacity:1;">
								</div>
							</div>
						</form>
					</div>
				</div>
		</div> 
		
		<!--订单未支付的时候显示-->
		<div class="row" id="zhifuDiv" style="margin-bottom:50px;">
			
		</div>
		<!--订单未支付的时候显示-->
	</div>
	<div  style="margin-bottom:10px;text-align: center;">
	       © 2015-2015 XingHuoBan.com 版权所有
       </div>
 

	<script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
    <script src="js/application.js"></script>
	<script src="js/subString.js"></script>
	

<script type="text/javascript">
	var orderBatchId = <%=orderBatchId%>;//批次id
	$(document).ready(function () {
		//获取订单详情
		getOrderBatchDetail(orderBatchId);
	});
	
	//获取订单详情
	function getOrderBatchDetail(orderBatchId){
		$.ajax({
			type : "post",
			url : "order_getOrderBatchDetailAndOrderListByOrderBatchId.html",
			dataType : "json",
			data:{
				"orderBatchId" : orderBatchId
			},
			aysnc : false,
			success : function(data){
				//订单批次信息显示
				var orderBatchMap = data.orderBatchMap;
				$("#orderBatchCodeShow").text(orderBatchMap.orderBatchCode);
				var orderBatchStatus = orderBatchMap.orderBatchStatus;
				var orderBatchStatusStr = "";
				if(orderBatchStatus == "0"){
					orderBatchStatusStr = "未支付";
					
					$("#zhifuDiv").empty();
					var cancleBtnDiv = document.createElement("div");
					$(cancleBtnDiv).addClass("col-xs-6").attr("style","text-align:center;margin-top:10px;");
					var cancleBtn = document.createElement("button");
					$(cancleBtn).addClass("btn btn-lg btn-block")
						.attr("type","button").text("取消")
						.attr("onclick","javascript:cancleOrderBatch("+orderBatchMap.orderBatchId+");")
						.appendTo(cancleBtnDiv);
					
					var zhifuBtnDiv = document.createElement("div");
					$(zhifuBtnDiv).addClass("col-xs-6").attr("style","text-align:center;margin-top:10px;");
					var zhifuBtn = document.createElement("button");
					$(zhifuBtn).addClass("btn btn-info btn-lg btn-block")
						.attr("type","button").text("结算")
						.attr("onclick","javascript:zhifuOrderBatch('"+orderBatchMap.orderBatchId+"','"+orderBatchMap.orderBatchCode+"','"+data.totalMoney+"');")
						.appendTo(zhifuBtnDiv);
					
					$("#zhifuDiv").append(cancleBtnDiv);
					$("#zhifuDiv").append(zhifuBtnDiv);
				}else if(orderBatchStatus == "1"){
					orderBatchStatusStr = "已支付";
					$("#zhifuDiv").empty();
				}else if(orderBatchStatus == "2"){
					orderBatchStatusStr = "已取消";
					$("#zhifuDiv").empty();
				}
				
				$("#orderBatchStatusShow").text(orderBatchStatusStr);
				$("#totalMoneyShow").text("总金额：" + data.totalMoney + "元");
				$("#orderTimeShow").text(orderBatchMap.orderTime);
				
				//订单列表显示
				$("#orderListShowDiv").empty();
				var orderList = data.orderList;
				for(var i=0;i<orderList.length;i++){
					var orderData = orderList[i];
					
					$("#linkmanShow").text("收货人："+orderData.linkman);
					
					$("#linkman").val(orderData.linkman);
					$("#linkmanPhone").val(orderData.linkmanPhone);
					$("#tripTime").val(orderData.tripTime);
					$("#fromAddress").val(orderData.fromAddress);
					$("#toAddress").val(orderData.toAddress);
					var orderCode = orderData.orderCode;
					var item = ' <div class="col-xs-12">';
					item += ' <span style="font-size: 60%;  " id="orderCodeShow">订单号：'+orderCode+'</span></div>';
					item += ' <div class="col-xs-12">';
					item += ' <div class="row" id="goodsId_1" style="border-bottom:1px solid #999999;" onclick="javascript:jumpToGoodsDetail(this);">';
					item += ' <div class="col-xs-5" style="padding:5px;">';
					item += ' <img id="goodsImg" style="width:80px;height:80px;" src="'+orderData.imagePath+'"></div>';
					item += ' <div class="col-xs-7"><div class="row">';
					item += ' <span style="font-size:80%;" id="goodsName">'+orderData.goodsName+'</span></div>';
					item += ' <div class="row">';
					item += ' <p style="font-size:8px;color:#666666;margin:3px 0px;" id="goodsIntroduce">'+orderData.goodsIntroduce+'</p></div>';
					item += ' <div class="row">';
					item += ' <span style="font-size:8px;color:#FA0B0B;" id="goodsPrice">￥'+orderData.goodsPrice+orderData.chargeUnit+'</span></div>';
					item += ' </div></div></div>';
					
					$(item).appendTo($("#orderListShowDiv"));
					
					
					
						
					
					var orderStatus = data.orderStatus;
					if(orderStatus == "1"){
						//订单已支付，显示售后按钮
						//客服按钮
						$(".kefu").show();
						//退货按钮
						$(".tuihuo").show();
						
						$("#tuikuanBtn").attr("onclick","javascript:openTuikuanApply("+orderData.orderId+")");
					}else{
						//客服按钮
						$(".kefu").hide();
						//退货按钮
						$(".tuihuo").hide();
					}
				}
				
				
				
				

			}
		});
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
	
	//跳转到商品详情页面
	function jumpToDetail(goodsId){
		window.location.href="page_pageJump.html?pageName=travelGoodsDetail&goodsId="+goodsId;
	}
	
	//取消出行订单
	function cancleOrderBatch(orderBatchId){
		$.ajax({
			type : "post",
			url : "order_cancleOrderAndOrderBatch.html",
			dataType : "json",
			data:{
				"orderBatchId" : orderBatchId
			},
			aysnc : false,
			success : function(data){
				getOrderBatchDetail(orderBatchId);
			}
		});
	}
	
	//支付出行订单
	function zhifuOrderBatch(orderBatchId, orderBatchCode, totalMoney){
		window.location.href="page_pageJump.html?pageName=pcGoodsOrder&orderBatchId="+orderBatchId
			+"&orderBatchCode="+orderBatchCode
			+"&totalPrice="+totalMoney;
	}
	
	//打开退货申请窗口
	function openTuikuanApply(orderId){
		$("#orderIdHide").val(orderId);
		
		$("#myModal").removeClass('hide');
		$("#myModal").modal('show');
	}
	
	//提交退款申请
	function submitTuikuanApply(){
		var orderId = $("#orderIdHide").val();
		var reason = $("#cancleReason").val();
		
		$.ajax({
			type : "post",
			url : "orderCancel_submitOrderCancleApply.html",
			dataType : "json",
			data:{
				"orderCancel.orderId" : orderId,
				"orderCancel.orderCancelType" : "0",
				"orderCancel.reason" : reason,
				"order.goodsType" : 2
			},
			aysnc : false,
			success : function(data){
				alert(data.msg);
				//获取订单详情
				getOrderBatchDetail(orderBatchId);
			}
		});
	}
	
	</script>
</body>
</html>
