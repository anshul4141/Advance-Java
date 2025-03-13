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
	<%
		List list = (List) request.getAttribute("list");
	%>
	<h1 align="center">User List</h1>
	<form action="UserListCtl" method="post">
		<table width="100%" border="1px">
			<tr style="background: skyblue">
				<th>id</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Login Id</th>
				<th>Gender</th>
				<th>Address</th>
				<th>DOB</th>
			</tr>

			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>
			<tr align="center">
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getGender()%></td>
				<td><%=bean.getAddress()%></td>
				<td><%=bean.getDob()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>

</body>
</html>