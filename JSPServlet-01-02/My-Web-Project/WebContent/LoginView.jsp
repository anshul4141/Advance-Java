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
		String msg = (String) request.getAttribute("msg");
		%>
		<form action="LoginCtl" method="post">
			<h1>Login</h1>

			<%
			if (msg != null) {
			%>
			<h2><%=msg%></h2>
			<%
			}
			%>
			<table>
				<tr>
					<th>login</th>
					<td><input type="email" name="login" value=""
						placeholder="enter your email"></td>
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