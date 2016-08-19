<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="narver.jsp" flush="true" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html xmlns="http://www.w3.org/1999/xhtml">
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
	</div>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
				<c:forEach var="comment" items="${comments }">
					<li>
						<dl>
							<dt>${comment.ecContent }</dt>
							<dd class="author">${comment.easyBuyUser.euUserName } <span class="timer"><fmt:formatDate value="${comment.ecCreateTime}" pattern="yyyy-MM-dd hh:mm:ss"/></span></dd>
							<dd>${comment.ecReply }</dd>
						</dl>
					</li>
				</c:forEach>
				
			</ul>
			<div class="clear"></div>
<!-- 			<div class="pager"> -->
<!-- 				<ul class="clearfix"> -->
<!-- 					<li><a href="#">上一页</a></li> -->
<!-- 					<li class="current">1</li> -->
<!-- 					<li><a href="#">2</a></li> -->
<!-- 					<li><a href="#">3</a></li> -->
<!-- 					<li><a href="#">4</a></li> -->
<!-- 					<li><a href="#">5</a></li> -->
<!-- 					<li><a href="#">下一页</a></li> -->
<!-- 				</ul> -->
<!-- 			</div> -->
			<div id="reply-box">
				<form action="/easybuy/comment/commentCreate">
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="easyBuyUser.euUserName" value="${sessionScope.user.euUserName }" readonly="readonly"/></td>
						</tr>
<!-- 						<tr> -->
<!-- 							<td class="field">留言标题：</td> -->
<!-- 							<td><input class="text" type="text" name="guestTitle" /></td> -->
<!-- 						</tr> -->
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="ecContent"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit" name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
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
