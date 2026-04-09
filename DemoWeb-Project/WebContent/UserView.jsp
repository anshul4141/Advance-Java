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
	String errorMsg = (String) request.getAttribute("erorrMsg");
	UserBean bean = (UserBean) request.getAttribute("bean");
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1><%=bean != null ? "Update User" : "Add User"%></h1>

		<h3 style="color: green"><%=succesMsg != null ? succesMsg : ""%></h3>
		<h3 style="color: red"><%=errorMsg != null ? errorMsg : ""%></h3>
		<form action="UserCtl.do" method="post">

			<input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">

			<table>

				<tr>
					<th>First Name :</th>
					<td><input type="text" name="firstName"
						value="<%=bean != null ? bean.getFirstName() : ""%>"
						placeholder="enter first name"></td>
				</tr>

				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lastName"
						value="<%=bean != null ? bean.getLastName() : ""%>"
						placeholder="enter last name"></td>
				</tr>

				<tr>
					<th>Login :</th>
					<td><input type="email" name="login"
						value="<%=bean != null ? bean.getLogin() : ""%>"
						placeholder="enter your login"></td>
				</tr>

				<tr>
					<th>Password :</th>
					<td><input type="password" name="password"
						value="<%=bean != null ? bean.getPassword() : ""%>"
						placeholder="enter your login"></td>
				</tr>

				<tr>
					<th>DOB :</th>
					<td><input type="date" name="dob"
						value="<%=bean != null ? bean.getDob() : ""%>"></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=bean != null ? "update" : "save"%>"></td>
				</tr>

			</table>

		</form>

	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>