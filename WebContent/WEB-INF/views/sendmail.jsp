<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send mail reset password</title>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<form method="post" class="form">
		<p>
			<label>Email</label> <input type="email" name="email">
		</p>
		<p>
			<label>Subject</label> <input type="text" name="subject" />
		</p>
		<p>
			<label>Content</label>
			<textarea name="content"></textarea>
		</p>
		<p>
			<button>Send mail</button>
		</p>
	</form>
	<c:if test="${not empty msg }">
		<div class="error">${msg}</div>
	</c:if>

</body>
</html>