<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FirstServlet" method="post">
		<table>
			<tr>
				<th>First Name</th>
				<td><input type="text" name="firstName"
					placeholder="Enter First Name"></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" name="lastName"
					placeholder="Enter Last Name"></td>
			</tr>
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
				<th>DOB</th>
				<td><input type="date" name="dob" placeholder="Enter Your Dob"></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><input type="text" name="address"
					placeholder="Enter Your address"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>