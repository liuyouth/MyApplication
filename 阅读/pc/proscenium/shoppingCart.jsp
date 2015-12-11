<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		
		<!--内容-->
		<div class="row" style="margin-top:10px;width: 100%;background-color: white; border-radius:5px;">
			
			<!--购物车列表-->
			<div class="col-xs-12" id="shoppingCartListDiv">
				
			</div>
			<!--购物车列表-->
			<div class="col-xs-12">
				<div class="row" style="margin-top: 10px;margin-bottom: 10px;">
				<div class="col-xs-2" style="margin:0px;padding:0px;text-align:center;">
					<!-- <label class="radio primary" style="margin-left:15px;" onclick="javascript:getAllRadio();">
						<input type="radio" data-toggle="radio" name="optionsRadios" id="allGetRadio" value="option1" data-radiocheck-toggle="radio" checked>
						全选
					</label> -->
					<div style="display: inline;">
						<input type="checkbox" id="allGetRadio" checked 
							style="padding-top:10px;width:20px;height:20px;" 
							onclick="javascript:getAllRadio();">
					</div>
					<div style="display: inline;  padding-left: 10px;">全选</div>
				</div>
				<div class="col-xs-6" style="text-align:left;">
					<button type="button" class="btn btn-link" onclick="javascript:deleteShoppingCart();">删除</button>
				</div>
				<div class="col-xs-2" style="margin:0px;padding-top:8px;  text-align: right;">
					合计:￥<span style="color:red" id="allMoney">0</span>元
					
				</div>
				<div class="col-xs-2" style="text-align:center;">
					<button type="button" class="btn btn-info" onclick="javasceipt:markOrder();">结算</button>
				</div>
			</div>
			</div>
		</div>
		
		<!--内容-->
		
    </div> <!-- /container -->
    
    <script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
    <script src="js/application.js"></script>
	<script src="js/subString.js"></script>
	<script src="js/page.js"></script>
	   
    <!-- 引入导航 TOP以及摇一摇 JS -->
	<script src="js/change_mark.js"></script> 
	<script type="text/javascript">
	var goodsList = "";
	var allMoneyA = 0;
	$(document).ready(function () {
		//加载菜单数据
		//initMenu();
		findAllChange();
		//加载购物车数据
		showData();
	});
	
	//加载购物车数据列表
	function showData(){
		$.ajax({
			type : "post",
			url : "shoppingCart_getShoppingCartGoodsList.html",
			dataType : "json",
			aysnc : false,
			success : function(data){
				goodsList = data.goodsList;
				
				$("#shoppingCartListDiv").empty();
				for(var i=0;i<goodsList.length;i++){
					var goodsData = goodsList[i];
					
					var goodsPrice = goodsData.goodsPrice;
					var goodsNum = goodsData.goodsNum;
					
					var rowDiv = document.createElement("div");
					$(rowDiv).addClass("row").attr("style","border-bottom:1px solid #d7d7d7;");
					
					var checkBoxDiv = document.createElement("div");
					$(checkBoxDiv).addClass("col-xs-2")
						.attr("style","text-align:center;padding-top:20px;")
						.appendTo(rowDiv);
					var checkBoxInput = document.createElement("input");
					$(checkBoxInput).addClass("goodsCheckbox").attr("id","goodsId_"+goodsData.goodsId)
						.attr("type","checkbox").attr("style","width:20px;height:20px;")
						.attr("onclick","javascript:CalculatePrice("+goodsData.goodsId+","+goodsData.goodsPrice+");")
						.attr("checked","").appendTo(checkBoxDiv);
					
					/*var strDiv = '<label class="checkbox" for="goodsId_'+goodsData.goodsId+'" style="">'
						+'<input type="checkbox" style="background-color:#1abc9c;width:20px;height:20px;" data-toggle="radio" value="" id="goodsId_'+goodsData.goodsId+'" checked required></label>';
					$(checkBoxDiv).append(strDiv);*/
					
					var imgDiv = document.createElement("div");
					$(imgDiv).addClass("col-xs-4").attr("style","padding:5px;")
						.appendTo(rowDiv);
					var img = document.createElement("img");
					$(img).attr("src",goodsData.imagePath)
						.attr("style","width:80px;height:80px;").appendTo(imgDiv);
					
					var goodsDetailDiv = document.createElement("div");
					$(goodsDetailDiv).addClass("col-xs-6").attr("style","padding-top: 20px;").appendTo(rowDiv);
					var nameDiv = document.createElement("div");
					$(nameDiv).addClass("row").appendTo(goodsDetailDiv);
					var nameSpan = document.createElement("span");
					$(nameSpan).attr("style","font-size:80%;")
						.text(goodsData.goodsName).appendTo(nameDiv);
					
					var p_mDiv = document.createElement("div");
					$(p_mDiv).addClass("row").appendTo(goodsDetailDiv);
					var pDiv = document.createElement("div");
					$(pDiv).attr("onclick","javascript:changeGoodsNum('p',"+goodsData.goodsId+","+goodsData.goodsPrice+");")
						.attr("style","background-color:#5DADE2;color:#FFFFFF;width:20px;height:20px;font-size:130%;font-weight:900;text-align:center;border-radius:20px;float:left;cursor: pointer;")
						.text("+").appendTo(p_mDiv);
					var numberDiv = document.createElement("div");
					$(numberDiv).attr("style","float:left;width:80px;height:20px;padding-top:0px;text-align:center;")
						.appendTo(p_mDiv);
					var numberInput = document.createElement("input");
					$(numberInput).attr("style","text-align:center;width:60px;height:20px;")
						.attr("id","goodsNum_"+goodsData.goodsId).attr("type","text").attr("value",goodsData.goodsNum)
						.attr("readonly","true").appendTo(numberDiv);
					var mDiv = document.createElement("div");
					$(mDiv).attr("onclick","javascript:changeGoodsNum('m',"+goodsData.goodsId+","+goodsData.goodsPrice+");")
						.attr("style","background-color:#E74C3C;color:#FFFFFF;width:20px;height:20px;font-size:130%;font-weight:900;text-align:center;border-radius:20px;float:left;cursor: pointer;")
						.text("-").appendTo(p_mDiv);
					
					var goodsPriceDiv = document.createElement("div");
					$(goodsPriceDiv).addClass("row").appendTo(goodsDetailDiv);
					var input = document.createElement("input");
					$(input).attr("type","hidden").attr("id","usedPrice_" + goodsData.goodsId).appendTo(goodsPriceDiv);
					/* var span = document.createElement("span");
					$(span).attr("style","font-size:80%;color:#FA0B0B;")
						.text("￥" + goodsData.goodsPrice + "元   " + goodsData.chargeUnit).appendTo(goodsPriceDiv); */
						
					var usedPrice = 0;
					var goodsPreferentialId = goodsData.goodsPreferentialId;//商品优惠id
					if(goodsPreferentialId != "" && goodsPreferentialId != null){
						//商品优惠信息不为空
						var oldPriceSpan = document.createElement("span");
						$(oldPriceSpan).attr("style","font-size:8px;color:#FA0B0B;").appendTo(goodsPriceDiv);
						var s = document.createElement("s");
						$(s).text("￥"+goodsData.goodsPrice+"元").appendTo(oldPriceSpan);
						
						var newPriceSpan = document.createElement("span");
						$(newPriceSpan).attr("style","font-size:8px;color:#FA0B0B;margin-left:5px;").appendTo(goodsPriceDiv);
						var preferentialType = goodsData.preferentialType;//优惠类型 0：打折 1：团购
						if(preferentialType == "0"){
							//打折
							var discount = goodsData.discount;
							var newPrice = goodsData.goodsPrice * discount / 10;
							$(newPriceSpan).text("￥"+ newPrice +"元   "+goodsData.chargeUnit);
							
							usedPrice = newPrice;
							$(input).attr("value",newPrice);
							
						}else if(preferentialType == "1"){
							//团购
							$(newPriceSpan).text("￥"+ goodsData.groupPrice +"元   "+goodsData.chargeUnit);
							usedPrice = goodsData.groupPrice;
							$(input).attr("value",goodsData.groupPrice);
						}
						
					}else{
						var priceSpan = document.createElement("span");
						$(priceSpan).attr("style","font-size:8px;color:#FA0B0B;")
							.text("￥"+goodsData.goodsPrice+"元   "+goodsData.chargeUnit).appendTo(goodsPriceDiv);
						
						usedPrice = goodsData.goodsPrice
						$(input).attr("value",goodsData.goodsPrice);
					}
					
					$("#shoppingCartListDiv").append(rowDiv);
					
					allMoneyA = (parseFloat(allMoneyA) + parseInt(goodsNum) * parseFloat(usedPrice)).toFixed(2);
				}
				
				$("#allMoney").text(allMoneyA);
			}
		});
		
	}
	
	//点击增加或者减少商品数量
	function changeGoodsNum(type,goodsId,goodsPrice){
		var goodsNum = $("#goodsNum_"+goodsId).val();
		goodsPrice = $("#usedPrice_" +goodsId).val();
		
		var allMoney = $("#allMoney").text();
		if(type == "p"){
			//点击添加商品
			goodsNum = parseInt(goodsNum) + 1;
			$("#goodsNum_"+goodsId).val(goodsNum);
			
			if($("#goodsId_"+goodsId).prop("checked")){
				$("#allMoney").text((parseFloat(allMoney) + parseFloat(goodsPrice)).toFixed(2));
			}
			
		}else{
			//点击减少商品
			if(goodsNum == 1){
				alert("商品数量不能小于1");
			}else{
				goodsNum = parseInt(goodsNum) - 1;
				$("#goodsNum_"+goodsId).val(goodsNum);
				
				if($("#goodsId_"+goodsId).prop("checked")){
					$("#allMoney").text((parseFloat(allMoney) - parseFloat(goodsPrice)).toFixed(2));
				}
				
			}
		}
	}
	
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
	
	//点击全选按钮
	function getAllRadio(){
		if($("#allGetRadio").prop("checked")){
			//点击执行了全选
			$(".goodsCheckbox").prop("checked","true");
			
			//算价格
			var allMoney = 0;
			for(var i=0;i<goodsList.length;i++){
				var goodsData = goodsList[i];
				
				//var goodsPrice = goodsData.goodsPrice;
				var goodsPrice = $("#usedPrice_" +goodsData.goodsId).val();
				var goodsNum = $("#goodsNum_"+goodsData.goodsId).val();
				
				
				allMoney = (parseFloat(allMoney) + parseInt(goodsNum)*parseFloat(goodsPrice)).toFixed(2);
			}
			$("#allMoney").text(allMoney);
		}else{
			//点击执行了全部取消
			$(".goodsCheckbox").removeAttr("checked");
			
			$("#allMoney").text(0);
		}
		
	}
	
	//算单个商品的价格
	function CalculatePrice(goodsId,goodsPrice){
		var goodsNum = $("#goodsNum_"+goodsId).val();
		goodsPrice = $("#usedPrice_" +goodsId).val();
		var allMoney = $("#allMoney").text();
		
		if($("#goodsId_"+goodsId).prop("checked")){
			$("#allMoney").text((parseFloat(allMoney) + parseInt(goodsNum)*parseFloat(goodsPrice)).toFixed(2));
		}else{
			$("#allMoney").text((parseFloat(allMoney) - parseInt(goodsNum)*parseFloat(goodsPrice)).toFixed(2));
		}
		
		var checkAll = true;//商品全部勾选标记
		var uncheckAll = true;//商品全部没有勾选标记
		for(var i=0;i<goodsList.length;i++){
			var goodsData = goodsList[i];
			var goodsId = goodsData.goodsId;
			if(!$("#goodsId_"+goodsId).prop("checked")){
				//该商品被勾选了
				checkAll = false;
			}else{
				uncheckAll = false;
			}
		}
		if(checkAll){
			$("#allGetRadio").prop("checked","true");
		}
		if(uncheckAll){
			$("#allGetRadio").removeAttr("checked");
		}
		
	}
	
	//生成订单并执行结算
	function markOrder(){
		//获取选中的商品
		var goodsIds = "";//选中的商品
		var goodsNums = "";//商品对应的数量
		
		var allMoney = $("#allMoney").text();
		for(var i=0;i<goodsList.length;i++){
			var goodsData = goodsList[i];
			
			var goodsId = goodsData.goodsId;
			if($("#goodsId_"+goodsId).prop("checked")){
				//该商品被勾选了
				var goodsNum = $("#goodsNum_"+goodsId).val();
				if(goodsIds == ""){
					goodsIds = goodsId;
					goodsNums = goodsNum;
				}else{
					goodsIds = goodsIds + "," + goodsId; 
					goodsNums = goodsNums + "," + goodsNum;
				}
			}
		}
		
		if(goodsIds == "" || goodsIds == null || goodsIds == undefined){
			alert("请选择需要结算的商品！");
			return;
		}
		//查询商品库存
		$.ajax({
			type : "post",
			url : "goods_queryGoodsInventories.html",
			dataType : "json",
			aysnc : false,
			data:{
				"goodsIds":goodsIds,
				"goodsNums":goodsNums
			},
			success : function(data){
				//购物车所有商品库存数组
				var allInventories=data.allInventories;
				var allGoodsName=data.allGoodsName;
				
				var inventoriesArr=allInventories.split(",");
				var goodsNameArr=allGoodsName.split(",");
				var goodsNumArr=goodsNums.split(",");
				
				var flag=true;
				
				$.each(goodsNumArr, function(index, goodsNum) { 
					var goodsNumInt=parseInt(goodsNum);
					var inventoriesInt=parseInt(inventoriesArr[index]);
					 if(inventoriesInt!=-1){//-1为核销类商品，支付时生成消费码
						 if(goodsNumInt>inventoriesInt){
							 var goodsName=goodsNameArr[index];
							 alert("抱歉，["+goodsName+"]库存不足");
							 flag=false;
						 }
					 }
				});
				if(flag){
					//跳转到提交订单页面
					window.location.href="page_pageJump.html?pageName=pcSubmitOrder&goodsIds="
								+goodsIds+"&goodsNums="+goodsNums+"&totalPrice="+allMoney;
				}
			}
		})
		
		
	}
	
	//删除购物车
	function deleteShoppingCart(){
		var goodsIds = "";//选中的商品
		for(var i=0;i<goodsList.length;i++){
			var goodsData = goodsList[i];
			
			var goodsId = goodsData.goodsId;
			if($("#goodsId_"+goodsId).prop("checked")){
				//该商品被勾选了
				var goodsNum = $("#goodsNum_"+goodsId).val();
				if(goodsIds == ""){
					goodsIds = goodsId;
					goodsNums = goodsNum;
				}else{
					goodsIds = goodsIds + "," + goodsId; 
					goodsNums = goodsNums + "," + goodsNum;
				}
			}
		}
		
		if(goodsIds == "" || goodsIds == null || goodsIds == undefined){
			alert("请选择需要删除的商品！");
			return;
		}
		
		$.ajax({
			type : "post",
			url : "shoppingCart_deleteShoppingCartGoodsByGoodsId.html",
			dataType : "json",
			aysnc : false,
			data : {
				"goodsIdsStr" : goodsIds
			},
			success : function(data){
				alert(data.msg);
				//加载购物车数据
				//showData();
				location.reload();
			}
		});
	}
	
	//点击底部按钮
	function changeBottomBtn(type){
		//根据type判断跳转页面
		if(type == 1){
			window.location.href="page_pageJump.html?pageName=serviceGoodsList"; //出行类商品
		}else if(type == 2){
			window.location.href="page_pageJump.html?pageName=activityList"; //活动列表
		}else if(type == 3){
			window.location.href="page_pageJump.html?pageName=accountCenter"; //账户中心
		}else if(type == 4){
			window.location.href="page_pageJump.html?pageName=shoppingCart"; //购物车
		}
	}
	
	</script>
  </body>
</html>
