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
	UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<%-- <jsp:useBean id="bean" class="com.rays.bean.UserBean" scope="request"></jsp:useBean> --%>
	<div align="center">
		<%
		String smsg = (String) request.getAttribute("successMsg");
		%>
		<%
		if (bean != null) {
		%>
		<h1>Update User</h1>
		<%
		} else {
		%>
		<h1>Add User</h1>
		<%
		}
		%>

		<h2 style="color: green"><%=smsg != null ? smsg : ""%></h2>

		<form action="UserCtl" method="post">

			<table>
				<input type="hidden" name="id"
					value="<%=bean != null ? bean.getId() : ""%>">
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName"
						value="<%=bean != null ? bean.getFirstName() : ""%>"
						placeholder="enter firstName"></td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lastName"
						value="<%=bean != null ? bean.getLastName() : ""%>"
						placeholder="enter lastName"></td>
				</tr>
				<tr>
					<th>Login:</th>
					<td><input type="email" name="login"
						value="<%=bean != null ? bean.getLogin() : ""%>"
						placeholder="enter your login"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="password" name="password"
						value="<%=bean != null ? bean.getPassword() : ""%>"
						placeholder="enter your password"></td>
				</tr>
				<tr>
					<th>Dob:</th>
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