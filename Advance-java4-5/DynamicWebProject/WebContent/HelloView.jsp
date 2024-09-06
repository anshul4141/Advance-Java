<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="HelloServlet" method="post">
		<table align="center">
			<tr>
				<th>FirstName:</th>
				<td><input type="text" name="firstName"
					placeholder="enter firstName"></td>
			</tr>
			<tr>
				<th>LastName:</th>
				<td><input type="text" name="lastName"
					placeholder="enter lastName"></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="email" name="loginId"
					placeholder="enter Email"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="password"
					placeholder="enter password"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" value="save"></td>
			</tr>
		</table>
	</form>
</body>
</html>