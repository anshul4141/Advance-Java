<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- scriptlet tag use to write java code in jsp -->
	<%
		int i = 5;
		int j = 10;
	%>

	<!-- expression tag use to print java values -->
	<h1><%=i + j%></h1>

</body>
</html>