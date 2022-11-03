<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Successfully deletion</title>
</head>
<body>

	<div class="alert alert-success w-50 mx-auto mt-5" role="alert">
		<h4 class="alert-heading">Student deleted!</h4>
		<p>Student ${student.id} ${student.firstname}  ${student.lastname} was deleted.</p>
		<hr>
		<button type="button" class="btn btn-outline-secondary">
			<i class="fa fa-chevron-left"></i> 
			<a href="${pageContext.request.contextPath}/jsps/studentsmenu.jsp" style="text-decoration: none; color:black;">Επιστροφή</a>
		</button>
	</div>


</body>
</html>