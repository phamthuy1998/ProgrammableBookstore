<%@ page language="java" pageEncoding="utf-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta pageEncoding="utf-8">
<title><s:message code="titleAddAuthor" /></title>

<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/css.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">

</head>
<body class="body-auth">
	<div class="login">
		<div class="col-ms-8 mx-auto">

			<form method="post" class="form-add-author">
				<h1 class="center lb-login">
					<s:message code="titleAddAuthor" />
				</h1>

				<br>

				<div>
					<label><s:message code="name_author" /></label> <br> <input
						class="form-control" type="text" name="name">
				</div>

				<br>

				<div class="center">
					<button class="btn btn-lg btn-primary">Save</button>
				</div>
			</form>

		</div>
	</div>

</body>
</html>