<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小程序后台管理系统</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">  
	        // 刷新图片  
	        function changeImg() {  
	            var imgSrc = $("#imgObj");  
	            var src = imgSrc.attr("src");  
	            imgSrc.attr("src", changeUrl(src));  
	        }  
	         //为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳  
	        function changeUrl(url) {  
	            var timestamp = (new Date()).valueOf();  
	            var index = url.indexOf("?",url);  
	            if (index > 0) {    
	                url = url.substring(index, url.indexOf(url, "?"));    
	            } 
	            if ((url.indexOf("&") >= 0)) {  
	                url = url + "×tamp=" + timestamp;  
	            } else {  
	                url = url + "?timestamp=" + timestamp;  
	            }  
	            return url;  
	        } 
    	</script>  
</head>
<body class="bgall">
	<div class="header">
        <div class="top_logo"><img src="../images/logo1.jpg"></div> 
    </div>
    <div class="content loginCon">
    	<div class="w1200 mAuto">
        	<div class="leftCon"><img src="../images/dlPic.jpg"></div>
            <div class="rightLogin">
            	<h1 class="loginTitle">小程序登陆</h1>
            	<form action="${pageContext.request.contextPath}/admin/login" method="post">
                <div class="loginConLine">
                	<h2>用户登录</h2>
                    <ul class="dlLine">
                    	<li>
                        	<em><img src="../images/icon3.jpg"></em>
                            <input type="text" class="textsrk" name="username" placeholder="邮箱 / 手机号码 / 用户名">
                        </li>
                        <li>
                        	<em><img src="../images/icon3-1.jpg"></em>
                            <input type="password" class="textsrk" name="password"  placeholder="密码">
                        </li>
                        <li>
                        	<input type="text" class="textsrkA" id="code" name="code" placeholder="请输入验证码">
                            <span><a href="#"><img id="imgObj" alt="验证码" src="${pageContext.request.contextPath}/admin/validateCode" onclick="changeImg()"></a></span>
                        </li>
                        <li>
                        	<input name="" type="checkbox" value="" class="fxk"> 保存登录信息
                        	<p style="color: red;">${msg}</p>
                        </li>
                        <li><input type="submit" value="立 即 登 录" class="submit"></li>
                    </ul>
                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>