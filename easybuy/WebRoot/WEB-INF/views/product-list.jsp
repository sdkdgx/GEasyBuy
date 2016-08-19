<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<c:forEach var="item" items="${sessionScope.recentList}">
					<li style="list-style-type: none;">
						<dl>
							<dt><a href="/easybuy/product/showView/${item.epId}" target="_blank"><img src="${item.epFileName}" width="55" height="55" /></a></dt>
							<dd class="title"><a href="/easybuy/product/showView/${item.epId}" target="_blank">${item.epName}</a></dd>
							
						</dl>
					</li>
				</c:forEach>
			</dl>

		</div>
	</div>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${pageIndex>1}">
                    <li><a href="/easybuy/productCategory/getProductsByEpcId/${epcId}?pageIndex=${pageIndex-1}">上一页</a></li>
                    </c:if>
                    <%--<li class="current">1</li>
                    <li><a href="#">2</a></li>--%>
                    <c:forEach var="page" begin="1" end="${totalPage}">
                    <c:if test="${pageIndex==page}">
                        <li class="current">${page}</a></li>
                    </c:if>
                    <c:if test="${pageIndex!=page}">
                        <li><a href="/easybuy/productCategory/getProductsByEpcId/${epcId}?pageIndex=${page}">${page}</a></li>
                    </c:if>
                    </c:forEach>

                    <c:if test="${pageIndex<totalPage}">
                    <li><a href="/easybuy/productCategory/getProductsByEpcId/${epcId}?pageIndex=${pageIndex+1}">下一页</a></li>
                    </c:if>
				</ul>
			</div>
			<div class="clear"></div>
			<ul class="product clearfix">
			
				<c:forEach var="item" items="${products}">
					<li>
						<dl>
							<dt><a href="/easybuy/product/showView/${item.epId}" target="_blank"><img src="${item.epFileName}" /></a></dt>
							<dd class="title"><a href="/easybuy/product/showView/${item.epId}" target="_blank">${item.epName}</a></dd>
							<dd class="price">${item.epPrice}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${pageIndex>1}">
                    <li><a href="/easybuy/productCategory/getProductsByEpcId/${epcId}?pageIndex=${pageIndex-1}">上一页</a></li>
                    </c:if>
                    <%--<li class="current">1</li>
                    <li><a href="#">2</a></li>--%>
                    <c:forEach var="page" begin="1" end="${totalPage}">
                    <c:if test="${pageIndex==page}">
                        <li class="current">${page}</a></li>
                    </c:if>
                    <c:if test="${pageIndex!=page}">
                        <li><a href="/easybuy/productCategory/getProductsByEpcId/${epcId}?pageIndex=${page}">${page}</a></li>
                    </c:if>
                    </c:forEach>

                    <c:if test="${pageIndex<totalPage}">
                    <li><a href="/easybuy/productCategory/getProductsByEpcId/${epcId}?pageIndex=${pageIndex+1}">下一页</a></li>
                    </c:if>
				</ul>
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
