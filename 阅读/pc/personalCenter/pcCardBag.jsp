<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<meta charset="utf-8">
<title>行伙伴-我的卡包</title>
<meta name="description"
	content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version." />

<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0">

<link href="css/bootstrap.min.css" rel="stylesheet">

<link href="css/flat-ui.min.css" rel="stylesheet">
<link href="css/ehco.css" rel="stylesheet">
<style type="text/css">
.carousel-indicators .active {
	margin-right: 18px;
	border: 0px;
}

.carousel-indicators li {
	border: 0px;
}

.header-logo {
	background-image: url(<%=basePath%>images/pc/echo_logo.png);
	background-repeat: no-repeat;
}
</style>
</head>
<body style="background-color: #ebebeb;">
		<!--标题-->
	<header id="global-header" class="global-header">
		<div class="header-logo ht">echo</div>

		<nav class="header-nav">
			<ul class="cf" style="z-index: 999">
				<!--                <li class="active"><a href="/index/home" title="动态">动态</a></li>-->
				<li><a
					href="<%=basePath%>page_pageJump.html?pageName=travel"
					title="出行">出行</a></li>
				<li><a
					href="<%=basePath%>page_pageJump.html?pageName=preferential"
					title="优惠专享">优惠专享</a></li>
				<li class="active"><a
					href="<%=basePath%>page_pageJump.html?pageName=personalCenter"
					title="个人中心">个人中心</a></li>

			</ul>
		</nav>

		<div class="sub-nav" style="position: fixed;">
			<nav>
				<ul id="sub-nav" class="cf" style="z-index:999">
	                <li >
	                	<a href="<%=basePath %>page_pageJump.html?pageName=personalCenter" title="我的账户">我的账户</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=pcCustomerInfoDetail" title="我的信息">我的信息</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=pcShoppingCart" title="我的购物车">我的购物车</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=pcOrderList" title="我的订单">我的订单</a></li>
					<li class="active">
						<a href="<%=basePath %>page_pageJump.html?pageName=pcCardBag" title="我的卡包">我的卡包</a></li>
					<li>
						<a href="<%=basePath %>page_pageJump.html?pageName=complaintAdvice" title="投诉与建议">投诉与建议</a></li>
					
		              
		        </ul>

			</nav>
		</div>
		<div id="top" class="top">
			<img style="margin: 5px; width: 80%;" alt="" src="images/top.png">
		</div>


		<div class="header-panel cf">
			<!--            <form method="get" class="header-panel-search fl">-->
			<!--                <input type="text" class="field br-2" placeholder="搜索内容">-->
			<!--                <button type="submit" class="submit ht" title="搜索">搜索</button>-->
			<!--            </form>-->
			<nav class="header-panel-nav fr">
				<ul>
					<li class="register"><a href="/index/login"
						style="margin-right: 20px; color: #F1707D;">购物车</a></li>
					<li class="register"><a href="/index/login">登录</a></li>

				</ul>
			</nav>
		</div>
	</header>
	<!--标题-->

		 <div class="container" style="margin-top:10px;">

		<!--轮播图-->
		<div id="carousel-ad" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carousel-ad" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-ad" data-slide-to="1"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img class="img-responsive"
						src="http://echo-image.qiniucdn.com/Fs11cPZT0sTr5JVhS31k9X_hRnac">
				</div>
				<div class="item">
					<img class="img-responsive"
						src="http://echo-image.qiniucdn.com/Ftv5BZ20zlTQ1YSPCbf0dpEegZza">
				</div>
			</div>
		</div>
		<!--轮播图-->
		</div>

		<!-- 我的卡包 -->
		<div class="container ppt-12">
			<!--标题-->
			<!--标题-->
			<!--列表-->
			<div class="user-info-wp br-4">
			<div class="row">
				<div class="col-xs-12">
					<table id="cardBagListDiv" class="table">
					</table>
				</div>
				<!--列表列表-->
			</div>
			<!--内容-->
		</div>
		<!-- /container -->

		<div id="towCodeModal" class="modal hide fade" tabindex="-1"
			role="dialog" aria-labelledby="detailModalLabel" aria-hidden="true"
			style="margin-left: 10px; margin-right: 10px;">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="margin-top: 150px;">
					<div class="modal-header"
						style="background-color: white; padding: 6px; border-bottom: 1px solid #d7d7d7; border-radius: 5px 5px 0px 0px;">
						<span id="detailModalLabel" style="font-size: 100%;">二维码</span>
					</div>
					<div class="modal-body" style="background-color: white;"
						id="twoCodeShow"></div>
					<div class="modal-footer"
						style="background-color: white; padding: 6px; border-top: 1px solid #d7d7d7; border-radius: 0px 0px 5px 5px;">
						<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
					</div>


				</div>
			</div>
		</div>

		<!-- 我的卡包 -->

	</div>
	<div style="margin-bottom: 10px; text-align: center;">© 2015-2015
		XingHuoBan.com 版权所有</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/flat-ui.min.js"></script>
	<script src="js/application.js"></script>
	<script src="js/subString.js"></script>
	<script src="js/page.js"></script>

	<script type="text/javascript">
		var pageNumber = 1;
		var isShow = 1;
		$(document).ready(function() {
			getCardBagList();
			$("#cardBagListDiv").empty();
		});
		//获取登录用户的卡包列表
		function getCardBagList() {
			$.ajax({
						type : "post",
						url : "electronicGoods_getElectronicGoodsListByCustomerId.html",
						dataType : "json",
						data : {
							"page" : pageNumber,
						},
						aysnc : false,
						success : function(data) {
							pageNumber++; 
							var listData = data.dataList;
							for (var i = 0; i < listData.length; i++) {
								var data = listData[i];
								var use_code = data[0];
								var use_status = data[1];
								var use_time = data[2];
								var goods_name = data[3];
								var electronic_goods_id = data[5];
								var rowDiv = '<tr >';
								rowDiv += '<td  border-top:0px>商品：</td>';
								rowDiv += '<td>' + goods_name + '</td>';
								rowDiv += '<td rowspan=2><button type="button" class="btn btn-danger" ';
								rowDiv += 'onclick="javascript:getTWOcode(\''
										+ use_code
										+ '\');">查看二维码</button></td></tr><tr>';
								rowDiv += '<td style="border-top:0px">消费码 </td>';
								rowDiv += '<td style="border-top:0px">'
										+ use_code + '</td></tr>';
								$("#cardBagListDiv").append(rowDiv);
							}
							if (0 == listData.length) {
								isShow = 0;
							}
						}
					});
		}
		//点击底部按钮
		function changeBottomBtn(type) {
			//根据type判断跳转页面
			if (type == 1) {
				window.location.href = "page_pageJump.html?pageName=serviceGoodsList"; //出行类商品
			} else if (type == 2) {
				window.location.href = "page_pageJump.html?pageName=activityList"; //活动列表
			} else if (type == 3) {
				window.location.href = "page_pageJump.html?pageName=accountCenter"; //账户中心
			} else if (type == 4) {
				window.location.href = "page_pageJump.html?pageName=shoppingCart"; //购物车
			}
		}
		//查看二维码
		function getTWOcode(code) {
			$.ajax({
				type : "post",
				url : "electronicGoods_getTWOcode.html",
				dataType : "json",
				data : {
					"electronicGoods.useCode" : code
				},
				aysnc : false,
				success : function(data) {
					$("#twoCodeShow").empty();
					$("#towCodeModal").removeClass('hide');
					$("#towCodeModal").modal('show');
					//
					var twoCode = data.twoCode;

					var rowDiv = document.createElement("div");
					$(rowDiv).addClass("row").attr("style",
							"margin-bottom:2px;text-align:center;");
					var twoCodeImg = document.createElement("img");
					$(twoCodeImg).attr("src", twoCode).css({
						"width" : "40%"
					}).appendTo(rowDiv);
					$("#twoCodeShow").append(rowDiv);
				}
			});
		}
		//监听屏幕滚动到底部的加载信息
		$(window).scroll(function() {
			var scrollTop = $(this).scrollTop();
			var scrollHeight = $(document).height();
			var windowHeight = $(this).height();
			if (scrollTop + windowHeight == scrollHeight) {

				//此处是滚动条到底部时候触发的事件，在这里写要加载的数据，或者是拉动滚动条的操作
				if (isShow == 1) {
					getCardBagList();
				}
			}
		});
	</script>
</body>
</html>
