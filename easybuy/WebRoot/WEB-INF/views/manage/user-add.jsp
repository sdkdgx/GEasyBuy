<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:useBean id="now" class="java.util.Date" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
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
			<h2>新增用户</h2>
			<div class="manage">
				<form action="/easybuy/user/userCreate">
					<table class="form">
						<tr>
							<td class="field">用户名：</td>
							<td><input type="text" class="text" name="euUserName"
								 /></td> <!-- readonly="readonly" -->
						</tr>
						<tr>
							<td class="field">密码：</td>
							<td><input type="text" class="text" name="euPassword" /></td>
						</tr>
						<tr>
							<td class="field">性别：</td>
							<td><input type="radio" name="euSex" value="0"
								checked="checked" />男 <input type="radio" name="euSex"
								value="1" />女</td>
						</tr>
						<tr>
							<td class="field">身份证号码：</td>
							<td><input type="text" class="text" name="euIdentityCode" /></td>
						</tr>
						<tr>
							<td class="field">电子邮件：</td>
							<td><input type="text" class="text" name="euEmail" /></td>
						</tr>
						<!-- 					<tr> -->
						<!-- 						<td class="field">出生日期：</td> -->
						<!-- 						<td> -->
						<!-- 							<select name="birthyear"> -->
						<!-- 								<option value="2000">2000</option> -->
						<!-- 								<option value="1999" selected="selected">1999</option> -->
						<!-- 							</select>年 -->
						<!-- 							<select name="birthmonth"> -->
						<!-- 								<option value="12">12</option> -->
						<!-- 								<option value="11" selected="selected">11</option> -->
						<!-- 							</select>月 -->
						<!-- 							<select name="birthday"> -->
						<!-- 								<option value="2">2</option> -->
						<!-- 								<option value="1" selected="selected">1</option> -->
						<!-- 							</select>日 -->
						<!-- 						</td> -->
						<!-- 					</tr> -->
						<tr>
							<td class="field">手机号码：</td>
							<td><input type="text" class="text" name="euMobile" /></td>
						</tr>
						<tr>
							<td class="field">送货地址：</td>
							<td><input type="text" class="text" name="euAddress" /></td>
						</tr>
						<!-- 					<tr> -->
						<!-- 						<td class="field">头像：</td> -->
						<!-- 						<td><input type="file" class="text" name="photo" /></td> -->
						<!-- 					</tr> -->
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit"
									name="submit" value="新增" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2010 北风教育 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>
