<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="${path }/resources/css/style.css" />
<script type="text/javascript" src="${path }/resources/scripts/function.js"></script>
<script type="text/javascript" src="${path }/resources/scripts/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${path }/resources/scripts/register.js"></script>
<script type="text/javascript">
	function selectCategory(c_id) {
		var categorys = document.getElementsByTagName('li');
		for (var i = 0; i < categorys.length - 1; i++) {
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
					for (var i = 0; i < result.length; i++) {
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
	function flushValidataCode() {
		var date = new Date();
		document.getElementById("veryCode").src ="${path}/checkCode.do?a="
				+ date.getTime();
	}
</script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="${path }/resources/images/logo.gif" />
		</div>
		<div class="help">
			<a href="#" class="shopping">购物车</a><a href="sswh/login.jsp">登录</a><a
				href="register.jsp">注册</a><a href="DoCommentList">留言</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li id="0" name="category" class="current"><a
					href="javascript:selectCategory('0');">首页</a></li>
				<f:forEach var="cate" items="${Parents}">
					<li name="category" id="${cate.c_id}"><a
						href="javascript:selectCategory('${cate.c_id}');">${cate.c_name}</a>
					</li>
				</f:forEach>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="wrap">
			<ul class="clearfix" id="select">
				<f:forEach var="cate" items="${categorys}">
					<li><a href="DoProductByTopCategory?name=${cate.c_name}">${cate.c_name}</a>
					</li>
				</f:forEach>
			</ul>
		</div>
	</div>
	<div id="register" class="wrap">
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>欢迎注册易买网</h1>
				<ul class="steps clearfix">
					<li class="current"><em></em>填写注册信息</li>
					<li class="last"><em></em>注册成功</li>
				</ul>
				<h3 style="text-align: center; color: red">
					${sessionScope.massa}</h3>
				<form id="regForm" method="post" action="${path}/user/regist"
					onsubmit="checkForm(this);">
					<table>
						<tr>
							<td class="field">用户名：</td>
							<td><input class="text" type="text" name="userName"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /> <span id=""></span>
							</td>
						</tr>

						<tr>
							<td class="field">性别：</td>
							<td>
							保密<input class="sex" type="radio" id="sex" name="sex" value="9" checked="checked"/>
								
							 男<input class="sex" type="radio" id="sex" name="sex" value="1" /> 
								
							女<input class="sex" type="radio" id="sex" name="sex" value="0" />
								 <span id=""></span>
							</td>
						</tr>
						<tr>
							<td class="field">出生日期：</td>
							<td><select id="year" name="year">
									<option value="">--年--</option>
							</select>年 <select id="month" name="month" >
									<option value="">--月--</option>
							</select>月 <select id="day" name="day">
									<option value="">--日--</option>
							</select>日</td>
							<span></span>
						</tr>
						<tr>
							<td class="field">身份证：</td>
							<td><input class="text" type="text" id="identity"
								name="identity" onfocus="FocusItem(this)"
								onblur="CheckItem(this);" /> <span id="msg"></span></td>
						</tr>
						<tr>
							<td class="field">email：</td>
							<td><input class="text" type="text" id="email" name="email"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /> <span id=""></span></td>
						</tr>
						<tr>
							<td class="field">电话：</td>
							<td><input class="text" type="text" id="phone" name="phone"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /> <span id=""></span></td>
						</tr>
						<tr>
							<td class="field">地址：</td>
							<td><input class="text" type="text" id="address"
								name="address" onfocus="FocusItem(this)"
								onblur="CheckItem(this);" /> <span id=""></span></td>
						</tr>

						<tr>
							<td class="field">登录密码：</td>
							<td><input class="text" type="text" id="passWord"
								name="passWord" onfocus="FocusItem(this)"
								onblur="CheckItem(this);" /> <span id="msg"></span></td>
						</tr>

						<tr>
							<td class="field">确认密码：</td>
							<td><input class="text" type="text" name="rePassWord"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /> <span id="rePassWordmsg"></span>
							</td>
						</tr>
						<tr>
							<td class="field">验证码：</td>
							<td><input class="text verycode" type="text" name="veryCode"
								onfocus="FocusItem(this)" onblur="CheckItem(this);"/> <img
								id="veryCode" onclick="flushValidataCode()"
								src="${path}/checkCode.do"/>
								<a href="javascript:flushValidataCode();">看不清</a><span id=""></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-green"> <input type="submit"
									name="submit" value="提交注册" />
							</label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">
<jsp:include page="footer.jsp"></jsp:include>
		
	</div>
	
	<script type="text/javascript">
	
	
	$(function(){
		var $year="";
		for(var i=1980;i<=new Date().getFullYear();i++){
			$year+="<option value ='"+i+"'>"+i+"</option>";
		}
		$("#year").append($year);
		
		//判断闰年
		var isRun=false;
		
		$("#year").bind("change",function(){
			var $year=$(this).val();//获取年的值
			if($year%400==0||($year%4==0&&$year%100!=0)){
				isRun=true;
			}
			
			//加载月份
			var $month="";
			for(var i=1;i<13;i++){
			$month+="<option value ='"+i+"'>"+i+"</option>";
			}
			$("#month").html("");
			$("#month").append($month);
			
		})
		
		
	})
		//加载月份
		$("#month").bind("change",function(){
			
			var $month=$(this).val();
			var $day="";
			
			switch($month){
			case "4":
			case "6":
			case "9":
			case "11":
				$dd=30;break;
			case "5":
			case "1":
			case "3":
			case "7":
			case "8":
			case "10":
			case "12":
				$dd=31;break;
			case "2":
				if(isRun==true){
					$dd=29;
				}else{
					$dd=28;
				}
			case "defaule":
				break;
			}
			
			for(var j=1;j<$dd+1;j++){
				$day+="<option value ='"+j+"'>"+j+"</option>";
			}
			
			
			$("#day").html("");
			$("#day").append($day);
		})
	
	</script>
	
</body>
</html>
