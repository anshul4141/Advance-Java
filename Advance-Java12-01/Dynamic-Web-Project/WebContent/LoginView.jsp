<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<form action="LoginCtl" method="post">

		<%
			String msg = (String) request.getAttribute("msg");
		%>

		<h1 align="center">Login</h1>
		
		<%if(msg != null) {%>
		<h3 align="center"><%=msg %></h3>
		<%} %>

		<table align="center">
			<tr>
				<th>LoginId</th>
				<td><input type="email" name="loginId"
					placeholder="Enter Your email" value=""></td>
			</tr>

			<tr>
				<th>Password</th>
				<td><input type="password" name="password"
					placeholder="Enter Your password" value=""></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="signIn"></td>
			</tr>
		</table>
	</form>

</body>
</html>