<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="loginControl.jsp"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>易买网 - 首页</title>
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		<script type="text/javascript" src="scripts/function.js">
</script>
		<script type="text/javascript">
function selectCategory(c_id) {
	var categorys = document.getElementsByTagName('li');
	for ( var i = 0; i < categorys.length - 1; i++) {
		if (categorys[i].name == 'category') {
			if (categorys[i].id == c_id) {
				categorys[i].className = "current";
				if (categorys[i].id == 0) {
					location.href = "DoIndex";
				}
			} else {
				categorys[i].className = "";
			}
		}
	}
	text_onkeyup(c_id);
}
function text_onkeyup(c_id) {
	var xhr;
	if (window.XmLHttpRequest) {
		xhr = new XmlHttpRequest();
	} else {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	var url = "DoCategorySelect?keyWord=" + c_id;
	xhr.open("GET", url, true);
	xhr.onreadystatechange = function() {
		if (xhr.readystate == 4 && xhr.status == 200) {
			if (xhr.responseText.length != 0) {
				var result = xhr.responseText.split('-');
				var clew = "";
				for ( var i = 0; i < result.length; i++) {
					clew += "<li><a href='DoProductByTopCategory?name="
							+ result[i] + "'>";
					clew += result[i];
					clew += "</li>";
				}
				document.getElementById("select").innerHTML = clew;
			}

		}
	};
	xhr.send(null);
}
</script>
	</head>
	<body>
		<div id="header" class="wrap">
			<div id="logo">
				<img src="images/logo.gif" />
			</div>
			<f:if test="${sessionScope.user == null}">
				<div class="help">
					<a href="#" class="shopping">购物车</a><a href="sswh/login.jsp">登录</a><a
						href="register.jsp">注册</a><a href="DoCommentList">留言</a>
				</div>
			</f:if>
			<f:if test="${sessionScope.user != null}">
				<div class="help">
					欢迎您：${sessionScope.user.u_name}
					<a href="DoExitLogin">退出</a>
				</div>
			</f:if>
			<div class="navbar">
				<ul class="clearfix">
					<li id="0" name="category" class="current">
						<a href="javascript:selectCategory('0');">首页</a>
					</li>
					<f:forEach var="cate" items="${Parents}">
						<li name="category" id="${cate.c_id}">
							<a href="javascript:selectCategory('${cate.c_id}');">${cate.c_name}</a>
						</li>
					</f:forEach>
				</ul>
			</div>
		</div>
		<div id="position" class="wrap">
			您现在的位置：
			<a href="DoIndex">易买网</a> &gt; 购物车
		</div>
		<div class="wrap">
			<div id="shopping">
				<form action="DoBackShoppingResult" method="post">
					<table>
						<tr>
							<th>
								商品名称
							</th>
							<th>
								商品价格
							</th>
							<th>
								购买数量
							</th>
							<th>
								操作
							</th>
						</tr>
						<f:forEach items="${sessionScope.cart}" var="pro">
							<tr id="product_id_${pro.id}">
								<td class="thumb">
									<img src="${pro.fileName}" />
									<a href="product-view.jsp">${pro.name}</a>
								</td>
								<td class="price" id="price_id_${pro.id}">
									<span id="product_price_${pro.id}">￥${pro.price *
										pro.count}</span>
									<input type="hidden" value="99" />
								</td>
								<td class="number">
									<dl>
										<dt>
											<input id="number_id_${pro.id}" type="text" name="number"
												value="${pro.count}" />
										</dt>
										<dd onclick="updateCart('${pro.id}','${pro.price}')">
											修改
										</dd>
									</dl>
								</td>
								<td class="delete">
									<a href="javascript:deleteShopping('${pro.id}');">删除</a>
								</td>
							</tr>
						</f:forEach>
						<h4 style="float: left;color:red">修改只能输入数字</h4>
					</table>
					<div class="button">
						<input type="submit" value="" />
					</div>
				</form>
			</div>
			
			<script type="text/javascript">
document.write("Cookie中记录的购物车商品ID：" + getCookie("product") + "，可以在动态页面中进行读取");
</script>
		</div>
		<div id="footer">
			Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
		</div>
	</body>
</html>