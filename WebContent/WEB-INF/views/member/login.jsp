<%@ page language="java" pageEncoding="utf-8"%>
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
</head>
<body class="body-login">
	<div class="login">
		<div class="col-ms-8 mx-auto">
			<form method="post" class="form-login">
				<h1 class="center lb-login">Login</h1>
				<br> <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div>
					<label>Email</label> <input class="form-control" value="admin"
						placeholder="Username" type="text" name="username">
				</div>
				<div>
					<label>Password</label> <input class="form-control" value="123"
						placeholder="Password" type="password" name="password">
				</div>
				<div>
					<label> <input type="checkbox" name="remember" value="1">
						Remember me
					</label>
				</div>
				<div>
					<button class="btn btn-lg btn-primary">Login</button>
				</div>
				<br>
				<div class="center">
					<a class="btn-register" href="${pageContext.request.contextPath}/user/register.htm">Register
						an Account</a>
				</div>
				<br>
				<div class="center">
					<a class="btn-register" href="${pageContext.request.contextPath}/user/forgot.htm">Forgot
						Password?</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>