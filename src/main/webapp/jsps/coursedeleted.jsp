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

<title>Successful Deletion</title>
</head>
<body>

	<div class="alert alert-success mt-5 mx-auto w-50" role="alert">
		<h4 class="alert-heading">Course deleted!</h4>
		<p>Course with course id ${course.id}, course description ${course.description} and teacher id ${course.teacherid} deleted successfully.</p>
		<hr>
		<button type="button" class="btn btn-outline-secondary">
			<i class="fa fa-chevron-left"></i> 
			<a href="${pageContext.request.contextPath}/jsps/coursesmenu.jsp" style="text-decoration: none; color:black;">Επιστροφή</a>
		</button>
	</div>


</body>
</html>