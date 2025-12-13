<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.util.HTMLUtility"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.controller.SubjectListCtl"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>
<%@page import="in.co.rays.proj4.bean.SubjectBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<html>
<head>
    <title>Subject List</title>
    <link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16x16" />
</head>
<body>
    <%@include file="Header.jsp"%>
    <div align="center">
        <h1 align="center" style="margin-bottom: -15; color: navy;">Subject List</h1>

        <div style="height: 15px; margin-bottom: 12px">
            <h3>
                <font color="red"><%=ServletUtility.getErrorMessage(request)%></font>
            </h3>
            <h3>
                <font color="green"><%=ServletUtility.getSuccessMessage(request)%></font>
            </h3>
        </div>

        <jsp:useBean id="bean" class="in.co.rays.proj4.bean.SubjectBean" scope="request"></jsp:useBean>
        <form action="<%=ORSView.SUBJECT_LIST_CTL%>" method="post">

            <%
                int pageNo = ServletUtility.getPageNo(request);
                int pageSize = ServletUtility.getPageSize(request);
                int index = ((pageNo - 1) * pageSize) + 1;
                int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());

                List<SubjectBean> courseList = (List<SubjectBean>) request.getAttribute("courseList");
                List<SubjectBean> subjectList = (List<SubjectBean>) request.getAttribute("subjectList");

                List<SubjectBean> list = (List<SubjectBean>) ServletUtility.getList(request);
                Iterator<SubjectBean> it = list.iterator();

                if (list.size() != 0) {
            %>

            <input type="hidden" name="pageNo" value="<%=pageNo%>">
            <input type="hidden" name="pageSize" value="<%=pageSize%>">

            <table style="width: 100%">
                <tr>
                    <td align="center">
                        <label><b>Subject Name :</b></label>
                        <%=HTMLUtility.getList("subjectId", String.valueOf(bean.getId()), subjectList)%>&emsp;
                        <label><b>Course Name :</b></label>
                        <%=HTMLUtility.getList("courseId", String.valueOf(bean.getCourseId()), courseList)%>&emsp;
                        <input type="submit" name="operation" value="<%=SubjectListCtl.OP_SEARCH%>">&nbsp;
                        <input type="submit" name="operation" value="<%=SubjectListCtl.OP_RESET%>">
                    </td>
                </tr>
            </table>
            <br>

            <table border="1" style="width: 100%; border: groove;">
                <tr style="background-color: #e1e6f1e3;">
                    <th width="5%"><input type="checkbox" id="selectall" /></th>
                    <th width="5%">S.No</th>
                    <th width="30%">Subject Name</th>
                    <th width="15%">Course Name</th>
                    <th width="40%">Description</th>
                    <th width="5%">Edit</th>
                </tr>

                <%
                    while (it.hasNext()) {
                        bean = it.next();
                %>
                <tr>
                    <td style="text-align: center;">
                        <input type="checkbox" class="case" name="ids" value="<%=bean.getId()%>">
                    </td>
                    <td style="text-align: center;"><%=index++%></td>
                    <td style="text-align: center; text-transform: capitalize;"><%=bean.getName()%></td>
                    <td style="text-align: center; text-transform: capitalize;"><%=bean.getCourseName()%></td>
                    <td style="text-align: center; text-transform: capitalize;"><%=bean.getDescription()%></td>
                    <td style="text-align: center;">
                        <a href="SubjectCtl?id=<%=bean.getId()%>">Edit</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>

            <table style="width: 100%">
                <tr>
                    <td style="width: 25%">
                        <input type="submit" name="operation" value="<%=SubjectListCtl.OP_PREVIOUS%>" <%=pageNo > 1 ? "" : "disabled"%>>
                    </td>
                    <td align="center" style="width: 25%">
                        <input type="submit" name="operation" value="<%=SubjectListCtl.OP_NEW%>">
                    </td>
                    <td align="center" style="width: 25%">
                        <input type="submit" name="operation" value="<%=SubjectListCtl.OP_DELETE%>">
                    </td>
                    <td style="width: 25%" align="right">
                        <input type="submit" name="operation" value="<%=SubjectListCtl.OP_NEXT%>" <%=nextPageSize != 0 ? "" : "disabled"%>>
                    </td>
                </tr>
            </table>

            <%
                }
                if (list.size() == 0) {
            %>
            <table>
                <tr>
                    <td align="right">
                        <input type="submit" name="operation" value="<%=SubjectListCtl.OP_BACK%>">
                    </td>
                </tr>
            </table>
            <%
                }
            %>
        </form>
    </div>
</body>
</html>