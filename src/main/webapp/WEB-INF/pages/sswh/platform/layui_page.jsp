<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/2/19
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>layui分页</title>
    <link rel="stylesheet" href="${path}/resources/layui/css/layui.css" media="all">
    <style>
        body{margin: 10px;}
        .demo-carousel{height: 200px; line-height: 200px; text-align: center;}
    </style>
</head>
<body>
<div id="test1"></div>

<script src="${path}/resources/layui/layui.js"></script>
<script>
    layui.use('laypage', function(){
        var laypage = layui.laypage;
        //执行一个laypage实例
        laypage.render({
            elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
            ,count: 30 //数据总数，从服务端得到
            ,limit: 5
            ,jump(obj,first){
                //obj包含了当前分页的所有参数，比如：
                console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                console.log(obj.limit); //得到每页显示的条数
                //首次不执行
                if(!first){
                    console.log(obj.count);
                }
            }
        });
    });
</script>
</body>
</html>
