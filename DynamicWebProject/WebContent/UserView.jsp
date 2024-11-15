<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<%
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>

	<center>
		<form action="UserCtl" method="post">

			<br> <br> <br>

			<%
				String msg = (String) request.getAttribute("msg");
			%>

			<%
				if (msg != null) {
			%>
			<span><%=msg%></span>
			<%
				}
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



			<table>

				<td><input type="hidden" name="id"
					value="<%=bean != null ? bean.getId() : ""%>"></td>

				<tr>
					<th>FirstName:</th>
					<td><input type="text" name="firstName"
						value="<%=bean != null ? bean.getFirstName() : ""%>"
						placeholder="Enter First Name"></td>
				</tr>
				<tr>
					<th>LastName:</th>
					<td><input type="text" name="lastName"
						value="<%=bean != null ? bean.getLastName() : ""%>"
						placeholder="Enter Last Name"></td>
				</tr>
				<tr>
					<th>LoginId:</th>
					<td><input type="email" name="loginId"
						value="<%=bean != null ? bean.getLoginId() : ""%>"
						placeholder="Enter your LoginId"></td>
				</tr>
				<tr>
					<th>password:</th>
					<td><input type="password" name="password"
						value="<%=bean != null ? bean.getPassword() : ""%>"
						placeholder="Enter your Password"></td>
				</tr>
				<tr>
					<th>Address:</th>
					<td><input type="text" name="address"
						value="<%=bean != null ? bean.getAddress() : ""%>"
						placeholder="Enter your Address"></td>
				</tr>
				<tr>
					<th>DOB:</th>
					<td><input type="date" name="dob"
						value="<%=bean != null ? bean.getDob() : ""%>"
						placeholder="Enter your dob"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=bean != null ? "update" : "save"%>"></td>
				</tr>

			</table>
		</form>
	</center>
	<%@ include file="Footer.jsp"%>
</body>
</html>