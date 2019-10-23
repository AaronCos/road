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
    <title>进入莘深</title>
    <!-- CSS -->
    <%--<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">--%>
    <link rel="stylesheet" href="${path}/resources/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${path}/resources/css/logincss/font-awesome.min.css">
    <link rel="stylesheet" href="${path}/resources/css/logincss/form-elements.css">
    <link rel="stylesheet" href="${path}/resources/css/logincss/style.css">

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="${path}/resources/images/loginimages/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="${path}/resources/images/loginimages/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="${path}/resources/images/loginimages/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"
          href="${path}/resources/images/loginimages/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed"
          href="${path}/resources/images/loginimages/apple-touch-icon-57-precomposed.png">
    <link rel="stylesheet" href="${path}/resources/layui/css/modules/layer/default/layer.css">
</head>
<body>
<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>莘深文化</strong> 智慧学习系统</h1>
                    <div class="description">
                        <p>
                            莘深 为爱而生，全心为你遇见更好的自己！
                            <%--Download it on <a href="#"><strong>AZMIND</strong></a>, customize and use it as you like!--%>
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>登陆系统</h3>
                            <p>输入用户名和密码进行登陆:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form action="${url}" method="post" class="login-form" enctype="multipart/form-data"
                              onsubmit="return check();">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">用户名</label>
                                <input type="text" name="username" placeholder="用户名称..."
                                       class="form-username form-control" id="form-username" value="">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">密码</label>
                                <input type="password" name="password" placeholder="密码..."
                                       class="form-password form-control" id="form-password">
                            </div>
                            <div style="min-height: 20px"></div>
                            <button type="submit" class="btn btn-large">登录!</button>
                            <div style="min-height: 10px"></div>
                            <button type="button" class="btn btn-primary">返回!</button>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" title="网站模板">网站模板</a></div>
<script>
    function check() {
        var result = true;
        let username = $('#form-username').val();
        let password = $('#form-password').val();
        if (username == '' || password == '') {
            layer.alert("用户名和密码不能为空",{offset:'180px'});
            return false;
        }
        $.ajax({
            async: false,
            url: "dologin.do",
            type: "post",
            cache:"false",
            data: {
                "username":username,
                "password":password
            },
            success: function (data) {
                if(data.msg!='登陆成功'){
                    result = false;
                }
            },
            error: function (data){
                result = false;
            }
        });
        if (!result){
            layer.alert("登录失败",{offset:'180px'});
            return false;
        }
        return true;
    }
</script>

<!-- Javascript -->
<script src="${path}/resources/js/loginjs/jquery-1.11.1.min.js"></script>
<script src="${path}/resources/js/bootstrap/bootstrap.min.js"></script>
<script src="${path}/resources/js/loginjs/jquery.backstretch.min.js"></script>
<script src="${path}/resources/js/loginjs/scripts.js"></script>
<script src="https://cdn.bootcss.com/layer/2.3/layer.js"></script>
<!--[if lt IE 10]>
<script src="${path}/resources/js/loginjs/placeholder.js"></script>
<![endif]-->
</body>
</html>