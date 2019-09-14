<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="post" modelAttribute="obj" cssClass="form">
	<p>
		<label>ID</label>
		<form:input path="id" />
	</p>
	<p>
		<label>Name</label>
		<form:input path="name" />
	</p>
	<p>
		<label>Parent</label>
		<form:select path="parent">
			<form:option value="">--Select Parent--</form:option>
			<form:options items="${map}" />
		</form:select>
	</p>
	<p>
		<button class="btn btn-primary">Save</button>
	</p>
</form:form>