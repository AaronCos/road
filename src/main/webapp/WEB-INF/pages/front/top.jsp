<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="${path}/resources/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">

    $(function(){
        $("ul li").click(function() {
            $(this).siblings('li').removeClass('active');  // 删除其他兄弟元素的样式
            $(this).addClass('active');                            // 添加当前元素的样式
        })
    })

</script>
<div class="agile_wthree_nav">
    <nav class="navbar navbar-default">
        <div class="navbar-header navbar-left" style="padding-left: 200px;">

          <%--  <h1><a class="navbar-brand" href="${path}/index.html">
                <c:if test="${!empty sessionScope.currentFrontUser.username}">
                        <a href="#" style="color: #ffffff;font-size: 35px;">欢迎您:${sessionScope.currentFrontUser.username}</a>&nbsp;<span><a href="${path}/front/logout.do" style="color: #ffffff;font-size: 25px;">退出</a></span>
                </c:if>
                <c:if test="${empty sessionScope.currentFrontUser.username}">
                    <a src="#" style="color: #ffffff;">登陆</a> <a src="#" style="color: #ffffff;" href="${path}/support/regist.do">注册</a>
                </c:if>

            </a></h1>--%>
             <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h1>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
            <nav class="link-effect-8" id="link-effect-8">
                <ul class="nav navbar-nav">
                    <li><a href="index.do">主页</a></li>
                    <li><a href="about.do">关于我们</a></li>
                    <%--<li><a href="selectpeople.do">教育中心</a></li>--%>
                    <li><a href="selectpeople.do">诚聘英才</a></li>
                    <li><a href="selectpeople.do">个人中心</a></li>
                    <%--<li><a href="mail.html">Mail Us</a></li>--%>
                </ul>
            </nav>
        </div>
        <%--<div class="agile_search">--%>
            <%--<!-- cd-search -->--%>
            <%--<div class="cd-main-header">--%>
                <%--<ul class="cd-header-buttons">--%>
                    <%--<li><a class="cd-search-trigger" href="#cd-search"> <span></span></a></li>--%>
                <%--</ul>--%>
                <%--<!-- cd-header-buttons -->--%>
            <%--</div>--%>
            <%--<div id="cd-search" class="cd-search agileinfo">--%>
                <%--<form action="#" method="post">--%>
                    <%--<input name="Search" type="search" placeholder="Click enter after typing...">--%>
                <%--</form>--%>
            <%--</div>--%>
            <%--<!-- //cd-search -->--%>

        <%--</div>--%>
    </nav>
</div>

