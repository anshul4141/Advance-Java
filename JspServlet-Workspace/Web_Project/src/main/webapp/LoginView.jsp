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
	<form action="LoginCtl" method="post">

		<div align="center">

			<h1 style="color: darkblue;">Login</h1>

			<h3 style="color: red"><%=err != null ? err : ""%></h3>
			<h3 style="color: green"><%=succ != null ? succ : ""%></h3>

			<table>
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
					<th></th>
					<td><input type="submit" value="signIn"></td>
				</tr>
			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>