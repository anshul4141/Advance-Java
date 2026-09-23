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
	String errorMsg = (String) request.getAttribute("errorMsg");
	String succMsg = (String) request.getAttribute("succMsg");
	%>

	<%@ include file="Header.jsp"%>
	<form action="LoginCtl" method="post">

		<div align="center">
			<h1>Login</h1>

			<h2 style="color: red"><%=errorMsg != null ? errorMsg : ""%></h2>
			<h2 style="color: green"><%=succMsg != null ? succMsg : ""%></h2>

			<table>

				<tr>
					<th>Login</th>
					<td><input type="email" name="loginId" value=""
						placeholder="enter your gmail"></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signIn"></td>
				</tr>

			</table>

		</div>

	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>