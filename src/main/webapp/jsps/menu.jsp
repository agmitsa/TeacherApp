<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.redirections {
	box-sizing: border-box;
	margin: auto;
	padding:0;

}

.redirections {
	margin-top:15%;
}
</style>


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

	<div class="redirections w-50">
	    <div class="container-fluid">
			<a href="${pageContext.request.contextPath}/jsps/teachersmenu.jsp" class="d-block btn btn-primary btn-lg active btn-block mb-2 py-3" role="button" aria-pressed="true">Teachers admin  <i class="fa fa-chevron-right"></i></a>
			<a href="${pageContext.request.contextPath}/jsps/studentsmenu.jsp" class="d-block btn btn-primary btn-lg active btn-block mb-2 py-3" role="button" aria-pressed="true">Students admin  <i class="fa fa-chevron-right"></i></a>
			<a href="${pageContext.request.contextPath}/jsps/coursesmenu.jsp" class="d-block btn btn-primary btn-lg active btn-block mb-2 py-3" role="button" aria-pressed="true">Courses admin <i class="fa fa-chevron-right"></i></a>
	    
	    </div>
	
	</div>
	<nav class="navbar fixed-bottom navbar-dark" style="background-color: #545e66;">
	  <a class="navbar-brand">Copyright&#169; Teacher App 2022 by Aggeliki</a>
	</nav>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>