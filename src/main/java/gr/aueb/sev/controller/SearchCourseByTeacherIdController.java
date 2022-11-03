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
import gr.aueb.sev.dao.CourseDAOImpl;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;
import gr.aueb.sev.service.CourseServiceImpl;

@WebServlet("/coursesearchbyteacher")

public class SearchCourseByTeacherIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO);          

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html, charset=UTF-8");

		try {		
			int teacherId = Integer.parseInt(request.getParameter("teacherid").trim());

			List<Course> courses = courseServ.getCourseByTeacherId(teacherId);
			
			if (courses == null) {
				throw new TeacherNotFoundException();
			} else {
			request.setAttribute("courses", courses);				
			}
			request.getRequestDispatcher("/jsps/courses.jsp").forward(request, response);
	
		} catch (CourseNotFoundException e) {
			request.setAttribute("courseNotFound", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);		
		} catch (TeacherNotFoundException e) {
			request.setAttribute("teacherNotFound", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			request.setAttribute("courseNotFound", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);		
		}  catch (SQLException e) {
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/coursesmenu.jsp").forward(request, response);
			
		}

	}



}
