<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<html>
<head>
<meta pageEncoding="utf-8">
<title>Sign In|Sign up</title>
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

<script type="text/javascript">

</script>
</head>
<body>

	<form method="post">
		<table class="table table-hover border  table-bordered ">
			<tr class="table-primary">
				<th>InvoiceId</th>
				<th>Email</th>
				<th>Tel</th>
				<th>Address</th>
				<th>Add date</th>
				<th>Status</th>
				<th>Detail</th>
				<th></th>
			</tr>
			<c:forEach items="${list}" var="i">

				<tr >
					<td>${i.id}</td>
					<td>${i.email}</td>
					<td>${i.tel}</td>
					<td>${i.address}</td>
					<td><fmt:formatDate value="${i.date}" pattern="dd/MM/yyyy" />
					</td>
					<td>${i.status}</td>
					<td><a
						href="${pageContext.request.contextPath}/user/invoice/detail/${i.id}.htm">
							<img src="${pageContext.request.contextPath}/images/order.png"
							alt="Edit">
					</a></td>

					<td><c:if test="${i.statusId == 1}">
							<a 
								onclick="return confirm('Are you sure you want to cancel ${i.id}?')"
								href="${pageContext.request.contextPath}/user/invoice/cancel/${i.id}.htm">
								<img src="${pageContext.request.contextPath}/images/cancel.png"
								alt="Delete">
							</a>
						</c:if></td>
				</tr>

			</c:forEach>
		</table>
	</form>

</body>
</html>