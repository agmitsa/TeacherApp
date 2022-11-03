package gr.aueb.sev.controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.ICourseDAO;
import gr.aueb.sev.dao.CourseDAOImpl;
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.exceptions.CourseAlreadyExistException;
import gr.aueb.sev.service.exceptions.TeacherAlreadyTeachException;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;
import gr.aueb.sev.service.CourseServiceImpl;

@WebServlet("/courseinsert")

public class InsertCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html, charset=UTF-8");
		String description = request.getParameter("description").trim();


		
		try {
			
			int teacherid = Integer.parseInt(request.getParameter("teacherid").trim());
			
			CourseDTO courseDTO= new CourseDTO();
			courseDTO.setDescription(description);
			courseDTO.setTeacherid(teacherid);
			
			courseServ.insertCourse(courseDTO);
			request.setAttribute("insertedCourse", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);

		} catch (TeacherAlreadyTeachException e) {
			request.setAttribute("teacherAlreadyTeach", true);
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsps/coursesmenu.jsp");

			rd.forward(request, response);
			//request.getRequestDispatcher(" /jsps/coursesmenu.jsp").forward(request, response);

		} catch (CourseAlreadyExistException e) {
			request.setAttribute("courseAlreadyExist", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);
		} catch (TeacherNotFoundException e) {
			request.setAttribute("teachernotfound", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			request.setAttribute("teachernotfound", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);		
		} catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);

		} 
	}


}
