<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../DoIndex">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="DoBackUserList">用户</a></li>
			<li><a href="DoProductBackSelectAll">商品</a></li>
			<li class="current"><a href="DoBackOrderList">订单</a></li>
			<li><a href="DoBackCommentList">留言</a></li>
			<li><a href="DoBackNewsList">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员${sessionScope.user.u_name }您好，今天是${sessionScope.strCurrentTime }，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><em><a href="user-add.jsp">新增</a></em><a href="DoBackUserList">用户管理</a></dd>
				<dt>商品信息</dt>
				<dd><em><a href="DoProductClassBackAddSelect">新增</a></em><a href="DoProductClassBackSelect">分类管理</a></dd>
				<dd><em><a href="DoProductBackAddSelect">新增</a></em><a href="DoProductBackSelectAll">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="DoBackOrderList">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="DoBackCommentList">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="DoBackNewsList">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>修改订单</h2>
		<div class="manage">
			<form action="DoBackOrderUpdate" method="post">
				<table class="form">
					<tr>
						<td class="field">订单ID：</td>
						<td><input type="text" class="text" name="orderId" value="${requestScope.order.o_id }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">订购人姓名：</td>
						<td><input type="text" class="text" name="userName" value="${requestScope.order.o_u_name }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">订购人地址：</td>
						<td><input type="text" class="text" name="userAddress" value="${requestScope.order.o_u_address }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">总金额：</td>
						<td><input type="text" class="text" name="cost" value="${requestScope.order.o_cost }" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">下单日期：</td>
						<td><input type="text" class="text" name="date" value="${requestScope.order.o_c_time }" readonly="readonly" /></td>
					</tr>
					<f:if test="${requestScope.order.o_status == 1}">
					<tr>
						<td class="field">订单状态：</td>
						<td>
						<select name="status">
						<option value="1" selected="selected">下单</option>
						<option value="2">审核通过</option>
						<option value="3">配货</option>
						<option value="4">送货中</option>
						<option value="5">收货并付款</option>
						</select>
						</td>
					</tr>
					</f:if>
					<f:if test="${requestScope.order.o_status == 2}">
					<tr>
						<td class="field">订单状态：</td>
						<td>
						<select name="status">
						<option value="1">下单</option>
						<option value="2" selected="selected">审核通过</option>
						<option value="3">配货</option>
						<option value="4">送货中</option>
						<option value="5">收货并付款</option>
						</select>
						</td>
					</tr>
					</f:if>
					<f:if test="${requestScope.order.o_status == 3}">
					<tr>
						<td class="field">订单状态：</td>
						<td>
						<select name="status">
						<option value="1">下单</option>
						<option value="2">审核通过</option>
						<option value="3" selected="selected">配货</option>
						<option value="4">送货中</option>
						<option value="5">收货并付款</option>
						</select>
						</td>
					</tr>
					</f:if>
					<f:if test="${requestScope.order.o_status == 4}">
					<tr>
						<td class="field">订单状态：</td>
						<td>
						<select name="status">
						<option value="1">下单</option>
						<option value="2">审核通过</option>
						<option value="3">配货</option>
						<option value="4" selected="selected">送货中</option>
						<option value="5">收货并付款</option>
						</select>
						</td>
					</tr>
					</f:if>
					<f:if test="${requestScope.order.o_status == 5}">
					<tr>
						<td class="field">订单状态：</td>
						<td>
						<select name="status">
						<option value="1">下单</option>
						<option value="2">审核通过</option>
						<option value="3">配货</option>
						<option value="4">送货中</option>
						<option value="5" selected="selected">收货并付款</option>
						</select>
						</td>
					</tr>
					</f:if>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
