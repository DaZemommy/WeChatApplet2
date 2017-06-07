<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>小程序应用后台</title>
<base href="${pageContext.request.contextPath }/renzheng/">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div class="login">
    	<div class="loginCon">
        	<h1 class="loginLogo"><img src="img/logo.png"></h1>
            <div class="logindlk">
            	<form action="${pageContext.request.contextPath }/user/rzLogin" method="post">
	            	<ul>
	                	<li>
	                    	<span class="loginIcon"><em><img src="img/icon.png"></em></span>
	                        <input type="text" name="username"  class="srk" placeholder="用户名">
	                    </li>
	                    <li>
	                    	<span class="loginIcon"><em><img src="img/icon1.png"></em></span>
	                        <input type="password" name="password" class="srk" placeholder="密码">
	                    </li>
	                    <li>
	                    	<div class="jzLeft"><input name="" type="checkbox" value="" id="checkbox"> <label for="checkbox">记住密码</label></div>
	                        <a href=""><input type="submit" class="tjBnt" value="登录"></a>
	                        <p style="color: red;">${rzmsg}</p>
	                    </li>
	                </ul>
                </form>
            </div>
        </div>
        <div class="loginFooter">Copyright 2009-2017 All Rights Reserved.津ICP备16006424号津公网安备 12011502000085号</div>
    </div>
</body>
</html>
