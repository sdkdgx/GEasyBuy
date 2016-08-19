<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html xmlns="http://www.w3.org/1999/xhtml">
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
		<h2>商品管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>商品名称</th>
					<th>操作</th>
				</tr>
				
				<c:forEach var="product" items="${products }" varStatus="item">
					<tr>
						<td class="first w4 c">${item.count }</td>
						<td class="thumb">
							<img src="${product.epFileName}" width="60" height="60"/>
							<a href="/easybuy/product/showView/${product.epId}" target="_blank">${product.epName }</a>
						</td>
						<td class="w1 c"><a href="/easybuy/product/enterProductModify/${product.epId }">修改</a> <a href="/easybuy/product/enterProductDelete/${product.epId }">删除</a></td> <!-- javascript:Delete(1); -->
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
