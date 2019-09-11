<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list category</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/chapter6/category/add.html"
		class="btn btnprimary">Add</a>
	<form method="post"
		action="${pageContext.request.contextPath}/chapter6/category/dels.html">
		<table class="table">
			<tr>
				<td><button class="btn btn-info">Delete</button></td>
				<th>Id</th>
				<th>Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list}" var="o">
				<tr>
					<td><input type="checkbox" value="${o.id}" name="ids">
					</td>
					<td>${o.id}</td>
					<td>${o.name}</td>
					<td><a
						href="${pageContext.request.contextPath}/chapter6/category/edit.html/${o.id}">
							<img src="${pageContext.request.contextPath}/images/edit.png"
							alt="Edit">
					</a></td>
					<td><a
						href="${pageContext.request.contextPath}/chapter6/category/del.html/${o.id}">
							<img src="${pageContext.request.contextPath}/images/trash.png"
							alt="Delete">
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>