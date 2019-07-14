<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" scope="session"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">

<head>
<title>莘深文化</title>
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
	function showLogin(){
	    parent.location.href="${path}/support/login.do";
	}
</script>
<!-- bootstrap-css -->
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!--// bootstrap-css -->
<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/style.css" type="text/css" media="all" />
<!--// css -->
<link rel="stylesheet" href="${path}/resources/css/owl.carousel.css" type="text/css" media="all">
<!-- font-awesome icons -->
<link href="${path}/resources/css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<!-- font -->
<link href="http://fonts.googleapis.com/css?family=Montserrat:200,200i,300,400,400i,500,600,700" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
<!-- //font -->

<!-- light-box -->
<link rel="stylesheet" href="${path}/resources/css/poposlides.css">
<!-- //light-box -->
</head>

<body>
<div class="main_agileits" id="page">
	<jsp:include page="top.jsp"></jsp:include>
	<div class="s1">
		<h3>学以致用</h3>
		<p> 莘深文化是一家致力于打造青少年习惯养成的开放式学校</p>
		<div class="w3-button">
			<div class="w3ls-button">
				<a href="single.html" class="hvr-shutter-out-vertical">了解 更多</a>
			</div>
			<div class="w3l-button">
				<a href="#" onclick="showLogin()" class="hvr-shutter-out-vertical scroll ">加入 我们</a>
			</div>
			<div class="clearfix"> </div>
		</div>

	</div>

	<div class="slides-box">
		<ul class="slides">
			<li style="background: url(${path}/resources/images/banner.jpg) center">
			</li>
			<li style="background: url(${path}/resources/images/banner1.jpg)center"></li>
			<li style="background: url(${path}/resources/images/banner3.jpg) center"></li>
			<li style="background: url(${path}/resources/images/banner2.jpg)center"></li>
			<li style="background: url(${path}/resources/images/banner1.jpg)center"></li>
		</ul>
	</div>
</div>
<!-- /banner_bottom_w3ls_agile -->
<div class="banner_bottom_w3ls_agile">
	<div class="banner_bottom_w3ls_info">
		<h2 class="agile_heading">合适的教育支撑孩子的未来</h2>
		<p>对待教育，我们从不满足于现在，我们立足当下，拥抱未来。</p>
		<div class="agileits-button">
			<a href="single.html" class="read hvr-shutter-out-vertical">了解 更多</a>
		</div>
	</div>
</div>
<!-- //banner_bottom_w3ls_agile -->
<!-- /services -->
<div class="agile_services">
	<div class="col-md-6 agile_services_img_wthree">
	</div>
	<div class="col-md-6 agile_inner_grids">
		<h3 class="agile_heading two">我们的服务</h3>
		<div class="w3ls-markets-grid_top">
			<div class="col-md-6 w3ls-markets-grid">
				<div class="agileits-icon-grid">
					<div class="icon-left">
						<i class="fa fa-laptop" aria-hidden="true"></i>
					</div>
					<div class="icon-right">
						<h5>学习规划 </h5>
						<p>专业的师资为孩子量身定制学习方案，针对性复习，迅速提高成绩</p>
					</div>
					<div class="clearfix"> </div>

				</div>
			</div>
			<div class="col-md-6 w3ls-markets-grid">
				<div class="agileits-icon-grid">
					<div class="icon-left">
						<i class="fa fa-pencil" aria-hidden="true"></i>
					</div>
					<div class="icon-right">
						<h5>心理辅导</h5>
						<p>守护那份童真，守护那份好奇心，童年很真，青春很美，我们一起护航..</p>
					</div>
					<div class="clearfix"> </div>

				</div>
			</div>
			<div class="col-md-6 w3ls-markets-grid">
				<div class="agileits-icon-grid">
					<div class="icon-left">
						<i class="fa fa-pied-piper" aria-hidden="true"></i>
					</div>
					<div class="icon-right">
						<h5> 走进自然 </h5>
						<p>大自然赐予我们幸福，你我一起遇见自然，与自然来次亲密约会..</p>
					</div>
					<div class="clearfix"> </div>

				</div>
			</div>
			<div class="col-md-6 w3ls-markets-grid">
				<div class="agileits-icon-grid">
					<div class="icon-left">
						<i class="fa fa-camera-retro" aria-hidden="true"></i>
					</div>
					<div class="icon-right">
						<h5>拥抱科技</h5>
						<p>时不我待，积极应对变化，拥抱科技，享受未来..</p>
					</div>
					<div class="clearfix"> </div>

				</div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<div class="clearfix"> </div>
