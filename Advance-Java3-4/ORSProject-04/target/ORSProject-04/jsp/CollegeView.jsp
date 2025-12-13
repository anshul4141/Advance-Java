<%@page import="in.co.rays.proj4.controller.ORSView"%>
<%@page import="in.co.rays.proj4.controller.CollegeCtl"%>
<%@page import="in.co.rays.proj4.util.DataUtility"%>
<%@page import="in.co.rays.proj4.util.ServletUtility"%>

<html>
<head>
    <title>Add College</title>
    <link rel="icon" type="image/png" href="<%=ORSView.APP_CONTEXT%>/img/logo.png" sizes="16x16" />
</head>
<body>
    <form action="<%=ORSView.COLLEGE_CTL%>" method="POST">
        <%@ include file="Header.jsp" %>

        <jsp:useBean id="bean" class="in.co.rays.proj4.bean.CollegeBean" scope="request"></jsp:useBean>

        <div align="center">
            <h1 align="center" style="margin-bottom: -15; color: navy">
                <%
                    if (bean != null && bean.getId() > 0) {
                %>Update<%
                    } else {
                %>Add<%
                    }
                %>
                College
            </h1>

            <div style="height: 15px; margin-bottom: 12px">
                <h3 align="center">
                    <font color="green">
                        <%=ServletUtility.getSuccessMessage(request)%>
                    </font>
                </h3>
                <h3 align="center">
                    <font color="red">
                        <%=ServletUtility.getErrorMessage(request)%>
                    </font>
                </h3>
            </div>

            <input type="hidden" name="id" value="<%=bean.getId()%>">
            <input type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
            <input type="hidden" name="modifiedBy" value="<%=bean.getModifiedBy()%>">
            <input type="hidden" name="createdDatetime" value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
            <input type="hidden" name="modifiedDatetime" value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">

            <table>
                <tr>
                    <th align="left">Name<span style="color: red">*</span></th>
                    <td><input type="text" name="name" placeholder="Enter College Name" value="<%=DataUtility.getStringData(bean.getName())%>"></td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%=ServletUtility.getErrorMessage("name", request)%>
                        </font>
                    </td>
                </tr>

                <tr>
                    <th align="left">Address<span style="color: red">*</span></th>
                    <td><input type="text" name="address" placeholder="Enter Address" value="<%=DataUtility.getStringData(bean.getAddress())%>"></td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%=ServletUtility.getErrorMessage("address", request)%>
                        </font>
                    </td>
                </tr>

                <tr>
                    <th align="left">State<span style="color: red">*</span></th>
                    <td><input type="text" name="state" placeholder="Enter State" value="<%=DataUtility.getStringData(bean.getState())%>"></td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%=ServletUtility.getErrorMessage("state", request)%>
                        </font>
                    </td>
                </tr>

                <tr>
                    <th align="left">City<span style="color: red">*</span></th>
                    <td><input type="text" name="city" placeholder="Enter City" value="<%=DataUtility.getStringData(bean.getCity())%>"></td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%=ServletUtility.getErrorMessage("city", request)%>
                        </font>
                    </td>
                </tr>

                <tr>
                    <th align="left">Phone No<span style="color: red">*</span></th>
                    <td><input type="text" name="phoneNo" maxlength="10" placeholder="Enter Phone No." value="<%=DataUtility.getStringData(bean.getPhoneNo())%>"></td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%=ServletUtility.getErrorMessage("phoneNo", request)%>
                        </font>
                    </td>
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
                    <td align="left" colspan="2">
                        <input type="submit" name="operation" value="<%=CollegeCtl.OP_UPDATE%>">
                        <input type="submit" name="operation" value="<%=CollegeCtl.OP_CANCEL%>">
                    <%
                        } else {
                    %>
                    <td align="left" colspan="2">
                        <input type="submit" name="operation" value="<%=CollegeCtl.OP_SAVE%>">
                        <input type="submit" name="operation" value="<%=CollegeCtl.OP_RESET%>">
                    <%
                        }
                    %>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>