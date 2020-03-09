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
    <style>
        label{
            display: inline;
        }
        .form-group{
            margin-top:10px;
        }
        button.btn{
            height: 38px;
            line-height: 38px;
            width:150px;

        }
        input#form-password,input#form-loginname,input#form-checkcode{
            width:333px;
        }
        input#form-checkcode{
            width:210px;
        }
        #btnlogin{
            margin-top: 25px;
            padding-left:40px;
        }

        .btn:hover, .btn:focus, .btn:active, .btn.active, .btn.disabled, .btn[disabled]{
         /*background-color:transparent;*/
        }

    </style>
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
                            <h3>登录系统</h3>
                            <p style="color: #1000ff;"><a href="${path}/front/regist.do">还没有账号 前往注册 》</a></p>
                        </div>
                        <div class="form-top-right">
<%--                            <i class="fa fa-key"></i>--%>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form action="${url}" method="post" class="login-form" enctype="multipart/form-data"
                              onsubmit="return check();">
                            <div class="form-group">
                                <label class="sr-only" for="form-loginname">用户名</label>
                                <input type="text" name="loginname" placeholder="用户名称..."
                                       class="form-username form-control" id="form-loginname" value="" autocomplete="false">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">密码&nbsp;&nbsp;&nbsp;</label>
                                <input type="password" name="password" placeholder="密码..."
                                       class="form-password form-control" id="form-password">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-checkcode">验证码</label>
                                <input type="text" name="checkcode" placeholder="验证码..."
                                       class="form-username form-control" id="form-checkcode">
                                <img id='putImg' src="${path}/checkCode.do" onclick="this.src='${path}/checkCode.do?t='+Math.random();"  alt="">
                            </div>
                            <div id="btnlogin">
                                <button type="submit" class="btn btn-default">登录!</button>
                                <button type="button" class="btn btn-primary" onclick="backurl();">返回!</button>

                            </div>

                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" title="网站模板">莘深文化</a></div>
<script>
    var backurl = function () {
        location.href="${path}/support/tab/index.do";
    }
    var putImg = function(imgsrc){
        console.log("hello world")
        imgsrc.src = "${path}/checkCode.do?t='javascript:Math.random()'";

    }
    function check() {
        var result = true;
        let loginname = $('#form-loginname').val();
        let password = $('#form-password').val();
        let checkcode = $('#form-checkcode').val();
        if (loginname == '' && password == '' && checkcode=='' ) {
            layer.alert("参数不能为空",{offset:'180px'});
            // document.getElementById("putImg").click();
            return false;
        }
        if (loginname == '' && password == '' ) {
            layer.alert("用户名和密码验证码不能为空",{offset:'180px'});
           // document.getElementById("putImg").click();
            return false;
        }
        if (loginname == '' && checkcode == '' ) {
            layer.alert("用户名和验证码不能为空",{offset:'180px'});
            // document.getElementById("putImg").click();
            return false;
        }
        if (password == '' && checkcode == '') {
            layer.alert("密码和验证码不能为空",{offset:'180px'});
            document.getElementById("putImg").click();
            return false;
        }
        if (loginname == '' ) {
            layer.alert("用户名不能为空",{offset:'180px'});
            // document.getElementById("putImg").click();
            return false;
        }
        if (password == '') {
            layer.alert("密码不能为空",{offset:'180px'});
            //document.getElementById("putImg").click();
            return false;
        }
        if (checkcode == '') {
            layer.alert("验证码不能为空",{offset:'180px'});
            document.getElementById("putImg").click();
            return false;
        }
        $.ajax({
            async: false,
            url: "dologin.do",
            type: "GET",
            cache:false,
            data: {
                "loginname":loginname,
                "password":password,
                "checkCode":checkcode
            },
            success: function (data) {
                if(data.code != '01'){
                    layer.alert(data.msg);
                    document.getElementById("putImg").click();
                    result = false;
                }
            },
            error: function (data){
                layer.alert("登录失败",{offset:'180px'});
                document.getElementById("putImg").click();
                result = false;
            }
        });
        return result;
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