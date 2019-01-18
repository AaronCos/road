<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript">
function selectCategory(c_id){
	var categorys = document.getElementsByTagName('li');
		for(var i = 0;i<categorys.length-1;i++){
		if(categorys[i].name == 'category'){
			if(categorys[i].id == c_id){
			categorys[i].className = "current";
			  if(categorys[i].id==0){
			  location.href = "DoIndex";
			  }
		   }else{
			 categorys[i].className = "";
		   }	
		}	
	}
	text_onkeyup(c_id);
}
function text_onkeyup(c_id){
	var xhr;
	if(window.XmLHttpRequest){
		xhr = new XmlHttpRequest();
		}
	else{
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	    }
		var url = "DoCategorySelect?keyWord="+c_id;
		xhr.open("GET",url,true);
		xhr.onreadystatechange = function(){
			if(xhr.readystate ==4&& xhr.status == 200){
			if(xhr.responseText.length!=0){
			   var result = xhr.responseText.split('-');
			   var clew = "";
			   for(var i = 0;i<result.length;i++){
			   clew+="<li><a href='DoProductByTopCategory?name="+result[i]+"'>";
			   clew+=result[i];
			   clew+="</li>";
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
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="#" class="shopping">购物车</a><a href="sswh/login.jsp">登录</a><a href="register.jsp">注册</a><a href="DoCommentList">留言</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li id = "0"  name = "category"  class="current"><a href="javascript:selectCategory('0');">首页</a></li>
			<f:forEach var = "cate" items = "${Parents}">
			<li name = "category" id = "${cate.c_id}"><a href="javascript:selectCategory('${cate.c_id}');">${cate.c_name}</a></li>
			</f:forEach>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix" id = "select">
		<f:forEach var = "cate" items = "${categorys}">
			<li><a href="DoProductByTopCategory?name=${cate.c_name}">${cate.c_name}</a></li>
			</f:forEach>
		</ul>
	</div>
</div>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="finished"><em></em>填写注册信息</li>
				<li class="last-current"><em></em>注册成功</li>
			</ul>
			<div class="msg">
				<p>恭喜：注册成功！</p>
				<p>正在进入首页...</p>
				<script type="text/javascript">
					setTimeout("location.href='DoIndex'", 3000);
				</script>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
