<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String goodsId = request.getParameter("goodsId"); %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>商品详情</title>
    <meta name="description" content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version."/>

    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0">
	
    <link href="css/bootstrap.min.css" rel="stylesheet">
	
    <link href="css/flat-ui.min.css" rel="stylesheet">
  </head>
  <body style="color:#000000;">
    <div class="container">
		<!--标题-->
		<div class="row navbar-fixed-top" style="text-align:center;border-bottom:1px solid #999999;background-color:#FFFFFF;">
			商品详情
		</div>
		<!--标题-->
		
		<!--商品图片（轮播）-->
        <div class="row" style="margin-top:31px;">
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators" id="goodsImageList1">
					
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox" id="goodsImageList2">
					
				</div>
			</div>
			<div id="noImageDiv">
				暂无图片
			</div>
		</div>
		<!--商品图片（轮播）-->
		
		<!--商品名称及价格-->
		<div class="row">
			<div class="col-xs-12">
				<input type="hidden" id="goodsId">
				<p style="margin:5px 0px;font-size:120%;" id="goodsName"></p>
			</div>
			<div class="col-xs-12" style="padding-top:6px;" id="goodsPrice">
			
			</div>
			<div class="col-xs-12" style="margin-top:10px;">
				<div class="col-xs-7">
					<div onclick="javascript:changeGoodsNum('p');" 
						style="background-color:#5DADE2;color:#FFFFFF;width:25px;height:25px;font-size:80%;margin-top:3px;
							font-weight:900;text-align:center;border-radius:15px;float:left;">
						+
					</div>
					<div style="float:left;width:80px;height:30px;text-align:center;">
						<input id="goodsNum" type="text" value="1" style="text-align:center;width:60px;height:30px;" readonly>
					</div>
					<div onclick="javascript:changeGoodsNum('m');" 
						style="background-color:#E74C3C;color:#FFFFFF;width:25px;height:25px;font-size:80%;margin-top:3px;
							font-weight:900;text-align:center;border-radius:15px;float:left;">
						-
					</div>
				</div>
				
				<div class="col-xs-5" style="text-align:center;">
					<button type="button" class="btn btn-danger" style="height:30px;padding-top:4px;"
						 onclick="javascript:addServiceGoodsToShoppingCart();">加入购物车</button>
				</div>
			</div>
		</div>
		<!--商品名称及价格-->
	</div> 
	<!-- /container -->
	
	<hr style="border:1px solid #999999;margin:5px 0px;height:3px;background-color:#999999;"/>
	
	<div class="container">
		<!--商品描述-->
		<div class="row" style="margin-bottom:50px;">
			<div class="col-xs-12"> 
				<span style="font-size:120%;font-weight:800;">商品属性</span>
			</div>
			<div class="col-xs-12"> 
				<span style="font-size:80%;" id="goodsIntroduce">
					
				</span>
			</div>
		</div>
		<!--商品描述-->
	</div> 
	<!-- /container -->
    

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
	<script src="js/carousel.js"></script>
	
	<script type="text/javascript">
	var goodsId = <%=goodsId%>;
	$(document).ready(function () {
		goodsId = <%=goodsId%>;
		$("#noImageDiv").hide();
		
		//根据商品id、商品种类查询商品详情
		showDetail();
	});

	function showDetail(){
		$.ajax({
			type : "post",
			url : "goods_getGoodsDetailByIdAndType.html",
			dataType : "json",
			data:{
				"goodsId" : goodsId,
				"goodsType" : "2"
			},
			aysnc : false,
			success : function(data){
				var goodsDetail = data.goodsDetail;
				//商品信息加载
				$("#goodsName").text(goodsDetail.goodsName);//商品名称
				$("#goodsPrice").empty();//商品价格
				var span = document.createElement("span");
				$(span).attr("style","font-size:80%;color:#FA0B0B;")
					.text("￥" + goodsDetail.goodsPrice + "元   " + goodsDetail.chargeUnit);
				$("#goodsPrice").append(span);
				
				$("#goodsIntroduce").text(goodsDetail.goodsIntroduce);//商品介绍
				
				//商品图片加载
				var goodsImageList = data.goodsImageList;
				if(goodsImageList != 0){
					$("#carousel-example-generic").show();
					$("#noImageDiv").hide();
					
					$("#goodsImageList1").empty();
					$("#goodsImageList2").empty();
					for(var i=0;i<goodsImageList.length;i++){
						var goodsImageData = goodsImageList[i];
						
						//第一部分
						var li = document.createElement("li");
						$(li).attr("data-target","#carousel-example-generic").attr("data-slide-to",i);
						if(i == 0){
							$(li).addClass("active");
						}
						$("#goodsImageList1").append(li);
						
						//第二部分
						var div = document.createElement("div");
						$(div).addClass("item");
						var img = document.createElement("img");
						$(img).attr("src",goodsImageData.imagePath)
							.attr("style","width:100%;height:180px;").appendTo(div);
						
						if(i == 0){
							$(div).addClass("active");
						}
						$("#goodsImageList2").append(div);
					}
				}else{
					//显示暂无图片画面
					$("#carousel-example-generic").hide();
					$("#noImageDiv").show();
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
	
	//点击增加或者减少商品数量
	function changeGoodsNum(type){
		var goodsNum = $("#goodsNum").val();
		if(type == "p"){
			//点击添加商品
			goodsNum = parseInt(goodsNum) + 1;
			$("#goodsNum").val(goodsNum);
		}else{
			//点击减少商品
			if(goodsNum == 1){
				alert("商品数量不能小于1");
			}else{
				goodsNum = parseInt(goodsNum) - 1;
				$("#goodsNum").val(goodsNum);
			}
		}
	}
	
	//添加服务类商品进购物车
	function addServiceGoodsToShoppingCart(){
		$.ajax({
			type : "post",
			url : "shoppingCart_addGoodsToShoppingCart.html",
			dataType : "json",
			data:{
				"goodsId" : goodsId,
				"goodsNum" : $("#goodsNum").val()
			},
			aysnc : false,
			success : function(data){
				if(data.success == true || data.success == "true"){
					alert("添加成功！");
				}
			}
		});
	}
	</script>
  </body>
</html>
