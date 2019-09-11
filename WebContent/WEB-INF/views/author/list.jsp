<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js">
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#checkBoxAll').click(function() {
			if ($(this).is(":checked"))
				$('.checkboxId').prop('checked', true);
			else
				$('.checkboxId').prop('checked', false);
		});
	});
</script>
</head>
<body>
	<a href="${pageContext.request.contextPath}/admin/author/add.htm"
		class="btn btnprimary">Add</a>
	<div></div>
	<form method="post"
		action="${pageContext.request.contextPath}/admin/author/dels.htm">

		<input type="submit" value="Delete"
			onclick="return confirm('Are you sure you want to delete these authors?')" />
		<br /> ${error} <br />
		<table border="1" style="width: 100%" class="table">
			<tr>
				<th><input type="checkbox" id="checkBoxAll" /></th>
				<th>Id</th>
				<th>Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list}" var="author">
				<tr>
					<td><input type="checkbox" class="checkboxId"
						value="${author.id}" name="authorIds"/></td>
					<td>${author.id}</td>
					<td>${author.name}</td>
					<td><a
						href="${pageContext.request.contextPath}/admin/author/edit/${author.id}.htm">
							<img src="${pageContext.request.contextPath}/images/edit.png"
							alt="Edit">
					</a></td>
					<td><a
						onclick="return confirm('Are you sure you want to delete ${author.name}?')"
						href="${pageContext.request.contextPath}/admin/author/del/${author.id}.htm">
							<img src="${pageContext.request.contextPath}/images/trash.png"
							alt="Delete">
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>