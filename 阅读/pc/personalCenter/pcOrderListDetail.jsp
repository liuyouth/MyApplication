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
			<div class="col-xs-12" style="margin-bottom:20px;">
				<div class="row" >
					<div class="col-xs-12" style="margin-bottom:20px;">
						<span style="font-size: 140%;" id="orderBatchCodeShow">
						</span>
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;" id="linkmanShow">
						</span>
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;" id="orderBatchStatusShow">
						</span>
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;" id="totalMoneyShow">
						</span>
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;" id="orderTimeShow">
						</span>
					</div>
				</div>
			</div>
			
			<div class="col-xs-12" id="orderListShowDiv" >
				
			</div>
		</div>
		<!--商品列表-->	
		
		<!--订单未支付的时候显示-->
		<div class="row" id="zhifuDiv">
			
		</div>
		<!--订单未支付的时候显示-->
    </div> <!-- /container -->

    
	<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
    	style="margin-left:10px;margin-right:10px;">
    	<div class="modal-dialog" role="document">
    	<div class="modal-content" style="margin-top:30%;">
		<div class="modal-body" style="background-color:white;">
			<input type="hidden" id="orderIdHide">
			<input type="hidden" id="cancelTypeHide">
			<input type="hidden" id="goodsTypeHide">
			<div class="row">
				<div class="col-xs-12" id="reasonText">
					退货理由：
				</div>
				<div class="col-xs-12">
			      	<textarea id="cancleReason" class="form-control" style="width:100%;min-width:100px;" rows="4"></textarea>
				</div>
			</div>
		</div>
		<div class="modal-footer" style="background-color:white;">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		    <button id="tuihuoBtn" class="btn btn-info" data-dismiss="modal" aria-hidden="true" onclick="javascript:submitTuikuanApply();">退货</button>
	  	</div>
	  	</div>
	  	</div>
	</div>
	
	<div id="detailModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="detailModalLabel" aria-hidden="true"
    	style="margin-left:10px;margin-right:10px;">
    	<div class="modal-dialog" role="document">
    	<div class="modal-content" style="margin-top:30%;">
		<div class="modal-header" style="background-color:white;padding:6px;border-radius:5px 5px 0px 0px;">
			<span id="detailModalLabel" style="font-size:120%;">详情</span>
		</div>
		<div class="modal-body" style="background-color:white;max-height:180px;overflow:auto;" id="electronicGoodsListShow">
			
		</div>
		<div class="modal-footer" style="background-color:white;padding:6px;border-top:1px solid #d7d7d7;border-radius:0px 0px 5px 5px;">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
	  	</div>
	  	</div>
	  	</div>
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
					.attr("type","button").text("取消订单")
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
				
				var rowDiv = document.createElement("div");
				$(rowDiv).addClass("row").attr("style","border-top:1px solid #d7d7d7;");
				
				var codeDiv = document.createElement("div");
				$(codeDiv).addClass("col-xs-12").appendTo(rowDiv);
				var codeSpan = document.createElement("span");
				$(codeSpan).attr("style","font-size:60%;width:80%;")
					.appendTo(codeDiv);
				var orderCode = orderData.orderCode;
				var codeLength = orderCode.strLen();
				if(codeLength > 28){
					orderCode = orderCode.subCHString(0, 26);
					$(codeSpan).text("订单号：" + orderCode+"...");
				}else{
					$(codeSpan).text("订单号：" + orderCode);
				}
				
				var goodsDataDivA = document.createElement("div");
				$(goodsDataDivA).addClass("col-xs-12").appendTo(rowDiv);
				var goodsDataDivB = document.createElement("div");
				$(goodsDataDivB).addClass("row").attr("id","goodsId_"+orderData.orderId)
					.attr("onclick","javascript:jumpToGoodsDetail(this);").appendTo(goodsDataDivA);
				var imgDiv = document.createElement("div");
				$(imgDiv).addClass("col-xs-5").attr("style","padding:5px;").appendTo(goodsDataDivB);
				var img = document.createElement("img");
				$(img).attr("src",orderData.imagePath).attr("style","width:110px;height:80px;").appendTo(imgDiv);
				var dataDiv = document.createElement("div");
				$(dataDiv).addClass("col-xs-7").appendTo(goodsDataDivB);
				var goodsNameDiv = document.createElement("div");
				$(goodsNameDiv).addClass("row").appendTo(dataDiv);
				var goodsNameSpan = document.createElement("span");
				$(goodsNameSpan).attr("style","font-size:80%;")
					.text(orderData.goodsName).appendTo(goodsNameDiv);
				
				var goodsIntroduceDiv = document.createElement("div");
				$(goodsIntroduceDiv).addClass("row").appendTo(dataDiv);
				var goodsIntroduceSpan = document.createElement("span");
				$(goodsIntroduceSpan).attr("style","font-size:80%;")
					.appendTo(goodsIntroduceDiv);
				/*var goodsIntroduce = orderData.goodsIntroduce;
				var length = goodsIntroduce.strLen();
				
				if(length > 20){
					goodsIntroduce = goodsIntroduce.subCHString(0, 18);
					$(goodsIntroduceSpan).text(goodsIntroduce+"...");
				}else{
					$(goodsIntroduceSpan).text(goodsIntroduce);
				}*/
				$(goodsIntroduceSpan).text("商品数量："+orderData.orderNumber);
				
				var goodsPriceDiv = document.createElement("div");
				$(goodsPriceDiv).addClass("row").appendTo(dataDiv);
				var goodsPriceSpan = document.createElement("span");
				$(goodsPriceSpan).attr("style","display:block;width:50%;text-align:left;float:left;font-size:8px;color:#FA0B0B;")
					.text("￥" + orderData.goodsPrice + orderData.chargeUnit).appendTo(goodsPriceDiv);
				
				var orderStatus = orderData.orderStatus;
				var orderStatusStr = "";
				var orderStatusSpan = document.createElement("span");
				$(orderStatusSpan).attr("style","display:block;width:48%;text-align:right;float:left;font-size:8px;color:#FA0B0B;")
					.appendTo(goodsPriceDiv);
				if(orderStatus == "0"){
					$(orderStatusSpan).text("未支付");
				}else if(orderStatus == "1"){
					$(orderStatusSpan).text("已支付");
					//订单已支付，显示售后按钮
					var goodsType = orderData.goodsType;
					//退货按钮
					/*var tuihuoDiv = document.createElement("div");
					$(tuihuoDiv).addClass("col-xs-6").attr("style","margin:5px 0px;text-align:center;").appendTo(rowDiv);
					if(goodsType == "0"){
						//实物商品显示退货按钮
						var tuihuoBtn = document.createElement("button");
						$(tuihuoBtn).addClass("btn").attr("type","button")
							.attr("style","margin:0px auto;padding:5px 10px;")
							.attr("onclick","javascript:openTuikuanApply("+orderData.orderId+",1,"+goodsType+")")
							.text("退货").appendTo(tuihuoDiv);
					}else{
						//服务商品显示退款按钮
						var tuihuoBtn = document.createElement("button");
						$(tuihuoBtn).addClass("btn").attr("type","button")
							.attr("style","margin:0px auto;padding:5px 10px;")
							.attr("onclick","javascript:openTuikuanApply("+orderData.orderId+",0,"+goodsType+")")
							.text("退款").appendTo(tuihuoDiv);
					}*/
					
					
					//确认收货按钮
					if(goodsType == "0"){
						//得是实物商品
						var querenDiv = document.createElement("div");
						$(querenDiv).addClass("col-xs-12").attr("style","margin:5px 0px;text-align:right;").appendTo(rowDiv);
						var querenBtn = document.createElement("button");
						$(querenBtn).addClass("btn btn-info").attr("type","button")
							.attr("style","padding:5px 10px;")
							.attr("onclick","javascript:confirmOrder("+orderData.orderId+");")
							.text("确认收货").appendTo(querenDiv);
					}else if(goodsType == "1"){
						//电子服务类商品
						var tuihuoDiv = document.createElement("div");
						$(tuihuoDiv).addClass("col-xs-6").attr("style","margin:5px 0px;text-align:right;").appendTo(rowDiv);
						var tuihuoBtn = document.createElement("button");
						$(tuihuoBtn).addClass("btn").attr("type","button")
							.attr("style","margin:0px auto;padding:5px 10px;")
							.attr("onclick","javascript:openTuikuanApply("+orderData.orderId+",0,"+goodsType+")")
							.text("退款").appendTo(tuihuoDiv);
						
						var queryDiv = document.createElement("div");
						$(queryDiv).addClass("col-xs-6").attr("style","margin:5px 0px;text-align:right;").appendTo(rowDiv);
						var queryBtn = document.createElement("button");
						$(queryBtn).addClass("btn btn-info").attr("type","button")
							.attr("style","padding:5px 10px;")
							.attr("onclick","javascript:queryElectronicGoods("+orderData.orderId+");")
							.text("查看电子卷").appendTo(queryDiv);
						
					}
				}else if(orderStatus == "2"){
					$(orderStatusSpan).text("取消订单");
				}else if(orderStatus == "3"){
					$(orderStatusSpan).text("退单中");
				}else if(orderStatus == "4"){
					$(orderStatusSpan).text("退单完成");
				}else if(orderStatus == "5"){
					
					//退货按钮
					var tuihuoDiv = document.createElement("div");
					$(tuihuoDiv).addClass("col-xs-12").attr("style","margin:5px 0px;text-align:right;").appendTo(rowDiv);
					var goodsType = orderData.goodsType;
					if(goodsType == "0"){
						//实物商品显示退货按钮
						var tuihuoBtn = document.createElement("button");
						$(tuihuoBtn).addClass("btn").attr("type","button")
							.attr("style","margin:0px auto;padding:5px 10px;")
							.attr("onclick","javascript:openTuikuanApply("+orderData.orderId+",1,"+goodsType+")")
							.text("退货").appendTo(tuihuoDiv);
					}else{
						//服务商品显示退款按钮
						var tuihuoBtn = document.createElement("button");
						$(tuihuoBtn).addClass("btn").attr("type","button")
							.attr("style","margin:0px auto;padding:5px 10px;")
							.attr("onclick","javascript:openTuikuanApply("+orderData.orderId+",0,"+goodsType+")")
							.text("退款").appendTo(tuihuoDiv);
					}
					
					$(orderStatusSpan).text("确认收货");
				}
				
				$("#orderListShowDiv").append(rowDiv);
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

