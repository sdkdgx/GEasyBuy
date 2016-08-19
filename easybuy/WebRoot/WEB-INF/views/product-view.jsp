<%@page import="sdust.easybuy.model.EasyBuyProduct"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
	您现在的位置：<a href="index.jsp">易买网</a> &gt; <a href="product-list.jsp">图书音像</a> &gt; 图书
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach var="item1" items="${productCategories}">
			  <c:if test="${item1.epcParentId==0}">
				<dt>${item1.epcName}</dt>
			  </c:if>
			  <c:forEach var="item2" items="${productCategories}">
         		<c:if test="${item2.epcParentId==item1.epcId}">
              	  <dd>
              	    <a href="/easybuy/productCategory/getProductsByEpcId/${item2.epcId}">${item2.epcName}</a>
              	  </dd>
            	</c:if>
              </c:forEach>
			</c:forEach>
			</dl>
		</div>
	</div>
	<div id="product" class="main">
		<h1>${product.epName}</h1>
		<div class="infos">
			<div class="thumb"><img src="${product.epFileName}" width="300" height="300" /></div>
			<div class="buy">
				<c:if test="${product.epSpecial==0 }">
					<p>商城价：<span class="price">￥${product.epPrice}</span></p>
				</c:if>
				<c:if test="${product.epSpecial==1 }">
					<p>特价：
						<span class="price">
							￥<fmt:formatNumber type="number" value="${product.epPrice * 0.8}" maxFractionDigits="3" pattern="#.00"/>
						</span></p>
					<p >原价：<span><s>￥${product.epPrice}</s></span></p>
				</c:if>
				<p>库　存：${product.epStock }</p>
				<div class="button"><input type="button" name="button" value="" onclick="goBuy(1, ${product.epId})" /><a href="/easybuy/cart/addNewProduct/${product.epId}">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${product.epDescription }
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
