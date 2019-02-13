<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>莘深 - 首页</title>
    <link type="text/css" rel="stylesheet" href="${path}/resources/css/style.css"/>
    <script type="text/javascript" src="${path}/resources/scripts/jquery-3.2.1.min.js"/>
    <script type="text/javascript">
        function FocusItem(obj)
        {
            /*obj.parentNode.parentNode.className = "current";*/
            var addClass=$(obj).parents("tr").addClass("current");
            var msgBox = obj.parentNode.getElementsByTagName("span")[0];
            msgBox.innerHTML = "";
            msgBox.className = "";
        }


        //失去焦点
        function CheckItem(obj)
        {
            obj.parentNode.parentNode.className = "";
            var msgBox = obj.parentNode.getElementsByTagName("span")[0];
            switch(obj.name) {
                case "userName":
                    if(obj.value == "") {
                        msgBox.innerHTML = "用户名不能为空";
                        msgBox.className = "error";
                        return false;
                    }
                    break;
                case "passWord":
                    if(obj.value == "") {
                        msgBox.innerHTML = "密码不能为空";
                        msgBox.className = "error";
                        return false;
                    }else if(obj.value.length < 4){
                        msgBox.innerHTML = "密码至少为4个字符";
                        msgBox.className = "error";
                        return false;
                    }
                    break;

                case "veryCode":
                    if(obj.value == "") {
                        msgBox.innerHTML = "验证码不能为空";
                        msgBox.className = "error";
                        return false;
                    }
                    break;
            }
            return true;
        }
        function selectCategory(c_id) {
            var categorys = document.getElementsByTagName('li');
            for (var i = 0; i<categorys.length - 1; i++) {
                if (categorys[i].name == 'category') {
                    if (categorys[i].id == c_id) {
                        categorys[i].className = "current";
                        if (categorys[i].id == 0) {
                            location.href = "DoIndex";
                        }
                    } else {
                        categorys[i].className = "";
                    }
                }
            }
            text_onkeyup(c_id);
        }

        function text_onkeyup(c_id) {
            var xhr;
            if (window.XmLHttpRequest) {
                xhr = new XmlHttpRequest();
            } else {
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            }
            var url = "DoCategorySelect?keyWord=" + c_id;
            xhr.open("GET", url, true);
            xhr.onreadystatechange = function () {
                if (xhr.readystate == 4 && xhr.status == 200) {
                    if (xhr.responseText.length != 0) {
                        let result = xhr.responseText.split('-');
                        let clew = "";
                        for (var i = 0; i < result.length; i++) {
                            clew += "";
                            clew += result[i];
                            clew += "</li>";
                        }
                        document.getElementById("select").innerHTML = clew;
                    }

                }
            };
            xhr.send(null);
        }

        function flushValidataCode() {
            var date = new Date();
            document.getElementById("veryCode").src = "${path}/checkCode.do?a="
                + date.getTime();
        }
    </script>
</head>
<body>
<!-- 头部信息 -->
<jsp:include page="top.jsp"/>
<div id="register" class="wrap">
    <div class="shadow">
        <em class="corner lb"></em> <em class="corner rt"></em>
        <div class="box">
            <h1>欢迎回到莘深</h1>
            <h3 style="text-align: center; color: red">${sessionScope.message}</h3>
            <form id="loginForm" method="post" action="DoLogin"
                  onsubmit="checkForm(this)">
                <table>
                    <tr>
                        <td class="field">用户名1：</td>
                        <td><input class="text" type="text" name="userName"
                                   onfocus="FocusItem(this)" onblur="CheckItem(this);"/>
                            <span></span>${requestScope.message}
                        </td>
                    </tr>
                    <tr>
                        <td class="field">登录密码：</td>
                        <td><input class="text" type="password" id="passWord"
                                   name="passWord" onfocus="FocusItem(this)"
                                   onblur="CheckItem(this);"/> <span></span></td>
                    </tr>
                    <tr>
                        <td class="field">验证码：</td>
                        <td><input class="text verycode" type="text" name="veryCode"
                                   onfocus="FocusItem(this)" onblur="CheckItem(this);"/> <img
                                id="veryCode" onclick="flushValidataCode();" src="${path}/checkCode.do"/>
                            <a href="javascript:flushValidataCode();">看不清</a><span></span></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><label class="ui-green"> <input type="submit"
                                                            name="submit" value="立即登录"/>
                        </label></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
