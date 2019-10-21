<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function delayer(delay) {
		onLoad = setTimeout(
				'window.location.href = "${pageContext.servletContext.contextPath}/home/products/1.htm"',
				delay);
	}
</script>

</head>
<body>
	<script>
		delayer(1000)
	</script>
</body>
</html>
 --%>


<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">

<meta charset="utf-8" />
<title>Tổ chức giao diện</title>
<link href="css/css2.css" rel="stylesheet" />

</head>
<body>
	<div class="container">
		<header>
			<h1>Shopping Mall</h1>
		</header>
		<nav>
			<a href="home/index.htm">Trang chủ</a> | <a href="home/about.htm">Giới
				thiệu</a> | <a href="#">English</a> | <a href="#">Tiếng Việt</a>
		</nav>
		<article>
			<jsp:include page="${param.view}" />
		</article>
		<aside>CONTROL PANEL</aside>
		<footer>FOOTER</footer>
	</div>
</body>
</html>