<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.controller.FacultyListCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.bean.FacultyBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<html>
<head>
<title>Faculty List</title>
<link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16x16" />
</head>
<body>
	<%@include file="Header.jsp"%>
	<div align="center">
		<h1 align="center" style="margin-bottom: -15; color: navy;">Faculty List</h1>

		<div style="height: 15px; margin-bottom: 12px">
			<h3>
				<font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
			</h3>
			<h3>
				<font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
			</h3>
		</div>

		<form action="<%=ORSView.FACULTY_LIST_CTL%>" method="post">
			<%
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;
				int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());

				List<FacultyBean> list = (List<FacultyBean>) ServletUtility.getList(request);
				Iterator<FacultyBean> it = list.iterator();

				if (list.size() != 0) {
			%>

			<input type="hidden" name="pageNo" value="<%=pageNo%>">
			<input type="hidden" name="pageSize" value="<%=pageSize%>">

			<table style="width: 100%">
				<tr>
					<td align="center">
						<label><b>First Name :</b></label>
						<input type="text" name="firstName" placeholder="Enter First Name" value="<%=ServletUtility.getParameter("firstName", request)%>">&emsp;
						<label><b>Last Name :</b></label>
						<input type="text" name="lastName" placeholder="Enter Last Name" value="<%=ServletUtility.getParameter("lastName", request)%>">&emsp;
						<label><b>Email Id :</b></label>
						<input type="text" name="email" placeholder="Enter Email Id" value="<%=ServletUtility.getParameter("email", request)%>">&emsp;
						<input type="submit" name="operation" value="<%=FacultyListCtl.OP_SEARCH%>">&nbsp;
						<input type="submit" name="operation" value="<%=FacultyListCtl.OP_RESET%>">
					</td>
				</tr>
			</table>
			<br>

			<table border="1" style="width: 100%; border: groove;">
				<tr style="background-color: #e1e6f1e3;">
					<th><input type="checkbox" id="selectall" /></th>
					<th>S.No</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email Id</th>
					<th>College Name</th>
					<th>Course Name</th>
					<th>Subject Name</th>
					<th>Gender</th>
					<th>Mobile No</th>
					<th>Date of Birth</th>
					<th>Edit</th>
				</tr>

				<%
					while (it.hasNext()) {
						FacultyBean bean = it.next();
				%>
				<tr>
					<td style="text-align: center;"><input type="checkbox" class="case" name="ids" value="<%=bean.getId()%>"></td>
					<td style="text-align: center;"><%=index++%></td>
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getFirstName()%></td>
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getLastName()%></td>
					<td style="text-align: center; text-transform: lowercase;"><%=bean.getEmail()%></td>
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getCollegeName()%></td>
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getCourseName()%></td>
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getSubjectName()%></td>
					<td style="text-align: center; text-transform: capitalize;"><%=bean.getGender()%></td>
					<td style="text-align: center;"><%=bean.getMobileNo()%></td>
					<%
						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
						String date = sdf.format(bean.getDob());
					%>
					<td style="text-align: center;"><%=date%></td>
					<td style="text-align: center;"><a href="FacultyCtl?id=<%=bean.getId()%>">Edit</a></td>
				</tr>
				<%
					}
				%>
			</table>

			<table style="width: 100%">
				<tr>
					<td style="width: 25%"><input type="submit" name="operation" value="<%=FacultyListCtl.OP_PREVIOUS%>" <%=pageNo > 1 ? "" : "disabled"%>></td>
					<td align="center" style="width: 25%"><input type="submit" name="operation" value="<%=FacultyListCtl.OP_NEW%>"></td>
					<td align="center" style="width: 25%"><input type="submit" name="operation" value="<%=FacultyListCtl.OP_DELETE%>"></td>
					<td style="width: 25%" align="right"><input type="submit" name="operation" value="<%=FacultyListCtl.OP_NEXT%>" <%=nextPageSize != 0 ? "" : "disabled"%>></td>
				</tr>
			</table>

			<%
				}
				if (list.size() == 0) {
			%>
			<table>
				<tr>
					<td align="right"><input type="submit" name="operation" value="<%=FacultyListCtl.OP_BACK%>"></td>
				</tr>
			</table>
			<%
				}
			%>
		</form>
	</div>
</body>
</html>