
<%
	String view = request.getParameter("view");
	System.out.print("view:aaaaa "+view);
	if (view.contains("product")) {
		pageContext.forward("admin-layout.jsp");
	} else {
		pageContext.forward("user-layout.jsp");
	}
%>