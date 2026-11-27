<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">

		<form>

			First Name <input type="text" name="firstName" value=""
				placeholder="enter you first name">
				<br>
				<br>
			Last Name <input type="text" name="lastName" value=""
				placeholder="enter you last name">
				<br>
				<br>
			Login <input type="email" name="login" value=""
				placeholder="enter you email">
			    <br>
				<br>
			Password <input type="password" name="password" value=""
				placeholder="enter you password">
			    <br>
				<br>
			DOB <input type="date" name="dob" value="">
			    <br>
				<br>
			Gender <select name="gender">
			           <option value="">-----select-----</option>
			           <option value="Male">Male</option>
			           <option value="Female">Female</option>
			           <option value="Other">Other</option>
			       </select>
			    <br>
				<br>
			<input type="submit" name="operation" value="save">
			       
		</form>

	</div>

</body>
</html>