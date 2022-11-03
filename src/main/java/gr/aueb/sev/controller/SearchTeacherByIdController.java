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
import gr.aueb.sev.dao.ITeacherDAO;
import gr.aueb.sev.dao.TeacherDAOImpl;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.CourseServiceImpl;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.ITeacherService;
import gr.aueb.sev.service.TeacherServiceImpl;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

@WebServlet("/searchteacherbyid")

public class SearchTeacherByIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO);          

	ITeacherDAO teacherDAO = new TeacherDAOImpl();
	ITeacherService teacherServ = new TeacherServiceImpl(teacherDAO);     
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html, charset=UTF-8");

		
		try {
			int id = Integer.parseInt(request.getParameter("id").trim());

			Teacher teacher = teacherServ.getTeacherById(id);
			List<Course> courses = courseServ.getCourseByTeacherId(id);

			request.setAttribute("teacher", teacher);
			if (courses == null) {
				request.setAttribute("courseNotFound", true);				
			} else {
				request.setAttribute("courses", courses);
			}
			request.getRequestDispatcher("/jsps/teacher.jsp").forward(request, response);
	
		} catch (TeacherNotFoundException e) {
			request.setAttribute("teacherNotFound", true);
			request.getRequestDispatcher("/jsps/teachersmenu.jsp").forward(request, response);		
		} catch (CourseNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			request.setAttribute("teacherNotFound", true);
			request.getRequestDispatcher("/jsps/teachersmenu.jsp").forward(request, response);		
		} catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/teachersmenu.jsp").forward(request, response);
			
		}

	}

}
