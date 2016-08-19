<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
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
	  <div id="logo"><img src="../images/logo.gif" /></div>
	  <div class="help"><a href="/easybuy/index/firstPage">返回前台页面</a></div>
	  <div class="navbar">
		<ul class="clearfix">
		  <li><a href="/easybuy/manage/enterManage">首页</a></li> <!-- class="current" -->
		  <li><a href="/easybuy/user/enterUserManage">用户</a></li>
		  <li><a href="/easybuy/product/enterProductManage">商品</a></li>
		  <li><a href="/easybuy/order/enterOrderManage">订单</a></li>
		  <li><a href="/easybuy/comment/enterCommentManage">留言</a></li>
		  <li><a href="/easybuy/news/enterNewsManage">新闻</a></li>
		</ul>
	  </div>
	</div>
	<div id="childNav">
	  <div class="welcome wrap">
		管理员${sessionScope.user.euUserName }您好，今天是<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />，欢迎回到管理后台。
	  </div>
	</div>

	<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="user-add.jsp">新增</a></em><a href="/easybuy/user/enterUserManage">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="productClass-add.jsp">新增</a></em><a href="productClass.jsp">分类管理</a></dd>
				<dd><em><a href="product-add.jsp">新增</a></em><a href="/easybuy/product/enterProductManage">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="/easybuy/order/enterOrderManage">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="/easybuy/comment/enterCommentManage">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="/easybuy/news/enterNewsManage">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="clear"></div>
</div>
  </body>
</html>
