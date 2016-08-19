<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<jsp:include page="sidebar.jsp" flush="true" />
	<div class="main">
		<h2>修改分类</h2>
		<div class="manage">
			<form action="/easybuy/productCategory/productCategoryUpdate">
				<input type="hidden" name="epcId" value="${ebpc.epcId }"/>
				<table class="form">
					<tr>
						<td class="field">父分类：</td>
						<td>
							<select name="epcParentId">
								<c:forEach var="item" items="${ebpcs }">
									<option value="${item.epcId }">${item.epcName }</option>
								</c:forEach>
								<option value="0" selected="selected">根栏目</option>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">分类名称：</td>
						<td><input type="text" class="text" name="epcName" value="${ebpc.epcName }" /></td>
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
