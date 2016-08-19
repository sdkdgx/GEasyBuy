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
		<h2>修改订单</h2>
		<div class="manage">
			<form action="/easybuy/order/orderUpdate">
				<input type="hidden" name="easyBuyUser.euUserId" value="${order.easyBuyUser.euUserId}" readonly="readonly"/>
				<input type="hidden" name="eoRerAddress" value="${order.eoRerAddress }">
				<table class="form">
					<tr>
						<td class="field">订单ID：</td>
						<td><input type="text" class="text" name="eoId" value="${order.eoId }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">订购人姓名：</td>
						<td><input type="text" class="text" name="easyBuyUser.euUserName" value="${order.easyBuyUser.euUserName}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td class="field">订单创建时间：</td>
						<td><input type="text" class="text" name="eoCreateTime" value="${order.eoCreateTime }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">订单状态：</td>
						<td>
							<select name="eoStatus">
								<option value="1">下单</option>
								<option value="2">审核通过</option>
								<option value="3">配货</option>
								<option value="4">送货中</option>
								<option value="5">收货并确认</option>
							</select>
<!-- 							<input type="text" class="text" name="eoStatus" value="${order.eoStatus }"/> -->
						</td>
					</tr>
					<tr>
						<td class="field">订单支付方式：</td>
						<td>
							<select name="eoType">
								<option value="1">货到付款</option>
								<option value="2">网上支付</option>
							</select>
<!-- 							<input type="text" class="text" name="eoType" value="${order.eoType }"/> -->
						</td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
