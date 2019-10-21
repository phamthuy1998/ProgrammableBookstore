<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<style type="text/css">
span {
	color: red;
	font-style: italic;
}
</style>
<script src="../js/jquery-1.9.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/css.css">
<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">

<a href="home/products/1.htm"  class="btn btn-primary"><s:message code="home_t" /></a>
<a href="home/about.htm"  class=" btn btn-primary"><s:message code="about" /></a>
<a href="#" data-lang="en"  class="btn btn-primary"><s:message code="label.en" /></a>
<a href="#" data-lang="vi"  class=" btn btn-primary"><s:message code="label.vi" /></a>
<a href="user/login.htm" class="btn btn-primary"><s:message code="label.login" /></a>
<a href="user/register.htm"  class="btn btn-primary"><s:message code="label.register" /></a>
<a href="user/edit.htm"  class="btn btn-primary"><s:message code="edit_user" /></a>
<a href="cart/index.htm"  class="btn btn-primary"> <img width="32px"
	src="${pageContext.request.contextPath}/images/cart.png"> <c:if
		test="${cartNumber != 0}">
		<span class='badge badge-warning' id='lblCartCount'>${cartNumber}</span>
	</c:if>

</a>


