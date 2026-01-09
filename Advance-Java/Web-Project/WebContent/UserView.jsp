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
		<%
		String smsg = (String) request.getAttribute("successMsg");
		%>
		<h1>Add User</h1>

		<h2 style="color: green"><%=smsg != null ? smsg : ""%></h2>

		<form action="UserCtl" method="post">

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
						placeholder="enter your login"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>
				</tr>
				<tr>
					<th>Dob:</th>
					<td><input type="date" name="dob" value=""></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="save"></td>
				</tr>

			</table>

		</form>

	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>