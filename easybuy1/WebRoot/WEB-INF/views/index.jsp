<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="narver.jsp" flush="true" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>易买网 - 首页2</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>css/style.css" />
    <script type="text/javascript" src="<%=basePath%>scripts/function.js"></script>
  </head>
  <body>
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
              	    <a href="product-list.html">${item2.epcName}</a>
              	  </dd>
            	</c:if>
              </c:forEach>
			</c:forEach>
		  </dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
		  <h2>最近浏览</h2>
		  <dl class="clearfix">
			<c:forEach var="item" items="${products}">
              <dt>
				<img src="${item.epFileName}" height="55" width="55" />
			  </dt>
			  <dd>
				<a href="/easybuy/product/showView/${item.epId}">${item.epName }%></a>
			  </dd>
			</c:forEach>
		  </dl>
		</div>
      </div>
	  <div class="main">
		<div class="price-off">
		  <h2>今日特价</h2>
		  <ul class="product clearfix">
			<c:forEach var="item" items="${products}">
              <li>
            	<dl>
            	  <dt>
					<a href="/easybuy/product/showView/${item.epId}" target="_blank"><img src="${item.epFileName}" /></a>
				  </dt>
				  <dd class="title">
					<a href="/easybuy/product/showView/${item.epId}" target="_blank">${item.epName}</a>
				  </dd>
					原价:
				  <dd class="beforeDiscount">${item.epPrice}</dd>
					特价:
				  <dd class="price">${item.epPrice}</dd>
            	</dl>
              </li>
            </c:forEach>
		  </ul>
		</div>
		<div class="side">
		  <div class="news-list">
			<h4>最新公告</h4>
			<ul>
			  <c:forEach var="item" items="${comments}" end="6">
				<li><a href="news-view.html" target="_blank">${item.ecContent}</a></li>
			  </c:forEach>
			  </ul>
			</div>
			<div class="spacer"></div>
			<div class="news-list">
			  <h4>新闻动态</h4>
			  <ul>
				<c:forEach var="item" items="${newses}" end="6">
				  <li><a href="news-view.html" target="_blank">${item.enTitle}</a></li>
				</c:forEach>
			  </ul>
			</div>
		  </div>
		<div class="spacer clear"></div>
		<div class="hot">
		  <h2>热卖推荐</h2>
		  <ul class="product clearfix">
			<c:forEach var="item" items="${hotProducts}">
              <li>
            	<dl>
            	  <dt>
					<a href="/easybuy/product/showView/${item.epId}" target="_blank"><img src="${item.epFileName}" /></a>
				  </dt>
				  <dd class="title">
					<a href="/easybuy/product/showView/${item.epId}" target="_blank">${item.epName}</a>
				  </dd>
				  <dd class="price">${item.epPrice}</dd>
				</dl>
              </li>
            </c:forEach>
		  </ul>
		</div>
	  </div>
	  <div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北风教育 All Rights Reserved.京ICP证1000001号</div>
  </body>
</html>
