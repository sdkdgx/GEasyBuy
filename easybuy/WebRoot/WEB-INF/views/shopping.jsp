<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="narver.jsp" flush="true" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="<%=basePath %>css/style.css" />
<script type="text/javascript" src="<%=basePath %>scripts/function.js"></script>
</head>
<body>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="/easybuy/order/orderCreate">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>购买数量</th>
					<th>操作</th>
				</tr>
				<c:forEach var="item" items="${sessionScope.user.easyBuyShoppingCarts}">
					<c:if test="${item.escProductQuantity > 0}">
						<tr id="product_id_1">
						<td class="thumb">
							<img src="${item.easyBuyProduct.epFileName}" height="60" width="60"/>
							<a href="/easybuy/product/showView/${item.easyBuyProduct.epId}">${item.easyBuyProduct.epName}</a>
						</td>
						<td class="price" id="price_id_1">
							<span>
								<fmt:formatNumber type="number" value="${item.easyBuyProduct.epPrice * item.escProductQuantity}" maxFractionDigits="3" pattern="#.00"/>
							</span>
							<input type="hidden" value="99" />
						</td>
						<td class="number">
							<dl>
								<dd><a href="cart/dec/${item.escId}">-</a></dd> <!-- onclick="reloadPrice(2,false);" -->
								<dt><input id="number_id_1" type="text" name="number" value="${item.escProductQuantity}" /></dt>
								<dd><a href="cart/add/${item.escId}">+</a></dd> <!--  onclick="reloadPrice(2,true);" -->
							</dl>
						</td>
						<td class="delete"><a href="cart/del/${item.escId}">删除</a></td><!-- javascript:delShopping(1); -->
						</tr>
					</c:if>
				</c:forEach>
			</table>
			<div class="button-submit"><input type="submit" value="" /></div>
		</form>
	</div>
	<script type="text/javascript">
		document.write("Cookie中记录的购物车商品ID："+ getCookie("product") + "，可以在动态页面中进行读取");
	</script>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
