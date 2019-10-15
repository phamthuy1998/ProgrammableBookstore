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
<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/css.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
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
	<a href="${pageContext.request.contextPath}/admin/user/add.htm"
		class="btn btnprimary">Add</a>
	<div></div>
	<form method="post"
		action="${pageContext.request.contextPath}/admin/user/dels.htm">

		<input type="submit" value="Delete"
			onclick="return confirm('Are you sure you want to delete these authors? \n${list.size()} item')" />
		<br /> ${error} <br />
		<table border="1" style="width: 100%" class="table">
			<tr>
				<th><input type="checkbox" id="checkBoxAll" /></th>
				<th>Id</th>
				<th>User name</th>
				<th>Password</th>
				<th>Phone</th>
				<th>Email</th>
				<th>gender</th>
				<th>Added date</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${list}" var="member">
				<tr>
					<td><input type="checkbox" class="checkboxId"
						value="${member.id}" name="authorIds" /></td>
					<td>${member.id}</td>
					<td>${member.username}</td>
					<td>${member.password}</td>
					<td>${member.tel}</td>
					<td>${member.email}</td>
					<td>${member.gender}</td>
					<td>${member.addeddate}</td>
					
					<td><a
						href="${pageContext.request.contextPath}/admin/user/edit/${member.id}.htm">
							<img src="${pageContext.request.contextPath}/images/edit.png"
							alt="Edit">
					</a></td>
					
					<td><a
						onclick="return confirm('Are you sure you want to delete ${member.username}?')"
						href="${pageContext.request.contextPath}/admin/user/del/${member.id}.htm">
							<img src="${pageContext.request.contextPath}/images/trash.png"
							alt="Delete">
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>