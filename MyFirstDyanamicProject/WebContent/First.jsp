<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<br>
	<br>
	<br>

	<center>

		<form action="FirstServlet" method="post">

			<table>

				<tr>

					<th>First Name</th>
					<td><input type="text" name="fname"></td>

				</tr>

				<tr>

					<th>Last Name</th>
					<td><input type="text" name="lname"></td>

				</tr>

				<tr>

					<th>Email</th>
					<td><input type="text" name="email"></td>

				</tr>

				<tr>

					<th>Password</th>
					<td><input type="password" name="pwd"></td>

				</tr>

				<tr>

					<th>Click here</th>
					<td><input type="submit" value="save"></td>

				</tr>

			</table>

		</form>
	</center>
</body>
</html>