<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>upload</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		<p>
			<label>Select File</label> <input type="file" name="f">
		</p>
		<p>
			<button>Upload</button>
		</p>
	</form>
	<c:if test="${name != null}">
		<img src="${pageContext.request.contextPath}/images/${name}">
	</c:if>
 
</body>
</html>