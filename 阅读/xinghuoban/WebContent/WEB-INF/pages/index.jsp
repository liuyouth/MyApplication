<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>行伙伴-注册</title>
<meta name="description" content="行伙伴-注册" />
<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/flat-ui.min.css" rel="stylesheet">
<link href="css/mobiscroll.min.css" rel="stylesheet">
<link href="css/xhb/register.css" rel="stylesheet">
</head>
<body>
	<div class="login-bg">
		<div class="btn-toolbar">
			<div class="btn-group" style="float: none; margin: 0 auto;">
				<a id="putong" class="btn btn-primary active" href="#fakelink"
					onClick="testDisplay(this)">普 通</a> <a id="zhongshihua"
					class="btn btn-primary" href="#fakelink"
					onClick="testDisplay(this)">中石化</a> <a id="yikatong"
					class="btn btn-primary" href="#fakelink"
					onClick="testDisplay(this)"> 一卡通</a> <a id="nanhang"
					class="btn btn-primary" href="#fakelink"
					onClick="testDisplay(this)">南 航</a>
			</div>
		</div>
		<div class="input-bg">
			<div class="form-signin">
				<div id="card" style="padding-top: 3%;">
					<img src="images/register/ico1.png" width="8%" height="8%"
						style="float: left; margin-top: 2%; margin-left: 3%; display: inline">
					<input type="text" id="cardnumber" placeholder="请输入卡号"
						class="form-control" style="width: 80%; margin-left: 15%;" />
				</div>

				<div style="padding-top: 3%">
					<img src="images/register/ico5.png" width="8%" height="8%"
						style="float: left; margin-top: 2%; margin-left: 3%; display: inline">
					<input id="name" type="text" placeholder="请输入姓名"
						class="form-control" style="width: 80%; margin-left: 15%;" />
				</div>
				<div style="padding-top: 3%">
					<img src="images/register/ico2.png" width="8%" height="8%"
						style="float: left; margin-top: 2%; margin-left: 3%; display: inline">
					<input id="phone" type="text" placeholder="请输入手机号"
						class="form-control" style="width: 80%; margin-left: 15%;" />
				</div>
				<div style="padding-top: 3%;">
					<img src="images/register/ico6.png" width="8%" height="8%"
						style="float: left; margin-left: 4%; margin-top: 3%; display: inline">

					<input id="yanzhengma" type="text" placeholder="请输入验证码"
						class="form-control"
						style="width: 50%; display: inline; margin-right: 6%;" />
					<div style="display: inline; margin-left: 3%; width: 10%">
						<a id="yanzhengmabtn" onClick="getYanzhengma()" style="width: 10%">
							<span class="STYLE1">获取验证码</span>
						</a>
					</div>
				</div>

				<div style="padding-top: 3%;">


					<img src="images/register/ico3.png" width="8%" height="8%"
						style="float: left; margin-top: 2%; margin-left: 3%; display: inline">
					<div
						style="display: inline; width: 30%; float: left; margin-left: 2%; margin-top: 2%">
						<font id="sex">男</font>

					</div>
					<img src="images/register/mh.png" id="man" width="8%" height="8%"
						onClick="sex(this)"
						style="float: left; margin-left: 3%; margin-top: 2%; display: inline">
					<img src="images/register/w.png" id="woman" width="8%" height="8%"
						onClick="sex(this)"
						style="margin-left: 3%; margin-top: 2%; display: inline">



				</div>

				<div style="padding-top: 3%; margin-bottom: 3%;">
					<img src="images/register/ico4.png" width="8%" height="8%"
						style="margin-left: 3%; float: left; margin-top: 4%; display: inline">
					<input type="text" placeholder="请输入生日" name="appDate" id="appDate"
						class="form-control"
						style="width: 80%; margin-left: 0%; margin-top: 3%; margin-bottom: 5%; display: inline" />
				</div>
			</div>
		</div>
		<div class="col-xs-3"
			style="width: 60%; float: none; margin: 0 auto; margin-top: 10%; margin-bottom: 20%;">
			<a href="#fakelink" onClick="submits()"
				class="btn btn-block btn-lg btn-info">注册</a>
		</div>

	</div>





	<script src="js/jquery.min.js"></script>
	<script src="js/flat-ui.min.js"></script>
	<script src="js/application.js"></script>
	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script src="js/mobiscroll/mobiscroll.min.js"></script>
	<script src="js/mobiscroll/mobiscroll-zh.js"></script>

	<script type="text/javascript">
