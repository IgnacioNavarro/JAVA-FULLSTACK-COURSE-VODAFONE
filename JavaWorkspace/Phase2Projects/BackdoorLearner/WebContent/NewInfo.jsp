<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Create teacher</h2>
<form action="TeacherController" method="post">
<label>Name</label>
<input type="text" name ="tname"><br/>


<input type="submit" value="Save teacher">
</form>


<h2>Create Subject for a teacher</h2>
<form action="SubjectController" method="post">
<label>Name</label>
<input type="text" name ="subname"><br/>
<label>Teacher id</label>
<input type="number" name ="ssid"><br/>


<input type="submit" value="Save class">
</form>


<h2>Create class</h2>
<form action="ClassController" method="post">
<label>Name</label>
<input type="text" name ="cname"><br/>


<input type="submit" value="Save class">
</form>

<h2>Add subject to class</h2>
<form action="JoinSubject" method="post">
<label>Class name</label>
<input type="text" name ="classname"><br/>
<label>Subject name</label>
<input type="text" name ="subjectname"><br/>


<input type="submit" value="Save class">
</form>

<h2>Create Student</h2>
<form action="StudentController" method="post">
<label>Name</label>
<input type="text" name ="sname"><br/>
<label>Surname</label>
<input type="text" name ="surname"><br/>
<label>Class id</label>
<input type="number" name ="cid"><br/>


<input type="submit" value="Save student">
</form>

<a href="index.jsp">back to dashboard</a> 

</body>
</html>