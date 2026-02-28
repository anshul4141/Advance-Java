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

	<%
	String smsg = (String) request.getAttribute("successMsg");
	String emsg = (String) request.getAttribute("errorMsg");
	%>

	<div align="center">
		<h1>Login</h1>

		<h3 style="color: green;"><%=smsg != null ? smsg : ""%></h3>
		<h3 style="color: red;"><%=emsg != null ? emsg : ""%></h3>

		<form action="LoginCtl" method="post">

			<table>
				<tr>
					<th>Login</th>
					<td><input type="email" value="" name="login"
						placeholder="enter your login"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" value="" name="password"
						placeholder="enter your password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="signIn"></td>
				</tr>
			</table>

		</form>

	</div>
</body>
</html>