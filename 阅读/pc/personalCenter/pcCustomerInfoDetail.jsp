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
<title>行伙伴-我的信息</title>
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
				<ul id="sub-nav" class="cf" style="z-index: 999">
					<li><a
						href="<%=basePath%>page_pageJump.html?pageName=personalCenter"
						title="我的账户">我的账户</a></li>
					<li class="active"><a
						href="<%=basePath%>page_pageJump.html?pageName=pcCustomerInfoDetail"
						title="我的信息">我的信息</a></li>
					<li><a
						href="<%=basePath%>page_pageJump.html?pageName=pcShoppingCart"
						title="我的购物车">我的购物车</a></li>
					<li><a
						href="<%=basePath%>page_pageJump.html?pageName=pcOrderList"
						title="我的订单">我的订单</a></li>
					<li><a
						href="<%=basePath%>page_pageJump.html?pageName=pcCardBag"
						title="我的卡包">我的卡包</a></li>
					<li><a
						href="<%=basePath%>page_pageJump.html?pageName=complaintAdvice"
						title="投诉与建议">投诉与建议</a></li>


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
      <div class="item active"><img class="img-responsive" src="http://echo-image.qiniucdn.com/Fs11cPZT0sTr5JVhS31k9X_hRnac"></div>
      <div class="item"><img class="img-responsive" src="http://echo-image.qiniucdn.com/Ftv5BZ20zlTQ1YSPCbf0dpEegZza"></div>
    </div>
  </div>
		<!--轮播图-->
	</div>
	<!--账户信息-->
	<div class="container ppt-12">
		<!--账户信息-->
		<div class="user-info-wp br-4">
			<div class="row">
				<form class="form-horizontal" role="form">
					<div class="form-group" style="margin: 5px 10px;">
						<label for="inputEmail1" class="col-xs-3 control-label"
							style="padding: 5px 0px 0px 0px; text-align: center;"> 账号
						</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" id="walletAccountShow"
								placeholder="账号" readonly=""
								onmouseover="this.style.cursor='text'"
								style="border: 1px solid rgb(235, 235, 235); color: #151213; opacity: 1; background-color: #FFFFFF;";>

						</div>
					</div>
					<div class="form-group" style="margin: 5px 10px;">
						<label for="inputEmail1" class="col-xs-3 control-label"
							style="padding: 5px 0px 0px 0px; text-align: center;">
							手机号 </label>
						<div class="col-xs-9">
							<input type="text" class="form-control" id="customerPhoneShow"
								placeholder="手机号" readonly=""
								onmouseover="this.style.cursor='text'"
								style="border: 1px solid rgb(235, 235, 235); color: #34495e; opacity: 1; background-color: #FFFFFF;">
						</div>
					</div>
					<div class="form-group" style="margin: 5px 10px;">
						<label for="inputEmail1" class="col-xs-3 control-label"
							style="padding: 5px 0px 0px 0px; text-align: center;"> 生日
						</label>
						<div class="col-xs-9">
							<input type="text" class="form-control" id="birthdayShow"
								placeholder="生日" readonly=""
								onmouseover="this.style.cursor='text'"
								style="border: 1px solid rgb(235, 235, 235); color: #34495e; opacity: 1; background-color: #FFFFFF;">
						</div>
					</div>
					<div class="form-group" style="margin: 5px 10px;">
						<label for="inputEmail1" class="col-xs-3 control-label"
							style="padding: 5px 0px 0px 0px; text-align: center;">
							微信昵称 </label>
						<div class="col-xs-9">
							<input type="text" class="form-control" id="nicknameShow"
								placeholder="微信昵称" readonly=""
								onmouseover="this.style.cursor='text'"
								style="border: 1px solid rgb(235, 235, 235); color: #34495e; opacity: 1; background-color: #FFFFFF;">
						</div>
					</div>
				</form>
			</div>
			<!--账户信息-->

			<hr
				style="border: 1px solid #d7d7d7; margin: 5px 0px; height: 3px; background-color: #d7d7d7;" />

			<!--绑卡信息区域-->
			<div class="row">
				<div class="col-xs-12" style="text-align: center;">已绑卡号</div>
				<form class="form-horizontal" role="form">
					<div class="form-group" id="yikatongA" style="margin: 5px 10px;">
						<label for="yikatongB" class="col-xs-3 control-label"
							style="padding: 5px 0px 0px 0px; text-align: center;">
							一卡通 </label>
						<div class="col-xs-9">
							<input type="text" id="yikatongB" class="form-control"
								value="123123123123123" readonly=""
								onmouseover="this.style.cursor='text'"
								style="border: 1px solid rgb(235, 235, 235); color: #34495e; opacity: 1; background-color: #FFFFFF;">
						</div>
					</div>
					<div class="form-group" id="zhongshihuaA" style="margin: 5px 10px;">
						<label for="zhongshihuaB" class="col-xs-3 control-label"
							style="padding: 5px 0px 0px 0px; text-align: center;">
							中石化 </label>
						<div class="col-xs-9">
							<input type="text" id="zhongshihuaB" class="form-control"
								readonly
								style="border: 1px solid rgb(235, 235, 235); color: #34495e; opacity: 1; background-color: #FFFFFF">
						</div>
					</div>
					<div class="form-group" id="zhongcheA" style="margin: 5px 10px;">
						<label for="zhongcheB" class="col-xs-3 control-label"
							style="padding: 5px 0px 0px 0px; text-align: center;"> 中车
						</label>
						<div class="col-xs-9">
							<input type="text" id="zhongcheB" class="form-control" readonly
								style="border: 1px solid rgb(235, 235, 235); color: #34495e; opacity: 1; background-color: #FFFFFF">
						</div>
					</div>
					<div class="form-group" id="nanhangA" style="margin: 5px 10px;">
						<label for="nanhangB" class="col-xs-3 control-label"
							style="padding: 5px 0px 0px 0px; text-align: center;"> 南航
						</label>
						<div class="col-xs-9">
							<input type="text" id="nanhangB" class="form-control" readonly
								style="border: 1px solid rgb(235, 235, 235); color: #34495e; opacity: 1; background-color: #FFFFFF">
						</div>
					</div>
				</form>
			</div>
			<!--绑卡信息区域-->

			<div class="row" style="margin-bottom: 50px;">
				<div class="col-xs-12" style="text-align: center;">
					<button class="btn btn-info" type="button"onclick="javascript:openAddCard();"style=" top: 0px;left: 0px; margin: auto; margin-top: 20px;  margin-bottom: 20px;"
						>绑定卡片</button>
				</div>
			</div>
		</div>

		<!-- /container -->



		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true"
			style="margin-left: 10px; margin-right: 10px;">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="margin-top: 30%;">
					<div class="modal-header" style="background-color: white;">
						<button class="close" type="button" data-dismiss="modal">×</button>
						<h5 id="myModalLabel">绑定卡片信息</h5>
					</div>
					<div class="modal-body" style="background-color: white;">
						<div class="row">
							<div class="col-xs-4"
								style="padding: 5px; font-size: 80%; text-align: right;">
								卡片类型：</div>
							<div class="col-xs-8">
								<select id="cardType" data-toggle="select"
									class="form-control select select-info mrs mbm"
									style="width: 90%; min-width: 100px;">
									<option value="0">一卡通</option>
									<option value="1">中石化加油卡</option>
									<option value="2">南航卡</option>
									<option value="3">中车卡</option>
								</select>
							</div>

							<div class="col-xs-4"
								style="padding: 0px 5px; font-size: 80%; text-align: right;">
								卡号：</div>
							<div class="col-xs-8">
								<input type="text" id="cardNumber" class="form-control"
									style="width: 90%; min-width: 100px;">
							</div>

						</div>
					</div>
					<div class="modal-footer" style="background-color: white;">
						<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
						<button class="btn btn-info" data-dismiss="modal"
							aria-hidden="true" onclick="javascript:addCard();">绑定</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 投诉与建议 -->
	</div>


	<div style="margin-bottom: 10px; text-align: center;">© 2015-2015
		XingHuoBan.com 版权所有</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/flat-ui.min.js"></script>
	<script src="js/application.js"></script>
	<script src="js/subString.js"></script>


	<script type="text/javascript">
		$(document).ready(function() {
			$("#yikatongA").hide();
			$("#zhongshihuaA").hide();
			$("#nanhangA").hide();
			$("#zhongcheA").hide();
			findAllChange();
			//获取客户微信名称、头像、账户信息
			getWalletBalance();
			//取绑卡信息
			getCustomerCardInfo();
		});
		function findAllChange() {

		}
		//获取客户微信名称、头像、账户信息
		function getWalletBalance() {
			$.ajax({
				type : "post",
				url : "customer_getCustomerInfoBySe.html",
				dataType : "json",
				aysnc : false,
				success : function(data) {
					var nickname = data.nickname;
					var customerData = data.result;
					var walletAccount = customerData.walletAccount;//账户号
					var customerPhone = customerData.customerPhone;//手机号
					var birthday = customerData.customerBirthday;//生日
					$("#nicknameShow").val(nickname);
					$("#walletAccountShow").val(walletAccount);
					$("#customerPhoneShow").val(customerPhone);
					$("#birthdayShow").val(birthday);
				}
			});
		}

		//取绑卡信息
		function getCustomerCardInfo() {
			$.ajax({
				type : "post",
				url : "customerCard_getCustomerCardByCustomerId.html",
				dataType : "json",
				aysnc : false,
				success : function(data) {
					var customerCardList = data.customerCardData;
					for (var i = 0; i < customerCardList.length; i++) {
						var customerCardMap = customerCardList[i];
						var cardType = customerCardMap.cardType;
						var cardNumber = customerCardMap.cardNumber;
						if (cardType == "0") {
							//点亮一卡通
							$("#yikatongA").show();
							$("#yikatongB").val(cardNumber);

						} else if (cardType == "1") {
							//点亮中石化加油卡
							$("#zhongshihuaA").show();
							$("#zhongshihuaB").val(cardNumber);
						} else if (cardType == "2") {
							//点亮南航卡
							$("#nanhangA").show();
							$("#nanhangB").val(cardNumber);
						} else if (cardType == "3") {
							//点亮中车
							$("#zhongcheA").show();
							$("#zhongcheB").val(cardNumber);
						}
					}
				}
			});
		}

		//打开添加卡片窗口
		function openAddCard() {
			$("#myModal").removeClass('hide');
			$("#myModal").modal('show');
		}

		//执行添加卡片信息
		function addCard() {
			var cardType = $("#cardType").val();
			var cardNumber = $("#cardNumber").val();

			if (cardNumber == "" || cardNumber == null
					|| cardNumber == undefined) {
				alert("卡号不能为空！");
				return;
			}

			$.ajax({
				type : "post",
				url : "customerCard_bindingCard.html",
				dataType : "json",
				aysnc : false,
				data : {
					"cardType" : cardType,
					"cardNumber" : cardNumber
				},
				success : function(data) {
					if (data.success) {
						alert(data.msg);
						//取绑卡信息
						getCustomerCardInfo();
					} else {
						alert("系统错误，请稍后重试！");
					}

				}
			});

		}
	</script>
</body>
</html>