var code ;
var intnumber;
var yanzhengmaResult;
//计时器数值
var myVar;
//计时器
var cardType1 = 0;
// cardType  0普通会员 1中石化 2一卡通 3南航
function startTimer(){ //计时器代码
     /*setInterval() 间隔指定的毫秒数不停地执行指定的代码*/
    myVar=setInterval(function(){
	$("#yanzhengmabtn").text(intnumber+"s");
	    console.log(intnumber--);
		if(intnumber <= 0){
			$("#yanzhengmabtn").addClass("STYLE1");
		    $("#yanzhengmabtn").text("获取验证码");
		    $("#yanzhengmabtn").css("color","#16a085");
	        $("#yanzhengmabtn").bind('click',function(){
	        	getYanzhengma();
				});
		    clearInterval(myVar);
		}
	},1000);
	
}
$(document).ready(function () { // 这是网页初始化时候会触发的函数 
	//$(".login-bg").css({width:$(window).width(),height:$(window).height()+50});
// 设置银行卡隐藏
	$("#card").hide();
//初始化日期选择器
var currYear = (new Date()).getFullYear();	
			var opt={};
			opt.date = {preset : 'date'};
			opt.datetime = {preset : 'datetime'};
			opt.time = {preset : 'time'};
			opt.default = {
				theme: 'android-ics light', //皮肤样式
		        display: 'modal', //显示方式 
		        mode: 'scroller', //日期选择模式
				dateFormat: 'yyyy-mm-dd',
				lang: 'zh',
				showNow: true,
				nowText: "今天",
		        startYear: currYear - 100, //开始年份
		        endYear: currYear  //结束年份
			}
	//为日期选择器绑定点击事件
		  	$("#appDate").mobiscroll($.extend(opt['date'], opt['default']));
});

function testDisplay(but) //为注册种类设置事件以及卡类标识
{
	var butId = but.id;
	if(butId != "putong"){
		//alert(but.id);
		$("#card").show();
		if(butId=="zhongshihua"){
			cardType=1;
			}
		if(butId=="yikatong"){
			cardType=2;
			}
		if(butId=="nanhang"){
			cardType=3;
			}
		
	}else{
		$("#card").hide();
		cardType=0;
	}

}

function getYanzhengma() //验证码计时初始化
{
	var phone = $("#phone").val();
	  if(validatemobile(phone)){
	alert("短信发送成功请注意查收");
	$.ajax({
		type : 'POST',
		url : "customer_inityanzhengma.html",
		dataType : "json",
		data : {customerPhone:phone},
		aysnc : false,
		success : function(data){
		  yanzhengmaResult=data.result;
		},
		error : function(){
			alert("系统错误,请稍后再试");
		}
	});
	
	intnumber = 60;
	
	$("#yanzhengmabtn").css("color","#CCC");
    $("#yanzhengmabtn").removeAttr("onclick")
	startTimer();
	  }else{
		  alert("未知错误！");
	  }

}

function sex(selcet){  //选择性别 
	var selcetId=selcet.id;
	
	if(selcetId=="woman"){
		
		$("#sex").text("女");
		$("#man")[0].src="images/register/m.png";
		$("#woman")[0].src="images/register/wh.png";
		console
	}else{
			
		$("#sex").text("男");
		$("#man")[0].src="images/register/mh.png";
		$("#woman")[0].src="images/register/w.png";
	}
}

function submits(){

	var name = $("#name").val();
	var cardNumber = $("#cardnumber").val();
	var phone = $("#phone").val();
	var yanzhengma = $("#yanzhengma").val();
	var sexValue = $("#sex").text();
	var date = $("#appDate").val();
    var obj = {};
    if(cardType1 != 0){
	    obj.cardCount = 1 ;
    }else{
    	 obj.cardCount = 0 ;
    }
    obj.customerName = name;
	obj.customerPhone = phone;
	obj.customerSex = sexValue;
	obj.customerBirthday = date;
	
	 obj.cardType = cardType;
	 obj.cardNumber = cardNumber;
	 //if(cardType1 != 0 ){
		  
			  // if(validatemobile(phone)){
					// if(yanzhengma==yanzhengmaResult){
						 $.ajax({
								type : 'POST',
								url : "customer_register.html",
								dataType : "json",
								data : obj,
								aysnc : false,
								success : function(data){
									if(data){
										var res = data.result;
										alert(res);
										if(res == "1"){
											alert("账户创建失败");
									    }else if(res == "2"){
											alert("请输入正确的卡号");
									    }else if(res == "3"){
										    window.location.href="page_pageJump.html?pageName=goodsList";
									    }
									}
									
								},
								error : function(){
									alert("系统错误,请重试.");
								}
							});
						// }else{//验证码验证
							// alert("验证码错误！");
						// }
					
	      //}else{alert("手机号验证不过");}//手机验证
	 
	//}else{alert("卡"+cardType);} //有没有卡验证
}
	

 


function validatemobile(mobile) { 
    if(mobile.length==0) 
    { 
       alert('请输入手机号码！'); 
       
       return false; 
    } else{
    	
        return true;
        }    
    if(mobile.length!=11) 
    { 
        alert('请输入有效的手机号码！'); 
        
        return false; 
    } else{
    	
        return true;
        }
     
    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
    if(!myreg.test(mobile)) 
    { 
        alert('请输入有效的手机号码！'); 
        
        return false; 
    }else{
    	
    return true;
    }
    
    
    /**
     * 初始化微信
     * @param data
     */
    function initWeiXin(data) {
        //alert(data.appid);
        //alert(data.timestamp);
        //alert(data.noncestr);
        //alert(data.signature);
        //alert(location.href.split('#')[0]);
        wx.config({
            debug: false,
            appId: data.appid,
            timestamp: data.timestamp,
            nonceStr: data.noncestr,
            signature: data.signature,
            jsApiList: [
                'checkJsApi',
                'onMenuShareTimeline',
                'onMenuShareAppMessage',
                'onMenuShareQQ',
                'onMenuShareWeibo'
            ]
        });
        
    }
}
</script>
</body>
</html>
