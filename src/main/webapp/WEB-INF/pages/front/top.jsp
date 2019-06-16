<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="agile_wthree_nav">
    <nav class="navbar navbar-default">
        <div class="navbar-header navbar-left">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <h1><a class="navbar-brand" href="${path}/index.html"><span><i class="fa fa-magic" aria-hidden="true"></i></span>Exec</a></h1>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
            <nav class="link-effect-8" id="link-effect-8">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.do">主页</a></li>
                    <li><a href="about.do">关于</a></li>
                    <li><a href="blog.html">博客</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Short Codes <b class="caret"></b></a>
                        <ul class="dropdown-menu agile_short_dropdown">
                            <li><a href="icons.html">Web Icons</a></li>
                            <li><a href="typography.html">Typography</a></li>
                        </ul>
                    </li>
                    <li><a href="mail.html">Mail Us</a></li>
                </ul>
            </nav>
        </div>
        <div class="agile_search">
            <!-- cd-search -->
            <div class="cd-main-header">
                <ul class="cd-header-buttons">
                    <li><a class="cd-search-trigger" href="#cd-search"> <span></span></a></li>
                </ul>
                <!-- cd-header-buttons -->
            </div>
            <div id="cd-search" class="cd-search agileinfo">
                <form action="#" method="post">
                    <input name="Search" type="search" placeholder="Click enter after typing...">
                </form>
            </div>
            <!-- //cd-search -->

        </div>
    </nav>
</div>

