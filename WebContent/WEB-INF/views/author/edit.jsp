<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edit author information</title>
</head>
<body>
	<div class="page-header">Edit Author</div>
	
	<form method="post" class="form">
		<input type="hidden" name="id" value="${o.id}">
		<div>
			<label>Name</label> <input type="text" name="name" value="${o.name}">
		</div>
		<div>
			<button class="btn btn-primary">Save</button>
		</div>
	</form>
</body>
</html>
