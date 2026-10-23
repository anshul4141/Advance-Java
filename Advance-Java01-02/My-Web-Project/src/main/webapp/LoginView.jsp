<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="" method="post">

		<div align="center">

			<h1>Login</h1>

			<table>

				<tr>
					<th>Login</th>
					<td><input type="email" name="login" value=""
						placeholder="enter your emial"></td>
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

</body>
</html>