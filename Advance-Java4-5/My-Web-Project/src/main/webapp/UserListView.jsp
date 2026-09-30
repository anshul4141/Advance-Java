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
	List<UserBean> list = (List<UserBean>) request.getAttribute("list");
	int pageNo = (int) request.getAttribute("pageNo");
	int pageSize = (int) request.getAttribute("pageSize");
	int index = (pageNo - 1) * pageSize + 1;
	Iterator<UserBean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>

	<div align="center">

		<h1>User List</h1>

		<form>

			<table border="1px" width="100%">
				<tr>
					<th>S No.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>Dob</th>
				</tr>

				<%
				while (it.hasNext()) {
					UserBean bean = it.next();
				%>
				<tr>
					<td><%=index++%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLoginId()%></td>
					<td><%=bean.getDob()%></td>
				</tr>
				<%
				}
				%>

			</table>

		</form>

	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>