<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小程序后台管理系统</title>
<base href="${pageContext.request.contextPath}/">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/mricode.pagination.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/common.css"/>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="js/mricode.pagination.js"></script>
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
                	<h2>数据对象列表</h2>
                    <div class="bntRight">
                    	<span class="searchLine"><input id="sousuo" name="" type="text" class="searchk" placeholder="搜索"> <em class="searchBnt"></em></span>
                        <span class="addsjdx"><a href="javascript:;" class="bounceIn">添加分类</a></span>
                    </div>
                	<!-- 添加分类弹窗 -->
                    <div id="dialogBg"></div>
						<div id="dialog" class="animated">
							<img class="dialogIco" width="50" height="50" src="img/ico.png" alt="" />
							<div class="dialogTop">
								<a href="javascript:;" class="claseDialogBtn"><font color="gray">关闭</font></a>
							</div>
							<form action="${pageContext.request.contextPath }/zixun/addOrEditZixun" method="post" id="addForm">
								<ul class="editInfos">
									<li><label><font color="#ff0000"></font><input id="z1" type="hidden" name="zid" class="ipt" /></label></li>
									<li><label><font color="#ff0000">* </font>对象名称：<input id="z2" type="text" name="zname" required value="" class="ipt" /></label></li>
									<li><label><font color="#ff0000">* </font>描&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp述：<input id="z3" type="text" name="zdesc" required value="" class="ipt" /></label></li>
									<li><input type="submit" value="确认提交" class="submitBtn" /></li>
								</ul>
							</form>
					</div>
                	
					<script type="text/javascript">
						var w,h,className;
						function getSrceenWH(){
							w = $(window).width();
							h = $(window).height();
							$('#dialogBg').width(w).height(h);
						}
	
						window.onresize = function(){  
							getSrceenWH();
						}  
						$(window).resize();  
	
						$(function(){
							getSrceenWH();
							
							//显示弹框(添加)
							$('.addsjdx').click(function(){
								className = $(this).attr('class');
								$('#dialogBg').fadeIn(300);
								$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
							});
						
							
							//关闭弹窗(添加)
							$('.claseDialogBtn').click(function(){
								$("#z1").val("");
								$("#z2").val("");
								$("#z3").val("");
								$('#dialogBg').fadeOut(300,function(){
									$('#dialog').addClass('bounceOutUp').fadeOut();
								});
							});
							
						});
							
					</script>
					
                    
                    
                </div>
                <div class="tabCon" id="flash">
                	<!-- 分页显示信息部分 -->
                	<table  id="zixunlist" width="100%" border="0" cellspacing="0" cellpadding="0">
                    
                    </table>
                    <!--翻页-->
                    <div class="zxgl-line1 jqlies">
                    	<div id="sports_page" class="m-pagination"></div>
                  	</div>
                  	
                  	<script type="text/javascript">
                  	$("#sports_page").pagination({
	        			pageBtnCount: 10,
	        			pageSize: 5,
	        		    firstBtnText: '首页',
	        		    lastBtnText: '尾页',
	        		    prevBtnText: '上一页',
	        		    showInfo: false,
	        			debug: true,
	        		    showInfo: true,
	        		    showJump: true,
	        		    showPageSizes: true,
	        		    loadFirstPage: true,
	        		    infoFormat: '共{total}条',
	        	        noInfoText: '暂无资讯',
	        		    remote: {
	        		        url: '${pageContext.request.contextPath}/zixun/showList?sousuo='+$("#sousuo").val(),  
	        		        beforeSend: function(XMLHttpRequest){
	        		        },
	        		        success: function (result) {
	        		        	load(result);
	        		        },
	        		        complete: function(XMLHttpRequest, textStatu){
	        		        	
	        		        },      
	        		        pageIndexName: 'pageNum',     	//请求参数，当前页数，索引从0开始
	        		        pageSizeName: 'pageSize',       //请求参数，每页数量
	        		        totalName: 'total' 
	        		    	}
	        		    })
	        		
	        		//显示列表里的数据
	        		function load(map){
	        			$("#zixunlist").html("");
	        			var s0 = "<tr><th width='21%'>对象名称</th><th width='31%'>描述</th><th width='29%'>操作</th><th width='19%'>管理</th></tr>"
	        			$("#zixunlist").append(s0);
	        			//回调函数
	        			$.each(map.list,function(i,zx){
  							var s1 = "<tr><td>"+zx.zname+"</td><td>"+zx.zdesc+"</td><td><span class='bjBnt'><a href='javascript:editZixun("+zx.zid+", \""+zx.zname+"\", \""+zx.zdesc+"\");'>编辑</a></span><span class='delBnt'><a href='javascript:delZixun("+zx.zid+", \""+zx.zname+"\");'>删除</a></span></td><td><span class='sjglBnt'><a href='detail/toDetail?dzid="+zx.zid+"'>数据管理</a></span></td></tr>"
  							$("#zixunlist").append(s1);
	        			});
	        		}  
                  	
	        		
	        		//删除
	        		function delZixun(id, name){
	        			if(confirm("确认删除对象\"" + name + "\"?")){
	        				$.ajax({
	        					type: "get",
	        					url: "${pageContext.request.contextPath}/zixun/delZixun?zid=" + id+"&zname="+name,
	        					success: function(data, textStatus){
	        						if(data){
	        							alert("删除成功！");
	        							window.location.reload();
	        						}else{
	        							alert("删除失败！");
	        						}}	
	        				});
	        			}
	        		}
	        		
	        		
	        		
	        		//点击查询
					$(".searchBnt").click(function(){
						location.reload();
					});
	        		
	        		
					function editZixun(zid,zname,zdesc){
						$("#z1").val(zid);
						$("#z2").val(zname);
						$("#z3").val(zdesc);
						className = $(this).attr('class');
						$('#dialogBg').fadeIn(300);
						$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
					}
	        		
	        		
                  	</script>
                  	
                  	
                  	
                  	
                </div>
            </div>
        </div>
            <!--弹出框-->
<div class="blackbg"></div>
<div class="tanchu">
	<div class="tc_title"><span>数据分类</span><i><img src="img/clooseIcon.jpg"/></i></div>
    <div class="tc_con">
    	<span class="addsjdx mt20"><a href="#">新增分类</a></span>
        <div class="gbBntLine"><span class="gbBnt">关 闭</div></div>
    </div>
</div>
<script src="js/jquery-1.8.3.min.js"></script>
<script>
<!--弹层-->
/* $(".addsjdx").click(function(){//点击弹框显示
	$(".blackbg").show();
	$(".tanchu").show();
})
$(".tc_title i,.gbBnt").click(function(){//弹框关闭
	$(".blackbg").hide();
	$(".tanchu,.picture,.scewm").hide();
}) */
</script>
    </div>
</body>
</html>
