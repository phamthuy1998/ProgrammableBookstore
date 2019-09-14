
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form class="form-search" method="get"
	action="${pageContext.request.contextPath}/home/search.htm">
	<input type="text" placeholder="Search..." name="q">
	<button class="btn btn-primary">Search</button>
</form>
<div class="products">
	<c:forEach var="o" items="${list}">
		<div class="col-4">
			<div class="item">
				<img alt="${o.title}"  height="285" width="200"
					src="${o.imageUrl}">
				<div class="info">
					<a
						href="${pageContext.request.contextPath}/home/product/detail/${o.id}.htm">${o.title}</a>
				</div>
			</div>
		</div>
	</c:forEach>
	<div class="clear"></div>
</div>