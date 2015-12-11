<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String pageType = request.getParameter("pageType");
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
		
		<!--充值结果-->
		<div class="success row" style="margin-top: 10px;background-color: white;width: 100%;padding: 30px;">
			<div class="col-xs-6" style="text-align:right;">
				<span style="display:block;text-align:center;border:1px solid #d7d7d7;margin:0 auto;
					width:20px;height:20px;border-radius:15px;color:white;background-color:red;" 
					class="fui-check"></span>
			</div>
			<div class="col-xs-6" style="text-align:left;font-size: 16px;color: red;" id="msgShowDiv">
				恭喜，您已经成功充值 
				<div>
					<span style="color:red;font-weight:900;font-size:150%;">2000.00</span>元！
				</div>
			</div>
			
	
			
		</div>
		
		<div class="success container" style="background-color: white;width: 100%;">
			<hr style="border:1px solid #d7d7d7;height:3px;background-color:#d7d7d7;"/>
				<!--提示操作-->
				<div class="row">
					<div class="col-xs-12">
					<h6>您现在可以做：</h6>
					</div>
				</div>
				
			<div class="row">
				<div class="col-xs-3" style="margin:10px 0px;text-align: center;">
					
		        </div>
				
				<div class="col-xs-2" style="margin:10px 0px;text-align: center;cursor: pointer;" onclick="javascript:goOn(2);">
					<span style="display:block;text-align:center;float:left;
						width:20px;height:20px;border-radius:15px;color:white;background-color:red;" 
						class="fui-user"></span>
					<span style="display:block;text-align:left;height:30px;float:left;margin-left:5px;">个人中心</span>
		        </div>
				<div class="col-xs-2" style="margin:10px 0px;text-align: center;cursor: pointer;" onclick="javascript:goOn(0);">
					<span style="display:block;text-align:center;float:left;
						width:20px;height:20px;border-radius:15px;color:white;background-color:red;" 
						class="fui-list-columned"></span>
					<span style="display:block;text-align:left;height:30px;float:left;margin-left:5px;">购物</span>
		        </div>
				<div class="col-xs-2" style="margin:10px 0px;text-align: center;cursor: pointer;" onclick="javascript:goOn(1);">
					<span style="display:block;text-align:center;float:left;
						width:20px;height:20px;border-radius:15px;color:white;background-color:red;" 
						class="fui-document"></span>
					<span style="display:block;text-align:left;height:30px;float:left;margin-left:5px;">处理订单</span>
		        </div>
				<div class="col-xs-3" style="margin:10px 0px;text-align: center;">
		        </div>
				<!--提示操作-->
		    </div>
		</div>
		
		
		<div class="fail row" style="margin-top:80px;margin-bottom:40px;">
			<div class="col-xs-3" style="padding:15px 0px 0px 10px;">
				<span style="display:block;text-align:center;border:1px solid #d7d7d7;margin:0 auto;
					width:30px;height:30px;border-radius:15px;color:white;background-color:red;" 
					class="fui-cross"></span>
			</div>
			<div class="col-xs-9" style="text-align:center;">
				对不起，您已经充值失败！
			</div>
		</div>
		
		<!--充值结果-->
	</div>
	
	
	
	<div class="fail container">
		<!--提示操作-->
		<div class="row">
			<div class="col-xs-12" style="">
			<h6>您现在可以做：</h6>
			</div>
		</div>
		<div class="col-xs-6" style="margin:10px 0px;" onclick="javascript:goOn(3);">
			
			<button class="btn btn-link">取消充值</button>
        </div>
		<div class="col-xs-6" style="margin:10px 0px;" onclick="javascript:goOn(4);">
			<button class="btn btn-info" >
				返回充值页面
			</button>
        </div>
		
		<!--提示操作-->
    </div>

	<script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
    <script src="js/application.js"></script>
	<script src="js/subString.js"></script>
	<script src="js/page.js"></script>

	<script type="text/javascript">
		var pageType = <%=pageType%>;
		$(document).ready(function () {
			if(pageType == "0"){
				$("#resultDiv").text("支付结果");
				
				$("#msgShowDiv").text("恭喜，您支付成功！ ");
				$("#msgShowDiv").attr("style","text-align:left;font-size: 16px;color: red;");
				
				$(".success").show();
				$(".fail").hide();
			}else if(pageType == "1"){
				$("#resultDiv").text("充值结果");
				$(".success").show();
				$(".fail").hide();
			} 
		});
		
		//继续操作
		function goOn(type){
			if(type == 0){
				window.location.href="page_pageJump.html?pageName=travel";//出行商品
			}else if(type == 1){
				window.location.href="page_pageJump.html?pageName=orderList"; //订单列表
			}else if(type == 2){
				window.location.href="page_pageJump.html?pageName=personalCenter"; //账户中心
			}else if(type == 3){
				window.location.href="page_pageJump.html?pageName=orderList"; //订单列表
			}else if(type == 4){
				window.location.href="page_pageJump.html?pageName=rechargeJump"; //跳转充值界面
			}
		}
	</script>
</body>
</html>
