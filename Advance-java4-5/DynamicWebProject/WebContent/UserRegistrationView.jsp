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
	<form action="UserRegistrationCtl" method="post">

		<%
			String smsg = (String) request.getAttribute("smsg");
		%>

		<table align="center">

			<%
				if (smsg != null) {
			%>
			<h3 style="color: green" align="center"><%=smsg%></h3>
			<%
				}
			%>

			<h1 align="center">User Registration</h1>
			<tr>
				<th>FirstName:</th>
				<td><input type="text" name="firstName"
					placeholder="Enter First Name"></td>
			</tr>
			<tr>
				<th>LastName:</th>
				<td><input type="text" name="lastName"
					placeholder="Enter Last Name"></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><input type="email" name="loginId"
					placeholder="Enter your Email"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="password"
					placeholder="Enter your Password"></td>
			</tr>
			<tr>
				<th>DOB:</th>
				<td><input type="date" name="dob" placeholder="Enter your Dob"></td>
			</tr>
			<tr>
				<th>Phone:</th>
				<td><input type="number" name="phoneNo"
					placeholder="Enter Your phoneNo"></td>
			</tr>
			<tr>
				<th>Address:</th>
				<td><input type="text" name="address"
					placeholder="Enter Your address"></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><input type="text" name="gender"
					placeholder="Enter Your gender"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="save"></td>
			</tr>
		</table>
	</form>

</body>
</html>