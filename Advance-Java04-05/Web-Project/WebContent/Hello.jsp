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
	for (int i = 1; i <= 10; i++) {
	%>
	<h1><%=i + " "%>Hello World
	</h1>
	<%
	}
	%>

	<%-- (<% %> ---> script let tag use to write java code in jsp) --%>
	<%-- (<%= %> ---> expression tag use to print java variable or value) --%>

</body>
</html>