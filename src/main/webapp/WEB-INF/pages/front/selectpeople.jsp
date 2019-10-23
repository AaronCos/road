<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html lang="en">

<head>
<title>莘深文化—诚聘英才</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="" />
<script type="application/x-javascript">
	addEventListener("load", function () {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- bootstrap-css -->
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--// bootstrap-css -->
<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/style.css" type="text/css" media="all" />
<!--// css -->
<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/team.css" type="text/css" media="all" />
<!--// css -->
<link rel="stylesheet" href="${path}/resources/css/owl.carousel.css" type="text/css" media="all">
<!-- font-awesome icons -->
<link href="${path}/resources/layui/css/layui.css"  media="all">

	<link href="${path}/resources/css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- font -->
<link href="http://fonts.googleapis.com/css?family=Montserrat:200,200i,300,400,400i,500,600,700" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
<!-- //font -->
</head>

<body>
<div class="inner_agile_pages">
	<div class="main_agileits">
		<jsp:include page="top.jsp"/>
	</div>
</div>
<div style="height: 50px;"></div>
<!--//w3_short-->
<div  style="text-align: center">

<div class=".container">
	<div class="row">
		<div class="col-md-6">中小学语文老师招聘<br/><br/>
			<div><img src="${path}/resources/images/g1.jpg" alt=""></div>
		</div>
		<div class="col-md-6">中小学数学老师招聘<br/><br/>
			<div><img src="${path}/resources/images/g2.jpg" alt=""></div>
		</div>
	</div>
	<div style="height: 30px"></div>
	<div class="row">
		<div class="col-md-6">中小学英语老师招聘</div>
		<div class="col-md-6">中小学物理老师招聘</div>
	</div>


</div>
<div style="height: 100px;"/>

</div>
<!-- footer -->
<div class="footer">
		<%--<p>Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>--%>
		<jsp:include page="footer.jsp"/>
	</div>
</div>
<!-- //footer -->
<script src="${path}/resources/js/jquery-2.1.4.min.js"></script>
<script src="${path}/resources/js/search.js"></script>
<!-- stats -->
<script src="${path}/resources/js/jquery.waypoints.min.js"></script>
<script src="${path}/resources/js/jquery.countup.js"></script>
<script>
	$('.counter').countUp();
</script>
<!-- //stats -->
<!-- carousel -->
<script src="${path}/resources/js/owl.carousel.js"></script>
<script>
	$(document).ready(function () {
		$("#owl-demo").owlCarousel({
			items: 1,
			itemsDesktop: [768, 1],
			itemsDesktopSmall: [414, 1],
			lazyLoad: true,
			autoPlay: true,
			navigation: true,

			navigationText: false,
			pagination: true,

		});

	});
</script>
<!-- //carousel -->
<script src="${path}/resources/js/bootstrap/bootstrap.js"></script>
</body>

</html>