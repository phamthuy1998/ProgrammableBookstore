<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/user/register.htm"
		method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<p>
			<input type="email" class="form-control" placeholder="Email"
				name="email">
		</p>
		<p>
			<input class="form-control" placeholder="Username" type="text"
				name="username">
		</p>
		<p>
			<input class="form-control" placeholder="Password" type="password"
				name="password">
		</p>
		<p>
			<input type="number" class="form-control" placeholder="Tel"
				name="tel">
		</p>
		<p>
			<input type="text" class="form-control" placeholder="Address"
				name="address">
		</p>
		<p>
			<select name="gender">
				<option value="0">Male</option>
				<option value="1">Female</option>
				<option value="2">Undefined</option>
			</select>
		</p>
		<p>
			<button>Register</button>
		</p>
		<p class="center">
			<a href="${pageContext.request.contextPath}/user/logon.html">Log
				On</a>
		</p>
		<p class="center">
			<a href="${pageContext.request.contextPath}/user/forgot.html">Forgot
				Password?</a>
		</p>
	</form>
</body>
</html>