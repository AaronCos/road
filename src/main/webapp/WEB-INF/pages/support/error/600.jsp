<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统未初始化</title>
<style type="text/css">
html {
	background: #F6F6F6;
}

html,body {
	width: 100%;
	height: 100%;
	margin: 0;
	overflow: hidden;
}

#box {
	background: #fff;
	color: #333;
	font-family: "MicrosoftYaHei", "微软雅黑", Verdana, Arial;
	width: 550px;
	padding: 1em 2em;
	-moz-border-radius: 11px;
	-khtml-border-radius: 11px;
	-webkit-border-radius: 11px;
	border-radius: 11px;
	border: 1px solid #dfdfdf;
}

a {
	color: #2583ad;
	text-decoration: none;
	cursor: pointer;
	font-size: 14px;
}

a:hover {
	color: #d54e21;
}

h1 {
	border-bottom: 1px solid #dadada;
	clear: both;
	color: #666;
	margin: 5px 0 5px 0;
	padding: 0;
	padding-bottom: 10px;
	font-size: 24px;
}
</style>

</head>
<body>
	<table width="100%" height="100%">
		<tr>
			<td>
				<table id="box" border="0" cellspacing="0" cellpadding="0" align="center">
					<tr>
						<td>
							<h1>
								未初始化
							</h1>
							<p style="font-size: 14px;color: #999;">
								系统未注册或者未初始化！
							</p>
						</td>
					</tr>
					<tr>
						<td>
							<p>
								<a href="${pageContext.request.contextPath}/" target="_top">返回首页</a>
							</p>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>