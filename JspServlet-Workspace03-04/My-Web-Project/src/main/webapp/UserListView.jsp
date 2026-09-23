<%@page import="java.util.Iterator"%>
<%@page import="com.rays.bean.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<%
	List<UserBean> list = (List<UserBean>) request.getAttribute("list");
	int pageNo = (int) request.getAttribute("pageNo");
	int pageSize = (int) request.getAttribute("pageSize");
	Iterator<UserBean> it = list.iterator();
	int index = (pageNo - 1) * pageSize + 1;
	String errorMsg = (String) request.getAttribute("errorMsg");
	String succMsg = (String) request.getAttribute("succMsg");
	%>
	<div align="center">
		<h1>User List</h1>

		<h2 style="color: red"><%=errorMsg != null ? errorMsg : ""%></h2>
		<h2 style="color: green"><%=succMsg != null ? succMsg : ""%></h2>

		<form action="UserListCtl" method="post">

			<input type="hidden" name="pageNo" value="<%=pageNo%>">

			<table border="1px" width="100%">

				<tr style="background-color: skyblue">
					<th>Delete</th>
					<th>S No.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>DOB</th>
				</tr>

				<%
				while (it.hasNext()) {
					UserBean bean = it.next();
				%>
				<tr align="center" style="background-color: lightgrey">
					<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
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

			<table width="100%">
				<tr>
					<td><input type="submit" name="operation" value="previous"
						<%=pageNo == 1 ? "disabled" : ""%>></td>
					<td align="center"><input type="submit" name="operation"
						value="delete"></td>
					<td align="right"><input type="submit" name="operation"
						value="next" <%=list.size() < 5 ? "disabled" : ""%>></td>
				</tr>
			</table>

		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>