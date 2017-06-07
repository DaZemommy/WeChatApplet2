<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>小程序应用后台</title>
<link href="${pageContext.request.contextPath}/renzheng/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/mricode.pagination.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="http://cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/mricode.pagination.js"></script>
</head>

<body>
	<div class="list">
    	<div class="header">
        	<h1 class="headerLogo"><img src="${pageContext.request.contextPath}/renzheng/img/logo.png"></h1>
            <a href="${pageContext.request.contextPath}/user/torzLogin"><div class="tcBnt">退出</div></a>
        </div>
        <div class="content content_help">
        	<div class="left_meun left_meun_help">
            	<dl class="leftList">
                	<dt>列表</dt>
                    <dd><div class="addNewList">新 加</div></dd>
                </dl>
            </div>
            <div class="right_con_help">
            	<div class="searchLine">
                	<div class="searchCon">
                    	<input id="sousuo" type="text" class="searchK" placeholder="请输入搜索内容">
                        <input type="button" class="searchBnt">
                    </div>
                </div>
                <dl class="listCon" id="renzhenglist">
                	<!-- <dt>
                    	<span class="bfbA"><em>ID</em></span>
                        <span class="bfbB"><em>公司名称</em></span>
                        <span class="bfbC"><em>证书编号</em></span>
                        <span class="bfbD"><em>操作</em></span>
                    </dt>
                    <dd class="firstC bg">
                    	<div class="lineA"><em>1</em></div>
                        <div class="lineB">北京天下互联信息科技有限公司</div>
                        <div class="lineC">BJ0123456789</div>
                        <div class="lineD">
                        	<div class="bjBnt">编辑</div>
                            <div class="scBnt">删除</div>
                        </div>
                    </dd>
                    <dd>
                    	<div class="lineA"><em>2</em></div>
                        <div class="lineB">北京天下互联信息科技有限公司</div>
                        <div class="lineC">BJ0123456789</div>
                        <div class="lineD">
                        	<div class="bjBnt">编辑</div>
                            <div class="scBnt">删除</div>
                        </div>
                    </dd> -->
                </dl>
                <div class="fyLine">
                	<!-- 分页部分 -->
                	<div id="sports_page" class="m-pagination"></div>
                </div>
                <script type="text/javascript">
                $("#sports_page").pagination({
	        			pageBtnCount: 10,
	        			pageSize: 10,
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
	        		        url: '${pageContext.request.contextPath}/renzheng/showList?sousuo='+$("#sousuo").val(),  
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
	        			$("#renzhenglist").html("");
	        			var s0 = "<dt><span class='bfbA'><em>ID</em></span><span class='bfbB'><em>公司名称</em></span><span class='bfbC'><em>证书编号</em></span><span class='bfbD'><em>操作</em></span></dt>"
	        			$("#renzhenglist").append(s0);
	        			//回调函数
	        			$.each(map.list,function(i,rz){
	        				if (i==0) {
								var s1 = "<dd class='firstC bg'><div class='lineA'><em>"+(i+1)+"</em></div><div class='lineB'>"+rz.rname+"</div><div class='lineC'>"+rz.rkey+"</div><div class='lineD'><a href='javascript:editRenzheng("+rz.rid+", \""+rz.rname+"\");'><div class='bjBnt'>编辑</div></a><a href='javascript:delRenzheng("+rz.rid+", \""+rz.rname+"\");'><div class='scBnt'>删除</div></a></div></dd>";
								$("#renzhenglist").append(s1);
							}else{
								var s1 = "<dd><div class='lineA'><em>"+(i+1)+"</em></div><div class='lineB'>"+rz.rname+"</div><div class='lineC'>"+rz.rkey+"</div><div class='lineD'><a href='javascript:editRenzheng("+rz.rid+", \""+rz.rname+"\");'><div class='bjBnt'>编辑</div></a><a href='javascript:delRenzheng("+rz.rid+", \""+rz.rname+"\");'><div class='scBnt'>删除</div></a></div></dd>";
								$("#renzhenglist").append(s1);
							}
	        			});
	        		}  
                
	              	//点击查询
					$(".searchBnt").click(function(){
						location.reload();
					});
                
        			
	            	
                	//删除
	        		function delRenzheng(id, name){
	        			if(confirm("确认删除对象\"" + name + "\"?")){
	        				$.ajax({
	        					type: "get",
	        					url: "${pageContext.request.contextPath}/renzheng/delRenzheng?rid=" + id+"&rname="+name,
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
                	
                	
	        		//编辑
	        		function editRenzheng(id, name){
	        			$("#editbg").show();
	        			$("#editwindow").show();
	        			$("#rname1").val(name);
	        			$("#editqd").click(function(){//确认提交
	        				$("#editbg").hide();
	        				$("#editwindow").hide();
	        				 $.ajax({
	        			         type: "GET",
	        			         url: "${pageContext.request.contextPath}/renzheng/editRenzheng",
	        			         data: {rid:id,rname:$("#rname1").val()},
	        			         dataType: "json",
	        			         success: function(data){
	        			        	 		if (data==true) {
	        			                     alert("编辑成功!")
	        			                     window.location.reload();
	        								}
	        			        	 		if (data==false) {
	        									alert("编辑失败!");
	        								}
	        			                  }
	        			     });
	        				
	        			})
	        			
	        			
	        			
	        			
	        		}
                	
                
                </script>
            </div>
        </div>
    </div>
     <!--弹出框-->
<div id="addbg" class="blackbg"></div>
<div id="addwindow" class="tanchu">
    <div class="tc_con">
    	<div class="addLeft">
        	<ul>
            	<li>公司名称</li>
            </ul>
        </div>
        <div class="addConRight">
	        	<ul>
	            	<li><input type="text" id="rname" name="rname" class="mcsrk"></li>
	                <li>
	                	<div id="addqd" class="qdBnt">确 定 新 加</div>
	                    <div id="addqx" class="qxBnt">取 消</div>
	                </li>
	            </ul>
        </div>
    </div>
</div>
<div id="editbg" class="blackbg"></div>
<div id="editwindow" class="tanchu">
    <div class="tc_con">
    	<div class="addLeft">
        	<ul>
            	<li>公司名称</li>
            </ul>
        </div>
        <div class="addConRight">
	        	<ul>
	            	<li><input type="text" id="rname1" name="rname" class="mcsrk"></li>
	                <li>
	                	<div id="editqd" class="qdBnt">确 定 编 辑</div>
	                    <div id="editqx" class="qxBnt">取 消</div>
	                </li>
	            </ul>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/renzheng/js/jquery-1.8.3.min.js"></script>
<script>
<!--弹层-->
$(".addNewList").click(function(){//点击弹框显示
	$("#addbg").show();
	$("#addwindow").show();
	$("#rname").val("");
})
$("#addqx").click(function(){//弹框关闭(添加)
	$("#addbg").hide();
	$("#addwindow").hide();
})
$("#editqx").click(function(){//弹框关闭(编辑)
	$("#editbg").hide();
	$("#editwindow").hide();
})

$("#addqd").click(function(){//确认提交
	$("#addbg").hide();
	$("#addwindow").hide();
	 $.ajax({
         type: "GET",
         url: "${pageContext.request.contextPath}/renzheng/addRenzheng",
         data: {rname:$("#rname").val()},
         dataType: "json",
         success: function(data){
        	 		if (data==true) {
                     alert("添加成功!")
                     window.location.reload();
					}
        	 		if (data==false) {
						alert("添加失败!");
					}
                  }
     });
	
})

</script>
</body>
</html>
