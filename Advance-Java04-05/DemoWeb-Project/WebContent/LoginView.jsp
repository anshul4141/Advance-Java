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
	String succesMsg = (String) request.getAttribute("successMsg");
	String erorrMsg = (String) request.getAttribute("erorrMsg");
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">
		<h1>Login</h1>
		<h3 style="color: green"><%=succesMsg != null ? succesMsg : ""%></h3>
		<h3 style="color: red"><%=erorrMsg != null ? erorrMsg : ""%></h3>
		<form action="LoginCtl" method="post">

			<table>
				<tr>
					<th>Login :</th>
					<td><input type="email" name="login" value=""
						placeholder="enter your login"></td>
				</tr>

				<tr>
					<th>Password :</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your login"></td>
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