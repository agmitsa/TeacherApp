package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.CourseDAOImpl;
import gr.aueb.sev.dao.ICourseDAO;
import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dao.IStudentDAO;
import gr.aueb.sev.dao.StudentCourseDAOImpl;
import gr.aueb.sev.dao.StudentDAOImpl;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.CourseServiceImpl;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.IStudentService;
import gr.aueb.sev.service.StudentCourseServiceImpl;
import gr.aueb.sev.service.StudentServiceImpl;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;

@WebServlet("/searchstudentbyid")
public class SearchStudentById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO);          

	IStudentDAO studentDAO = new StudentDAOImpl();
	IStudentService studentServ = new StudentServiceImpl(studentDAO);     
	
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO);   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html, charset=UTF-8");

		
		try {
			int id = Integer.parseInt(request.getParameter("id").trim());

			Student student = studentServ.getStudentById(id);
			List<Course> courses = studentCourseServ.getCourseByStudentId(id);
			List<Course> allCourses = courseServ.getAllCourses();
			

			request.setAttribute("student", student);
			
			if (courses == null) {
				request.setAttribute("coursenotfound", true);
			} else {
				request.setAttribute("courses", courses);
			}
			
			request.setAttribute("allcourses", allCourses);			
			request.getRequestDispatcher("/jsps/student.jsp").forward(request, response);
	
		} catch (StudentNotFoundException e) {
			request.setAttribute("studentNotFound", true);
			request.getRequestDispatcher("/jsps/studentsmenu.jsp").forward(request, response);		
		} catch (CourseNotFoundException e) {
			e.printStackTrace();		
		} catch (NumberFormatException e) {
			request.setAttribute("studentNotFound", true);
			request.getRequestDispatcher("/jsps/studentsmenu.jsp").forward(request, response);			
		} catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/studentsmenu.jsp").forward(request, response);
			
		} 

	}

}
