<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
  <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    <meta charset="utf-8">
    <title>行伙伴-投诉记录</title>
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
                <li><a href="<%=basePath%>page_pageJump.html?pageName=travel" title="出行">出行</a></li>
                <li><a href="<%=basePath%>page_pageJump.html?pageName=preferential" title="优惠专享">优惠专享</a></li>
                <li class="active"><a href="<%=basePath%>page_pageJump.html?pageName=personalCenter" title="个人中心">个人中心</a></li>
              
            </ul>
        </nav>
        
        <div class="sub-nav" style="position:fixed;">
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
					<li >
						<a href="<%=basePath %>page_pageJump.html?pageName=pcCardBag" title="我的卡包">我的卡包</a></li>
					<li class="active">
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
     
    <div class="container" style="margin-top:10px;margin-bottom:40px;  border-radius:5px;">
    
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
     
     <!-- 投诉与建议 -->

     
    <!--内容-->
		<div class="row" style="margin:0px;margin-top:10px;padding: 5px;width: 100%;background-color: white; border-radius:5px; text-align: right;border-bottom:1px solid #d7d7d7;">
        <!--标题-->
        <!--标题-->
        
        
            <button type="button" class="btn btn-info" onclick="javascript:openAdd();"style="font-size:12px;">添加</button>
              <!--记录-->
        <div id="listShowDiv" style="background-color: white;">
            
        </div>
        <!--记录-->
        </div>
       

      

    
    

    <div id="detailModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="detailModalLabel" aria-hidden="true"
        style="margin-top:40%;margin-left:0px;margin-right:10px;">
        <div class="modal-header" style="background-color:white;padding:6px;border-bottom:1px solid #999999;border-radius:5px 5px 0px 0px;">
            <span id="addModalLabel" style="font-size:120%;">详情</span>
        </div>
        <div class="modal-body" style="background-color:white;">
            <div class="row">

                <div class="col-xs-12" id="contentShowDiv" style="font-size:80%;">
                </div>
                
                <div class="col-xs-6" id="typeShowDiv" style="font-size:80%;color:red;">
                </div>
                <div class="col-xs-6" id="stutasShowDiv" style="font-size:80%;color:red;">
                </div>
                <div class="col-xs-12 dealT" style="margin-top:8px;padding-top:5px;border-top:1px solid #999999;font-size:80%;">
                    处理时间：<span id="dealTimeShowDiv"></span>
                </div>
                <div class="col-xs-12 dealR" style="font-size:80%;">
                    处理结果：<span id="dealResultShowDiv"></span>
                </div>
                
            </div>
        </div>
        <div class="modal-footer" style="background-color:white;padding:6px;border-top:1px solid #999999;border-radius:0px 0px 5px 5px;">
            <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
        </div>
    </div>

    
    <div id="addModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="addModalLabel" aria-hidden="true"
        style="margin-left:10px;margin-right:10px;">
        <div class="modal-dialog" role="document">
        <div class="modal-content" style="margin-top:30%;">
        <div class="modal-header" style="background-color:white;padding:6px;border-bottom:1px solid #999999;border-radius:5px 5px 0px 0px;">
            <span id="addModalLabel" style="font-size:120%;">添加</span>
        </div>
        <div class="modal-body" style="background-color:white;">
            <div class="row">
                <div class="col-xs-4" style="padding:5px;font-size:80%;text-align:right;">
                    类型：
                </div>
                <div class="col-xs-8">
                    <select id="complaintAdviceTypeAdd" data-toggle="select" 
                        class="form-control select select-info mrs mbm"
                        style="width:90%;min-width: 100px;">
                        <option value="0">投诉</option>
                        <option value="1">建议</option>
                    </select>
                </div>
                
                <div class="col-xs-4" style="padding:0px 5px;font-size:80%;text-align:right;">
                    内容：
                </div>
                <div class="col-xs-8">
                    <textarea id="contentAdd" class="form-control" 
                        style="width:90%;min-width: 100px;" rows="3"></textarea>
                </div>
                
            </div>
        </div>
        <div class="modal-footer" style="background-color:white;padding:6px;border-top:1px solid #999999;border-radius:0px 0px 5px 5px;">
            <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
            <button class="btn btn-info" data-dismiss="modal" aria-hidden="true" onclick="javascript:addComplaintAdvice();">添加</button>
        </div>
        </div>
        </div>
    </div>
     <!-- 投诉与建议 -->
       
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
    var secondActive = 14;
    var goodsCatalogId = 14;
    $(document).ready(function () {
        //showNav();
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
                    parentCatalogId : "2"
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
//监听屏幕滚动到底部的加载信息
    
    $(window).scroll(function () {
            var scrollTop = $(this).scrollTop();
            var scrollHeight = $(document).height();
            var windowHeight = $(this).height();
            if (scrollTop + windowHeight == scrollHeight) {

          //此处是滚动条到底部时候触发的事件，在这里写要加载的数据，或者是拉动滚动条的操作
          if(isShow==1){
                //showData();
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

     
     /*
      * 投诉意见
      */
     
     $(document).ready(function () {
         $(".dealT").hide();
         $(".dealR").hide();
         //加载投诉建议记录列表
         getList();
         //findAllChange();
     });
     //加载投诉建议记录列表
     function getList(){
         $.ajax({
             type : "post",
             url : "complaintAdvice_getComplaintAdviceListByCustomerId.html",
             dataType : "json",
             aysnc : false,
             success : function(data){
                 var dataList = data.dataList;
                 showDate(dataList);
             }
         });
     }
     //页面展示
     function showDate(dataList){
         $("#listShowDiv").empty();
         for(var i=0;i<dataList.length;i++){
             var dataMap = dataList[i];
             
             var rowDiv = document.createElement("div");
             $(rowDiv).addClass("con row")
                 .attr("style","margin:0px -15px;border-bottom:1px solid #e6e6e6;margin-left:0px;margin-right:0px;")
                 .attr("onclick","javascript:openDetail("+dataMap.complaintAdviceId+");");

                    
             
             var timeDiv = document.createElement("div");
             $(timeDiv).addClass("col-xs-2").attr("style","font-size:120%;color:#666666;margin:10px 0px 10px 0px;")
                 .text(dataMap.submitTime).appendTo(rowDiv);
             
             var contentDiv = document.createElement("div");
             $(contentDiv).addClass("col-xs-5").attr("style","font-size:120%;margin:10px 0px 10px 0px;")
                 .appendTo(rowDiv);
             var content = dataMap.content;
             var length = content.strLen();
             
             $(contentDiv).text(content);     
             
             var typeDiv = document.createElement("div");
             $(typeDiv).addClass("col-xs-2").attr("style","font-size:120%;color:#00BBFF;padding:0px 5px;margin:10px 0px 10px 0px;")
                 .appendTo(rowDiv);
             if(dataMap.complaintAdviceType == "0"){
                 //投诉
                 $(typeDiv).text("投诉");
             }else if(dataMap.complaintAdviceType == "1"){
                 //建议
                 $(typeDiv).text("建议");
             }
             
             var statusDiv = document.createElement("div");
             $(statusDiv).addClass("col-xs-3").attr("style","font-size:120%;color:red;margin:10px 0px 10px 0px;")
                 .appendTo(rowDiv);
             if(dataMap.idDeal == "0"){
                 //未处理
                 $(statusDiv).text("未处理")
             }else if(dataMap.idDeal == "1"){
                 //已忽略
                 $(statusDiv).text("已忽略");
             }else if(dataMap.idDeal == "2"){
                 //已处理
                 $(statusDiv).text("已处理").attr("style","color:green");
             }
             
             $("#listShowDiv").append(rowDiv);
         }
         
     }
     

     
     //打开添加窗口
     function openAdd(){
         $("#addModal").removeClass('hide');
         $("#addModal").modal('show');
     }
     
     //添加投诉建议
     function addComplaintAdvice(){
         var complaintAdviceType = $("#complaintAdviceTypeAdd").val();
         var content = $("#contentAdd").val();
         if(content == "" || content == null || content == undefined){
             alert("内容不能为空！");
             return;
         }
         
         $.ajax({
             type : "post",
             url : "complaintAdvice_addComplaintAdvice.html",
             dataType : "json",
             aysnc : false,
             data : {
                 "complaintAdviceType" : complaintAdviceType,
                 "content" : content
             },
             success : function(data){
                 if(data.success){
                     alert(data.msg);
                     $("#contentAdd").val("");
                     //加载投诉建议记录列表
                     getList();
                 }else{
                     alert("系统错误，请稍后再试！");
                 }
             }
         });
     }
    </script>
</body>
</html>
