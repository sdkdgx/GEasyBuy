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
		<h2>修改新闻</h2>
		<div class="manage">
			<form action="/easybuy/news/newsUpdate">
			<input type="hidden" name="enId" value="${news.enId }">
			<input type="hidden" name="enCreateTime" value="${news.enCreateTime }">
				<table class="form">
					<tr>
						<td class="field">新闻标题：</td>
						<td><input type="text" class="text" name="enTitle" value="${news.enTitle }" /></td>
					</tr>
					<tr>
						<td class="field">创建时间：</td>
						<td><input type="text" name="enCreateTime" value="${news.enCreateTime }" readonly="readonly">
					</tr>
					<tr>
						<td class="field">新闻内容：</td>
						<td><input type="text" name="enContent" value="${news.enContent }" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="修改" /></label></td>
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
