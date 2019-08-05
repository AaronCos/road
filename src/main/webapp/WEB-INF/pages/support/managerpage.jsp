<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>莘深文化-管理中心</title>
    <!-- CSS -->
    <link rel="stylesheet" href="${path}/resources/layui/css/layui.css">
    <style>
        .grid-demo{padding: 10px; line-height: 50px; text-align: center; background-color: #79C48C; color: #fff;}
        .grid-demo-bg1{background-color: #63BA79;}
        .grid-demo-bg2{background-color: #49A761;}
        .grid-demo-bg3{background-color: #38814A;}
    </style>
</head>
<body>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<fieldset class="layui-elem-field site-demo-button" style="margin-top: 30px;">
    <legend>按钮主题</legend>
    <div>
        <button type="button" class="layui-btn layui-btn-primary">原始按钮</button>
        <button type="button" class="layui-btn">默认按钮</button>
        <button type="button" class="layui-btn layui-btn-normal">百搭按钮</button>
        <button type="button" class="layui-btn layui-btn-warm">暖色按钮</button>
        <button type="button" class="layui-btn layui-btn-danger">警告按钮</button>
        <button type="button" class="layui-btn layui-btn-disabled">禁用按钮</button>
    </div>
</fieldset>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>移动设备、桌面端的组合响应式展现</legend>
</fieldset>

<div class="layui-row">
    <div class="layui-col-xs12 layui-col-md8">
        <div class="grid-demo grid-demo-bg1">移动：12/12、桌面：8/12</div>
    </div>
    <div class="layui-col-xs6 layui-col-md4">
        <div class="grid-demo">移动：6/12、桌面：4/12</div>
    </div>
    <div class="layui-col-xs6 layui-col-md12">
        <div class="grid-demo grid-demo-bg2">移动：6/12、桌面：12/12</div>
    </div>
</div>
<script src="${path}/resources/layui/layui.all.js"></script>
</body>
</html>