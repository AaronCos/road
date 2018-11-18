<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="${path}/css/style.css" />
<script type="text/javascript" src="${path}/scripts/function.js">
	
</script>
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
		document.getElementById("veryCode").src = "${pageContext.request.contextPath}/checkCodea="
				+ date.getTime();
	}
</script>
</head>
<body>
		<!-- 头部信息 -->
	<jsp:include page="top.jsp"></jsp:include>
	<div id="register" class="wrap">
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>欢迎回到易买网</h1>
				<h3 style="text-align: center; color: red">${sessionScope.message}</h3>
				<form id="loginForm" method="post" action="DoLogin"
					onsubmit="checkForm(this)">
					<table>
						<tr>
							<td class="field">用户名：</td>
							<td><input class="text" type="text" name="userName"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /> <span></span>${requestScope.message}
							</td>
						</tr>
						<tr>
							<td class="field">登录密码：</td>
							<td><input class="text" type="password" id="passWord"
								name="passWord" onfocus="FocusItem(this)"
								onblur="CheckItem(this);" /> <span></span></td>
						</tr>
						<tr>
							<td class="field">验证码：</td>
							<td><input class="text verycode" type="text" name="veryCode"
								onfocus="FocusItem(this)" onblur="CheckItem(this);" /> <img
								id="veryCode" onclick="flushValidataCode()" src="${pageContext.request.contextPath}/checkCode" />
								<a href="javascript:flushValidataCode();">看不清</a><span></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-green"> <input type="submit"
									name="submit" value="立即登录" />
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
</body>
</html>
