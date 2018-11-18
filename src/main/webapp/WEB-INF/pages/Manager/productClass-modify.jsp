<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>后台管理 - 易买网</title>
		<link type="text/css" rel="stylesheet" href="../css/style.css" />
		<script type="text/javascript" src="../scripts/function-manage.js">
</script>
		<script>
function checkAll() {
	if (document.getElementById("type").value == "") {
		alert("类型不能为空");
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
					<li>
						<a href="DoBackUserList">用户</a>
					</li>
					<li class="current">
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
							<em><a href="user-add.jsp">新增</a>
							</em><a href="DoBackUserList">用户管理</a>
						</dd>
						<dt>
							商品信息
						</dt>
						<dd>
							<em><a href="DoProductClassBackAddSelect">新增</a>
							</em><a href="DoProductClassBackSelect">分类管理</a>
						</dd>
						<dd>
							<em><a href="DoProductBackAddSelect">新增</a>
							</em><a href="DoProductBackSelectAll">商品管理</a>
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
							<em><a href="news-add.jsp">新增</a>
							</em><a href="DoBackNewsList">新闻管理</a>
						</dd>
					</dl>
				</div>
			</div>
			<div class="main">
				<h2>
					修改分类
				</h2>
				<div class="manage">
					<form action="DoProductClassBackAdd?id=${id}" method="post"
						onsubmit="return checkAll()">
						<table class="form">
							<tr>
								<td class="field">
									父分类：
								</td>
								<td>
									<select name="parentId"
										<f:if test="${p_id==0}"> disabled = "disabled"</f:if>>

										<f:forEach var="pCategory" items="${P_Categorys}">
											<option value="${pCategory.c_id}">
												${requestScope.product.c_name}
											</option>
										</f:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td class="field">
									分类名称：
								</td>
								<td>
									<input type="text" id="type" class="text" name="className"
										value="${requestScope.product.c_name}" />
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<label class="ui-blue">
										<input type="submit" name="submit" value="更新" />
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
