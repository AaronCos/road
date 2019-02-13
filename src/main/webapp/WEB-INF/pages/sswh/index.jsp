<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>
<f:set value="${pageContext.request.contextPath}" var="path" scope="session"></f:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>莘深 - 首页</title>
    <link type="text/css" rel="stylesheet" href="${path}/resources/css/style.css"/>
    <script type="text/javascript" src="${path}/resources/scripts/function.js"></script>
    <script type="text/javascript" src="${path}/resources/scripts/function-manage.js"></script>
<head>
<body>
<%--<%@include file="indexTop.jsp" %>--%>
<%--<jsp:include page="top.jsp"></jsp:include>--%>
<%@include file="top.jsp"%>    <%--这种方式是把子页面当成整体的一个部分，和父级文件一起进行编译--%>
<jsp:include page="indexTop.jsp"></jsp:include>
<div class="spacer"></div>
<div class="last-view">
    <h2>
        最近浏览
    </h2>
    <dl class="clearfix">
        <dt>
            <img src="${path}/resources/images/product/0_tiny.gif"/>
        </dt>
        <dd>
            <a href="../product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a>
        </dd>
        <dt>
            <img src="${path}/resources/images/product/0_tiny.gif"/>
        </dt>
        <dd>
            <a href="../product-view.jsp">法国德菲丝松露精品巧克力500g/盒</a>
        </dd>
    </dl>
</div>
</div>
<div class="main">
    <div class="price-off">
        <h2>
            今日特价
        </h2>
        <ul class="product clearfix">
             <c:forEach var="shop" items="${Products}">
                <li>
                    <dl>
                        <dt>
                            <a href="DoProductViewSelect?id=${shop.id}" target="_blank"><img
                                    src="${shop.fileName}" />
                            </a>
                        </dt>
                        <dd class="title">
                            <a href="DoProductViewSelect?id=${shop.id}" target="_blank">${shop.name}</a>
                        </dd>
                        <dd class="price">
                            ￥${shop.price}
                        </dd>
                    </dl>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="side">
        <div class="news-list">
            <h4>
                最新公告
            </h4>
            <ul>
                <div id="container" onmouseover="over_payce()"
                     onmouseout="out_connetion()">
                     <f:forEach items="${requestScope.news}" var="n">
                        <li id="Li">
                            <a href="DoNewsList?newsId=${n.id }" target="_blank">${n.title
                                }</a>
                        </li>
                        <div id="copycTable"></div>
                    </f:forEach>
                </div>
            </ul>
        </div>
        <div class="spacer"></div>
        <div class="news-list">
            <h4>
                新闻动态
            </h4>
            <ul>
                <div id="containers" onmouseover="over_payces()"
                     onmouseout="out_connetions()">

                    <f:forEach items="${requestScope.news}" var="n">
                        <li id="Lis">
                            <a href="DoNewsList?newsId=${n.id }" target="_blank">${n.title
                                }</a>
                        </li>
                        <div id="copycTables"></div>
                    </f:forEach>
                </div>
            </ul>
        </div>
    </div>
    <div class="spacer clear"></div>
    <div class="hot">
        <h2>
            热卖推荐
        </h2>
        <ul class="product clearfix">
            <c:forEach var="shop" items="${NProducts}">
                <li>
                    <dl>
                        <dt>
                            <a href="DoProductViewSelect?id=${shop.id}" target="_blank"><img
                                    src="${shop.fileName}" />
                            </a>
                        </dt>
                        <dd class="title">
                            <a href="DoProductViewSelect?id=${shop.id}" target="_blank">${shop.name}</a>
                        </dd>
                        <dd class="price">
                            ￥${shop.price}
                        </dd>
                    </dl>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<div class="clear"></div>
</div>
<div id="footer">
    <!-- 动态获取 -->
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
<script type="text/javascript">

    //进行数据的滚动显示
    function initData() {
        //获得第一个容器的id
        var container = document.getElementById("container");
        //获得第二个容器id
        var copycTable = document.getElementById("copycTable");
        //将第一个容器的内容复制到第二个容器中
        copycTable.innerHTML = container.innerHTML;
        //启动定时器
        titar = setInterval("move()", 50);
    }

    //滚动信息效果函数
    function move() {
        //获得第一个容器的id
        var container = document.getElementById("container");
        //获得显示信息的表格的id
        var Tbale1 = document.getElementById("Li");
        //获取表格的高度
        var Tbale1Height = parseInt(Tbale1.currentStyle.height);
        //滚动的数据进行数据的++
        container.scrollTop++;
        if (container.scrollTop == Tbale1Height) {
            container.scrollTop = 0;
        }
    }

    //定义计时器
    var titar;

    //进行鼠标的事件,关闭计时器
    function over_payce() {
        clearInterval(titar);
    }

    function out_connetion() {
        titar = setInterval("move()", 50);
    }

    //进行数据的滚动显示
    function initDatas() {
        //获得第一个容器的id
        var container = document.getElementById("containers");
        //获得第二个容器id
        var copycTable = document.getElementById("copycTables");
        //将第一个容器的内容复制到第二个容器中
        copycTable.innerHTML = container.innerHTML;
        //启动定时器
        titare = setInterval("moves()", 40);
    }

    //滚动信息效果函数
    function moves() {
        //获得第一个容器的id
        var container = document.getElementById("containers");
        //获得显示信息的表格的id
        var Tbale1 = document.getElementById("Lis");
        //获取表格的高度
        var Tbale1Height = parseInt(Tbale1.currentStyle.height);
        //滚动的数据进行数据的++
        container.scrollTop++;
        if (container.scrollTop == Tbale1Height) {
            container.scrollTop = 0;
        }
    }

    //定义计时器
    var titare;

    //进行鼠标的事件,关闭计时器
    function over_payces() {
        clearInterval(titare);
    }

    function out_connetions() {
        titare = setInterval("moves()", 40);
    }


</script>
