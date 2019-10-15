<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" charset="utf-8">
<title>Insert title here</title>

<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/css.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<th>Title</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Image</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="o">
		
			<tr>
				<td>${o.title}</td>


				<td>
					<button class="btn_minus">-</button>
					 <input
					value="${o.quantity}" class="${o.productId}">
					
					<button class="btn_plus">+</button>
				</td>

				<td>${o.price}</td>

				<td><img width="70px" src="${o.imageUrl}"></td>

				<td><a
					onclick="return confirm('Are you sure you want to delete this ${o.title} from cart?')"
					href="${pageContext.request.contextPath}/cart/del/${o.productId}.htm">
						<img src="${pageContext.request.contextPath}/images/trash.png"
						alt="Delete" />
				</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="${pageContext.request.contextPath}/cart/checkout.htm"
			class="btn btn-primary">Check Out</a>
	</p>
	<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/btn_add.js"></script>
</body>
</html>