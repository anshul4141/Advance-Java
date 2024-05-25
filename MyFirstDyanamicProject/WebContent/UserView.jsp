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
	<form action="UserCtl" method="post">
		<%
			String msg = (String) request.getAttribute("msg");
			UserBean bean = (UserBean) request.getAttribute("bean");
		%>
		<%
			if (bean != null) {
		%>
		<h2 style="color: darkblue" align="center">Update User</h2>
		<%
			} else {
		%>
		<h2 style="color: darkblue" align="center">Add User</h2>
		<%
			}
		%>

		<%
			if (msg != null) {
		%>
		<%=msg%>
		<%
			}
		%>

		<table align="center">
			<tr>
				<td><input type="hidden" name="id"
					value="<%=(bean != null) ? bean.getId() : ""%>"></td>

			</tr>
			<tr>

				<th>First Name</th>
				<td><input type="text" name="firstName"
					value="<%=(bean != null) ? bean.getFirstName() : ""%>"
					placeholder="Enter FName"></td>

			</tr>
			<tr>

				<th>Last Name</th>
				<td><input type="text" name="lastName"
					value="<%=(bean != null) ? bean.getLastName() : ""%>"
					placeholder="Enter LName"></td>

			</tr>
			<tr>

				<th>LoginId</th>
				<td><input type="text" name="email"
					value="<%=(bean != null) ? bean.getLoginId() : ""%>"
					placeholder="Enter Email"></td>

			</tr>
			<tr>

				<th>Password</th>
				<td><input type="password" name="password"
					value="<%=(bean != null) ? bean.getPassword() : ""%>"
					placeholder="Enter Password"></td>

			</tr>
			<tr>

				<th>DOB</th>
				<td><input type="date" name="dob"
					value="<%=(bean != null) ? bean.getDob() : ""%>"
					placeholder="Enter dob"></td>

			</tr>
			<tr>

				<th>Address</th>
				<td><input type="text" name="address"
					value="<%=(bean != null) ? bean.getAddress() : ""%>"
					placeholder="Enter address"></td>

			</tr>
			<tr>

				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(bean != null) ? "update" : "save"%>"></td>

			</tr>
		</table>
	</form>
</body>
</html>