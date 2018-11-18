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
		<script>
function check() {
	if (document.getElementById("guestName").value == "") {
		alert("昵称不能为空！");
		return false;
	} else if (document.getElementById("guestName").value.length > 20) {
		alert("昵称长度过长！");
		return false;
	} else if (document.getElementById("guestContent").value == "") {
		alert("留言内容不能为空！");
		return false;
	}
	return true;
}
</script>
	</head>
	<body>
		<div id="header" class="wrap">
			<%@include file="indexTop.jsp"%>
		</div>
		<div class="main">
			<div class="guestbook">
				<h2>
					全部留言
				</h2>
				<ul>
					<f:forEach items="${requestScope.comments}" var="c">
						<li>
							<dl>
								<dt>
									${c.c_content }
								</dt>
								<dd class="author">
									网友：${c.c_nick_name }
									<span class="timer">${c.c_create_time }</span>
								</dd>
								<dd>
									${c.c_reply }
								</dd>
							</dl>
						</li>
					</f:forEach>

				</ul>
				<div class="clear"></div>
				<div class="pager">
					<ul class="clearfix">
					<f:if test="${requestScope.pageIndex >1}">
							<a href="DoCommentList?pageIndex=${requestScope.pageIndex -1}">上一页</a>
						</f:if>
						<f:if test="${requestScope.pageIndex  == 1}">
							上一页
						</f:if>
						<f:if test="${requestScope.pageIndex <requestScope.pageCount}">
							<a href="DoCommentList?pageIndex=${requestScope.pageIndex +1}">下一页</a>
						</f:if>
						<f:if test="${requestScope.pageIndex  == requestScope.pageCount}">
							下一页
						</f:if>
						<a href="DoCommentList?pageIndex=1">首页</a>
						<a href="DoCommentList?pageIndex=${pageCount}">末页</a>
					</ul>
				</div>
				<div id="reply-box">
					<form action="DoCommentAdd" method="post" onsubmit="check()">
						<table>
							<tr>
								<td class="field">
									昵称：
								</td>
								<td>
									<input class="text" type="text" name="guestName" id="guestName" />
								</td>
							</tr>
							<tr>
								<td class="field">
									留言标题：
								</td>
								<td>
									<input class="text" type="text" name="guestTitle" />
								</td>
							</tr>
							<tr>
								<td class="field">
									留言内容：
								</td>
								<td>
									<textarea name="guestContent" id="guestName"></textarea>
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<label class="ui-blue">
										<input type="submit" name="submit" value="提交留言" />
									</label>
								</td>
							</tr>
						</table>
					</form>
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
