<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.controller.UserCtl"%>
<%@page import="in.co.rays.proj4.bean.FacultyBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="in.co.rays.proj4.controller.FacultyCtl"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<html>
<head>
<title>Add Faculty</title>
<link rel="icon" type="image/png"
	href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16x16" />
</head>
<body>
	<form action="<%=ORSView.FACULTY_CTL%>" method="post">
		<%@ include file="Header.jsp"%>

		<jsp:useBean id="bean" class="in.co.rays.proj4.bean.FacultyBean"
			scope="request"></jsp:useBean>

		<%
			List<FacultyBean> collegeList = (List<FacultyBean>) request.getAttribute("collegeList");
			List<FacultyBean> courseList = (List<FacultyBean>) request.getAttribute("courseList");
			List<FacultyBean> subjectList = (List<FacultyBean>) request.getAttribute("subjectList");
		%>

		<div align="center">
			<h1 align="center" style="margin-bottom: -15; color: navy">
				<%
					if (bean != null && bean.getId() > 0) {
				%>Update<%
					} else {
				%>Add<%
					}
				%>
				Faculty
			</h1>

			<div style="height: 15px; margin-bottom: 12px">
				<H3 align="center">
					<font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
					</font>
				</H3>
				<H3 align="center">
					<font color="red"> <%=ServletUtility.getErrorMessage(request)%>
					</font>
				</H3>
			</div>
			<input type="hidden" name="id" value="<%=bean.getId()%>"> <input
				type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="modifiedBy"
				value="<%=bean.getModifiedBy()%>"> <input type="hidden"
				name="createdDatetime"
				value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
			<input type="hidden" name="modifiedDatetime"
				value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

			<table>
				<tr>
					<th align="left">First Name<span style="color: red">*</span></th>
					<td><input type="text" name="firstName"
						placeholder="Enter First Name"
						value="<%=DataUtility.getStringData(bean.getFirstName())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Last Name<span style="color: red">*</span></th>
					<td><input type="text" name="lastName"
						placeholder="Enter Last Name"
						value="<%=DataUtility.getStringData(bean.getLastName())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Email Id<span style="color: red">*</span></th>
					<td><input type="text" name="email"
						placeholder="Enter Email ID"
						value="<%=DataUtility.getStringData(bean.getEmail())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("email", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Date of Birth<span style="color: red">*</span></th>
					<td><input type="text" id="udate" name="dob" placeholder="Select Date of Birth"
						value="<%=DataUtility.getDateString(bean.getDob())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("dob", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Gender<span style="color: red">*</span></th>
					<td>
						<%
							HashMap<String, String> map = new HashMap<String, String>();

							map.put("Male", "Male");
							map.put("Female", "Female");

							String htmlList = HTMLUtility.getList("gender", bean.getGender(), map);
						%> <%=htmlList%>
					</td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("gender", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Mobile No<span style="color: red">*</span></th>
					<td><input type="text" name="mobileNo" maxlength="10"
						placeholder="Enter Mobile No."
						value="<%=DataUtility.getStringData(bean.getMobileNo())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></td>
				</tr>
				<tr>
					<th align="left">College<span style="color: red">*</span></th>
					<td><%=HTMLUtility.getList("collegeId", String.valueOf(bean.getCollegeId()), collegeList)%></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("collegeId", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Course<span style="color: red">*</span></th>
					<td><%=HTMLUtility.getList("courseId", String.valueOf(bean.getCourseId()), courseList)%></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("courseId", request)%></font></td>
				</tr>
				<tr>
					<th align="left">Subject<span style="color: red">*</span></th>
					<td><%=HTMLUtility.getList("subjectId", String.valueOf(bean.getSubjectId()), subjectList)%></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("subjectId", request)%></font></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<%
						if (bean != null && bean.getId() > 0) {
					%>
					<td align="left" colspan="2"><input type="submit"
						name="operation" value="<%=FacultyCtl.OP_UPDATE%>"> <input
						type="submit" name="operation" value="<%=FacultyCtl.OP_CANCEL%>">
						<%
							} else {
						%>
					<td align="left" colspan="2"><input type="submit"
						name="operation" value="<%=FacultyCtl.OP_SAVE%>"> <input
						type="submit" name="operation" value="<%=FacultyCtl.OP_RESET%>">
						<%
							}
						%>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>