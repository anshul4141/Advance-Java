<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	for (int i = 1; i <= 6; i++) {
	%>
	<div align="center">
		<h<%=i%>><%=i%>Hello Java </h<%=i%>>
	</div>
	<%
	}
	%>
</body>
</html>