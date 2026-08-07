<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- <% %> script let tag use to write java code in html body in jsp page --%>
	<%-- <%= %> expression tag use to print java variable and object in jsp page --%>

	<%
	for (int i = 1; i <= 10; i++) {
	%>

	<h1><%=i%>Hello World
	</h1>

	<%
	}
	%>
</body>
</html>