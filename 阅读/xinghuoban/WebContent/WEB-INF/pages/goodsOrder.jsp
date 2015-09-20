<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String orderBatchCode = request.getParameter("orderBatchCode"); 
	String totalPrice = request.getParameter("totalPrice"); 
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>商品订单</title>
    <meta name="description" content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version."/>

    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0">
	
    <link href="css/bootstrap.min.css" rel="stylesheet">
	
    <link href="css/flat-ui.min.css" rel="stylesheet">
  </head>
  <body style="color:#000000;">
    <div class="container">
		<!--标题-->
		<div class="row navbar-fixed-top" style="text-align:center;border-bottom:1px solid #999999;background-color:#FFFFFF;">
			支付
		</div>
		<!--标题-->
		
		<!--一级菜单-->
        <div class="row" style="margin-top:31px;">
			<ul class="nav nav-tabs" id="firstMenuUl" style="margin-top:5px;margin-left:5px;">
				
			</ul>
		</div>
		<!--一级菜单-->
		
		<!--内容-->
		<div class="row" style="background-image:url(images/order_bg.png);background-size:100% 100%;height:200px;
			width:100%;margin-left:0px;padding-left:10px;margin-top:10px;">
			<div class="col-xs-12" style="text-align:left;padding:40px 0px 0px 30px;">订单号：</div>
			<div class="col-xs-12" style="text-align:center;padding:0px;font-size:60%;" id="orderBatchCode">
				
			</div>
			<div class="col-xs-6" style="text-align:center;padding:10px 0px 0px 30px;">结算金额：</div>
			<div class="col-xs-6" style="text-align:left;padding:10px 0px 0px 0px;" id="totalPrice">
				
			</div>
		</div>
		
		<div class="row" style="margin-top:20px;">
			<h5 style="padding-left:10px;">支付方式</h5>
			<hr style="border:1px solid #999999;margin:5px 0px;height:1px;background-color:#999999;"/>
			<div class="col-xs-4" style="text-align:center;margin:10px 0px;">
				余额支付
			</div>
			<div class="col-xs-7" style="text-align:center;margin:10px 0px;">
				<span style="color:red;">余额 : </span>
				<span style="color:red;">13313321元</span>
			</div>
			<div class="col-xs-1" style="text-align:center;margin:10px 0px;padding:0px 2px 0px 5px;">
				<input type="radio" checked>
			</div>
			
			<div class="col-xs-6" style="text-align:center;margin-top:10px;">
				<button type="button" class="btn btn-danger btn-lg btn-block" 
					onclick="javascript:recharge();">充值</button>
			</div>
			<div class="col-xs-6" style="text-align:center;margin-top:10px;">
				<button type="button" class="btn btn-info btn-lg btn-block" 
					onclick="javascript:payOrder();">支付</button>
			</div>
		</div>
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
	var orderBatchCode = "<%=orderBatchCode%>";//批次号
	var totalPrice = <%=totalPrice%>;//选中的商品的总价格
	$(document).ready(function () {
		
		$("#orderBatchCode").text(orderBatchCode);
		$("#totalPrice").text(totalPrice + "元");
		
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
	
	</script>
  </body>
</html>
