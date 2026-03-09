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
	UserBean bean = (UserBean) request.getAttribute("bean");
	%>

	<div align="center">
		<h1><%=bean != null ? "Update User" : "Add User"%></h1>

		<h3 style="color: green;"><%=smsg != null ? smsg : ""%></h3>
		<h3 style="color: red;"><%=emsg != null ? emsg : ""%></h3>

		<form action="UserCtl.do" method="post">
			<input type="hidden" value="<%=bean != null ? bean.getId() : ""%>"
				name="id">
			<table>
				<tr>
					<th>FirstName</th>
					<td><input type="text"
						value="<%=bean != null ? bean.getFirstName() : ""%>"
						name="firstName" placeholder="enter firstName"></td>
				</tr>
				<tr>
					<th>LastName</th>
					<td><input type="text"
						value="<%=bean != null ? bean.getLastName() : ""%>"
						name="lastName" placeholder="enter lastName"></td>
				</tr>
				<tr>
					<th>Login</th>
					<td><input type="email"
						value="<%=bean != null ? bean.getLogin() : ""%>" name="login"
						placeholder="enter your login"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password"
						value="<%=bean != null ? bean.getPassword() : ""%>"
						name="password" placeholder="enter your password"></td>
				</tr>
				<tr>
					<th>Dob</th>
					<td><input type="date"
						value="<%=bean != null ? bean.getDob() : ""%>" name="dob"
						style="width: 98%"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=bean != null ? "update" : "save"%>"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>