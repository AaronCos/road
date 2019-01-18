<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="loginControl.jsp"%>
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
//进行数据的滚动显示
function initData() {
	//获得第一个容器的id
	var container = document.getElementById("container");
	//获得第二个容器id
	var copycTable = document.getElementById("copycTable");
	//将第一个容器的内容复制到第二个容器中
	copycTable.innerHTML = container.innerHTML;
	//启动定时器
	titar = setInterval("move()", 50);
}
//滚动信息效果函数
function move() {
	//获得第一个容器的id
	var container = document.getElementById("container");
	//获得显示信息的表格的id 
	var Tbale1 = document.getElementById("Li");
	//获取表格的高度
	var Tbale1Height = parseInt(Tbale1.currentStyle.height);
	//滚动的数据进行数据的++
	container.scrollTop++;
	if (container.scrollTop == Tbale1Height) {
		container.scrollTop = 0;
	}
}
//定义计时器
var titar;
//进行鼠标的事件,关闭计时器
function over_payce() {
	clearInterval(titar);
}
function out_connetion() {
	titar = setInterval("move()", 50);
}

//进行数据的滚动显示
function initDatas() {
	//获得第一个容器的id
	var container = document.getElementById("containers");
	//获得第二个容器id
	var copycTable = document.getElementById("copycTables");
	//将第一个容器的内容复制到第二个容器中
	copycTable.innerHTML = container.innerHTML;
	//启动定时器
	titare = setInterval("moves()", 40);
}
//滚动信息效果函数
function moves() {
	//获得第一个容器的id
	var container = document.getElementById("containers");
	//获得显示信息的表格的id 
	var Tbale1 = document.getElementById("Lis");
	//获取表格的高度
	var Tbale1Height = parseInt(Tbale1.currentStyle.height);
	//滚动的数据进行数据的++
	container.scrollTop++;
	if (container.scrollTop == Tbale1Height) {
		container.scrollTop = 0;
	}
}
//定义计时器
var titare;

//进行鼠标的事件,关闭计时器
function over_payces() {
	clearInterval(titare);
}
function out_connetions() {
	titare = setInterval("moves()", 40);
}
window.onload = function() {
	initData();
	initDatas();
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
					<a href="shopping.jsp" class="shopping">购物车</a><a
						href="DoCommentList">留言</a><a href="DoExitLogin">退出</a>
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
		<div id="position" class="wrap" height="30">
			<li>
				您当前的位置是：易买网&nbsp; &nbsp; 新闻动态&nbsp; &nbsp; ${requestScope.n.title}
			</li>
		</div>
		<div id="main" class="wrap">
			<div class="left-side">
				<div class="news-list">
					<h4>
						最新公告
					</h4>
					<ul>
						<div id="container" onmouseover="over_payce()"
							onmouseout="out_connetion()">
							<f:forEach items="${requestScope.news}" var="n">
								<li id="Li">
									<a href="DoNewsList?newsId=${n.id }" target="_blank">${n.title
										}</a>
								</li>
								<div id="copycTable"></div>
							</f:forEach>
						</div>
					</ul>
				</div>
				<div class="spacer"></div>
				<div class="news-list">
					<h4>
						新闻动态
					</h4>
					<ul>
						<div id="containers" onmouseover="over_payces()"
							onmouseout="out_connetions()">
							<f:forEach items="${requestScope.news}" var="n">
								<li id="Lis">
									<a href="DoNewsList?newsId=${n.id }" target="_blank">${n.title
										}</a>
								</li>
								<div id="copycTables"></div>
							</f:forEach>
						</div>
					</ul>
				</div>
			</div>
			<div id="news" class="right-main">
				<h1>
					${requestScope.n.title }
				</h1>
				<div class="content">
					${requestScope.n.content }
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div id="footer">
			Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
		</div>
	</body>
</html>
