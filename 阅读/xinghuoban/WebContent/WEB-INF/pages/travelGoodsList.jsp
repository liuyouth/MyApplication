<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>商品列表</title>
    <meta name="description" content="Flat UI Kit Free is a Twitter Bootstrap Framework design and Theme, this responsive framework includes a PSD and HTML version."/>

    <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0">
	
    <link href="css/bootstrap.min.css" rel="stylesheet">
	
    <link href="css/flat-ui.min.css" rel="stylesheet">
  </head>
  <body style="color:#000000;">
    <div class="container">
		<!--标题-->
		<div class="row navbar-fixed-top" style="text-align:center;border-bottom:1px solid #999999;background-color:#FFFFFF;">
			商品列表
		</div>
		<!--标题-->
		
		<!--一级菜单-->
        <div class="row" style="margin-top:31px;">
			<ul class="nav nav-tabs" id="firstMenuUl" style="margin-top:5px;margin-left:5px;">
				
			</ul>
		</div>
		<!--一级菜单-->
		
		<!--内容-->
		<div class="row">
		
			<!--二级菜单-->
			<div class="col-xs-3" style="padding:0px 3px;">
				<ul class="list-group" id="secondMenuUl" style="font-size:14px;text-align:center;">
					
				</ul>
			</div>
			<!--二级菜单-->
			
			<!--选择的菜单id-->
			<input type="hidden" id="getGoodsCatalogId" value="4">
			<!--选择的菜单id-->
			
			<!--商品列表-->
			<div class="col-xs-9 goodsShowDiv">
				
			</div>
			<!--商品列表-->
			<!--分页-->
			<input type="hidden" id="nowPage" value="1">
			<div id="pagePanel" class="row pageNumDiv" style="margin:20px auto 25px auto;">
			</div>
			<!--分页-->
			
			<!--无数据-->
			<div class="col-xs-9 noDataDiv">
				<div style="margin:10px auto;color:#999999;font-size:150%;font-weight:900;text-align:center;">
					暂无数据！
				</div>
			</div>
			<!--无数据-->
			
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
	$(document).ready(function () {
		//无数据div隐藏
		$(".noDataDiv").hide();
		$(".goodsShowDiv").hide();
		$(".pageNumDiv").hide();
		
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
					
					var currentParentCatalogId = 0;
					for(var i=0;i<firstMenuDataList.length;i++){
						var firstMenuData = firstMenuDataList[i];
						
						var goodsCatalogId = firstMenuData[0];
						var parentCatalogId = firstMenuData[1];
						var goodsCatalogName = firstMenuData[2];
						var goodsCatalogStatus = firstMenuData[3];
						
						var li = document.createElement("li");
						if(i == 0){
							$(li).addClass("active");
							currentParentCatalogId = goodsCatalogId;
						}
						$(li).attr("id","firstMenu_"+goodsCatalogId)
							.attr("onclick","javascript:changeTopBtn("+i+");");
						var a = document.createElement("a");
						$(a).attr("href","javascript:void(0);").text(goodsCatalogName).appendTo(li);
						
						$("#firstMenuUl").append(li);
					}
					//购物车li
					var li = document.createElement("li");
					$(li).attr("id","shoppingCartBtn")
						.attr("onclick","javascript:changeTopBtn(3);");
					var a = document.createElement("a");
					$(a).attr("href","javascript:void(0);").text("购物车").appendTo(li);
					
					$("#firstMenuUl").append(li);
					
					//加载二级菜单
					$.ajax({
						type : "post",
						url : "catalog_querySecondMenuListByParentId.html",
						dataType : "json",
						data : {
							parentCatalogId : currentParentCatalogId
						},
						aysnc : false,
						success : function(data){
							var secondMenuDataList = data.secondMenuList;
							if(secondMenuDataList.length != 0){
								//有二级目录数据
								$("#secondMenuUl").empty();
								for(var i=0;i<secondMenuDataList.length;i++){
									var secondMenuData = secondMenuDataList[i];
									
									var goodsCatalogId = secondMenuData[0];
									var parentCatalogId = secondMenuData[1];
									var goodsCatalogName = secondMenuData[2];
									var goodsCatalogStatus = secondMenuData[3];
									
									var li = document.createElement("li");
									if(i == 0){
										$("#getGoodsCatalogId").val(goodsCatalogId);
										$(li).addClass("active");
									}
									$(li).addClass("list-group-item secondList").attr("id","catalogId_"+goodsCatalogId)
										.attr("style","padding:3px 0px;cursor:pointer;")
										.attr("onclick","javascript:changeSecondList(this);")
										.text(goodsCatalogName);
									$("#secondMenuUl").append(li);
								}
								
								//加载商品列表页面数据
								showData();
								
							}else{
								//无二级目录数据
								alert("系统错误，请稍后重试！");
							}
						}
					});
				}else{
					alert("系统错误，请稍后重试！");
				}
			}
		});
		
	}
	//加载商品列表页面数据
	function showData(){
		//清空之前显示的商品列表
		$(".goodsShowDiv").empty();
		$.ajax({
			type : "post",
			url : "goods_findGoodsListByTypeAndStatus.html",
			dataType : "json",
			data:{
				"goodsType" : "2",
				"goodsSalesStatus" : "2",
				"goodsCatalogId" : $("#getGoodsCatalogId").val(),
				"page" : $('#nowPage').val()
			},
			aysnc : false,
			success : function(data){
				var total = data.total;
				var goodsList = data.goodsList;
				if(goodsList != null && goodsList != ""){
					//后台查询的数据不为空
					//页面显示商品列表
					$(".goodsShowDiv").show();
					$(".pageNumDiv").show();
					pageShow(total);
					
					//页面商品列表div隐藏
					$(".noDataDiv").hide();
					
					//页面加载
					for(var i=0;i<goodsList.length;i++){
						var goodsData = goodsList[i];
						var rowDiv = document.createElement("div");
						$(rowDiv).addClass("row").attr("onclick","javascript:jumpToDetail("+goodsData.goodsId+");")
							.attr("style","border:1px solid #999999;");
						
						var imgDiv = document.createElement("div");
						$(imgDiv).addClass("col-xs-5").attr("style","padding:5px;").appendTo(rowDiv);
						var img = document.createElement("img");
						$(img).attr("src",goodsData.imagePath).attr("style","width:80px;height:80px;")
							.appendTo(imgDiv);
						
						var dataDiv = document.createElement("div");
						$(dataDiv).addClass("col-xs-7").appendTo(rowDiv);
						
						var nameDiv = document.createElement("div");
						$(nameDiv).addClass("row").appendTo(dataDiv);
						var nameSpan = document.createElement("span");
						$(nameSpan).attr("style","font-size:80%;").text(goodsData.goodsName).appendTo(nameDiv);
						
						var introduceDiv = document.createElement("div");
						$(introduceDiv).addClass("row").appendTo(dataDiv);
						var introduceP = document.createElement("p");
						$(introduceP).attr("style","font-size:8px;color:#666666;margin:3px 0px;")
							.text(goodsData.goodsIntroduce).appendTo(introduceDiv);
						var goodsIntroduce = goodsData.goodsIntroduce;
						var length = goodsIntroduce.strLen();
						
						if(length > 20){
							goodsIntroduce = goodsIntroduce.subCHString(0, 18);
							$(introduceP).text(goodsIntroduce+"...");
						}else{
							$(introduceP).text(goodsIntroduce);
						}
						
						var priceDiv = document.createElement("div");
						$(priceDiv).addClass("row").appendTo(dataDiv);
						var priceSpan = document.createElement("span");
						$(priceSpan).attr("style","font-size:8px;color:#FA0B0B;")
							.text("￥"+goodsData.goodsPrice+"元   "+goodsData.chargeUnit).appendTo(priceDiv);
						
						$(".goodsShowDiv").append(rowDiv);
					}
				}else{
					//后台查询的数据为空
					//页面提示商品信息为空
					$(".noDataDiv").show();
					//页面商品列表div隐藏
					$(".goodsShowDiv").hide();
					$(".pageNumDiv").hide();
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
	
	//点击二级菜单
	function changeSecondList(list){
		var listId = list.id;
		var goodsCatalogId = listId.split("_")[1];
		$("#getGoodsCatalogId").val(goodsCatalogId);
		//改变页面显示
		$(".secondList").removeClass("active");
		$("#"+list.id).addClass("active");
		//然后根据分类去查询商品信息
		showData();
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
	
	//跳转到商品详情页面
	function jumpToDetail(goodsId){
		window.location.href="page_pageJump.html?pageName=serviceGoodsDetail&goodsId="+goodsId;
	}
	</script>
  </body>
</html>
