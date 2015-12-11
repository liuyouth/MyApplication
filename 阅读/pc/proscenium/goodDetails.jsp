<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<% String goodsId = request.getParameter("goodsId"); %>

    <meta charset="utf-8">
    <title>行伙伴-专享告知</title>
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
tr{
	
	line-height:30px;
	
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
                <li class="active"><a href="http://localhost:8080/xinghuoban/page_pageJump.html?pageName=travel" title="出行">出行</a></li>
                <li><a href="http://localhost:8080/xinghuoban/page_pageJump.html?pageName=preferential#" title="优惠专享">优惠专享</a></li>
                <li><a href="<%=basePath %>page_pageJump.html?pageName=personalCenter"  title="个人中心">个人中心</a></li>
              
            </ul>
        </nav>
        
      

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
     
         
        <div id="top" class="top">
        	<img style="margin: 5px;width: 80%;" alt="" src="images/top.png">
        </div>
        
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
     
     <div class="container ppt-12">
            <ul id="ListDiv"  class="voices-list cf">
                 <li style="width:100%; height:100% ;background-color:#fff;">
                    
                <div style="text-align: center; margin-top:15px;">
                 <img style="width:50%; height:50%; float:left;" src="http://echo-image.qiniucdn.com/FuRVDTEyEU4KsTPVNOKa8j69aY-z?imageMogr2/thumbnail/!200x200r/gravity/Center/crop/200x200/dx/0/dy/0" alt="voice-cover">
                 </div>
                <div style="text-align: center; margin-top:15px;">
               	 	<span style="font-size: xx-large;">商品名字</span>
               	 	<hr>
	               	<div style="height:250px; margin:10px;">
	               		<div style="margin:10px;">
	               	 		<span style="font-size: xx-large;">商品介绍</span>
			            </div>
	               		<div style="margin:10px;">
	               	 		<span style="font-size: large;">商属性</span>
			            </div>
	               	 
	                </div>
               	 	<hr>
                    <div style=" font-size: large; ">
                        <span>价格</span><span>价格</span>
                    </div>
                    <div class="ui-status cf" style="bottom:20px;margin: 0 auto;text-align: center;padding-top: 90px; ">
                       	<img id="" style="width: 22px; margin-bottom:4px;vertical-align:bottom;"alt="" src="images/pc/jian.png">
                   		<input id="goodsNumber" style="width: 100px;margin-left: 10px;">
                        <img id="" style="width: 22px; margin-bottom:4px; margin-left: 10px;vertical-align:bottom;"alt="" src="images/pc/jia.png">
                       	<button id="addToCat" style="margin-left: 100px;border-radius: 5px;background-color: #DC3D10;font-size: medium;padding: 7px;color: #fff;border: 0;">加入购物车</button>
                    </div>
                </div>
                        
                       
                    
                </li>
                           
            </ul>
      </div>
     
       
	</div>
	<div  style="margin-bottom:10px;text-align: center;">
	       © 2015-2015 XingHuoBan.com 版权所有
       </div>
 

	<script src="js/jquery.min.js"></script>
    <script src="js/flat-ui.min.js"></script>
    <script src="js/application.js"></script>
	<script src="js/subString.js"></script>
	

	<script type="text/javascript">
	var goodsId = <%=goodsId%>;
	var goodNumber = 1;
	$(document).ready(function () {
		//根据商品id、商品种类查询商品详情
		showDetail();
		$("#ListDiv").empty();
	});
	
	$(function(){
		$('.carousel').carousel({
		interval: 3000
		});
		});
	function showDetail(){
		$.ajax({
			type : "post",
			url : "goods_getGoodsDetailByIdAndType.html",
			dataType : "json",
			data:{
				"goodsId" : goodsId,
				
			},
			aysnc : false,
			success : function(data){
				var goodsDetail = data.goodsDetail;
				var goodsImageList = data.goodsImageList;
				var goodsImageData = goodsImageList[1];
				var preferentialType = goodsDetail.preferentialType;//优惠类型 0：打折 1：团购
			
				
				
				var li = '<li style="width:100%; height:100% ;background-color:#fff;">';
	                li += '<div style="text-align: center; margin-top:15px;">';
					li += '<img style="width:50%; height:50%; float:left;" src="http://echo-image.qiniucdn.com/FuRVDTEyEU4KsTPVNOKa8j69aY-z?imageMogr2/thumbnail/!200x200r/gravity/Center/crop/200x200/dx/0/dy/0" alt="voice-cover">';
					li += '</div>';
					li += '<div style="text-align: center; margin-top:15px;">';
					li += '<span style="font-size: xx-large;">'+goodsDetail.goodsName+'</span>';
					li += '<hr>';
					li += '<div style="height:220px; margin:10px;">';
					li += '<div style="margin:10px;">';
					li += '<span style="font-size: xx-large;">商品介绍</span>';
					li += '</div>';
					li += '<div style="margin:10px;">';
					li += '<span style="font-size: large;">'+goodsDetail.goodsIntroduce+'</span>';
					li += '</div>';
					li += '</div>';
					li += '<hr>';
					li += '<div style=" font-size: large; margin-bottom: 10px; text-align:start;padding-left:520px">';
					
					
					
					li += '<TABLE style=" BORDER-COLLAPSE: collapse" borderColor=#000000 height=40 cellPadding=1 align=center bgColor=#fffbec border=0>';
					li += '<TBODY>';
					li += '<TR>';
					
					
					if("0"==goodsDetail.goodsType){
							if("" != goodsDetail.discount && typeof goodsDetail.discount != "object"){
								
								li += '<td><div style=" font-size: 14px;">售价</div></td>';
								li += '<td><div style="font-size:14px;text-decoration:line-through; margin-left:24px;">￥'+goodsDetail.goodsPrice+'</div></TD></TR>';
								li += '<TR><td><div style=" font-size: 14px;">折后价</div></td>';
								li += '<td><div style="color:#c40000;font-size:22px;">￥'+goodsDetail.goodsPrice*goodsDetail.discount/10+'</div></TD></TR>';
							
							}else if("" != goodsDetail.groupPrice && typeof goodsDetail.groupPrice != "object"){
								
								li += '<td><div style=" font-size: 14px;">售价</div></td>';
								li += '<td><div style="font-size:14px;text-decoration:line-through; margin-left:24px;">￥'+goodsDetail.goodsPrice+'</div></TD></TR>';
								li += '<td><div style=" font-size: 14px;">团购价</div></td>';
								li += '<td><div style="color:#c40000;font-size:30px;">￥'+goodsDetail.groupPrice+'</div></TD></TR>';
								
							}else{
								li += '<TR><td><div style=" font-size: 14px;">售价</div></td>';
								li += '<td><div style="color:#c40000;font-size:22px;">￥'+goodsDetail.goodsPrice+'</div></TD></TR>';
									
							}
							
							li += '<TR><td><div style=" font-size: 14px;">累计销量</div></td>';
							li += '<td><div style="font-size:18px;margin-left:24px;">'+goodsDetail.sold+'</div></TD></TR>';
							li += '<TR><td><div style=" font-size: 14px;">服务热线</div></td>';
							li += '<td><div style="color:#6ebe2f;font-size:30px;">'+goodsDetail.serviceHotline+'</div></TD></TR></TBODY></TABLE>';
							//li += '<span>售价</span><span style="color:#e4393c">￥'+goodsDetail.goodsPrice+'</span>';
							li += '</div>';
							li += '<div class="ui-status cf" style="bottom:20px;margin: 0 auto;text-align:center;padding-top:0px;">';
							li += '<img onclick="sub()" id="subtract" style="width: 22px; margin-bottom:4px;vertical-align:bottom;"alt=""src="images/pc/jian.png">';
							li += '<input id="goodNumber" style="text-align:center; width: 100px;margin-left: 10px;" onkeypress="number()" onkeyup="filterInput()" onchange="filterInput()" onbeforepaste="filterPaste()" onpaste="return false" style="ime-mode: disabled">';
							li += '<img onclick="adda()" id="add" style="width: 22px; margin-bottom:4px; margin-left:10px;vertical-align:bottom;"alt="" src="images/pc/jia.png">';
							if("0"==goodsDetail.goodsType){
							li += '<font style="margin-left: 10px; color:rgba(163, 163, 169, 1)">剩余库存'+goodsDetail.inventories+goodsDetail.chargeUnit+'</font>';
								}
							li += '<button id="addToCat" style="margin-left: 80px;border-radius: 5px;background-color:#DC3D10;font-size: medium;padding: 7px;color: #fff;border:0;" onclick="javascript:addGoodsToShoppingCart();">加入购物车</button>';
							li += '</div>';
							li += '</div>';
							li += '</li>';
						}else{
								
							if("" != goodsDetail.discount && typeof goodsDetail.discount != "object"){
								
								li += '<td><div style=" font-size: 14px; margin-left:24px">售价</div></td>';
								li += '<td><div style="font-size:14px;text-decoration:line-through; margin-left:24px;">￥'+goodsDetail.goodsPrice+'</div></TD>';
								li += '<td><div style=" font-size: 14px; margin-left:24px">折后价</div></td>';
								li += '<td><div style="color:#c40000;font-size:22px;">￥'+goodsDetail.goodsPrice*goodsDetail.discount/10+'</div></TD>';
							
							}else if("" != goodsDetail.groupPrice && typeof goodsDetail.groupPrice != "object"){
								
								li += '<td><div style=" font-size: 14px;  margin-left:24px">售价</div></td>';
								li += '<td><div style="font-size:14px;text-decoration:line-through; margin-left:24px;">￥'+goodsDetail.goodsPrice+'</div></TD>';
								li += '<td><div style=" font-size: 14px;  margin-left:24px">团购价</div></td>';
								li += '<td><div style="color:#c40000;font-size:22px;">￥'+goodsDetail.groupPrice+'</div></TD>';
								
							}else{
								li += '<td><div style=" font-size: 14px;  margin-left:24px">售价</div></td>';
								li += '<td><div style="color:#c40000;font-size:22px;">￥'+goodsDetail.goodsPrice+'</div></TD>';
									
							}
							
								li += '<td><div style=" font-size: 14px;  margin-left:24px">累计销量</div></td>';
								li += '<td><div style="font-size:18px;margin-left:24px;">'+goodsDetail.sold+'</div></TD>';
								li += '<td><div style=" font-size: 14px;  margin-left:24px">服务热线</div></td>';
								li += '<td><div style="color:#6ebe2f;font-size:22px;">'+goodsDetail.serviceHotline+'</div></TD></TR>';
								li += '<tr><td><div style=" font-size: 14px;  margin-left:10px">出行时间</div></td><td><input style=" font-size: 14px;width: 70px; height:22px;";></td><td><div style=" font-size: 14px;  margin-left:10px">出行时间</div></td><td><input style=" font-size: 14px;width: 70px; height:22px;";></td><td><div style=" font-size: 14px;  margin-left:10px">出行时间</div></td><td><input style=" font-size: 14px;width: 70px; height:22px;";></td></tr>';
								li += '<tr><td><div style=" font-size: 14px;  margin-left:10px">出行时间</div></td><td><input style=" font-size: 14px;width: 70px; height:22px;";></td><td><div style=" font-size: 14px;  margin-left:10px">出行时间</div></td><td><input style=" font-size: 14px;width: 70px; height:22px;";></td></tr>';
								li += '</TBODY></TABLE>';
								//li += '<span>售价</span><span style="color:#e4393c">￥'+goodsDetail.goodsPrice+'</span>';
								li += '</div>';
								li += '<div class="ui-status cf" style="bottom:20px;margin: 0 auto;text-align:center;padding-top:0px;">';
								li += '<img onclick="sub()" id="subtract" style="width: 22px; margin-bottom:4px;vertical-align:bottom;"alt=""src="images/pc/jian.png">';
								li += '<input id="goodNumber" style="text-align:center; width: 100px;margin-left: 10px;" onkeypress="number()" onkeyup="filterInput()" onchange="filterInput()" onbeforepaste="filterPaste()" onpaste="return false" style="ime-mode: disabled">';
								li += '<img onclick="adda()" id="add" style="width: 22px; margin-bottom:4px; margin-left:10px;vertical-align:bottom;"alt="" src="images/pc/jia.png">';
								if("0"==goodsDetail.goodsType){
								li += '<font style="margin-left: 10px; color:rgba(163, 163, 169, 1)">剩余库存'+goodsDetail.inventories+goodsDetail.chargeUnit+'</font>';
									}
								li += '<button id="addToCat" style="margin-left: 80px;border-radius: 5px;background-color:#DC3D10;font-size: medium;padding: 7px;color: #fff;border:0;" onclick="javascript:addGoodsToShoppingCart();">加入购物车</button>';
								li += '</div>';
								li += '</div>';
								li += '</li>';
							
							}
					
					
				
			
			
			$("#ListDiv").append(li);
			
			$("#goodNumber").val(goodNumber);
			
				
			}
		});
	}
	
	
	
	//加载商品列表页面数据
	function showData(){
		//清空之前显示的商品列表
		//$("#ListDiv").empty();
		$.ajax({
			type : "post",
			url : "goods_findGoodsListByTypeAndStatus.html",
			dataType : "json",
			data:{
				"goodsType" : "2",
				"goodsSalesStatus" : "2",
				"goodsCatalogId" :goodsCatalogId,
				"page" : pageNumber
			},
			aysnc : false,
			success : function(data){
				pageNumber++;
				var total = data.total;
				var goodsList = data.goodsList;
				if(goodsList != null && goodsList != ""){
					//后台查询的数据不为空
					//页面显示商品列表
					$(".goodsShowDiv").show();
					$(".pageNumDiv").show();
					//页面商品列表div隐藏
					$(".noDataDiv").hide();
					
					//页面加载
					for(var i=0;i<goodsList.length;i++){
						var goodsData = goodsList[i];
						li = '<li><div class="voice-wp"><div class="voice-cover"><div class="voice-cover-wp">';
							li += '<img src="'+goodsData.imagePath+'" alt="voice-cover">';
	                        li += '<div class="mask"></div><i class="icon play-icon"></i></div>';
	                        li += '<a href="/sound/965138" class="btn play-btn"></a></div>';
	                        li += '<h3 class="voice-name"><a href="/sound/965138">'+goodsData.goodsName+'</a></h3>';
	                        li += '<div class="category"><a href="/channel/1143"></a>'+goodsData.goodsIntroduce+'</div>';
	                        li += '<div class="ui-status cf" ><span style=" color:rgba(255, 6, 6, 0.91)">'+goodsData.goodsPrice+'</span><span>/</span><span style="font-size:10px; ">'+goodsData.chargeUnit+'</span></div></div></li>';
						
						
						
						$("#ListDiv").append(li);
					}
				}else{
					//后台查询的数据为空
					//页面提示商品信息为空
					if(1==pageNumber){
						$(".noDataDiv").show();
		    			}
					//页面商品列表div隐藏
					$(".goodsShowDiv").hide();
					$(".pageNumDiv").hide();
				}
			}
		});
	}

	
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

	 // 加减 goodNumber
	 
	 function sub(){
		 goodNumber = $("#goodNumber").val();
		 if(1==goodNumber){
			 }else{
		 goodNumber --;
			 }
		 $("#goodNumber").val(goodNumber);
	 }
	 
	 function adda(){
		 
		 goodNumber = $("#goodNumber").val();
		 goodNumber ++;
		 $("#goodNumber").val(goodNumber);
	 }
	 
	

	 function number()
	 {
	 var char = String.fromCharCode(event.keyCode)
	 var re = /[0-9]/g
	 event.returnValue = char.match(re) != null ? true : false
		 goodNumber = $("#goodNumber").val();
	 }

	 function filterInput()
	 {
	 if (event.type.indexOf("key") != -1)
	 {
		 goodNumber = $("#goodNumber").val();
	 var re = /37|38|39|40/g
	 if (event.keyCode.toString().match(re)) return false
	 }
	 event.srcElement.value = event.srcElement.value.replace(/[^0-9]/g, "")
		 goodNumber = $("#goodNumber").val();
	 }

	 function filterPaste()
	 {
	 var oTR = this.document.selection.createRange()
	 var text = window.clipboardData.getData("text")
	 oTR.text = text.replace(/[^0-9]/g, "")
		 goodNumber = $("#goodNumber").val();
	 }

	 
	//添加商品进购物车
		function addGoodsToShoppingCart(){
			$.ajax({
				type : "post",
				url : "shoppingCart_addGoodsToShoppingCart.html",
				dataType : "json",
				data:{
					"goodsId" : goodsId,
					"goodsNum" : $("#goodNumber").val()
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
