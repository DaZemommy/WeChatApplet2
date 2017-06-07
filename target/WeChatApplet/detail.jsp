<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
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
                	<h2>添加数据</h2>
                    <div class="bntRight">
                        <span class="addsjBnt"><a href="detail/toAddDetail?dzid=${zixun.zid}">新建数据</a></span>
                        <span class="backBntA"><a href="index.jsp">返回</a></span>
                    </div>
                </div>
                <div class="flLine">
                	<div class="flLineLeft"><p>分类：</p><span>${zixun.zname}</span></div>
                </div>
                
                <div class="tabCon tabConB">
                	<!-- 分页显示 -->
                	<table id="detaillist" width="100%" border="0">
                     
                    </table>
                     <!--翻页-->
                    <div class="zxgl-line1 jqlies">
                    	<div id="sports_page" class="m-pagination"></div>
                  	</div>
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
	        		        url: '${pageContext.request.contextPath}/detail/showList?dzid=${zixun.zid}',  
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
	        			$("#detaillist").html("");
	        			var s0 = "<tr><th width='13%'>置顶</th><th width='17%'>修改分类</th><th width='10%'>图</th><th width='20%'>名字</th><th width='10%'>封面图</th><th width='21%'>操作</th><th width='9%'>是否显示</th></tr>";
	        			$("#detaillist").append(s0);
	        			//回调函数
	        			$.each(map.list,function(i,dt){
  							var s1 = "<tr><td><input type='text' class='zfxx w96' name=''></td><td><select name='' class='zfxx w96'></select></td><td><div class='picxs'><img src='"+dt.pics+"'/></div></td><td>"+dt.dname+"</td><td><div class='picxs'><img src='"+dt.fpic+"'/></div></td><td><span class='bjBnt mlbfb'><a href='detail/toEditDetail?did="+dt.did+"'>编辑</a></span><span class='delBnt'><a href='javascript:delDetail("+dt.did+", \""+dt.dname+"\");'>删除</a></span><span class='sjglBnt fzBnt'><a href=''>复制</a></span></td><td><input name='' type='checkbox' value=''></td></tr>";
  							$("#detaillist").append(s1);
	        			});
	        		}  
                  	
	        		
	        		//删除
	        		function delDetail(id, name){
	        			if(confirm("确认删除对象\"" + name + "\"?")){
	        				$.ajax({
	        					type: "get",
	        					url: "${pageContext.request.contextPath}/detail/delDetail?did="+id+"&dname="+name,
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
	        		
	        		
                  	</script>
                
            </div>
        </div>
    </div>
</body>
</html>
