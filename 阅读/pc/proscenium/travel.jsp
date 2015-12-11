<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    <meta charset="utf-8">
    <title>行伙伴-出行</title>
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
                <li class="active"><a href="<%=basePath %>page_pageJump.html?pageName=travel" title="出行">出行</a></li>
                <li><a href="<%=basePath %>page_pageJump.html?pageName=preferential#" title="优惠专享">优惠专享</a></li>
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
					  	<a href="<%=basePath %>page_pageJump.html?pageName=pcShoppingCart" style="margin-right: 20px;color: #F1707D;" >购物车</a></li>
                      <li class="register">
                        <a href="/index/login">登录</a></li>

                    </ul>
                </nav>
                    </div>
    </header>
     <!--标题-->
      <div class="sub-nav" style="position:fixed;">
        	<nav >
	            <ul id="sub-nav" class="cf" style="z-index:999">
	                <li class="active">
	                	<a href="/sound/exploration" title="1">1</a></li>
					<li>
						<a href="/channel/list" title="优1">优惠11</a></li>
					<li>
						<a href="/index/download" target="_blank" title="1">1中心</a></li>
		              
		        </ul>
	        </nav>
        </div>
         
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
            <ul id="ListDiv"  style="display:none" class="voices-list cf">
                 <li>
                    <div class="voice-wp">
                        <div class="voice-cover">
                            <div class="voice-cover-wp">
                                <img src="http://echo-image.qiniucdn.com/FuRVDTEyEU4KsTPVNOKa8j69aY-z?imageMogr2/thumbnail/!200x200r/gravity/Center/crop/200x200/dx/0/dy/0" alt="voice-cover">
                                <div class="mask"></div>
                               	 <i class="icon play-icon"></i>
                            	</div>
                            <a href="/sound/965138" class="btn play-btn"></a>
                        </div>
                        <h3 class="voice-name"><a href="/sound/965138">商品名字</a></h3>
                        <div class="category"><a href="/channel/1143"></a>简介</div>
                        <div class="ui-status cf">
                           <span>价格</span><span>价格</span>
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
	var pageNumber = 1;
	var isShow = 1;
	var secondActive = 4;
	var goodsCatalogId = 4;
	$(document).ready(function () {
		showNav();
	});
	
	$(function(){
		$('.carousel').carousel({
		interval: 3000
		});
		});
	function showNav(){
			//加载二级菜单
			$.ajax({
				type : "post",
				url : "catalog_querySecondMenuListByParentId.html",
				dataType : "json",
				data : {
					parentCatalogId : "1"
				},
				aysnc : false,
				success : function(data){
					var secondMenuDataList = data.secondMenuList;
					if(secondMenuDataList.length != 0){
						//有二级目录数据
						
						$("#sub-nav").empty();
						var n = 0;
						for(var i=0;i<secondMenuDataList.length;i++){
							var secondMenuData = secondMenuDataList[i];
							var goodsCatalogId = secondMenuData[0];
							var parentCatalogId = secondMenuData[1];
							var goodsCatalogName = secondMenuData[2];
							var goodsCatalogStatus = secondMenuData[3];
							if(0==i){
							goodsCatalogId = goodsCatalogId;
							secondActive = goodsCatalogId;
							var li = '<li id="l'+goodsCatalogId+'" class="active"><a href="#" title="'+goodsCatalogName+'" onclick="javascript:changeSecondList('+goodsCatalogId+')">'+goodsCatalogName+'</a></li>';					
							}else{
							var li = '<li id="l'+goodsCatalogId+'"><a href="#" title="'+goodsCatalogName+'" onclick="javascript:changeSecondList('+goodsCatalogId+')">'+goodsCatalogName+'</a></li>';					
							}
							
							$("#sub-nav").append(li);
							
							
						}
						//加载商品列表页面数据
						showData();
					}else{
						//无二级目录数据
						alert("系统错误，请稍后重试！");
					}
				}
			});
			}
		
	function changeSecondList(id){
		$("#l"+secondActive).removeClass("active");
		$("#l"+id).addClass("active");
		goodsCatalogId = id;
		secondActive = id;
		pageNumber = 1;
		 if($("#ListDiv").css("display")=='none'){
			 //$("#ListDiv").fadeIn(1000);
			      }
			      else{
			 $("#ListDiv").fadeOut(1000,none);
		 }
	}
	//处理渐隐动画完成之后
	function none(){
		$("#ListDiv").css("display","none");
		$("#ListDiv").empty();
		showData();
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
					
					//页面加载
					for(var i=0;i<goodsList.length;i++){
						var goodsData = goodsList[i];
						li = '<li><div class="voice-wp"><div class="voice-cover"><div class="voice-cover-wp">';
							li += '<img src="'+goodsData.imagePath+'" alt="voice-cover">';
	                        li += '<div class="mask"></div><i class="icon play-icon"></i></div>';
	                        li += '<a href="javascript:void(0);" onclick="jumpDetail('+goodsData.goodsId+')" class="btn play-btn"></a></div>';
	                        li += '<h3 class="voice-name"><a href="">'+goodsData.goodsName+'</a></h3>';
	                        li += '<div class="category"><a href=""></a>'+goodsData.goodsIntroduce+'</div>';
	                        li += '<div class="ui-status cf" ><span style=" color:rgba(255, 6, 6, 0.91)">'+goodsData.goodsPrice+'</span><span>/</span><span style="font-size:10px; ">'+goodsData.chargeUnit+'</span></div></div></li>';
						
						
						
	            			$("#ListDiv").append(li);
					}
					  if($("#ListDiv").css("display")=='none'){
							 $("#ListDiv").fadeIn(1000);
						}else{
							// $("#ListDiv").fadeOut(1000);
			  		 	}
				}else{
					isShow = 0;
					 if($("#ListDiv").css("display")=='none'){
						 $("#ListDiv").fadeIn(1000);
						      }
						      else{
								//$("#ListDiv").fadeOut(1000);
		  		 				}
					//后台查询的数据为空
					//页面提示商品信息为空
					if(1==pageNumber){
		    			}
				}
			}
		});
	}
//监听屏幕滚动到底部的加载信息
 	
 	$(window).scroll(function () {
	        var scrollTop = $(this).scrollTop();
	        var scrollHeight = $(document).height();
	        var windowHeight = $(this).height();
	        if (scrollTop + windowHeight == scrollHeight) {

	      //此处是滚动条到底部时候触发的事件，在这里写要加载的数据，或者是拉动滚动条的操作
	      if(isShow==1){
	    	  
	        	showData();
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
	 
	//跳转详情页
	 function jumpDetail(goodsId){
		 window.open("page_pageJump.html?pageName=goodDetails&goodsId="+goodsId);
	 };
	 

	</script>
</body>
</html>
