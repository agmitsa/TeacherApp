package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.ICourseDAO;
import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dao.IStudentDAO;
import gr.aueb.sev.dao.StudentCourseDAOImpl;
import gr.aueb.sev.dao.StudentDAOImpl;
import gr.aueb.sev.dao.CourseDAOImpl;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.IStudentService;
import gr.aueb.sev.service.StudentCourseServiceImpl;
import gr.aueb.sev.service.StudentServiceImpl;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.CourseServiceImpl;

@WebServlet("/coursesearchbyid")

public class SearchCourseByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO);
	
	IStudentDAO studentDAO = new StudentDAOImpl();
	IStudentService studentServ = new StudentServiceImpl(studentDAO);    
	
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO);      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html, charset=UTF-8");

		try {
			int id = Integer.parseInt(request.getParameter("courseid").trim());

			Course course = courseServ.getCourseById(id);
			List<Student> students = studentCourseServ.getStudentByCourseId(id);
			List<Student> allStudents = studentServ.getAllStudents();

			request.setAttribute("course", course);
			if (students == null) {
				request.setAttribute("studentNotFound", true);				
			} else {
				request.setAttribute("students", students);				
			}
			
			request.setAttribute("allstudents", allStudents);
			request.getRequestDispatcher("/jsps/course.jsp").forward(request, response);
	
		} catch (CourseNotFoundException e) {
			request.setAttribute("courseNotFound", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);		
		} catch (NumberFormatException e) {
			request.setAttribute("courseNotFound", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);			
		} catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);
			
		} 

	}



}
