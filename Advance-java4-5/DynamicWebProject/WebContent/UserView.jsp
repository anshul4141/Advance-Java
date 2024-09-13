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
			String smsg = (String) request.getAttribute("smsg");
			UserBean bean = (UserBean) request.getAttribute("bean");
		%>

		<table align="center">

			<%
				if (smsg != null) {
			%>
			<h3 style="color: green" align="center"><%=smsg%></h3>
			<%
				}
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



			<tr>
				<td><input type="hidden" name="id"
					value="<%=bean != null ? bean.getId() : ""%>"></td>
			</tr>

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
				<th>Email:</th>
				<td><input type="email" name="loginId"
					value="<%=bean != null ? bean.getLoginId() : ""%>"
					placeholder="Enter your Email"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="password"
					value="<%=bean != null ? bean.getPassword() : ""%>"
					placeholder="Enter your Password"></td>
			</tr>
			<tr>
				<th>DOB:</th>
				<td><input type="date" name="dob"
					value="<%=bean != null ? bean.getDob() : ""%>"
					placeholder="Enter your Dob"></td>
			</tr>
			<tr>
				<th>Phone:</th>
				<td><input type="number" name="phoneNo"
					value="<%=bean != null ? bean.getPhoneNo() : ""%>"
					placeholder="Enter Your phoneNo"></td>
			</tr>
			<tr>
				<th>Address:</th>
				<td><input type="text" name="address"
					value="<%=bean != null ? bean.getAddress() : ""%>"
					placeholder="Enter Your address"></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><input type="text" name="gender"
					value="<%=bean != null ? bean.getGender() : ""%>"
					placeholder="Enter Your gender"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=bean != null ? "update" : "add"%>"></td>
			</tr>
		</table>
	</form>

</body>
</html>