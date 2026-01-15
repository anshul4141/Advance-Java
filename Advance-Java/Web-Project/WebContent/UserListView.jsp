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

	<%
	List list = (List) request.getAttribute("list");
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">
		<h1>User List</h1>

		<form action="UserListCtl.do" method="post">

			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName"
						placeholder="search by firstName">
					<th>last Name</th>
					<td><input type="text" name="lastName"
						placeholder="search by lastName"> <input type="submit"
						name="operation" value="search"></td>
				</tr>
			</table>

			<table width="100%" border="1px">
				<tr style="background: skyblue">
					<th>Delete</th>
					<th>Id</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Login</th>
					<th>DOB</th>
					<th>Edit</th>
				</tr>

				<%
				Iterator<UserBean> it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = it.next();
				%>
				<tr align="center" style="background: lightgrey">
					<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getDob()%></td>
					<td><a href="UserCtl.do?id=<%=bean.getId()%>">Edit</a></td>
				</tr>
				<%
				}
				%>
			</table>
			<table width="100%">
				<tr>
					<th></th>
					<td align="center"><input type="submit" name="operation"
						value="delete"></td>
				</tr>
			</table>
		</form>

	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>