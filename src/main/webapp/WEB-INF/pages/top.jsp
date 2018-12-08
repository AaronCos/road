<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="header" class="wrap">
	<div id="logo">
		<img src="${path}/resources/images/logo.gif" />
	</div>
	<c:if test="${sessionScope.user == null}">
		<div class="help">
			<a href="shopping.jsp" class="shopping">购物车</a> 
			<a href="${path}/page/login">登录</a>
			<a href="${path}/page/register">注册</a>
			<a href="DoCommentList">留言</a>
		</div>
	</c:if>
<%-- 	<c:if test="${sessionScope.user != null}">
		<div class="help">
			欢迎您：${sessionScope.user.u_name} <a href="shopping.jsp"
				class="shopping">购物车</a>
				<a href="DoCommentList">留言</a>
				<a href="DoExitLogin">退出</a>
		</div>
	</c:if> --%>
	<div class="navbar">
		<ul class="clearfix">
			<li id="0" name="category" class="current"><a
				href="javascript:selectCategory('0');">首页</a></li>
			<c:forEach var="cate" items="${Parents}">
				<li name="category" id="${cate.c_id}">
				<a href="javascript:selectCategory('${cate.c_id}');">${cate.c_name}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix" id="select">
			<c:forEach var="cate" items="${categorys}">
				<li><a href="DoProductByTopCategory?name=${cate.c_name}">${cate.c_name}</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>