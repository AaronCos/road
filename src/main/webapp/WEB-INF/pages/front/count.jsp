<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <%-- <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">--%>
    <meta http-equiv="expires" content="0">
    <title>成绩图形</title>
    <script src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
</head>
<body>


<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>

<!-- Javascript -->
<script src="${path}/resources/js/loginjs/jquery-1.11.1.min.js"></script>

<![endif]-->


<script type="text/javascript">
    var sourceValue;
    $(function () {
        sourceValue = ${source}
    })

</script>
<script type="text/javascript" src="${path}/resources/js/front/count.js"></script>
</body>
</html>