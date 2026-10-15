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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		%>

		<h1><%=firstName%></h1>
		<h1><%=lastName%></h1>
		<h1><%=login%></h1>
		<h1><%=password%></h1>
		<h1><%=dob%></h1>


	</div>

</body>
</html>