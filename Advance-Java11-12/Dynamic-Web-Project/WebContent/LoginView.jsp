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
	<h1 align="center">Login</h1>
	<form action="LoginCtl" method="post">

		<%
			String msg = (String) request.getAttribute("msg");
		%>

		<%
			if (msg != null) {
		%>
		<center>
			<h2 style="color: green"><%=msg%></h2>
		</center>
		<%
			}
		%>

		<table align="center">
			<tr>
				<th>LoginId</th>
				<td><input type="email" name="loginId"
					placeholder="Enter Your email"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password"
					placeholder="Enter Your Password"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="SignIn"></td>
			</tr>
		</table>
	</form>
</body>
</html>