</div>
<!-- //services -->
<div class="portfolio-agileinfo" id="portfolio">
	<h3 class="agile_heading">成果展示</h3>
	<p class="sub_cap">Phasellus dapibus felis elit, sed accumsan arcu gravida vitae.</p>
	<div class="agile_inner_info">
		<div class="agile_port_w3ls_info">
			<div class="col-md-6 portfolio-grids_left">
				<div class="col-md-6 portfolio-grids" data-aos="zoom-in">
					<a href="${path}/resources/images/g1.jpg" class="b-link-stripe b-animate-go lightninBox" data-lb-group="1">
							<img src="${path}/resources/images/g1.jpg" class="img-responsive" alt="w3ls" />
							<div class="b-wrapper two">
								<i class="fa fa-magic" aria-hidden="true"></i>
								
							</div>
						</a>
				</div>
				<div class="col-md-6 portfolio-grids" data-aos="zoom-in">
					<a href="${path}/resources/images/g2.jpg" class="b-link-stripe b-animate-go lightninBox" data-lb-group="1">
							<img src="${path}/resources/images/g2.jpg" class="img-responsive" alt="w3ls" />
							<div class="b-wrapper">
							<i class="fa fa-magic" aria-hidden="true"></i>
								
							</div>
						</a>
				</div>
				<div class="col-md-6 portfolio-grids" data-aos="zoom-in">
					<a href="${path}/resources/images/g3.jpg" class="b-link-stripe b-animate-go lightninBox" data-lb-group="1">
							<img src="${path}/resources/images/g3.jpg" class="img-responsive" alt="w3ls" />
							<div class="b-wrapper">
								<i class="fa fa-magic" aria-hidden="true"></i>
								
							</div>
						</a>
				</div>
			</div>
			<div class="col-md-6 portfolio-grids_left">
				<div class="col-md-6 portfolio-grids" data-aos="zoom-in">
					<a href="${path}/resources/images/g5.jpg" class="b-link-stripe b-animate-go lightninBox" data-lb-group="1">
							<img src="${path}/resources/images/g5.jpg" class="img-responsive" alt="w3ls" />
							<div class="b-wrapper two">
								<i class="fa fa-magic" aria-hidden="true"></i>
								
							</div>
						</a>
				</div>
				<div class="col-md-6 portfolio-grids" data-aos="zoom-in">
					<a href="${path}/resources/images/g4.jpg" class="b-link-stripe b-animate-go lightninBox" data-lb-group="1">
							<img src="${path}/resources/images/g4.jpg" class="img-responsive" alt="w3ls" />
							<div class="b-wrapper">
								<i class="fa fa-magic" aria-hidden="true"></i>
								
							</div>
						</a>
				</div>
				<div class="col-md-6 portfolio-grids" data-aos="zoom-in">
					<a href="${path}/resources/images/g6.jpg" class="b-link-stripe b-animate-go lightninBox" data-lb-group="1">
							<img src="${path}/resources/images/g6.jpg" class="img-responsive" alt="w3ls" />
							<div class="b-wrapper">
								<i class="fa fa-magic" aria-hidden="true"></i>
								
							</div>
						</a>
				</div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!-- stats -->
