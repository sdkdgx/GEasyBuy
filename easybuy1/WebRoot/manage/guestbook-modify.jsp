<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>å后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">è¿ååå°é¡µé¢</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">é¦é¡µ</a></li>
			<li><a href="user.jsp">ç¨æ·</a></li>
			<li><a href="product.jsp">åå</a></li>
			<li><a href="order.jsp">è®¢å</a></li>
			<li class="current"><a href="guestbook.jsp">çè¨</a></li>
			<li><a href="news.jsp">æ°é»</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		ç®¡çåpillysæ¨å¥½ï¼ä»å¤©æ¯2012-12-21ï¼æ¬¢è¿åå°ç®¡çåå°ã
	</div>
</div>
<div id="position" class="wrap">
	æ¨ç°å¨çä½ç½®ï¼<a href="index.jsp">æä¹°ç½</a> &gt; ç®¡çåå°
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>ç¨æ·ç®¡ç</dt>
				<dd><em><a href="user-add.jsp">æ°å¢</a></em><a href="user.html">ç¨æ·ç®¡ç</a></dd>
				<dt>ååä¿¡æ¯</dt>
				<dd><em><a href="productClass-add.jsp">æ°å¢</a></em><a href="productClass.jsp">åç±»ç®¡ç</a></dd>
				<dd><em><a href="product-add.jsp">æ°å¢</a></em><a href="product.jsp">ååç®¡ç</a></dd>
				<dt>è®¢åç®¡ç</dt>
				<dd><a href="order.jsp">è®¢åç®¡ç</a></dd>
				<dt>çè¨ç®¡ç</dt>
				<dd><a href="guestbook.jsp">çè¨ç®¡ç</a></dd>
				<dt>æ°é»ç®¡ç</dt>
				<dd><em><a href="news-add.jsp">æ°å¢</a></em><a href="news.jsp">æ°é»ç®¡ç</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>åå¤çè¨</h2>
		<div class="manage">
			<form action="manage-result.jsp">
				<table class="form">
					<tr>
						<td class="field">çè¨IDï¼</td>
						<td><input type="text" class="text" name="orderId" value="100000" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">çè¨å§åï¼</td>
						<td><input type="text" class="text" name="name" value="å¼ ä¸" /></td>
					</tr>
					<tr>
						<td class="field">çè¨åå®¹ï¼</td>
						<td>é«èåºçè´§åäºæ²¡ï¼</td>
					</tr>
					<tr>
						<td class="field">åå¤åå®¹ï¼</td>
						<td><textarea name="replyContent"></textarea></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="æ´æ°" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 åé£æè² All Rights Reserved. äº¬ICPè¯1000001å·
</div>
</body>
</html>
