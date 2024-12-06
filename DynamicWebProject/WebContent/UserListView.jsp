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
	<br>
	<br>

	<%
		List list = (List) request.getAttribute("list");
		int pageNo = 1;
	%>

	<%
		if (request.getAttribute("pageNo") != null) {
	%>
	<%
		pageNo = (int) request.getAttribute("pageNo");
	%>
	<%
		}
	%>

	<form action="UserListCtl.do" method="post">

		<h1 align="center">User List</h1>

		<table>
			<th>First Name</th>
			<td><input type="text" name="firstName"
				placeholder="Enter First Name"></td> &nbsp;

			<th>Last Name</th>
			<td><input type="text" name="lastName"
				placeholder="Enter Last Name"></td> &nbsp;

			<th>DOB</th>
			<td><input type="date" name="dob"></td> &nbsp;

			<th></th>
			<td><input type="submit" name="operation" value="search">
				<input type="submit" name="operation" value="new"></td>
		</table>

		<br>

		<table height="100" width="100%" cellpadding=10 border=4
			style="border-collapse: collapse;" 1px">


			<tr align="center" style="background: skyblue">
				<th>Delete</th>
				<th>S.No</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>LoginId</th>
				<th>Address</th>
				<th>DOB</th>
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
				<td><%=bean.getAddress()%></td>
				<td><%=bean.getDob()%></td>
				<td><a href="UserCtl.do?id=<%=bean.getId()%>">Edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<table width="100%">
			<tr>
				<td align="left"><input type="submit" name="operation"
					value="previous" <%=(pageNo == 1) ? "disabled" : ""%>></td>
				<td><input type="submit" name="operation" value="delete"></td>
				<td align="right"><input type="submit" name="operation"
					value="next" <%=(list.size() == 0) ? "disabled" : ""%>></td>
			</tr>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>