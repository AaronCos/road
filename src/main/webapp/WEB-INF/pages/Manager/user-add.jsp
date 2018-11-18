<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>后台管理 - 易买网</title>
		<link type="text/css" rel="stylesheet" href="../css/style.css" />
		<script type="text/javascript" src="../scripts/function-manage.js">
</script>
		<script>
function check() {
	var reg = /^(19\d{2}|200\d)-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2]\d|3[0-1])$/;
	var reg2 = /^1\d{10}$/;
	if (document.getElementById("eu_user_id").value == "") {
		alert("用户名不能为空！");
		return false;
	} else if (document.getElementById("eu_user_name").value == "") {
		alert("姓名不能为空！");
		return false;
	} else if (document.getElementById("eu_password").value == "") {
		alert("密码不能为空！");
		return false;
	} else if (document.getElementById("eu_password").value.length < 4) {
		alert("密码至少为4个字符！");
		return false;
	} else if (document.getElementById("eu_password").value.length > 20) {
		alert("密码长度过长！");
		return false;
	} else if (document.getElementById("eu_user_id").value.length > 20) {
		alert("用户名长度过长！");
		return false;
	} else if (document.getElementById("eu_user_name").value.length > 20) {
		alert("姓名长度过长！");
		return false;
	} else if (reg.test(document
			.getElementById("ctl00_ContentPlaceHolder1_txtExamDate").value) == false) {
		alert("出生日期格式不正确！例如:1991-1-14");
		return false;
	} else if (reg2.test(document.getElementById("eu_mobile").value) == false) {
		alert("手机号码格式不正确！必须大于十位");
		return false;
	}
	return true;
}
</script>
	</head>
	<body>
		<div id="header" class="wrap">
			<div id="logo">
				<img src="../images/logo.gif" />
			</div>
			<div class="help">
				<a href="../DoIndex">返回前台页面</a>
			</div>
			<div class="navbar">
				<ul class="clearfix">
					<li>
						<a href="index.jsp">首页</a>
					</li>
					<li class="current">
						<a href="DoBackUserList">用户</a>
					</li>
					<li>
						<a href="DoProductBackSelectAll">商品</a>
					</li>
					<li>
						<a href="DoBackOrderList">订单</a>
					</li>
					<li>
						<a href="DoBackCommentList">留言</a>
					</li>
					<li>
						<a href="DoBackNewsList">新闻</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="childNav">
			<div class="welcome wrap">
				管理员${sessionScope.user.u_name }您好，今天是${sessionScope.strCurrentTime
				}，欢迎回到管理后台。
			</div>
		</div>
		<div id="position" class="wrap">
			您现在的位置：
			<a href="index.jsp">易买网</a> &gt; 管理后台
		</div>
		<div id="main" class="wrap">
			<div id="menu-mng" class="lefter">
				<div class="box">
					<dl>
						<dt>
							用户管理
						</dt>
						<dd>
							<em><a href="user-add.jsp">新增</a> </em><a href="DoBackUserList">用户管理</a>
						</dd>
						<dt>
							商品信息
						</dt>
						<dd>
							<em><a href="DoProductClassBackAddSelect">新增</a> </em><a
								href="DoProductClassBackSelect">分类管理</a>
						</dd>
						<dd>
							<em><a href="DoProductBackAddSelect">新增</a> </em><a
								href="DoProductBackSelectAll">商品管理</a>
						</dd>
						<dt>
							订单管理
						</dt>
						<dd>
							<a href="DoBackOrderList">订单管理</a>
						</dd>
						<dt>
							留言管理
						</dt>
						<dd>
							<a href="DoBackCommentList">留言管理</a>
						</dd>
						<dt>
							新闻管理
						</dt>
						<dd>
							<em><a href="news-add.jsp">新增</a> </em><a href="DoBackNewsList">新闻管理</a>
						</dd>
					</dl>
				</div>
			</div>
			<div class="main">
				<h2>
					新增用户
				</h2>
				<div class="manage">
					<form action="DoBackUserAdd" method="post"
						onsubmit="return check()">
						<table class="form">
							<tr>
								<td class="field">
									用户名：
								</td>
								<td>
									<input type="text" class="text" name="eu_user_id"
										id="eu_user_id" value="" />
								</td>
							</tr>
							<tr>
								<td class="field">
									姓名：
								</td>
								<td>
									<input type="text" class="text" name="eu_user_name"
										id="eu_user_name" value="" />
								</td>
							</tr>
							<tr>
								<td class="field">
									密码：
								</td>
								<td>
									<input type="password" class="text" name="eu_password"
										id="eu_password" value="" />
								</td>
							</tr>
							<tr>
								<td class="field">
									性别：
								</td>
								<td>
									<input type="radio" name="eu_sex" value="男" checked="checked" />
									男
									<input type="radio" name="eu_sex" value="女" />
									女
								</td>
							</tr>
							<tr>
								<td class="field">
									出生日期：
								</td>
								<td>
									<input name="begindatetime" type="text" class="text" value=""
										id="ctl00_ContentPlaceHolder1_txtExamDate" />
								</td>
							</tr>
							<tr>
								<td class="field">
									手机号码：
								</td>
								<td>
									<input type="text" class="text" name="eu_mobile" id="eu_mobile"
										value="" />
								</td>
							</tr>
							<tr>
								<td class="field">
									送货地址：
								</td>
								<td>
									<input type="text" class="text" name="eu_address"
										id="eu_address" value="" />
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<label class="ui-blue">
										<input type="submit" name="submit" value="添加" />
									</label>
								</td>
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
