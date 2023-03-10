<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Page</h2>
	<form action="LoginDBServlet" method="get">
		<label>User</label> 
		<input type="text" name="user"> </br>
		
		<label>Password</label>
		<input type="password" name="pass"> </br>
		<input type="submit" value="SignIn"> 
		<input type="reset" name="reset">
	</form>
	
		
</body>
</html>