<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="session"></c:set>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <%-- <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">--%>
    <meta http-equiv="expires" content="0">
    <title>登录界面</title>
</head>
<body>
<form action="${url}" method="post">
    登录名：<input type="text" name="userName" value="${platformUser.userName}">
    密码：<input type="password" name="password" value="${platformUser.password}">
    <input type="submit" value="登录">
</form>
</body>
</html>