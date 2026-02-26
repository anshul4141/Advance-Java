<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">

		<h1>Form View</h1>

		<form action="FormCtl" method="post">

			<table>
				<tr>
					<th>FirstName</th>
					<td><input type="text" value="" name="firstName" placeholder="enter firstName"></td>
				</tr>
				<tr>
					<th>LastName</th>
					<td><input type="text" value="" name="lastName" placeholder="enter lastName"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="save"></td>
				</tr>
			</table>

		</form>

	</div>
</body>
</html>