<div class="stats" id="stats">
	<div class="container">
		<div class="agile_inner_info_stats">
			<div class="col-md-3 w3layouts_stats_left w3_counter_grid">
				<i class="fa fa-laptop" aria-hidden="true"></i>
				<p class="counter">45</p>
				<h3>Projects</h3>
			</div>
			<div class="col-md-3 w3layouts_stats_left w3_counter_grid1">
				<i class="fa fa-smile-o" aria-hidden="true"></i>
				<p class="counter">165</p>
				<h3>Members</h3>
			</div>
			<div class="col-md-3 w3layouts_stats_left w3_counter_grid2">
				<i class="fa fa-trophy" aria-hidden="true"></i>
				<p class="counter">563</p>
				<h3>Awards</h3>
			</div>
			<div class="col-md-3 w3layouts_stats_left w3_counter_grid3">
				<i class="fa fa-user" aria-hidden="true"></i>
				<p class="counter">245</p>
				<h3>Investors</h3>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!-- //stats -->
<!-- /services -->
<div class="featured_services">
	<div class="container">
		<h3 class="agile_heading">Featured Services</h3>
		<p class="sub_cap">Phasellus dapibus felis elit, sed accumsan arcu gravida vitae.</p>
		<div class="agile_inner_info">
			<div class="col-md-4 w3_agile_services_grid">
				<div class="agile_services_grid">
					<div class="hover06 column">
						<div>
							<figure><img src="${path}/resources/images/g2.jpg" alt=" " class="img-responsive"></figure>
						</div>
					</div>
					<div class="agile_services_grid_pos">
						<i class="fa fa-cubes" aria-hidden="true"></i>
					</div>
				</div>
				<h4>Tempus eu turpis</h4>
				<p>Lorem ipsum dolor sit amet, do eiusmod tempor incididunt .Aliquam lacus turpis, lobortis quis dolor sed, dignissim rhoncus
					neque.
				</p>
			</div>
			<div class="col-md-4 w3_agile_services_grid">
				<div class="agile_services_grid">
					<div class="hover06 column">
						<div>
							<figure><img src="${path}/resources/images/g3.jpg" alt=" " class="img-responsive"></figure>
						</div>
					</div>
					<div class="agile_services_grid_pos">
						<i class="fa fa-line-chart" aria-hidden="true"></i>
					</div>
				</div>
				<h4>Lobortis quis dolor</h4>
				<p>Lorem ipsum dolor sit amet, do eiusmod tempor incididunt .Aliquam lacus turpis, lobortis quis dolor sed, dignissim rhoncus
					neque.
				</p>
			</div>
			<div class="col-md-4 w3_agile_services_grid">
				<div class="agile_services_grid">
					<div class="hover06 column">
						<div>
							<figure><img src="${path}/resources/images/g6.jpg" alt=" " class="img-responsive"></figure>
						</div>
					</div>
					<div class="agile_services_grid_pos">
						<i class="fa fa-cog" aria-hidden="true"></i>
					</div>
				</div>
				<h4>Dignissim rhoncus</h4>
				<p>Lorem ipsum dolor sit amet, do eiusmod tempor incididunt .Aliquam lacus turpis, lobortis quis dolor sed, dignissim rhoncus
					neque.
				</p>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!-- //services -->
