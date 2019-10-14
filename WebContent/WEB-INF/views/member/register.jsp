<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<meta http-equiv="Content-Type" charset="utf-8">
<title>Sign In|Sign up</title>

<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/css.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<script>
	$(function() {
		$("a[data-lang]").click(
				function() {
					var lang = $(this).attr("data-lang");
					$.get(
							"${pageContext.request.contextPath}/user/register.htm?language="
									+ lang, function() {
								location.reload();
							});
					$.get(
							"${pageContext.request.contextPath}/user/login.htm?language="
									+ lang, function() {
								location.reload();
							});
					$.get(
							"${pageContext.request.contextPath}/user/forgot.htm?language="
									+ lang, function() {
								location.reload();
							});
					return false;
				});
	});
</script>

</head>
<body class="body-login">

	<a href="#" data-lang="en"><s:message code="label.en" /></a> |
	<a href="#" data-lang="vi"><s:message code="label.vi" /></a>
	<div class="login">
		<div class="col-ms-8 mx-auto">
			<form:form method="post" class="form-login" modelAttribute="member">
				<h1 class="center lb-login">
					<s:message code="label.register" />
				</h1>
				<br>


				<div>
					<label><s:message code="label.username" /></label> <input
						class="form-control"
						placeholder="<s:message code="label.username"/>" type="text"
						name="username">
					<form:errors path="username" />
				</div>

				<div>
					<label><s:message code="label.email" /></label> <input
						type="email" class="form-control"
						placeholder="<s:message code="label.email" />" name="email">
					<form:errors path="email" />
				</div>

				<div>
					<label><s:message code="label.password" /></label> <input
						class="form-control"
						placeholder="<s:message code="label.password" />" type="password"
						name="password">
					<form:errors path="password" />
				</div>

				<div>
					<label><s:message code="label.phone" /></label> <input
						type="number" class="form-control"
						placeholder="<s:message code="label.phone" />" name="tel">
					<form:errors path="tel" />
				</div>

				<br>

				<div>
					<label><s:message code="label.gender" /></label> <input
						type="radio" name="gender" value="0" checked>
					<s:message code="label.male" />
					<input value="1" type="radio" name="gender">
					<s:message code="label.female" />
					<br>
				</div>

				<br>

				<div>
					<button class="btn btn-primary btn-lg">
						<s:message code="label.register" />
					</button>
				</div>

				<br>
				<div class="center">
					<a class="btn-register"
						href="${pageContext.request.contextPath}/user/login.htm"><s:message
							code="label.login" /></a>
				</div>
				<br>
				<div class="center">
					<a class="btn-register"
						href="${pageContext.request.contextPath}/user/forgot.htm"><s:message
							code="label.forgotpassword" /></a>
				</div>
			</form:form>
		</div>
	</div>

</body>
</html>