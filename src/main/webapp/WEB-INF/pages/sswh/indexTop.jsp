<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>易买网 - 首页</title>
    <link type="text/css" rel="stylesheet" href="${path}/resources/css/style.css"/>
    <script type="text/javascript" src="${path}/resources/scripts/function.js">
    </script>
    <script type="text/javascript">
        function selectCategory(c_id) {
            var categorys = document.getElementsByTagName('li');
            for (var i = 0; i < categorys.length - 1; i++) {
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
                        var result = xhr.responseText.split('-');
                        var clew = "";

                        document.getElementById("select").innerHTML = clew;
                    }

                }
            };
            xhr.send(null);
        }
    </script>
</head>
<body>
<!-- 头部信息 -->
<div id="position" class="wrap" height="30">
    <li>
        您当前的位置是：莘深&nbsp;&nbsp; ${parentName}&nbsp; &nbsp; ${CategoryName}
    </li>
</div>
<div id="main" class="wrap">
    <div class="lefter">
        <div class="box">
            <h2>
                商品分类
            </h2>
            <dl>
                <c:forEach var="cate" items="${Parents}">
                    <dt>
                            ${cate.c_name}
                    </dt>

                    <c:forEach var="shop" items="${categorys}">
                        <c:if test="${shop.c_parent_id ==cate.c_id }">
                            <dd>
                                <a href="DoProductByLeftCategory?c_id=${shop.c_id}">${shop.c_name}</a>
                            </dd>
                        </c:if>
                    </c:forEach>
                </c:forEach>
            </dl>
        </div>
    </div>
</div>
</body>
</html>
