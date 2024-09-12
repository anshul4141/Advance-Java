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
		<h1 align="center">Login</h1>
		<table align="center">
			<tr>
				<th>LoginId:</th>
				<td><input type="email" name="loginId"
					placeholder="Enter your loginId"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="password"
					placeholder="Enter your password"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="signIn"></td>
			</tr>
		</table>
	</form>
</body>
</html>