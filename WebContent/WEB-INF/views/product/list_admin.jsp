<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" charset="utf-8">
<title><s:message code="title_book" /></title>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">

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
	<a href="${pageContext.request.contextPath}/admin/product/add.htm"
		class="btn btnprimary">Add</a>
	<div></div>
	<form method="post"
		action="${pageContext.request.contextPath}/admin/product/dels.htm">

		<input type="submit" value="Delete"
			onclick="return confirm('Are you sure you want to delete these authors? \n${list.size()} item')" />
		<br /> ${error} <br />
		<table class="table table-hover border table-striped">
			<tr class="thead-dark">
				<th><input type="checkbox" id="checkBoxAll" /></th>
				<th><s:message code="id_book" /></th>
				<th><s:message code="name_book" /></th>
				<th><s:message code="price_book" /></th>
				<th><s:message code="page_book" /></th>
				<th><s:message code="image_book" /></th>
				<th><s:message code="eidt_book" /></th>
				<th><s:message code="del_book" /></th>
			</tr>
			<c:forEach items="${list}" var="p">
				<tr>
					<td><input type="checkbox" class="checkboxId" value="${p.id}"
						name="productIds" /></td>
					<td>${p.id}</td>
					<td>${p.title}</td>
					<td><fmt:formatNumber value="${p.price}" type="currency" /></td>
					<td>${p.pages}</td>
					<td><img width="100px"
						src="${pageContext.request.contextPath}/images/${p.imageUrl}.jpg"></td>
					<td><a 
						href="${pageContext.request.contextPath}/admin/product/edit/${p.id}.htm">
							<img src="${pageContext.request.contextPath}/images/edit.png"
							alt="Edit">
					</a></td>
					<td><a
						onclick="return confirm('Are you sure you want to delete ${p.title}?')"
						href="${pageContext.request.contextPath}/admin/product/del/${p.id}.htm">
							<img src="${pageContext.request.contextPath}/images/trash.png"
							alt="Delete">
					</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>