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
<link type="text/css" rel="stylesheet" href="<%=basePath %>css/style.css" />
<script type="text/javascript" src="<%=basePath %>scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<jsp:include page="narver.jsp" flush="true" />
</div>

<div id="main" class="wrap">
<jsp:include page="sidebar.jsp" flush="true"/>
	
	<div class="main">
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
				<form method="get">
					订单号：<input type="text" class="text" name="orderId" /> 订货人：<input type="text" class="text" name="userName" /> <label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>发货地址</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach var="order" items="${orders }" varStatus="item">
					<tr>
						<td class="first w4 c">${item.count }</td>
						<td class="w1 c">${order.easyBuyUser.euUserName }</td>
						<td>${order.eoRerAddress }</td>
						<td class="w1 c">
							<c:if test="${order.eoStatus == 1}">下单</c:if>
							<c:if test="${order.eoStatus == 2}">审核通过</c:if>
							<c:if test="${order.eoStatus == 3}">配货</c:if>
							<c:if test="${order.eoStatus == 4}">送货中</c:if>
							<c:if test="${order.eoStatus == 5}">收货并确认</c:if>
						</td>
						<td class="w1 c"><a href="/easybuy/order/enterOrderModify/${order.eoId }">修改</a> <a href="/easybuy/order/enterOrderDelete/${order.eoId }">删除</a></td><!-- javascript:Delete(1); -->
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
