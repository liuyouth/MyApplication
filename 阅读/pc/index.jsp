<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height:100%;">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style>
.control-group {
	margin-bottom: 10px;
    position:relative;
}

.control-group .icon-user {
	background: url(images/register/ico5.png) no-repeat;
	width: 30px;
	height: 30px;
	float: left;
	margin-left: 50px;
}

.control-group .icon-tall {
	background: url(images/register/ico2.png) no-repeat;
	width: 30px;
	height: 30px;
	float: left;
	margin-left: 50px;
}

.control-group .icon-lock {
	background: url(images/register/ico1.png);
	width: 30px;
	height: 30px;
	float: left;
	margin-left: 50px;
}

.control-group .icon-lock {
	backgtound-position: -30px 0px;
}

.control-group input {
	border-left: #cccccc 1px solid;
	background-color: rgba(255, 255, 255, 0.75);
	padding-left: 6px;
	width: 206px;
	padding-right: 6px;
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	margin-bottom: 10px;
	height: 20px;
	color: #000000;
	margin-left: -50px;
	font-size: 1.25em;
	border-top: #cccccc 1px solid;
	padding-top: 4px;
	border-radius: 10px 10px 10px 10px;
}

.control-group input:focus {
	z-index: 2;
	outline-style: dotted;
	outline-color: invert;
	outline-width: thin;
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px
		rgba(82, 168, 236, 0.6);
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px
		rgba(82, 168, 236, 0.6);
	-moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px
		rgba(82, 168, 236, 0.6)
}

.remember-me {
	margin-top: 0px;
	display: block;
	margin-bottom: 25px
}

.remember-me input {
	vertical-align: middle;
	cursor: pointer
}

.remember-me label {
	font-size: 13px;
	vertical-align: middle;
	cursor: pointer
}

.remember-me a {
	float: right;
	color: #333;
	text-decoration: none;
	padding-top: 1px;
	padding-right: 60px;
}

.remember-me a:hover {
	border-bottom: #999 1px dashed;
	color: #999;
	text-decoration: none
}

.login-btn input {
	border-bottom: 1px solid;
	border-left: 1px solid;
	padding-bottom: 4px;
	line-height: 30px;
	background-color: #f56c06;
	margin: 0px auto;
	padding-left: 12px;
	width: 180px;
	padding-right: 12px;
	display: block;
	background-repeat: repeat-x;
	color: #ffffff;
	font-size: 1.5em;
	border-top: 1px solid;
	cursor: pointer;
	border-right: 1px solid;
	padding-top: 4px;
	border-radius: 4px 4px 4px 4px;
	box-shadow: 0 1px 0 rgba(255, 255, 255, 0.2) inset, 0 1px 2px
		rgba(0, 0, 0, 0.05);
	text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25)
}

.login-btn input:hover {
	background-color: #fa7716;
}

.forget-btn {
	padding-top: 10px
}

.captcha{
    position:absolute;
    width:70px;
    height:20px;
    padding-top:5px;
    margin-left:10px;
    background:#395B78;
    color:#CCCCCC;
    border:1px solid #CCCCCC;
    font-size:12px;
    border-radius:5px;
    cursor:pointer;
}
</style>
</head>
<body style="margin:0;padding:0;height:100%;width:100%;background: url(images/imgBuddha/bg.jpg) no-repeat; background-size: cover;">
	<div style="width: 100%; height: 100%;">
		<!--  头+Logo start-->
		<div style="width: 300px; height: 150px; margin: 0 auto; padding-top: 3%;">
			<img src="images/imgBuddha/login_bgDB.png">
		</div>
		<!--头+Logo end-->
		<!--用户登录框 start-->
		<div style="width: 400px; height: 330px; background-color: rgba(0, 0, 0, 0.25); -webkit-border-radius: 15px; margin:50px auto;z-index: 4; padding: 20px; overflow: visible; text-align: center;">
			<h1 style="font-size: 2.25em; font-family: monospace;">用户登录</h1>
			<div class="control-group">
				<span class="icon-user"></span>
				<input id="username" type="text" name="username"
					placeholder="姓名">
			</div>
			<div class="control-group">
				<span class="icon-tall"></span>
				<input id="phone" type="text" name="phone" placeholder="手机号">
                <span class="captcha">获取验证码</span>
			</div>
			<div class="control-group">
				<span class="icon-lock"></span> 
				<input id="phonenum" type="text" name="phonenum" placeholder="手机验证码">
			</div>
			<div class="remember-me" style="display:none;">
				<input id="rm" value="1" type="checkbox" name="remember">
                <label for="rm">记住我</label>
				<!--  <A id=forget-password href="/">忘记密码?</A> -->
			</div>
			<div class="login-btn">
				<input id="login-btn" value="登 录" type="submit" name="submit">
			</div>
		</div>
		<!--用户登录框 end-->
	</div>
	<script src="js/jquery.min.js"></script>
	<script>
	    $(function(){
	        var validFlag = true;
	        var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;
	        var yanzhengmaResult;
	        /** 登录  */
	        $("#login-btn").on("click",function(){
	            var name=$("#username").val();//姓名 值
                var phone=$("#phone").val();//手机号 值
                var phonenum=$("#phonenum").val();//验证码 值
                //判定姓名
                /* if(name==null||name==""){
                    alert("请输入姓名");
                    return;
                } */
                //判定手机号
                /* if(phone==null||phone==""){
                    alert("请输入手机号");
                    return;
                } else if(!reg.test(phone)){
                    alert("请输入正确的手机号");
                    return;
                } */
                //判定验证码
                /* if(phonenum==null||phonenum==""){
                    alert("请输入收到的手机验证码");
                    return;
                } else if(phonenum != yanzhengmaResult){
                    alert("输入的手机验证码错误");
                    return;
                } */
                //登录
                $("#login-btn").attr("disabled","disabled");
                $.ajax({
                    type : 'POST',
                    url : "customer_login.html",
                    dataType : "json",
                    data : {customerPhone:phone/*,yanzhengma:phonenum*/},
                    aysnc : false,
                    success : function(data){
                        if(data){
                            var res = data.result;
                            if(res == "1"){
                                alert("登录失败，请 稍后再试！");
                            }else{
                                window.location.href="page_pageJump.html?pageName=travel";
                            }
                        }
                    },
                    error : function(){
                        alert("系统错误,请重试.");
                    }
                });
	        });
	        //获取验证码
	        $(".captcha").on("click",function(){
	            var t = $(this);
	            var time = 120;
	            var phone=$("#phone").val();//手机号 值
	            if(!reg.test(phone)){
                    alert("请输入正确的手机号");
                    return;
                }
	            if(validFlag){
	                validFlag = false;
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
	                        alert("系统错误,请稍后再试!");
	                    }
	                });
	                var a = setInterval(function(){
	                    t.html("稍等" + time + "秒");
	                    if(time == 0){
	                        clearInterval(a);
	                        t.html("获取验证码");
	                        validFlag = true;
	                    }
	                    time--;
	                },1000);
	            }
	        });
	    });
	</script>
</BODY>
</html>