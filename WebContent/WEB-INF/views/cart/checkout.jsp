<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" charset="utf-8">
<title>Insert title here</title>
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

				<td><input type="number" value="${o.quantity}" name="qty"
					class="qty"></td>

				<td>${o.price}</td>
				
				<td><img width="70px" 
					src="${o.imageUrl}"></td>
					
				<td><img
					src="${pageContext.request.contextPath}/images/trash.png"></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="${pageContext.request.contextPath}/cart/checkout.html"
			class="btn btn-primary">Check Out</a>
	</p>
</body>
</html>