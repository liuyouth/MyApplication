<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String orderBatchId = request.getParameter("orderBatchId"); 
	String orderBatchCode = request.getParameter("orderBatchCode"); 
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
		<!--标题-->
		<!--标题-->
		
		<!--内容-->
		<div style="background-image:url(images/order_bg.png);background-size:100% 100%;height:200px;
				width:100%;margin-left:0px;padding-left:10px;background-color: white;margin: 10px 0px 0px 0px;">
			<div class="row" style="  padding-top: 50px;" >
				
				<div class="col-xs-6" style="text-align: right;">订单号：</div>
				<div class="col-xs-6" style="text-align: left;" id="orderBatchCode">
					
				</div>
			</div>
			<div class="row" style="  padding-top: 20px;">	
				<div class="col-xs-6" style="text-align: right;">结算金额：</div>
				<div class="col-xs-6" style="font-size: 16px;text-align: left;color:red;" id="totalPrice">
					
				</div>
			</div>
		</div>
		<div class="row" style="padding-top:20px;background-color: #fff;width: 100%;">
			<h5 style="padding-left:10px;">支付方式</h5>
			<hr style="border:1px solid #d7d7d7;margin:5px 0px;height:1px;background-color:#d7d7d7;"/>
			<form class="form-horizontal" role="form" style="margin-top:20px;">
				<div class="form-group" style="margin:5px 10px;">
					<div class="col-xs-4" style="text-align:center;margin:10px 0px;">
						余额支付
					</div>
					<div class="col-xs-4" style="text-align:center;margin:10px 0px;">
						<span style="color:red;">余额 : </span>
						<span style="color:red;" id="walletBalance">0元</span>
					</div>
					<div class="col-xs-4" style="text-align:center;margin:10px 0px;padding:0px 2px 0px 5px;">
						<input type="radio" checked>
					</div>
				</div>
				<div class="form-group" style="margin:20px;">
					<div class="col-xs-6">
						<button type="button" class="btn btn-danger btn-lg btn-block" 
						onclick="javascript:recharge();" style="width:25%;">充值</button>
					</div>
					<div class="col-xs-6">
						<button type="button" class="btn btn-info btn-lg btn-block" onclick="javascript:openModal();" style="width:25%;">支付</button>
					</div>
				</div>
			</form>
		</div>
		<!--内容-->
    </div> <!-- /container -->

    
    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
    	style="">
    	<div class="modal-dialog" role="document">
    	<div class="modal-content" style="margin-top:30%;">
		<div class="modal-header" style="background-color:white;">
			<button class="close" type="button" data-dismiss="modal">×</button>
			<h5 id="myModalLabel">提示消息</h5>
		</div>
		<div class="modal-body" style="background-color:white;">
			您确认支付么？
		</div>
		<div class="modal-footer" style="background-color:white;">
		    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		    <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" onclick="javascript:payOrder();">确认</button>
	  	</div>
	  	</div>
	  	</div>
	</div>

    <script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
    <script src="js/application.js"></script>
	<script src="js/subString.js"></script>
	<script src="js/page.js"></script>
	
	<script src="js/modal.js"></script>
    <!-- 引入导航 TOP以及摇一摇 JS -->
	<script src="js/change_mark.js"></script> 
	<script type="text/javascript">
	var orderBatchId = <%=orderBatchId%>;//订单批次Id
	var orderBatchCode = "<%=orderBatchCode%>";//批次号
	var totalPrice = <%=totalPrice%>;//选中的商品的总价格
	var walletBalance = 0;//账户余额
	$(document).ready(function () {
		findAllChange();
		$("#orderBatchCode").text(orderBatchCode);
		$("#totalPrice").text(totalPrice + "元");
		
		//查询账户余额
		getWalletBalance();
	});
	
	//查询账户余额
	function getWalletBalance(){
		$.ajax({
			type : "post",
			url : "customer_getCustomerInfoBySe.html",
			dataType : "json",
			aysnc : false,
			success : function(data){
				var customerData = data.result;
				walletBalance = customerData.walletBalance;//账户余额
				
				$("#walletBalance").text(walletBalance + "元");
			}
		});
	}
	
	//跳转充值界面
	function recharge(){
		window.location.href="page_pageJump.html?pageName=rechargeJump"; //跳转充值界面
	}
	
	function openModal(){
		$("#myModal").removeClass('hide');
		$("#myModal").modal('show');
	}
	
	//点击支付按钮
	function payOrder(){
		if(walletBalance < totalPrice){
			alert("您的账户余额不足，请先充值再消费！谢谢~");
		}else{
			//支付订单
			$.ajax({
				type : "post",
				url : "order_payForOrder.html",
				dataType : "json",
				aysnc : false,
				data : {
					"orderBatchId" : orderBatchId,
					"orderBatchCode" : orderBatchCode,
					"allMoney" : totalPrice
				},
				success : function(data){
					if(data.success){
						alert(data.msg);
						//pageType分为0：支付，1：充值
						window.location.href="page_pageJump.html?pageName=pcRechargeOrPayOver&pageType=0"; //跳转支付成功界面
					}else{
						alert(data.msg);
					}
				}
			});
		}
	}
	</script>
  </body>
</html>
