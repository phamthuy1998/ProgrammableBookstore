
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<div class="products">
	<div class="col-4">
		<img src="${pageContext.request.contextPath}/images/${o.imageUrl}" width="300" >
	</div>
	<div class="col-8">
		<h2>${o.title}</h2>
		<p>
			ISBN: <b>${o.isbn}</b>
		</p>
		<p>
			Pages: <b>${o.pages}</b>
		</p>
		<p>
			Price: <b><fmt:formatNumber value="${o.price}" type="currency" /></b>
		</p>
		<form method="post"
			action="${pageContext.request.contextPath}/cart/add.htm">

			<input type="hidden" value="${o.id}" name="productId"> <input
				type="number" name="quantity" value="1">
			<button class="btn btn-primary">Add to Cart</button>
		</form>
	</div>
</div>
