<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String orderBatchId = request.getParameter("orderBatchId");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>行伙伴-订单信息</title>
    <meta name="description" content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version."/>

    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0">

    <link href="css/bootstrap.min.css" rel="stylesheet">
	
    <link href="css/flat-ui.min.css" rel="stylesheet">
    <style type="text/css">
    </style>
</head>
<body>
    <div class="container">
		<!--标题-->
		<div class="row navbar-fixed-top" style="text-align:center;border-bottom:1px solid #999999;background-color:#FFFFFF;">
			订单信息
		</div>
		<!--标题-->
		
		<!--商品列表-->
		<div class="row" style="margin-top:31px;">
			<div class="col-xs-12">
				<div class="row" style="border:1px solid #999999;">
					<div class="col-xs-12" style="text-align:center;">
						<span style="font-size:60%;">
							D144238679124724414540612181711724
						</span>
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;">
							收货人：薛洋
						</span>
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;">
							订单状态：未付款
						</span>
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;">
							总金额：32131元
						</span>
					</div>
					<div class="col-xs-6">
						<span style="font-size:60%;">
							2015/12/12-12:12
						</span>
					</div>
				</div>
				
				<div class="row" style="border:1px solid #999999;">
					<div class="col-xs-12">
						<span style="font-size:
						60%; margin-left: 5%; ">
							订单号：X14423867912472441454061218...
						</span>
					</div>
					<!--商品信息-->
					<div class="col-xs-12">
						<div class="row" id="goodsId_1" style="border-bottom:1px solid #999999;" 
							onclick="javascript:jumpToGoodsDetail(this);">
							<div class="col-xs-5" style="padding:5px;">
								<img src="docs\assets\img\demo\browser-author.jpg" style="width:80px;height:80px;">
							</div>
							<div class="col-xs-7">
								<div class="row">
									<span style="font-size:80%;">4人直升机</span>
								</div>
								<div class="row">
									<p style="font-size:8px;color:#666666;margin:3px 0px;">附送驾驶员，十公升汽油</p>
								</div>
								<div class="row">
									<span style="font-size:8px;color:#FA0B0B;">￥10W/天</span>
								</div>
							</div>
						</div>
					</div>
					<!--商品信息-->
				</div>
				
				<div class="row" style="border:1px solid #666666;">
					<div class="col-xs-12">
						<span style="font-size: 60%; width: 80%; margin-left:5%;">
							订单号：X14423867912472441454061218...
						</span>
					</div>
					<!--商品信息-->
					<div class="col-xs-12">
						<div class="row" id="goodsId_1" style="border:1px solid #999999;" 
							onclick="javascript:jumpToGoodsDetail(this);">
							<div class="col-xs-5" style="padding:5px;">
								<img src="docs\assets\img\demo\browser-author.jpg" style="width:80px;height:80px;">
							</div>
							<div class="col-xs-7">
								<div class="row">
									<span style="font-size:80%;">4人直升机</span>
								</div>
								<div class="row">
									<p style="font-size:8px;color:#666666;margin:3px 0px;">附送驾驶员，十公升汽油</p>
								</div>
								<div class="row">
									<span style="font-size:8px;color:#FA0B0B;">￥10W/天</span>
								</div>
							</div>
						</div>
					</div>
					<!--商品信息-->
					<div class="col-xs-4" style="margin:5px 0px;">
						<button type="button" class="btn btn-link" style="padding:5px 10px;">联系客服</button>
					</div>
					
					<div class="col-xs-4" style="margin:5px 0px;">
						<button type="button" class="btn" style="display:none;margin:0px auto;padding:5px 10px;">退款</button>
						<button type="button" class="btn" style="display:block;margin:0px auto;padding:5px 10px;">退货</button>
					</div>
					
					<div class="col-xs-4" style="margin:5px 0px;">
						<button type="button" class="btn btn-info" style="padding:5px 10px;">确认收货</button>
					</div>
				</div>
				
			</div>
		</div>
		<!--商品列表-->	
		
		<!--订单未支付的时候显示-->
		<div class="row">
			<div class="col-xs-6" style="text-align:center;margin-top:10px;">
				<button type="button" class="btn btn-lg btn-block">取消</button>
			</div>
			<div class="col-xs-6" style="text-align:center;margin-top:10px;">
				<button type="button" class="btn btn-info btn-lg btn-block">结算</button>
			</div>
		</div>
		<!--订单未支付的时候显示-->
    </div> <!-- /container -->

    <footer>
      <div class="container">
        <div class="navbar-fixed-bottom" style="background-color:#FFFFFF;padding:5px 0px 0px 0px;margin-bottom:-3px;">
			
			<div class="row" style="margin:0px auto;">
				<div class="btn-group" role="group" style="width:100%;margin:0px;padding:0px;">
					<button id="goodsBtn" type="button" class="btn btn-primary bottomBtn" style="width:33%;" 
						onclick="javascript:changeBottomBtn(1);">
						商品
					</button>
					<button id="activityBtn" type="button" class="btn btn-primary bottomBtn" style="width:34%;" 
						onclick="javascript:changeBottomBtn(2);">
						活动
					</button>
					<button id="accountBtn" type="button" class="btn btn-info bottomBtn" style="width:33%;" 
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
	var orderBatchId = <%=orderBatchId%>;//批次id
	$(document).ready(function () {
		alert(orderBatchId);
		//获取订单详情
		getOrderBatchDetail(orderBatchId);
	});
	
	//获取订单详情
	function getOrderBatchDetail(orderBatchId){
		
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
	
	//跳转页面
	function jumpToDetail(){
	
	}
	</script>
</body>
</html>
