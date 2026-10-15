<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">

		<%
		for (int i = 1; i <= 10; i++) {
		%>
		<h1><%=i%>Hello World
		</h1>
		<%
		}
		%>

	</div>

</body>
</html>