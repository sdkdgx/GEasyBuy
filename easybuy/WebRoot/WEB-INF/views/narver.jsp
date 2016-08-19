<%@page import="sdust.easybuy.services.EasyBuyProductCategoryService"%>
<%@page import="sdust.easybuy.model.EasyBuyProductCategory"%>
<%@page import="sdust.easybuy.model.EasyBuyUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'narver.jsp' starting page</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath %>css/style.css" />
    <script type="text/javascript" src="<%=basePath %>scripts/function.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div id="header" class="wrap">
	  <div id="logo">
		<img src="<%=basePath %>images/logo.gif" />
	  </div>
	  <div><strong>温馨提示 : </strong>本网站为学生在校的实训项目作业，只用与学习途径，不用于任何商业用途。最终解释权归本人所有。</div>
	  <div class="help">
		<a href="/easybuy/cart/getCart/" class="shopping">购物车</a>
		<% EasyBuyUser user = (EasyBuyUser)session.getAttribute("user");
		if(user == null){ %>
		<a href="/easybuy/user/enterLogin">登录</a>
		<a href="/easybuy/user/enterRegister">注册</a>
<!-- 		<a href="/easybuy/comment/enterComment">留言</a> -->
		<%} else {%>
		<a href="/easybuy/comment/enterComment">留言</a>
		<a href="/easybuy/comment/enterComment"><%=user.getEuUserName() %></a>
		<c:if test="${sessionScope.user.euStatus == 2}">
			<a href="/easybuy/manage/enterManage">管理控制台</a>
		</c:if>
		<a href="/easybuy/user/logout">退出</a>
		<%} %>
	  </div>
	  <div class="navbar">
		<ul class="clearfix">
		  <li class="current"><a href="/easybuy/index/firstPage">首页</a></li>
		  <% List<EasyBuyProductCategory> ebpcs = new EasyBuyProductCategoryService().getFirstCategory(); request.setAttribute("ebpcs", ebpcs); %>
		  <c:forEach var="item" items="${ebpcs }">
		  	<li><a href="/easybuy/productCategory/getProductsByEpcId/${item.epcId}">${item.epcName}</a></li>
		  </c:forEach>
		</ul>
	  </div>
	</div>
	<div id="childNav">
	  <div class="wrap">
		<ul class="clearfix">
		  <% List<EasyBuyProductCategory> ebpcs2 = new EasyBuyProductCategoryService().getSecondCategory(); request.setAttribute("ebpcs", ebpcs); %>
		  <c:forEach var="item" items="${ebpcs }">
		  	<li><a href="/easybuy/productCategory/getProductsByEpcId/${item.epcId}">${item.epcName}</a></li>
		  </c:forEach>
		</ul>
	  </div>
	</div>
  </body>
</html>
