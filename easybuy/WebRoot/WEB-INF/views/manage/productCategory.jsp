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
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
		<jsp:include page="narver.jsp" flush="true" />
</div>

<div id="main" class="wrap">
	<jsp:include page="sidebar.jsp" flush="true" />
	<div class="main">
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>
				<c:set var="num" value="1" />
				<c:forEach var="item1" items="${ebpcs}">
			  <c:if test="${item1.epcParentId==0}">
			  <tr>
					<td class="first w4 c">${num }</td>
					<c:set value="${num+1 }" var="num"></c:set>
					<td>${item1.epcName }</td>
					<td class="w1 c"><a href="/easybuy/productCategory/enterProductCategoryUpdate/${item1.epcId }">修改</a> <a href="/easybuy/productCategory/enterProductCategoryDelete/${item1.epcId }">删除</a></td><!-- javascript:productCategoryDelete(${item1.epcId }); -->
				</tr>
			  </c:if>
			  <c:forEach var="item2" items="${ebpcs}">
         		<c:if test="${item2.epcParentId==item1.epcId}">
         		<tr>
					<td class="first w4 c">${num }</td>
					<c:set value="${num+1 }" var="num"></c:set>
					<td class="childClass">${item2.epcName}</td>
					<td class="w1 c"><a href="/easybuy/productCategory/enterProductCategoryUpdate/${item2.epcId }">修改</a> <a href="/easybuy/productCategory/enterProductCategoryDelete/${item2.epcId }">删除</a></td>
				</tr>
            	</c:if>
              </c:forEach>
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
