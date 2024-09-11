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

		<%
			List list = (List) request.getAttribute("list");
		%>

		<table border="1px" width="100%" align="center">
			<tr>
				<th>Id</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
				<th>DOB</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Gender</th>
			</tr>

			<%
				Iterator it = list.iterator();
			%>

			<%
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>
			<tr align="center">
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getPhoneNo()%></td>
				<td><%=bean.getAddress()%></td>
				<td><%=bean.getGender()%></td>
			</tr>
			<%
				}
			%>


		</table>
	</form>
</body>
</html>