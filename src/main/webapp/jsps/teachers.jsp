<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher</title>
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
	<div class="col-md-9 mx-auto mt-5 ">
		<div class="table-responsive">
		  <table class="table table-hover">
			<thead>
				<tr>
					<th>ID</th><th>First Name</th><th>Last Name</th><th>Details</th><th>Delete</th><th>Update</th>					
				</tr>
			</thead>
			<tbody>
				<c:forEach var = "teacher" items="${teachers}">
					<tr>
					
						<th scope="row">${teacher.id}</th>
						<td>${teacher.firstname}</td>
						<td>${teacher.lastname}</td>
						<td><a href="${pageContext.request.contextPath}/searchteacherbyid?id=${teacher.id}&firstname=${teacher.firstname}&lastname=${teacher.lastname}">See more</a></td>					
						<td><a href="${pageContext.request.contextPath}/teacherdelete?id=${teacher.id}&firstname=${teacher.firstname}&lastname=${teacher.lastname}">Delete</a></td>
						<td><a href="${pageContext.request.contextPath}/teacherupdate?id=${teacher.id}&firstname=${teacher.firstname}&lastname=${teacher.lastname}">Update</a></td>
		
					</tr>
				</c:forEach>
			</tbody>
		  </table>
		</div>

		<button type="button" class="btn btn-outline-secondary">
			<i class="fa fa-chevron-left"></i> 
			<a href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp" style="text-decoration: none; color:black;">Επιστροφή</a>
		</button>

	</div>
	<div>
		<c:if test="${deleteAPIError}">
			<p>Error in delete</p>
		</c:if>
	</div>
	<div>
		<c:if test="${sqlError}">
			<p>Error in update</p>
		</c:if>
	</div>
	<nav class="navbar fixed-bottom navbar-dark" style="background-color: #545e66;">
	  <a class="navbar-brand">Copyright&#169; Teacher App 2022 by Aggeliki</a>
	</nav>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
			
</body>

</html>