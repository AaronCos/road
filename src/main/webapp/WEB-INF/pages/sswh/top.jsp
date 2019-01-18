<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="header" class="wrap">
	<div id="logo">
		<img src="${path}/resources/images/logo.gif" />
	</div>
	<c:if test="${sessionScope.user == null}">
		<div class="help">
			<a href="../shopping.jsp" class="shopping">购物车</a>
			<a href="${path}/page/login.do">登录</a>
			<a href="${path}/page/register.do">注册</a>
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
				<li name="category" id="c_id">
				<a href="javascript:selectCategory('c_id');">helo</a>
				</li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix" id="select">
				<li><a href="DoProductByTopCategory?name=hello">helo</a>
				</li>
		</ul>
	</div>
</div>