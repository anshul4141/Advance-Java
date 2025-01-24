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
	<h1 align="center">User List</h1>
	<form action="UserListCtl.do" method="post">

		<%
			List list = (List) request.getAttribute("list");
			int pageNo = (int) request.getAttribute("pageNo");
			int pageSize = (int) request.getAttribute("pageSize");
		%>

		<table>
			<tr>
				<th>First Name</th>
				<td><input type="text" name="firstName"
					placeholder="search by firstName"></td>
				<th>Last Name</th>
				<td><input type="text" name="lastName"
					placeholder="search by lastName"></td>
				<td>&nbsp;<input type="submit" name="operation" value="search"></td>
			</tr>
		</table>
		<br>
		<table algin="center" width="100%" border="1px">
			<tr style="background-color: orange">
				<th>Select</th>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>LoginId</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>
			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
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
		</table>
		<br>
		<table width="100%">
			<tr>
				<td><input type="submit" name="operation" value="previous"
					<%=pageNo == 1 ? "disabled" : ""%>></td>
				<td><input type="submit" name="operation" value="delete"></td>
				<td align="right"><input type="submit" name="operation"
					value="next"></td>
			</tr>
		</table>
		<input type="text" name="pageNo" value="<%=pageNo%>"> <input
			type="text" name="pageSize" value="<%=pageSize%>">
	</form>
</body>
</html>