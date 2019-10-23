<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/9/13
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="${path}/resources/css/basic.css">
    <link rel="stylesheet" href="${path}/resources/layui/css/layui.css" media="all">
</head>
<body>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-lg12" style="background-color: #FFFF00">
            移动：4/12 | 平板：5/12 | 桌面：4/12
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-lg12" style="height: 50px">

        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-lg3">
            <img src="${path}/resources/images/g5.jpg" alt="">
        </div>
        <div class="layui-col-lg1">
            hello workd
        </div>
        <div class="layui-col-lg4">
            <img src="${path}/resources/images/g5.jpg" alt="">
        </div>
        <div class="layui-col-lg4">
            <img src="${path}/resources/images/g5.jpg" alt="">
        </div>

    </div>
    <div class="layui-row">
        <div class="layui-col-lg12" style="height: 10px">

        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-lg3">
            <img src="${path}/resources/images/g4.jpg" alt="">
        </div>
        <div class="layui-col-lg1">
            hello workd
        </div>
        <div class="layui-col-lg4">
            <img src="${path}/resources/images/g4.jpg" alt="">
        </div>
        <div class="layui-col-lg4">
            <img src="${path}/resources/images/g4.jpg" alt="">
        </div>

    </div>
    <div class="layui-row">
        <div class="layui-col-lg12" style="height: 10px">

        </div>
    </div>
    <div class="layui-row">
    <div class="layui-col-lg3">
        <img src="${path}/resources/images/g3.jpg" alt="">
    </div>
    <div class="layui-col-lg1">
        hello workd
    </div>
    <div class="layui-col-lg4">
        <img src="${path}/resources/images/g3.jpg" alt="">
    </div>
    <div class="layui-col-lg4">
        <img src="${path}/resources/images/g3.jpg" alt="">
    </div>

</div>
    <div class="layui-row">
        <div class="layui-col-lg12" style="height: 10px">

        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-lg3">
            <img src="${path}/resources/images/g2.jpg" alt="">
        </div>
        <div class="layui-col-lg1">
            hello workd
        </div>
        <div class="layui-col-lg4">
            <img src="${path}/resources/images/g2.jpg" alt="">
        </div>
        <div class="layui-col-lg4">
            <img src="${path}/resources/images/g2.jpg" alt="">
        </div>

    </div>
    <div class="layui-row">
        <div class="layui-col-lg12" style="height: 10px">

        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-lg3">
            <img src="${path}/resources/images/g3.jpg" alt="">
        </div>
        <div class="layui-col-lg1">
            hello workd
        </div>
        <div class="layui-col-lg4">
            <img src="${path}/resources/images/g3.jpg" alt="">
        </div>
        <div class="layui-col-lg4">
            <img src="${path}/resources/images/g3.jpg" alt="">
        </div>

    </div>
    <div class="layui-row">
        <div class="layui-col-lg12" style="height: 10px">

        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-lg3">
            <img src="${path}/resources/images/g2.jpg" alt="">
        </div>
        <div class="layui-col-lg1">
            hello workd
        </div>
        <div class="layui-col-lg4">
            <img src="${path}/resources/images/g2.jpg" alt="">
        </div>
        <div class="layui-col-lg4">
            <img src="${path}/resources/images/g2.jpg" alt="">
        </div>

    </div>
    <div class="layui-row">
        <div class="layui-col-lg12" style="height: 10px">

        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-lg12 ">
            移动：4/12 | 平板：5/12 | 桌面：4/12
        </div>

    </div>

</div>


<script src="${path}/resources/layui/layui.js"></script>
<script>
    //一般直接写在一个js文件中
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer
            , form = layui.form;

        //layer.msg('Hello World');
    });
</script>
</body>
</html>
