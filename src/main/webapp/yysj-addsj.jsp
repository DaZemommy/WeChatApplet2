<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>小程序后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div class="header">
        <div class="top_logo"><img src="img/logo.jpg"></div> 
        <div class="topRight">
        	<ul class="czLeft">
            	<li><a href="#"><em><img src="img/icon.jpg"></em>预览</a></li>
            </ul>
            <div class="yhmLine">
            	<div class="yhmPic"><img src="img/pic.jpg"></div>
                <span>海水的味道 <em><img src="img/icon1-2.jpg"></em></span>
            </div>
        </div>
    </div>
    <div class="content content_help">
    	<div class="left_meun left_meun_help">
        	<ul>
            	<li class="leftMeunHover"><a href="index.html"><em></em><p>应用数据</p><i class="xialaxx"></i></a></li>
            </ul>
        </div>
        <div class="right_con_help">
        	<div class="rightConLine">
            	<div class="rightTitle">
                	<h2>添加数据</h2>
                    <div class="bntRight">
                        <span class="backBntA"><a href="#">返回</a></span>
                    </div>
                </div>
                <div class="tabConA">
                	<table width="100%" border="0" cellspacing="0">
                      <tr>
                        <td width="16%" align="right">分类：</td>
                        <td width="84%">无</td>
                      </tr>
                      <tr>
                        <td align="right">图：</td>
                        <td><form name="form0" id="form0" ><div class="picyl"><img src="" id="img0" ></div>
<div class="upload-img"><input type="file" name="file0" id="file0" class="sctp" multiple /><img src="img/sctp.jpg" alt="上传照片" title=""></div>
</form></td>
                      </tr>
                      <tr>
                        <td align="right">内容：</td>
                        <td><img src="img/pic1.jpg"></td>
                      </tr>
                      <tr>
                        <td align="right">封面图：</td>
                        <td><form name="form1" id="form1" ><div class="picyl"><img src="" id="img1" ></div>
<div class="upload-img"><input type="file" name="file1" id="file1" class="sctp" multiple /><img src="img/sctp.jpg" alt="上传照片" title=""></div>
</form></td>
                      </tr>
                    </table>
                </div>
                <div class="tjBnts"><span class="bcBnt">保 存</span> <span class="backBnt">返 回</span></div>
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