<!-- /testimonials-->
<div class="agile_testimonials">
	<div class="col-md-6 testmonial_agile_info">
		<h3 class="agile_heading two">What Clients Say</h3>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus at placerat ante. Praesent nulla nunc, pretium dapibus
			efficitur in, auctor eget elit. Lorem ipsum dolor sit amet fusce eget erat nunc..</p>
		<div class="agileits-button two">
			<a href="single.html" class="read scroll hvr-shutter-out-vertical">More Details</a>
		</div>
	</div>
	<div class="col-md-6 clients_agile_slider">
		<div id="owl-demo" class="owl-carousel owl-theme">
			<div class="item">
				<div class="agile_tesimonials_content">
					<div class="about-midd-main">
						<img class="agile-img" src="${path}/resources/images/t1.png" alt=" " class="img-responsive">
						<h4>Smith Kevin</h4>
						<p> Lorem ipsum adipiscing elit, sed do eiusmod idunt ut labore. sed do eiusmod tempor incididunt.</p>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="agile_tesimonials_content">
					<div class="about-midd-main">
						<img class="agile-img" src="${path}/resources/images/t2.png" alt=" " class="img-responsive">
						<h4>Laura Hill</h4>
						<p> Lorem ipsum adipiscing elit, sed do eiusmod idunt ut labore. sed do eiusmod tempor incididunt.</p>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="agile_tesimonials_content">
					<div class="about-midd-main">
						<img class="agile-img" src="${path}/resources/images/t3.png" alt=" " class="img-responsive">
						<h4>Thomson Doe</h4>
						<p> Lorem ipsum adipiscing elit, sed do eiusmod idunt ut labore. sed do eiusmod tempor incididunt.</p>
					</div>
				</div>
			</div>

		</div>
		<div class="clearfix"> </div>
	</div>
	<div class="clearfix"> </div>
</div>
<!-- //testimonials-->
<!-- footer -->
<div class="footer">
	<div class="container">
		<h2><a href="index.html"><i class="fa fa-magic" aria-hidden="true"></i>  Exec</a></h2>
		<h3>Subscribe To Our Newsletter</h3>
		<p class="footer_info_w3ls_agile">Subscribe to our newsletter and we will inform you about newest projects and promotions.</p>
		<form action="#" method="post">
			<input type="email" name="email" placeholder="Your email..." required="">
			<input type="submit" value="Subscribe">
		</form>
		<div class="agileits_w3layouts_nav">
			<div class="agileits_w3layouts_nav_left">
				<ul>
					<li class="active"><a href="index.html">Home</a></li>
					<li><a href="about.html">About</a></li>
					<li><a href="icons.html">Icons</a></li>
					<li><a href="mail.html">Mail Us</a></li>
				</ul>
			</div>
			<div class="agileits_w3layouts_nav_right">
				<ul>
					<li><a href="#" class="w3_agile_facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
					<li><a href="#" class="agile_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					<li><a href="#" class="w3_agile_dribble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
					<li><a href="#" class="w3_agile_vimeo"><i class="fa fa-vimeo" aria-hidden="true"></i></a></li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
		<p>Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
	</div>
</div>
<!-- //footer -->
<script src="${path}/resources/js/jquery-2.1.4.min.js"></script>
<script src="${path}/resources/js/search.js"></script>
<script src="${path}/resources/js/poposlides.js">
</script>
<script>
	$(".slides").poposlides();
</script>
	<!-- js for portfolio lightbox -->
<script src="${path}/resources/js/jquery.chocolat.js "></script>
<link rel="stylesheet " href="${path}/resources/css/chocolat.css " type="text/css " media="screen ">
<!--light-box-files -->
<script type="text/javascript ">
	$(function () {
		$('.portfolio-grids a').Chocolat();
	});
</script>
<!-- /js for portfolio lightbox -->
<!-- stats -->
<script src="${path}/resources/js/jquery.waypoints.min.js"></script>
<script src="${path}/resources/js/jquery.countup.js"></script>
<script>
	$('.counter').countUp();
</script>
<!-- //stats -->
<!-- start-smooth-scrolling -->
<script type="text/javascript" src="${path}/resources/js/move-top.js"></script>
<script type="text/javascript" src="${path}/resources/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function ($) {
		$(".scroll").click(function (event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop: $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- start-smooth-scrolling -->
<!-- here stars scrolling icon -->
<script type="text/javascript">
	$(document).ready(function () {
		/*
			var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
			};
		*/

		$().UItoTop({
			easingType: 'easeOutQuart'
		});

	});
</script>
<!-- //here ends scrolling icon -->


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
<script src="${path}/resources/js/bootstrap.js"></script>

</body>
</html>