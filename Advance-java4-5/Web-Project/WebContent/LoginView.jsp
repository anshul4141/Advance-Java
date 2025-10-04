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
		String successMsg = (String) request.getAttribute("successMsg");
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">
		<h1>Login View</h1>

		<%
			if (errorMsg != null) {
		%>

		<h2 style="color: red"><%=errorMsg%></h2>

		<%
			}
		%>

		<%
			if (successMsg != null) {
		%>

		<h2 style="color: green"><%=successMsg%></h2>

		<%
			}
		%>

		<form action="LoginCtl" method="post">
			<table>
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
					<th></th>
					<td><input type="submit" name="operation" value="signIn"></td>
				</tr>
			</table>
		</form>

	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>