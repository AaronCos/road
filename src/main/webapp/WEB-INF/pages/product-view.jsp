<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="loginControl.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<%@include file="sswh/indexTop.jsp" %>
	</div>
	<div id="product" class="main">
		<h1>${pro.name}</h1>
		<div class="infos">
			<div class="thumb"><img width="300" height="300" src="${path}.jpg" /></div>
			<div class="buy">
				<p>商城价：<span class="price">￥${pro.price}</span></p>
				<p>库　存：${pro.stock}</p>
				<div class="button"><input type="button" name="button" value="" onclick="goCart(${pro.id})" /><a href="DoShopping?productId=${pro.id}">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${pro.description}<br />
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
