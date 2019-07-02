<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/7/2
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>head</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="doUploadImage.do">
    File to upload: <input type="file" name="upfile"><br/>
    Notes about the file: <input type="text" name="note"><br/>
    <br/>
    <input type="submit" value="Press"> to upload the file!
</form>
</body>
</html>
