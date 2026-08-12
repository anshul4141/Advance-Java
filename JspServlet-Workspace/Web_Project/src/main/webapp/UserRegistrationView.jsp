<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	String succ = (String) request.getAttribute("successMsg");
	%>

	<%@ include file="Header.jsp"%>
	<form action="UserRegistrationCtl" method="post">

		<div align="center">

			<h1 style="color: darkblue;">User Registration</h1>

			<h3><%=succ != null ? succ : ""%></h3>

			<table>

				<tr>
					<th>First Name:<font color="red">*</font></th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter firstName"></td>
				</tr>

				<tr>
					<th>Last Name:<font color="red">*</font></th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter lastName"></td>
				</tr>

				<tr>
					<th>Login:<font color="red">*</font></th>
					<td><input type="email" name="login" value=""
						placeholder="enter you email"></td>
				</tr>

				<tr>
					<th>Password:<font color="red">*</font></th>
					<td><input type="password" name="password" value=""
						placeholder="enter you password"></td>
				</tr>

				<tr>
					<th>Dob:<font color="red">*</font></th>
					<td><input type="date" name="dob" value=""></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" value="signUp"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>