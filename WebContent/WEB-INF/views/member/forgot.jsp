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
					<h1 class="center lb-login">Forgot Password</h1>
					<br> 
					<div>
						<label>Email</label> <input type="email" class="form-control"
							placeholder="Email" name="email">
					</div>

					<br>

					<div class="center">
						<button h class="btn btn-lg btn-primary">Reset Password</button>
					</div>
					
					<div class="center">
						<a class="btn-register" href="${pageContext.request.contextPath}/user/login.htm">Log
							On</a>
					</div>
					<div class="center">
						<a class="btn-register"  href="${pageContext.request.contextPath}/user/forgot.htm">Forgot
							Password?</a>
					</div>
				</form>
		</div>
	</div>
</body>
</html>