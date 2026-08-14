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

		<h1>Login</h1>

		<form>

			<table>
				<tr>
					<th>Login:</th>
					<td><input type="email" name="login" value=""
						placeholder="enter you email"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password" value=""
						placeholder="enter you password"></td>
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