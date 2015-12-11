<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
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
        
        <div class="sub-nav" style="position:fixed;">
        	<nav >
	             <ul id="sub-nav" class="cf" style="z-index:999">
	                <li >
	                	<a href="<%=basePath %>page_pageJump.html?pageName=personalCenter" title="我的账户">我的账户</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=pcCustomerInfoDetail" title="我的信息">我的信息</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=pcShoppingCart" title="我的购物车">我的购物车</a></li>
					<li class="active">
						<a href="<%=basePath %>page_pageJump.html?pageName=pcOrderList" title="我的订单">我的订单</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=pcCardBag" title="我的卡包">我的卡包</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=complaintAdvice" title="投诉与建议">投诉与建议</a></li>
					
		              
		        </ul>
	        </nav>
        </div>
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
          <div class="user-info-wp br-4">
		       <div class="row" style="background-size:100% 100%; ">
					<div class="col-xs-12" style="text-align:center">
						<!--一级菜单-->
				        <div class="row" style="margin-top:10px; margin-right:15px;margin-left:15px;">
							<ul class="nav nav-tabs" style="margin-top:5px;margin-left:5px;">
								<li id="order_0" role="presentation" class="order active" onclick="javascript:changeOrderBatchStatus(0);">
									<a href="javascript:void(0);">
										未支付
									</a>
								</li>
								<li id="order_1" role="presentation" class="order" onclick="javascript:changeOrderBatchStatus(1);">
									<a href="javascript:void(0);">
										已支付
									</a>
								</li>
								<li id="order_2" role="presentation" class="order" onclick="javascript:changeOrderBatchStatus(2);">
									<a href="javascript:void(0);">
										已取消
									</a>
								</li>
							</ul>
						</div>
						<!--一级菜单-->
						
						<!--商品列表-->
						<div class="row">
							<div class="col-xs-12">
								<table id="orderBatchListDiv" class="table table-striped">
								
								
								</table>
							</div>
						</div>
							<!--商品列表-->
								
				
				
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
	var orderBatchStatus = 0;
	var pageNumber = 1;
	var isShow = 1;
	$(document).ready(function () {
		//根据不同的状态获取订单批次列表
		getOrderList(orderBatchStatus);
	});
	function changeOrderBatchStatus(status){
		$("#orderBatchListDiv").empty();
		orderBatchStatus = status;
		pageNumber = 1;
		isShow = 1;
		getOrderList(orderBatchStatus);
	}
	//根据不同的状态获取订单批次列表
	function getOrderList(orderBatchStatus){
		
		$(".order").removeClass("active");
		$("#order_"+orderBatchStatus).addClass("active");
		
		$.ajax({
			type : "post",
			url : "order_getOrderBatchListByCustomerIdAndStatus.html",
			dataType : "json",
			data:{
				"orderBatchStatus" : orderBatchStatus,
				"page" : pageNumber,
				
			},
			aysnc : false,
			success : function(data){
				var listData = data.listMap;
				pageNumber ++;
				if(0==listData.length){
					isShow=0;
				}else{
					
					for(var i=0;i<listData.length;i++){
						var mapData = listData[i];
						var rowDiv = '<tr><td style="line-height:50px;">'+mapData.orderBatchCode+'</td>';
						rowDiv += '<td style="line-height:50px;">'+mapData.orderTime+'</td>';
						rowDiv += '<td style="color:#6ed56c ;font-weight: bold; line-height:50px;">'+mapData.totalMoney+'元</td>';
						rowDiv += '<td><button type="button" class="btn btn-danger" style="margin:0px; margin-top:5px; height:40px;"';
						rowDiv += 'onclick="javascript:jumpToOrderBatchDetail('+mapData.orderBatchId+','+mapData.goodsType+');">查看详情</button></td>';
							
						$("#orderBatchListDiv").append(rowDiv);
					}
				}
			}
		});
	}
	
	
	//跳转页面
	function jumpToOrderBatchDetail(orderBatchId,goodsType){
		if(goodsType == 2 || goodsType == "2"){
			window.location.href="page_pageJump.html?pageName=pcTravelGoodsOrderDetail&orderBatchId="+orderBatchId; //出行类订单详情
		}else{
			window.location.href="page_pageJump.html?pageName=pcOrderListDetail&orderBatchId="+orderBatchId; //订单详情
		}
		
	}
	
//监听屏幕滚动到底部的加载信息
 	
 	$(window).scroll(function () {
	        var scrollTop = $(this).scrollTop();
	        var scrollHeight = $(document).height();
	        var windowHeight = $(this).height();
	        if (scrollTop + windowHeight == scrollHeight) {

	      //此处是滚动条到底部时候触发的事件，在这里写要加载的数据，或者是拉动滚动条的操作
	      if(isShow==1){
	    	  
	    	  getOrderList(orderBatchStatus);	
	      }
	        }
	 });
	</script>
</body>
</html>
