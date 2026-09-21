<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<%
	String succ = (String) request.getAttribute("succMsg");
	String err = (String) request.getAttribute("errorMsg");
	%>

	<div align="center">
		<h1>Add User</h1>

		<h2 style="color: green"><%=succ != null ? succ : ""%></h2>
		<h2 style="color: red"><%=err != null ? err : ""%></h2>

		<form action="UserCtl" method="post">

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
						placeholder="enter your login"></td>
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
					<td><input type="submit" name="operation" value="save"></td>
				</tr>

			</table>

		</form>

	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>