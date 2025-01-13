<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Second JSP</h1>
	<%
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
	%>
	<h1><%=firstName%></h1>
	<h1><%=lastName%></h1>
</body>
</html>