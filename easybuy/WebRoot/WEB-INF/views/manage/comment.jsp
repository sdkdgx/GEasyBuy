<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<jsp:include page="narver.jsp" flush="true" />
</div>
<div id="main" class="wrap">
	<jsp:include page="sidebar.jsp" flush="true"/>
	<div class="main">
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>留言内容</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach var="comment" items="${comments }" varStatus="item">
				<tr>
					<td class="first w4 c">${item.count }</td>
					<td class="w1 c">${comment.easyBuyUser.euUserName }</td>
					<td>${comment.ecContent }</td>
					<td class="w1 c">已回复</td>
					<td class="w1 c"><a href="/easybuy/comment/enterCommentModify/${comment.ecId}">回复</a> <a href="/easybuy/comment/enterCommentDelete/${comment.ecId}">删除</a></td><!-- javascript:Delete(1); -->
				</tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
