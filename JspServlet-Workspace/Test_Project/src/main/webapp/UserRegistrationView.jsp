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
	<div align="center">

		<h1>User Registration</h1>

		<form action="UserRegistrationCtl" method="post">

			<table>

				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter firstName"></td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter lastName"></td>
				</tr>
				<tr>
					<th>Login:</th>
					<td><input type="email" name="login" value=""
						placeholder="enter you email"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password" value=""
						placeholder="enter you password"></td>
				</tr>
				<tr>
					<th>Dob:</th>
					<td><input type="date" name="dob" value=""></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="signUp"></td>
				</tr>
			</table>

		</form>

	</div>

</body>
</html>