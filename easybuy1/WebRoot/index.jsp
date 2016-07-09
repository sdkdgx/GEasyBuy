<%@page import="java.text.DecimalFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="sdust.easybuy.model.EasyBuyProduct"%>
<%@page import="sdust.easybuy.services.EasyBuyProductService"%>
<%@page import="sdust.easybuy.services.EasyBuyNewsService"%>
<%@page import="sdust.easybuy.model.EasyBuyNews"%>
<%@page import="sdust.easybuy.model.EasyBuyComment"%>
<%@page import="sdust.easybuy.services.EasyBuyCommentService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>易买网 - 首页2</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath %>css/style.css" />
    <script type="text/javascript" src="<%=basePath %>scripts/function.js"></script>
  </head>
  <body>
	<div id="header" class="wrap">
	  <div id="logo">
		<img src="<%=basePath %>images/logo.gif" />
	  </div>
	  <div class="help">
		<a href="#" class="shopping">购物车</a>
		<a href="login/enterLogin">登录</a>
		<a href="register.html">注册</a>
		<a href="guestbook.html">留言</a>
	  </div>
	  <div class="navbar">
		<ul class="clearfix">
		  <li class="current"><a href="#">首页</a></li>
		  <li><a href="#">图书</a></li>
		  <li><a href="#">百货</a></li>
		  <li><a href="#">品牌</a></li>
		  <li><a href="#">促销</a></li>
		</ul>
	  </div>
	</div>
	<div id="childNav">
	  <div class="wrap">
		<ul class="clearfix">
		  <li class="first"><a href="#">音乐</a></li>
		  <li><a href="#">电影</a></li>
		  <li><a href="#">少儿</a></li>
		  <li><a href="#">动漫</a></li>
		  <li><a href="#">小说</a></li>
		  <li><a href="#">外语</a></li>
		  <li><a href="#">数码相机</a></li>
	 	  <li><a href="#">笔记本</a></li>
		  <li><a href="#">羽绒服</a></li>
		  <li><a href="#">秋冬靴</a></li>
		  <li><a href="#">运动鞋</a></li>
		  <li><a href="#">美容护肤</a></li>
		  <li><a href="#">家纺用品</a></li>
		  <li><a href="#">婴幼奶粉</a></li>
		  <li><a href="#">饰品</a></li>
		  <li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	  </div>
	</div>
	<div id="main" class="wrap">
	  <div class="lefter">
	 	<div class="box">
		  <h2>商品分类</h2>
		  <dl>
			<dt>图书音像</dt>
			<dd>
			  <a href="product-list.html">图书</a>
			</dd>
			<dd>
			  <a href="product-list.html">音乐</a>
			</dd>
			<dt>百货</dt>
			<dd>
			  <a href="product-list.html">运动健康</a>
			</dd>
			<dd>
			  <a href="product-list.html">服装</a>
			</dd>
			<dd>
			  <a href="product-list.html">家居</a>
			</dd>
			<dd>
			  <a href="product-list.html">美妆</a>
			</dd>
			<dd>
			  <a href="product-list.html">母婴</a>
			</dd>
			<dd>
			  <a href="product-list.html">食品</a>
			</dd>
			<dd>
			  <a href="product-list.html">手机数码</a>
			</dd>
			<dd>
			  <a href="product-list.html">家具首饰</a>
			</dd>
			<dd>
			  <a href="product-list.html">手表饰品</a>
			</dd>
			<dd>
			  <a href="product-list.html">鞋包</a>
			</dd>
			<dd>
			  <a href="product-list.html">家电</a>
			</dd>
			<dd>
			  <a href="product-list.html">电脑办公</a>
			</dd>
			<dd>
			  <a href="product-list.html">玩具文具</a>
			</dd>
			<dd>
			  <a href="product-list.html">汽车用品</a>
			</dd>
		  </dl>
		</div>
		<div class="spacer"></div>
		  <div class="last-view">
			<h2>最近浏览</h2>
			  <dl class="clearfix">
			  <%
				  	EasyBuyProductService productService = new EasyBuyProductService();
				  	List<EasyBuyProduct> products = productService.getAllProducts();
				  	for(EasyBuyProduct product : products){
				   %>
				   	<dt>
						<img src=<%=basePath %><%=product.getEpFileName() %> height="55" width="55"/>
					</dt>
					<dd>
						<a href="product-view.html" ><%=product.getEpName() %></a>
					</dd>
				  <%
				    }
				   %>
				</dl>
			</div>
		</div>
		<div class="main">
			<div class="price-off">
				<h2>今日特价</h2>
				<ul class="product clearfix">
					<%
				  	products = productService.getAllProducts();
				  	for(EasyBuyProduct product : products){
				   %>
				   	<li>
						<dl>
							<dt>
								<a href="product-view.html" target="_blank"><img
									src=<%=basePath %><%=product.getEpFileName() %> /></a>
							</dt>
							<dd class="title">
								<a href="product-view.html" target="_blank"><%=product.getEpName() %></a>
							</dd>
							原价:<dd class="beforeDiscount"><%=product.getEpPrice() %></dd>
							特价:<dd class="price"><%=new DecimalFormat("0.00").format(product.getEpPrice()*0.8) %></dd>
						</dl>
					</li>
				  <%
				    }
				   %>
					
					
				</ul>
			</div>
			<div class="side">
				<div class="news-list">
					<h4>最新公告</h4>
					<ul>
					  <%
					  	EasyBuyCommentService commentService = new EasyBuyCommentService();
					  	List<EasyBuyComment> comments = commentService.getAllComments();
					  	for(EasyBuyComment comment : comments){
					   %>
					   	<li><a href="news-view.html" target="_blank"><%=comment.getEcContent() %></a></li>
					  <%
					    }
					   %>
					</ul>
				</div>
				<div class="spacer"></div>
				<div class="news-list">
					<h4>新闻动态</h4>
					<ul>
					  <%
					  	EasyBuyNewsService newsService = new EasyBuyNewsService();
					  	List<EasyBuyNews> newses = newsService.getTopNewses();
					  	for(EasyBuyNews news : newses){
					   %>
					   	<li><a href="news-view.html" target="_blank"><%=news.getEnTitle() %></a></li>
					  <%
					    }
					   %>
					</ul>
				</div>
			</div>
			<div class="spacer clear"></div>
			<div class="hot">
				<h2>热卖推荐</h2>
				<ul class="product clearfix">
				  <%
				  	products = productService.getAllProducts();
				  	for(EasyBuyProduct product : products){
				   %>
				   	<li>
						<dl>
							<dt>
								<a href="product-view.html" target="_blank"><img
									src=<%=basePath %><%=product.getEpFileName() %> /></a>
							</dt>
							<dd class="title">
								<a href="product-view.html" target="_blank"><%=product.getEpName() %></a>
							</dd>
							<dd class="price"><%=product.getEpPrice() %></dd>
						</dl>
					</li>
				  <%
				    }
				   %>
				</ul>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北风教育 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
