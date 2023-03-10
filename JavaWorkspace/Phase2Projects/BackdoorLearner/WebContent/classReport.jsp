<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Search class info</h1>
<form action="ClassController" method="get">
<label>Class Name</label>
<input type="text" name="name">
<input type="submit" value="search">
<br>
<a href="index.jsp">back to dashboard</a> 
</body>
</html>