<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>后台管理 - 易买网</title>
	<link type="text/css" rel="stylesheet" href="../css/style.css" />
	<script type="text/javascript" src="../scripts/function-manage.js"></script>    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  <div id="header" class="wrap">
	<jsp:include page="narver.jsp" flush="true" />
</div>
<div id="main" class="wrap">
	<jsp:include page="sidebar.jsp" flush="true"/>
	<div class="main">
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<c:forEach var="user" items="${users}" varStatus="item">
					<tr>
						<td class="first w4 c">${item.count }</td>
						<td class="w1 c">${user.euUserName}</td>
						<td class="w2 c">
							<c:if test="${user.euSex == 0}">男</c:if>
							<c:if test="${user.euSex == 1}">女</c:if>
						</td>
						<td>${user.euEmail}</td>
						<td class="w4 c">${user.euMobile}</td>
						<c:if test="${user.euStatus == 1 }">
							<td class="w1 c"><a href="/easybuy/user/userModify/${user.euUserId}">修改</a> </td><!-- <a href="javascript:Delete(1);">删除</a> -->
						</c:if>
						<c:if test="${user.euStatus == 2 }">
							<td class="w1 c"></td>
						</c:if>
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
