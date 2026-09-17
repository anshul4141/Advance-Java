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
	<form>

		<div align="center">

			<h1>User Registration</h1>

			<table>

				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter your firstName"></td>
				</tr>

				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter your lastName"></td>
				</tr>

				<tr>
					<th>Login</th>
					<td><input type="email" name="loginId" value=""
						placeholder="enter your gmail"></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>
				</tr>

				<tr>
					<th>D.O.B</th>
					<td><input type="date" name="dob" value=""></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signUp"></td>
				</tr>

			</table>

		</div>

	</form>
<%@ include file="Footer.jsp"%>
</body>
</html>