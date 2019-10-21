<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta charset="utf-8">
<title><s:message code="label.register" /></title>
<style type="text/css">
span {
	color: red;
	font-style: italic;
}
</style>
<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">

<link href="css/css2.css" rel="stylesheet" />
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
<body>
	<div class="container">

		<header>
			<h1>Shopping Mall</h1>
		</header>

		<nav>
			<jsp:include page="menu_user.jsp" />
		</nav>

		<article>
			<jsp:include page="${param.view}" />
		</article>
		<aside>CONTROL PANEL</aside>
		<footer>FOOTER user</footer>
	</div>
</body>
</html>
