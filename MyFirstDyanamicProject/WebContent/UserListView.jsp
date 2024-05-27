<%@page import="com.rays.bean.UserBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
	<form action="UserListCtl" method="post">
		<h2 style="color: darkblue" align="center">User List</h2>
		<%
			List userList = (List) request.getAttribute("userList");
			String msg = (String) request.getAttribute("msg");
		%>

		<%
			if (msg != null) {
		%>
		<%=msg%>
		<%
			}
		%>
		<center>
			<table>
				<tr>
					<lable>FristName :</lable>
					<input type="text" name="firstName" placeholder="Enter First Name">

				</tr>
				&nbsp;
				<tr>
					<input type="submit" name="operation" value="search">
				</tr>
			</table>
		</center>
		<table border="1px" cellpadding="10px"
			style="border-collapse: collapse;" width="100%">

			<br>
			<tr bgcolor="skyblue">
				<th>select</th>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>LoginId</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>
			<%
				Iterator<UserBean> it = userList.iterator();
				while (it.hasNext()) {

					UserBean bean = it.next();
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getAddress()%></td>
				<td><a href="UserCtl.do?id=<%=bean.getId()%>">Edit</a></td>
			</tr>
			<%
				}
			%>
			</tr>
		</table>
		<br>
		<table>
			<tr>
				<input type="submit" name="operation" value="delete">
			</tr>
		</table>

	</form>

</body>
</html>