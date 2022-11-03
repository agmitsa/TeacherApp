<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course</title>
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
            <a class="nav-link" href="${pageContext.request.contextPath}/jsps/coursesmenu.jsp">Courses menu</a>
          </li>

        </ul>
      </div>
     </div>
    </nav>
	<div class="col-md-7 mx-auto mt-5 mb-5">
		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th><th>First Name</th><th>Last Name</th><th>Delete</th><th>Update</th>					
					</tr>
				</thead>
				<tbody>
						<tr>					
							<th scope="row">${student.id}</th>
							<td>${student.firstname}</td>
							<td>${student.lastname}</td>
							<td><a href="${pageContext.request.contextPath}/studentdelete?id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}&jspname=/jsps/student.jsp">Delete</a></td>
							<td><a href="${pageContext.request.contextPath}/studentupdate?id=${student.id}&firstname=${student.firstname}&lastname=${student.lastname}">Update</a></td>
	
						</tr>
				</tbody>
	
			</table>
		</div>
		<c:if test="${deleteStudentError}">
			<p class="text-center text-danger">Error in delete</p>
		</c:if>	
		<h2 class="mt-4 text-center">Student's courses</h2>
		<div class="table-responsive col-md-10 mx-auto">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>	
						<th>Description</th>
						<th>Teacher id</th>	
						<th>Delete</th>					
										
					</tr>
				</thead>
				<tbody>
	
					<c:forEach var = "course" items="${courses}">
						<tr>
						
							<td>${course.id}</td>
							<td>${course.description}</td>
							<td>${course.teacherid}</td>
							<td><a href="${pageContext.request.contextPath}/studentcoursedelete?courseid=${course.id}&studentid=${student.id}&returnurl=/jsps/student.jsp">Delete</a></td>					
						</tr>
					</c:forEach>
				</tbody>
	
			</table>
		</div>
		<c:if test="${coursenotfound}">
			<p class="text-center text-warning">No courses found</p>
		</c:if>
		<c:if test="${studentcoursedeleted}">
			<p class="text-center text-success">Entry deleted!</p>
		</c:if>	
		<c:if test="${deleteStudentCourseError}">
			<p class="text-center text-danger">Error in delete</p>
		</c:if>				
		<div class="addcourse mt-5">
		
			<h4 class="mb-0 p-2">Enroll to a course:</h4>
			
			<form class="form-inline mb-0" method="POST" action="${pageContext.request.contextPath}/insertstudentcourse">
				<input type="hidden" name="studentid" id="studentid" value="${student.id}">
				<input type="hidden" name="jspname" id="jspname" value="/jsps/student.jsp">
				
				<div class="form-group d-inline-flex p-3 mb-2">
					<select class="custom-select w-30" name="courseid" id="courseid">
					    <option value="0" selected disabled required>Select a course</option>		
					    <c:forEach items="${allcourses}" var="course">
					        <c:if test="${course != selected}">
					            <option value="${course.id}" required>${course.description}</option>
					        </c:if>
					    </c:forEach>
					</select>				
				</div>
		  		<input type="submit" id="add-btn" class="btn btn-success col-md-1 mb-2" value="Add">
			</form>
			<c:if test="${insertAPIerror}">
					<div class="alert alert-danger alert-dismissible fade show w-50 mt-2" role="alert">
					  <strong>Error in insert</strong>
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
					    <span aria-hidden="true">&times;</span>
					  </button>
					</div>				
		
			</c:if>	


			<c:if test="${studentenrolled}">
				<div class="alert alert-success alert-dismissible fade show w-50 mt-2" role="alert">
				  <strong>Student enrolled successfully!</strong>
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>				
		
			</c:if>					

			<c:if test="${studentalreadyenrolled}">
				<div class="alert alert-danger alert-dismissible fade show w-50 mt-2" role="alert">
				  <strong>Student is already enrolled.</strong>
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>				
		
			</c:if>	


			<button type="button" class="btn btn-outline-secondary mt-2">
				<i class="fa fa-chevron-left"></i> 
				<a href="${pageContext.request.contextPath}/jsps/studentsmenu.jsp" style="text-decoration: none; color:black;">Επιστροφή</a>
			</button>	
		</div>
	</div>
	<nav class="navbar navbar-dark" style="background-color: #545e66;">
	  <a class="navbar-brand">Copyright&#169; Teacher App 2022 by Aggeliki</a>
	</nav>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		
</body>
</html>