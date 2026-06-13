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
		<h1>User Registeration</h1>

		<form action="LoginCtl" method="post">

			<table>
				<tr>
					<th>FirstName<span style="color: red">*</span></th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter you firstName"></td>
				</tr>
				<tr>
					<th>LastName<span style="color: red">*</span></th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter you lastName"></td>
				</tr>
				<tr>
					<th>LoginId<span style="color: red">*</span></th>
					<td><input type="email" name="loginId" value=""
						placeholder="enter you email"></td>
				</tr>
				<tr>
					<th>Password<span style="color: red">*</span></th>
					<td><input type="password" name="password" value=""
						placeholder="enter you password"></td>
				</tr>
				<tr>
					<th>Dob<span style="color: red">*</span></th>
					<td><input type="date" name="dob" value=""
						style="width: 165px"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signUn"></td>
				</tr>
			</table>

		</form>


	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>