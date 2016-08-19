<%@page import="sdust.easybuy.model.EasyBuyUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
EasyBuyUser user = (EasyBuyUser)session.getAttribute("user");
if(user==null){
	response.sendRedirect("/easybuy/user/enterLogin");
}else{
out.println();}
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
	  <div id="logo"><img src="<%=basePath%>images/logo.gif" /></div>
	  <div><strong>温馨提示 : </strong>本网站为学生在校的实训项目作业，只用与学习途径，不用于任何商业用途。最终解释权归本人所有。</div>
	  <div class="help"><a href="/easybuy/index/firstPage">返回前台页面</a></div>
	  <div class="navbar">
		<ul class="clearfix">
		  <li><a href="/easybuy/manage/enterManage">首页</a></li> <!-- class="current" -->
		  <li><a href="/easybuy/user/enterUserManage">用户</a></li>
		  <li><a href="/easybuy/product/enterProductManage">商品</a></li>
		  <li><a href="/easybuy/order/enterOrderManage">订单</a></li>
		  <li><a href="/easybuy/comment/enterCommentManage">留言</a></li>
		  <li><a href="/easybuy/news/enterNewsManage">新闻</a></li>
		</ul>
	  </div>
	  
	<div id="childNav">
	  <div class="welcome wrap">
		管理员${sessionScope.user.euUserName }您好，今天是<fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" />，欢迎回到管理后台。
	  </div>
	</div>
	