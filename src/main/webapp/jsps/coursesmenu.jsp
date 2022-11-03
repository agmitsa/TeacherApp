<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page isELIgnored="false"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Courses Menu</title>
<style>
body {
	box-sizing: border-box;
	margin: 0;
	padding:0;
	background-color: #fdfdfd;
}

</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark"  style="background-color: #545e66;">
   	   <div class="container-fluid">
     	 <a class="navbar-brand" href="${pageContext.request.contextPath}/jsps/menu.jsp">
          Teacher App
        </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mb-2 mb-lg-0 ">
          <li class="nav-item">
            <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp">Teachers menu</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/jsps/studentsmenu.jsp">Students menu</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="${pageContext.request.contextPath}/jsps/coursesmenu.jsp">Courses menu</a>
          </li>

        </ul>
      </div>
     </div>
    </nav>
	<div class="center col-md-10 mx-auto mt-5">

		<div class="search-wrapper bg-white col-md-4 mx-auto mb-4 p-4 border border-secondary rounded">
		
			<h2 class="text-center mb-3">Search Course</h2>
			<form class="form-inline" method="GET" action="${pageContext.request.contextPath}/coursesearchbyteacher">
			  <div class="form-group d-inline-flex p-3 mx-sm-3 mb-2">
			    <input type="text" class="form-control" name="teacherid" id="teacherid" placeholder="Search by teacher's id" required>
			  </div>
			  <input type="submit" class="btn btn-secondary mb-2" value="Search">
			</form>		
				
			<form class="form-inline" method="GET" action="${pageContext.request.contextPath}/coursesearchbyid">
			  <div class="form-group d-inline-flex p-3 mx-sm-3 mb-2">
			    <input type="text" class="form-control" name="courseid" id="courseid" placeholder="Search by course id" required>   
			  </div>
			  <input type="submit" class="btn btn-secondary mb-2" value="Search">
			</form>				
			<div class="center text-danger">
				<c:if test="${teacherNotFound}">
					<p>Teacher not found!</p>
				</c:if>
			</div>
			<div class="center text-danger">
				<c:if test="${courseNotFound}">
					<p>Course not found</p>
				</c:if>
			</div>						
		</div>
		<div class="insert-wrapper bg-white col-md-6 mx-auto p-5 pt-4 border border-secondary rounded">
			<h2 class="text-center">Add new course</h2>	
			<form method="POST" action="${pageContext.request.contextPath}/courseinsert">
			  <div class="row">
			
			    <div class="form-group col p-2">
			      <label for="description">Course Description</label><br/>    
			      <input type="text" class="form-control" name="description" id="description" required>
			    </div>
			    <div class="form-group col p-2">
			      <label for="teacherid">Teacher id</label>			    
			      <input type="text" class="form-control"  name="teacherid" id="teacherid" required>
			    </div>
			  </div>
			  
			  <button type="submit" class="btn btn-success col-md-3 float-right">Add</button>
			</form>
			<div class="center">
				<c:if test="${sqlError}">
					<p>Error in insert</p>
				</c:if>
			</div>
			<div class="center text-danger">
				<c:if test="${teacherAlreadyTeach}">
					<p>Teacher already teach the course!</p>
				</c:if>
			</div>
			<div class="center text-danger">
				<c:if test="${courseAlreadyExist}">
					<p>Course already exist!</p>
				</c:if>
			</div>
			<div class="center text-danger">
				<c:if test="${teachernotfound}">
					<p>Teacher not found!</p>
				</c:if>
			</div>

		</div>	
		<c:if test="${insertedCourse}">
			<div class="alert alert-success alert-dismissible fade show w-50 mt-2 mx-auto" role="alert">
			  <strong>Course inserted successfully!</strong>
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>				
	
		</c:if>		
	</div>

	<nav class="navbar mt-5 navbar-dark" style="background-color: #545e66;">
	  <a class="navbar-brand">Copyright&#169; Teacher App 2022 by Aggeliki</a>
	</nav>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>