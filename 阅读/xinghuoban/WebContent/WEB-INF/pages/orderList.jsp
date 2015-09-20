<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>行伙伴-我的订单</title>
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
			订单列表
		</div>
		<!--标题-->
		
		<!--一级菜单-->
        <div class="row" style="margin-top:31px;">
			<ul class="nav nav-tabs" style="margin-top:5px;margin-left:5px;">
				<li id="order_0" role="presentation" class="order active" onclick="javascript:getOrderList(0);">
					<a href="javascript:void(0);">
						未支付
					</a>
				</li>
				<li id="order_1" role="presentation" class="order" onclick="javascript:getOrderList(1);">
					<a href="javascript:void(0);">
						已支付
					</a>
				</li>
				<li id="order_2" role="presentation" class="order" onclick="javascript:getOrderList(2);">
					<a href="javascript:void(0);">
						已取消
					</a>
				</li>
			</ul>
		</div>
		<!--一级菜单-->
		
		<!--商品列表-->
		<div class="row">
			<div class="col-xs-12" id="orderBatchListDiv">
				
			</div>
			<!--商品列表-->
			
		</div>
		<!--内容-->
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
	$(document).ready(function () {
		//根据不同的状态获取订单批次列表
		var orderBatchStatus = "0";//未支付
		getOrderList(orderBatchStatus);
	});
	
	//根据不同的状态获取订单批次列表
	function getOrderList(orderBatchStatus){
		
		$(".order").removeClass("active");
		$("#order_"+orderBatchStatus).addClass("active");
		
		$.ajax({
			type : "post",
			url : "order_getOrderBatchListByCustomerIdAndStatus.html",
			dataType : "json",
			data:{
				"orderBatchStatus" : orderBatchStatus
			},
			aysnc : false,
			success : function(data){
				$("#orderBatchListDiv").empty();
				var listData = data.listMap;
				
				for(var i=0;i<listData.length;i++){
					var mapData = listData[i];
					var rowDiv = document.createElement("div");
					$(rowDiv).addClass("row").attr("id","orderBatchId_"+mapData.orderBatchId)
						.attr("style","border:1px solid #999999;")
						.attr("onclick","javascript:jumpToDetail(this);");
					
					var codeDivXS = document.createElement("div");
					$(codeDivXS).addClass("col-xs-12").appendTo(rowDiv);
					var codeDivRow = document.createElement("div");
					$(codeDivRow).addClass("row").appendTo(codeDivXS);
					
					var textDiv = document.createElement("div");
					$(textDiv).addClass("col-xs-3").appendTo(codeDivRow)
						.attr("style","text-align:center;padding:0px;");
					var textSpan = document.createElement("span");
					$(textSpan).attr("style","font-size:80%;font-weight:bold;padding-left:10px;")
						.text("订单号：").appendTo(textDiv);
					
					var codeDiv = document.createElement("div");
					$(codeDiv).addClass("col-xs-8").appendTo(codeDivRow)
						.attr("style","text-align:center;padding:0px;");
					var codeSpan = document.createElement("span");
					$(codeSpan).attr("style","font-size:50%;font-weight:bold;")
						.text(mapData.orderBatchCode).appendTo(codeDiv);
					
					var contentDivXS = document.createElement("div");
					$(contentDivXS).addClass("col-xs-12").appendTo(rowDiv);
					var contentDivRow = document.createElement("div");
					$(contentDivRow).addClass("row").appendTo(contentDivXS);
					
					var showDivXS = document.createElement("div");
					$(showDivXS).addClass("col-xs-7").appendTo(contentDivRow);
					var timeDivRow = document.createElement("div");
					$(timeDivRow).addClass("row").appendTo(showDivXS);
					var timeDiv = document.createElement("div");
					$(timeDiv).addClass("col-xs-12").appendTo(timeDivRow);
					var timeSpan = document.createElement("sapn");
					$(timeSpan).attr("style","font-size:50%;").text(mapData.orderTime).appendTo(timeDiv);
					
					var moneyDivRow = document.createElement("div");
					$(moneyDivRow).addClass("row").appendTo(showDivXS);
					var moneyTextDiv = document.createElement("div");
					$(moneyTextDiv).addClass("col-xs-5").attr("style","padding:0px 0px 0px 15px;")
						.appendTo(moneyDivRow);
					var moneyTextSpan = document.createElement("span");
					$(moneyTextSpan).attr("style","font-size:80%;font-weight:bold;color:red;")
						.text("总金额：").appendTo(moneyTextDiv);
					
					var moneyDiv = document.createElement("div");
					$(moneyDiv).addClass("col-xs-7").attr("style","padding:0px 5px;")
						.appendTo(moneyDivRow);
					var moneySpan = document.createElement("span");
					$(moneySpan).attr("style","font-size:80%;font-weight:bold;color:red;")
						.text(mapData.totalMoney + "元").appendTo(moneyDiv);
					
					var buttonDiv = document.createElement("div");
					$(buttonDiv).addClass("col-xs-5").appendTo(contentDivRow);
					var button = document.createElement("button");
					$(button).attr("type","button").addClass("btn btn-danger")
						.attr("style","margin-top:10px;")
						.attr("onclick","javascript:jumpToOrderBatchDetail("+mapData.orderBatchId+");").text("查看详情").appendTo(buttonDiv);
					
					$("#orderBatchListDiv").append(rowDiv);
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
	
	//跳转页面
	function jumpToOrderBatchDetail(orderBatchId){
		window.location.href="page_pageJump.html?pageName=orderDetail&orderBatchId="+orderBatchId; //订单详情
	}
	</script>
</body>
</html>
