 package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.ICourseDAO;
import gr.aueb.sev.dao.CourseDAOImpl;
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.CourseServiceImpl;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;

@WebServlet("/coursedelete")

public class DeleteCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO);   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html, charset=UTF-8");

		int id = Integer.parseInt(request.getParameter("id").trim());
		String description = request.getParameter("description").trim();
		int teacherId = Integer.parseInt(request.getParameter("teacherid").trim());
		
		CourseDTO courseDTO= new CourseDTO();
		courseDTO.setId(id);
		courseDTO.setDescription(description);
		courseDTO.setTeacherid(teacherId);
		
		try {
			
			courseServ.deleteCourse(courseDTO);
			request.setAttribute("course", courseDTO);
			request.getRequestDispatcher("/jsps/coursedeleted.jsp").forward(request, response);
		} catch (SQLException e) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/course.jsp").forward(request, response);
			
		} catch (CourseNotFoundException e) {
			request.setAttribute("coursenotfound", true);
			request.getRequestDispatcher("/jsps/course.jsp").forward(request, response);			
		}

	}
}
