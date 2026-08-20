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
	String err = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="Header.jsp"%>
	<form action="UserCtl" method="post">

		<div align="center">

			<h1 style="color: darkblue;">Add User</h1>

			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>
			<h3 style="color: red"><%=err != null ? err : ""%></h3>

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
					<td><input type="submit" value="save"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>