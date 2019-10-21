<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<style type="text/css">
span {
	color: red;
	font-style: italic;
}
</style>
<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/css.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">

<script>
	$(function() {
		$("a[data-lang]").click(function() {
			var lang = $(this).attr("data-lang");
			$.get("home/about.htm?language=" + lang, function() {
				location.reload();
			});
			return false;
		});
	});
</script>


<a href="home/index.htm">Trang chủ</a>
|
<a href="home/about.htm">Giới thiệu</a>
|
<a href="#" data-lang="en"><s:message code="label.en" /></a>
|
<a href="#" data-lang="vi"><s:message code="label.vi" /></a>
