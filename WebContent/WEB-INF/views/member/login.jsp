<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
	<div class="login">
		<div class="col-ms-8 mx-auto">
			<form:form method="post" class="form-login" modelAttribute="member">
				<h1 class="center lb-login">
					<s:message code="label.login" />
				</h1>
				<br> 
				
				<div>
					<label><s:message code="label.emailorphone" /></label> <input
						class="form-control" placeholder="<s:message code="label.emailorphone" />"
						type="text" name="email">
				</div>
				<div>
					<label><s:message code="label.password" /></label> <input
						class="form-control"
						placeholder="<s:message code="label.password" />" type="password"
						name="password">
				</div>
				<%-- <div>
					<label> <input type="checkbox" name="remember" value="1">
						<s:message code="label.rememberme" />
					</label>
				</div> --%>
				<br>	
				<div>
					<button class="btn btn-lg btn-primary"><s:message code="label.login" /></button>
				</div>
				<br>
				<div class="center">
					<a class="btn-register"
						href="${pageContext.request.contextPath}/user/register.htm"><s:message
							code="label.regislink" /></a>
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