//取消订单批次
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

//结算订单批次
function zhifuOrderBatch(orderBatchId,orderBatchCode,totalPrice){
	window.location.href="page_pageJump.html?pageName=pcGoodsOrder&orderBatchId="+orderBatchId
			+"&orderBatchCode="+orderBatchCode
			+"&totalPrice="+totalPrice;
}

//点击确认收货按钮
function confirmOrder(orderId){
	$.ajax({
		type : "post",
		url : "order_confirmOrder.html",
		dataType : "json",
		data:{
			"orderId" : orderId
		},
		aysnc : false,
		success : function(data){
			alert("确认成功！");
			getOrderBatchDetail(orderBatchId);
		}
	});
}

//打开退货申请窗口
function openTuikuanApply(orderId, cancelType, goodsType){
	$("#orderIdHide").val(orderId);
	$("#cancelTypeHide").val(cancelType);
	$("#goodsTypeHide").val(goodsType);
	
	if(cancelType == 0 || cancelType == "0"){
		$("#reasonText").text("退款理由：");
		$("#tuihuoBtn").text("退款");
	}else{
		$("#reasonText").text("退货理由：");
		$("#tuihuoBtn").text("退货");
	}
	$("#myModal").removeClass('hide');
	$("#myModal").modal('show');
}

