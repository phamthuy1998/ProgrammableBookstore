
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form class="form-search" method="get"
	action="${pageContext.request.contextPath}/chapter6/home/search.html">
	<input type="text" placeholder="Search..." name="q">
	<button class="btn btn-primary">Search</button>
</form>
<div class="products">
	<c:forEach var="o" items="${list}">
		<div class="col-4">
			<div class="item">
				<img alt="${o.title}"
					src="${pageContext.request.contextPath}/upload/${o.imageUrl}">
				<div class="info">
					<a
						href="${pageContext.request.contextPath}/chapter6/home/detail.html/${o.id}">${o.title}</a>
				</div>
			</div>
		</div>
	</c:forEach>
	<div class="clear"></div>
</div>