<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>ScriptLet tag</h1>
	<%
		for (int i = 1; i <= 5; i++) {
	%>
	<h1><%=i%>
		Hello JSP
	</h1>
	<%
		}
	%>

	<%
		int a = 6, b = 2;
	%>
	<h1>
		sum =<%=a + b%><br>
		<%=a * b%>
		<%=a / b%>
		<%=a - b%>
	</h1>
</body>
</html>