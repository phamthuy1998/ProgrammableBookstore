<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">


</head>
<body>
	<form class="form-search" method="get"
		action="${pageContext.request.contextPath}/home/search.htm">
		<input type="text" placeholder="Search..." name="q">
		<button class="btn btn-primary">Search</button>
	</form>
	<div class="products">
		<c:forEach var="o" items="${list}">
			<div class="col-4">
				<div class="item">
					<img class="img-product" alt="${o.title}"
						src="${pageContext.request.contextPath}/images/${o.id}.jpg">
					<div class="info">
						<a
							href="${pageContext.request.contextPath}/home/product/detail/${o.id}.htm">${o.title}</a>
					</div>
				</div>
			</div>
		</c:forEach>
		<div class="clear"></div>
	</div>
	<ul class="pagination">
		<c:forEach begin="1" end="${pageNum}" step="1" var="i">
			<li class="page-item"><a class="page-link"
				href="${pageContext.request.contextPath}/home/products/${i}.htm">${i}</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>