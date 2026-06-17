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
	String _suc = (String) request.getAttribute("successMsg");
	String _err = (String) request.getAttribute("errorMsg");
	%>
	<%@ include file="Header.jsp"%>

	<div align="center">
		<h1>Login</h1>
		
		<h3 style="color: green"><%=_suc != null ? _suc : ""%></h3>
		<h3 style="color: red"><%=_err != null ? _err : ""%></h3>
		
		<form action="LoginCtl" method="post">

			<table>
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
					<th></th>
					<td><input type="submit" name="operation" value="signIn"></td>
				</tr>
			</table>

		</form>

	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>