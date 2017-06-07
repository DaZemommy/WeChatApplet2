<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>小程序后台管理系统</title>
<base href="${pageContext.request.contextPath}/">
<link href="css/style.css" rel="stylesheet" type="text/css">
<!-- 配置文件 -->
<script type="text/javascript" src="ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="ueditor/ueditor.all.js"></script>
<script type="text/javascript" src="ueditor/lang/zh-cn/zh-cn.js"></script>
</head>

<body>
	<!-- 公共的头部信息 -->
	<jsp:include page="/head.jsp"></jsp:include>
	
    <div class="content content_help">
    	<div class="left_meun left_meun_help">
        	<ul>
            	<li class="leftMeunHover"><a href="index.jsp"><em></em><p>应用数据</p><i class="xialaxx"></i></a></li>
            </ul>
        </div>
        <div class="right_con_help">
        	<div class="rightConLine">
            	<div class="rightTitle">
                	<h2>添加数据</h2>
                    <div class="bntRight">
                        <span class="backBntA"><a href="detail/toDetail?dzid=${zxn.zid}">返回</a></span>
                    </div>
                </div>
                <form id="detailForm" name="detailForm" action="detail/addDetail" method="post" enctype="multipart/form-data">
                <div class="tabConA">
                	<table width="100%" border="0" cellspacing="0">
                      <tr>
                        <td width="16%" align="right">分类：</td>
                        <td width="84%">${zxn.zname}</td>
                      </tr>
                      <tr>
                        <td align="right">名称:</td>
                        <td>
	  						<span><input type="text" placeholder="请输入名称" name="dname" id="dname" size="50px" style="height:20px"></span>
	  						<span><input type="hidden" name="dzid" id="dzid" value="${zxn.zid}"></span>
	  					</td>
                      </tr>
                      <tr>
                        <td align="right">内容：</td>
                        <td>
                        	<script id="content" name="content" type="text/plain" style="height:300px;width:1000px"></script>
							<script type="text/javascript">var editor = UE.getEditor('content')</script>
						</td>
                      </tr>
                      <tr>
                      </tr>
                    </table>
                </div>
                <div class="tjBnts"><span ><input type="submit" class="bcBnt" value="保 存" style="height:40px;width: 50px"/></span></div>
                </form>
            </div>
        </div>
        

    </div>
    <script src="js/jquery-1.8.3.min.js"></script>
    <script>	
$("#file0").change(function(){
	var objUrl = getObjectURL(this.files[0]) ;
	console.log("objUrl = "+objUrl) ;
	if (objUrl) {
		$("#img0").attr("src", objUrl) ;
	}
}) ;
$("#file1").change(function(){
	var objUrl = getObjectURL(this.files[0]) ;
	console.log("objUrl = "+objUrl) ;
	if (objUrl) {
		$("#img1").attr("src", objUrl) ;
	}
}) ;
//建立一個可存取到該file的url
function getObjectURL(file) {
	var url = null ; 
	if (window.createObjectURL!=undefined) { // basic
		url = window.createObjectURL(file) ;
	} else if (window.URL!=undefined) { // mozilla(firefox)
		url = window.URL.createObjectURL(file) ;
	} else if (window.webkitURL!=undefined) { // webkit or chrome
		url = window.webkitURL.createObjectURL(file) ;
	}
	return url ;
}

</script>
</body>
</html>
