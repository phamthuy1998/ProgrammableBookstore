
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta charset="utf-8">
<title><s:message code="home" /></title>

<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">

<script>
	$(function() {
		$("a[data-lang]").click(function() {
			var pathname = window.location.pathname;
			/* alert(pathname); */
			var lang = $(this).attr("data-lang");
			$.get(pathname + "?language=" + lang, function() {
				location.reload();
			});
			return false;
		});
	});
</script>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<link href="css/css2.css" rel="stylesheet" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.mySlides {
	display: none;
}
</style>

</head>
<body>
	<div class="container">

		<br>
		<header>
			<div class="w3-content w3-display-container">
				<img height="266" width="1100" class="mySlides header"
					src="https://cdn-images-1.medium.com/max/800/1*gLe1O6T4dHUOBJckSsNegQ.png">
				<img class="mySlides"
					src="https://coderseye.com/wp-content/uploads/Best-Computer-Coding-Books-for-beginners-1.jpg">
				<img class="mySlides"
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS88FsCdYcyjne5P1Rzq6VpMYxkFrGv2P4TU9TLzPQ2d56VW7wf">
				<img class="mySlides"
					src="https://pbs.twimg.com/media/Dv1ERJpVsAAA-HP.jpg">
				
				<button class="w3-button w3-black w3-display-left"
					onclick="plusDivs(-1)">&#10094;</button>
				<button class="w3-button w3-black w3-display-right"
					onclick="plusDivs(1)">&#10095;</button>
			</div>

			<script>
				var slideIndex = 1;
				showDivs(slideIndex);

				function plusDivs(n) {
					showDivs(slideIndex += n);
				}

				function showDivs(n) {
					var i;
					var x = document.getElementsByClassName("mySlides");
					if (n > x.length) {
						slideIndex = 1
					}
					if (n < 1) {
						slideIndex = x.length
					}
					for (i = 0; i < x.length; i++) {
						x[i].style.display = "none";
					}
					x[slideIndex - 1].style.display = "block";
				}
			</script>
		</header>

		<nav>
			<jsp:include page="menu_user.jsp" />
		</nav>

		<article>
			<jsp:include page="${param.view}" />
		</article>

		<aside>
			CONTROL PANEL <a href="hehe">hehe</a>
		</aside>


		<footer>FOOTER admin</footer>
	</div>
</body>
</html>