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
		<h2>修改商品</h2>
		<div class="manage">
			<form action="/easybuy/product/productUpdate" method="post">
				<input type="hidden" name="epId" value="${product.epId }">
				<table class="form">
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" class="text" name="epName" value="${product.epName }" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="easyBuyProductCategory.epcId">
								<c:forEach var="ebpc" items="${ebpcs }" >
									<option value="${ebpc.epcId }">${ebpc.epcName }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td class="field">商品图片：</td> -->
<!-- 						<td><input type="file" class="text" name="photo" /></td> -->
<!-- 					</tr> -->
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" class="text tiny" name="epPrice" value="${product.epPrice }"/> 元</td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td class="field">品牌：</td> -->
<!-- 						<td><input type="text" class="text" name="productName" /></td> -->
<!-- 					</tr> -->
					<tr>
						<td class="field">库存：</td>
						<td><input type="text" class="text tiny" name="epStock"  value="${product.epStock }"/></td>
					</tr>
<!-- 					<tr> -->
<!-- 						<td class="field">条码号：</td> -->
<!-- 						<td><input type="text" class="text" name="productName" /></td> -->
<!-- 					</tr> -->
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
