<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<style>
body {
	box-sizing: border-box;
	margin: 0;
	padding:0;
	background-color: #fdfdfd;
}

</style>
<meta charset="UTF-8">
<title>Student Update</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #545e66;">
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
  
	<div class="col-md-6 mt-5 mx-auto">
		<div class="update-wrapper bg-white p-5 pt-4 border border-secondary rounded">
			<h2 class="text-center">Update student</h2>	
			<form method="POST" action="${pageContext.request.contextPath}/studentupdate">
			  <div class="row">
				<input  type="hidden" name="id" id="id" value="${student.id}" required autofocus/>
			    <div class="form-group col p-2">
			      <input type="text" class="form-control" name="firstname" id="firstname" 
			      value="${student.firstname}" placeholder="Update student's firstname" required>
			    </div>
			    <div class="form-group col p-2">
			      <input type="text" class="form-control"  name="lastname" id="lastname"  
			     placeholder="Update student's firstname" value="${student.lastname}" required>
			    </div>
			    
			  </div>
			  <button type="submit" class="btn btn-success col-md-3 float-right">Update Student</button>
			</form>
				<div class="center text-danger">
					<c:if test="${sqlError}">
						<p>Error in insert</p>
					</c:if>
				</div>
	
						
		</div>
		
		<c:if test="${studentUpdated}">
			<div class="alert alert-success alert-dismissible fade show w-50 mt-2" role="alert">
			  <strong>Student updated successfully!</strong>
		  
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>				
	
		</c:if>	
		
		<div class="mt-5">
			<button type="button" class="btn btn-outline-secondary">
				<i class="fa fa-chevron-left"></i> 
				<a href="javascript:history.go(-2)" style="text-decoration: none; color:black;">Επιστροφή</a>
			</button>			
		</div>			
	</div>

		
	<nav class="navbar fixed-bottom navbar-dark" style="background-color: #545e66;">
	  <a class="navbar-brand">Copyright&#169; Teacher App 2022 by Aggeliki</a>
	</nav>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
				
</body>
</html>