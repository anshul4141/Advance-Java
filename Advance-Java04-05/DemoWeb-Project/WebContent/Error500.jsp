<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	text-align: center;
	padding-top: 100px;
}

.container {
	background: #fff;
	padding: 40px;
	margin: auto;
	width: 420px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

h1 {
	font-size: 60px;
	color: #e67e22;
}

p {
	font-size: 18px;
	color: #555;
}

.error-details {
	margin-top: 15px;
	font-size: 14px;
	color: #999;
}

a {
	text-decoration: none;
	color: #3498db;
	font-weight: bold;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>

<body>
	<div class="container">
		<h1>500</h1>
		<p>Oops! Something went wrong.</p>
		<p>Internal Server Error occurred.</p>

		<!-- Optional: Show exception message -->
		<div class="error-details">
			<%=exception != null ? exception.getMessage() : "Please try again later."%>
		</div>

		<br> <a href="index.jsp">Go Back to Home</a>
	</div>
</body>
</html>