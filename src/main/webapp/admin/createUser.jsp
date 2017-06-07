<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小程序后台管理系统</title>
<base href="${pageContext.request.contextPath}/">
<link href="${pageContext.request.contextPath}/css/admin.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="header">
        <div class="top_logo"><img src="${pageContext.request.contextPath}/images/logo.jpg"></div> 
        <div class="topRight">
            <div class="yhmLine">
            	欢迎您！${existUser.name }
            </div>
        </div>
    </div>
    <div class="content">
    	<div class="flCon">
        	<ul class="flLine">
                
                
            </ul>
        </div>
    	<ul class="xcxLista" id="widget-box">
            <li>
            <input type="text" name="name"/>
            <input type="text" name="username"/>
            <input type="text" name="password"/>
            <input type="text" name="templateid"/>
            <input type="text" name="SN"/>
            <input type="text" name="keyword"/>
            </li>
           
        </ul>
       
    </div>
    <script type="text/javascript" src="js/jquery.min.js"></script>

</body>
</html>