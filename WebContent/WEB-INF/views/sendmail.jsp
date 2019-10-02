<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send mail reset password</title>
</head>
<body>

	${message }
	<form action="${pageContext.servletContext.contextPath}/sendmail.htm"
		method="post">
		<p>
			<input name="from" placeholder="From">
		</p>
		<p>
			<input name="to" placeholder="To">
		</p>
		<p>
			<input name="subject" placeholder="Subject">
		</p>
		<p>
			<textarea name="body" placeholder="Body" rows="3" cols="30"></textarea>
		</p>
		<button>Send</button>
	</form>
</body>
</html>