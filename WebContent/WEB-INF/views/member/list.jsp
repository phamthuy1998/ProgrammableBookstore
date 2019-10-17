<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		class="btn btnprimary"><s:message code="label.insert" /></a>
	<div></div>
	
	<form method="post"
		action="${pageContext.request.contextPath}/admin/user/dels.htm">
		
		<input type="submit" value="<s:message code="label.delete" />"
			onclick="return confirm('Are you sure you want to delete these authors?')" />
		
		<br /> ${error} <br />
		
		<table class="table table-hover border table-striped">
			<tr class="thead-dark">
				<th><input type="checkbox" id="checkBoxAll" /></th>
				<th><s:message code="label.id" /></th>
				<th><s:message code="label.username" /></th>
				<th><s:message code="label.password" /></th>
				<th><s:message code="label.phone" /></th>
				<th><s:message code="label.email" /></th>
				<th><s:message code="label.gender" /></th>
				<th><s:message code="label.datecreate" /></th>
				<th><s:message code="label.update" /></th>
				<th><s:message code="label.delete" /></th>
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