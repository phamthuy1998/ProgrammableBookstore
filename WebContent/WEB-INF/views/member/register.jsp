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
					return false;
				});
	});
</script>

</head>
<body class="body-login">

	<a href="#" data-lang="en">English</a> |
	<a href="#" data-lang="vi">Tiếng Việt</a>
	<div class="login">
		<div class="col-ms-8 mx-auto">
			<form method="post" class="form-login">
				<h1 class="center lb-login"><s:message code="label.register" /></h1>
				<br>
				<div>
					<label><s:message code="label.username"/></label> <input
						class="form-control" placeholder="<s:message code="label.username"/>" type="text"
						name="username">
				</div>

				<div>
					<label><s:message code="label.email" /></label> <input
						type="email" class="form-control" placeholder="<s:message code="label.email" />" name="email">
				</div>

				<div>
					<label><s:message code="label.password" /></label> <input
						class="form-control" placeholder="<s:message code="label.password" />" type="password"
						name="password">
				</div>

				<div>
					<label><s:message code="label.phone" /></label> <input
						type="number" class="form-control" placeholder="<s:message code="label.phone" />" name="tel">
				</div>

				<br>

				<div>
					<label><s:message code="label.gender" /></label>
					<!-- <select name="gender">
							<option value="0">Male</option>
							<option value="1">Female</option>
							<option value="2">Undefined</option>
						</select> -->

					<input type="radio" name="gender" value="0" checked>
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
			</form>
		</div>
	</div>

</body>
</html>