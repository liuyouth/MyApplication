<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    <meta charset="utf-8">
    <title>行伙伴-个人中心</title>
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
                <li><a href="<%=basePath %>page_pageJump.html?pageName=preferential" title="优惠专享">优惠专享</a></li>
                <li class="active"><a href="<%=basePath %>page_pageJump.html?pageName=personalCenter" title="个人中心">个人中心</a></li>
              
            </ul>
        </nav>
        
        <div class="sub-nav" style="position:fixed;">
        	<nav >
	            <ul id="sub-nav" class="cf" style="z-index:999">
	                <li class="active">
	                	<a href="<%=basePath %>page_pageJump.html?pageName=personalCenter" title="我的账户">我的账户</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=pcCustomerInfoDetail" title="我的信息">我的信息</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=pcShoppingCart" title="我的购物车">我的购物车</a></li>
					<li>
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
     
     <!--内容-->
     <div class="container ppt-12">
           
               <div class="user-info-wp br-4">
               		<div class="row" style="background-size:100% 100%;">
						<div class="col-xs-6" style="text-align:center">
							<div class="row" style="margin-top:35px;">
								<img style="width: 141px;height: 141px;border-radius:50%;" id="headimgurlShow" src="http://echo-image.qiniucdn.com/Fjl47J5zcs29uw403-I7Z2yCK_Yp?imageView2/4/w/250">
							</div>
							<div class="row" style="margin-top:20px;margin-bottom:20px;">
								<span style="font-size: 210%;" id="nicknameShow">昵称</span>
							</div>
						</div>
						
						<div class="col-xs-6">
							<div class="row" style="margin-top:105px;">
								<div class="col-xs-4" style="font-size: 16px;text-align:center;">余额：</div>
								<div class="col-xs-4" style="font-size: 16px;color:#F00;text-align:center;" id="walletBalanceShow">0元</div>
								<div class="col-xs-4" style="font-size: 16px;color:#F00;text-align:center;" ></div>
							</div>
			
						</div>
						<div class="col-xs-12" >
							<div class="row" style="margin-top: 70px;margin-bottom: 20px;">
								<div class="col-xs-3" style="">
									<div class="row" style="text-align:center;height: 40px;">
										<span id="yikatongA" class="fui-credit-card" style="
			    font-size: 26px;
			"></span>
									</div>
									<div class="row" style="text-align:center;height: 40px;">
										<span style="font-size: 18px;">一卡通</span>
									</div>
									<div class="row" id="yikatongB" style="text-align:center;height:25px;">
										<span style="font-size: 16px;color:#666;">未激活</span>
									</div>
								</div>
								<div class="col-xs-3" style="">
									<div class="row" style="text-align:center;height: 40px;">
										<span id="zhongshihuaA" class="fui-credit-card" style="
			    font-size: 26px;
			"></span>
									</div>
									<div class="row" style="text-align:center;height: 40px;">
										<span style="font-size: 18px;">中石化</span>
									</div>
									<div class="row" id="zhongshihuaB" style="text-align:center;height:25px;">
										<span style="font-size: 16px;color:#666;">未激活</span>
									</div>
								</div>
								<div class="col-xs-3" style="">
									<div class="row" style="text-align:center;height: 40px;">
										<span id="zhongcheA" class="fui-credit-card" style="
			    font-size: 26px;
			"></span>
									</div>
									<div class="row" style="text-align:center;height: 40px;">
										<span style="font-size: 18px;">中  车</span>
									</div>
									<div class="row" id="zhongcheB" style="text-align:center;height:25px;">
										<span style="font-size: 16px;color:#666;">未激活</span>
									</div>
								</div>
								<div class="col-xs-3" style="">
									<div class="row" style="text-align:center;height: 40px;">
										<span id="nanhangA" class="fui-credit-card" style="
			    font-size: 26px;
			"></span>
									</div>
									<div class="row" style="text-align:center;height: 40px;">
										<span style="font-size: 18px;">南  航</span>
									</div>
									<div class="row" id="nanhangB" style="text-align:center;height:25px;">
										<span style="font-size: 16px;color:#666;">未激活</span>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xs-12">
						<hr>
						<div class="row" style="margin-top: 0px;margin-left: 20px;">
								<div id="chongzhi" class="col-xs-2" style="font-size: 16px;text-align: center;background-color: #6ed56c;height: 28px;border-radius: 3px;padding: 5px;color: #fff;">充值记录</div>
								<div id="xiaofei" class="col-xs-2" style="margin-left:20px; font-size: 16px;color: #FFF;text-align:center;background-color: #E25A3B;height: 28px;padding: 5px;border-radius: 3px;" id="walletBalanceShow">消费记录</div>
								<div class="col-xs-1"></div>
								<div class="col-xs-6" ></div>
						</div>
						<hr>
						
						
							<table id="logListDiv" class="table table-striped">
								
								
							</table>
	
						<hr>
							 
						</div>
					</div>
		            
		       </div>
      </div>
     
       
	</div>
     <!--内容-->
	<div  style="margin-bottom:10px;text-align: center;">
	       © 2015-2015 XingHuoBan.com 版权所有
       </div>
 

	<script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
    <script src="js/application.js"></script>
	<script src="js/subString.js"></script>
	

	<script type="text/javascript">
	var pageNumber = 1;
	var isShow = 1;
	var consumptionType = 0;
	$(document).ready(function () {
		$("#logListDiv").empty();
		getLogList(consumptionType);
		getWalletBalance();
	});
	
	$(function(){
		$('.carousel').carousel({
		interval: 3000
		});
		});

 	
 	$(window).scroll(function () {
	        var scrollTop = $(this).scrollTop();
	        var scrollHeight = $(document).height();
	        var windowHeight = $(this).height();
	        if (scrollTop + windowHeight == scrollHeight) {

	      //此处是滚动条到底部时候触发的事件，在这里写要加载的数据，或者是拉动滚动条的操作
	      if(isShow==1){
	    	  getLogList(consumptionType);
	      }
	        }
	 });
	
	
 	//监听屏幕滚动到底部TOP的显示隐藏 以及摇一摇
	 $(window).scroll(function() {
	 	if($(this).scrollTop() != 0) {
			 $('#top').fadeIn();
			 } else {
				 $('#top').fadeOut();
			 }
	 	});
	  
	 $('#top').click(function() {
		
	 $('body,html').animate({scrollTop:0},500);
		 });
	 $('#xiaofei').click(function() {
		 pageNumber = 1;
		  consumptionType = 1;
		$("#logListDiv").empty();
		 getLogList(consumptionType);
		 });
	 $('#chongzhi').click(function() {
		 pageNumber = 1;
		  consumptionType = 0;
		$("#logListDiv").empty();
		 getLogList(consumptionType);
		 });

	 //跳转详情页
	 function jumpDetail(goodsId){
		 window.open("page_pageJump.html?pageName=goodDetails&goodsId="+goodsId);
	 };
	 
	 
	//获取客户名称、头像、账户信息
		function getWalletBalance() {
			$.ajax({
				type : "post",
				url : "customer_getCustomerInfoBySe.html",
				dataType : "json",
				aysnc : false,
				success : function(data) {
					var nickname = data.nickname;
					var headimgurl = data.headimgurl;
					var customerData = data.result;
					var walletBalance = customerData.walletBalance;//账户号
					$("#nicknameShow").text(nickname);
					$("#walletBalanceShow").text(walletBalance+" 元");
					$("#headimgurlShow").attr("src",headimgurl);
				}
			});
		}
	 
	 
	//根据类型加载记录列表
		function getLogList(type){
			$.ajax({
				type : "post",
				url : "wallet_getWalletAccountRecordListByCustomerIdAndChangeType.html",
				dataType : "json",
				data:{
					"walletAccountRecord.changeType" : type,
					"page" : pageNumber
				},
				aysnc : false,
				success : function(data){
					pageNumber++;
					var dataList = data.dataList;
					showDate(dataList);
				}
			});
		}
		
		//页面展示
		function showDate(dataList){
			var rowDiv ="";
			if(dataList.length != 0){
				if(consumptionType == 0){
					//显示消费记录
						rowDiv1 = '<tr><th style="text-align: center;">充值时间</th><th style="text-align: center;">充值金额</th><th style="text-align: center;">充值类型</th><th style="text-align: center;">充值卡号</th>';
						$("#logListDiv").append(rowDiv1);
					for(var i=0;i<dataList.length;i++){
						var dataMap = dataList[i];
						rowDiv += '<tr><td>'+dataMap.changeTime+'</td><td style="color:#6ed56c ;font-weight: bold;">';
						rowDiv += '+'+dataMap.changeAmount.toFixed(2)+'元</td>';
						rechargeType = dataMap.rechargeType;
						if(rechargeType == "0"){
							//一卡通
							rechargeTypeStr = "一卡通";
							
						rowDiv += '<td>'+rechargeTypeStr+'</td>';
						rowDiv += '<td>'+dataMap.cardNumber+'</td></tr>';
						}else if(rechargeType == "1"){
							//中石化加油卡
							rechargeTypeStr = "中石化加油卡";
							rowDiv += '<td>'+rechargeTypeStr+'</td>';
							rowDiv += '<td>'+dataMap.cardNumber+'</td></tr>';
						}else if(rechargeType == "2"){
							//中石化加油卡
							rechargeTypeStr = "南航卡";
							rowDiv += '<td>'+rechargeTypeStr+'</td>';
							rowDiv += '<td>'+dataMap.cardNumber+'</td></tr>';
						}else if(rechargeType == "3"){
							//中石化加油卡
							rechargeTypeStr = "掌钱";
							rowDiv += '<td>'+rechargeTypeStr+'</td>';
							rowDiv += '<td>'+dataMap.cardNumber+'</td></tr>';
						}else if(rechargeType == "4"){
							//中石化加油卡
							rechargeTypeStr = "微信";
							rowDiv += '<td>'+rechargeTypeStr+'</td></tr>';
						}
							
						$("#logListDiv").append(rowDiv);
					}
						
					
				}else{
					//显示消费记录
						rowDiv1 = '<tr><th style="text-align: center;">消费时间</th><th style="text-align: center;">消费金额</th>';
					$("#logListDiv").append(rowDiv1);
					for(var i=0;i<dataList.length;i++){
						var dataMap = dataList[i];
						var rowDiv='';
						rowDiv += '<tr><td>'+dataMap.changeTime+'</td><td style="color:#f37800 ;font-weight: bold;">';
						rowDiv += '-'+dataMap.changeAmount.toFixed(2)+'元</td>';
						
						$("#logListDiv").append(rowDiv);
						
					}
					
				}
			}else{
				
				$("#noMsgDiv").show();
				
			}
			
		}

	</script>
</body>
</html>