//提交退款申请
function submitTuikuanApply(){
	var orderId = $("#orderIdHide").val();
	var cancelType = $("#cancelTypeHide").val();
	var reason = $("#cancleReason").val();
	var goodsType = $("#goodsTypeHide").val();
	if(reason == "" || reason == null || reason == undefined){
		alert("退单理由不能为空！");
		return;
	}
	
	$.ajax({
		type : "post",
		url : "orderCancel_submitOrderCancleApply.html",
		dataType : "json",
		data:{
			"orderCancel.orderId" : orderId,
			"orderCancel.orderCancelType" : cancelType,
			"orderCancel.reason" : reason,
			"order.goodsType" : goodsType
		},
		aysnc : false,
		success : function(data){
			alert(data.msg);
			//获取订单详情
			getOrderBatchDetail(orderBatchId);
			
		}
	});
}

//查询电子订单详情
function queryElectronicGoods(orderId){
	$.ajax({
		type : "post",
		url : "electronicGoods_getElectronicGoodsListByOrderId.html",
		dataType : "json",
		data:{
			"electronicGoods.orderId" : orderId
		},
		aysnc : false,
		success : function(data){
			$("#electronicGoodsListShow").empty();
			$("#detailModal").removeClass('hide');
			$("#detailModal").modal('show');
			
			var dataList = data.dataList;
			
			for(var i=0;i<dataList.length;i++){
				var dataMap = dataList[i];
				var rowDiv = document.createElement("div");
				$(rowDiv).addClass("row").attr("style","border-bottom:1px solid #666666;margin-bottom:5px;");
				var codeDiv = document.createElement("div");
				$(codeDiv).addClass("col-xs-12").attr("style","font-size:80%;")
					.text("消费码：" + dataMap.useCode).appendTo(rowDiv);
				
				var useStatus = dataMap.useStatus;
				var statusDiv = document.createElement("div");
				$(statusDiv).addClass("col-xs-12").attr("style","font-size:80%;")
					.appendTo(rowDiv);
				if(useStatus == 0 || useStatus == "0"){
					$(statusDiv).text("已过期");
				}else if(useStatus == 1 || useStatus == "1"){
					$(statusDiv).text("已销毁");
				}else if(useStatus == 2 || useStatus == "2"){
					$(statusDiv).append("<span style='color:red;'>未使用</span>"
						+"<br>有效期为：<span style='color:red;'>" 
						+ dataMap.validTime + "至" + dataMap.invalidTime + "</span>");
				}else if(useStatus == 3 || useStatus == "3"){
					$(statusDiv).text("已使用，使用时间：" + dataMap.useTime);
				}
				$("#electronicGoodsListShow").append(rowDiv);
			}
		}
	});
}
</script>
</body>
</html>
