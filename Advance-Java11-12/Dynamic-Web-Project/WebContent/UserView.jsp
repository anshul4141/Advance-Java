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
	<form action="UserCtl.do" method="post">

		<%
			String msg = (String) request.getAttribute("msg");
			UserBean bean = (UserBean) request.getAttribute("bean");
		%>

		<%
			if (bean != null) {
		%>
		<h1 align="center">Update User</h1>
		<%
			} else {
		%>
		<h1 align="center">Add User</h1>
		<%
			}
		%>

		<%
			if (msg != null) {
		%>
		<h1 align="center"><%=msg%></h1>
		<%
			}
		%>
		<table align="center">
			<input type="hidden" name="id"
				value="<%=bean != null ? bean.getId() : ""%>">
			<tr>
				<th>First Name</th>
				<td><input type="text" name="firstName"
					value="<%=bean != null ? bean.getFirstName() : ""%>"
					placeholder="Enter First Name"></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" name="lastName"
					value="<%=bean != null ? bean.getLastName() : ""%>"
					placeholder="Enter Last Name"></td>
			</tr>
			<tr>
				<th>LoginId</th>
				<td><input type="email" name="loginId"
					value="<%=bean != null ? bean.getLoginId() : ""%>"
					placeholder="Enter Your email"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password"
					value="<%=bean != null ? bean.getPassword() : ""%>"
					placeholder="Enter Your Password"></td>
			</tr>
			<tr>
				<th>DOB</th>
				<td><input type="date" name="dob"
					value="<%=bean != null ? bean.getDob() : ""%>"
					placeholder="Enter Your Dob"></td>
			</tr>
			<tr>
				<th>Address</th>
				<td><input type="text" name="address"
					value="<%=bean != null ? bean.getAddress() : ""%>"
					placeholder="Enter Your address"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=bean != null ? "update" : "save"%>"></td>
			</tr>
		</table>
	</form>
</body>
</html>