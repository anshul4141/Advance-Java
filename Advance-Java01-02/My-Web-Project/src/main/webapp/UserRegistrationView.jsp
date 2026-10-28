<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String successMsg = (String) request.getAttribute("successMsg");
	%>
	<%@ include file="Header.jsp"%>
	<form action="UserRegistrationCtl" method="post">

		<div align="center">

			<h1>User Registration</h1>

			<h2 style="color: green"><%=successMsg != null ? successMsg : ""%></h2>

			<table>

				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter first name"></td>
				</tr>

				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter last name"></td>
				</tr>

				<tr>
					<th>Login</th>
					<td><input type="email" name="login" value=""
						placeholder="enter your emial"></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>
				</tr>

				<tr>
					<th>DOB</th>
					<td><input type="date" name="dob" value=""></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signUp"></td>
				</tr>

			</table>

		</div>

	</form>

</body>
</html>