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
import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.CourseServiceImpl;
import gr.aueb.sev.service.ICourseService;
import gr.aueb.sev.service.IStudentCourseService;
import gr.aueb.sev.service.IStudentService;
import gr.aueb.sev.service.StudentCourseServiceImpl;
import gr.aueb.sev.service.StudentServiceImpl;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.exceptions.StudentAlreadyEnrolledException;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;

@WebServlet("/insertstudentcourse")
public class InsertStudentCourseController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	IStudentCourseDAO studentCourseDAO = new StudentCourseDAOImpl();
	IStudentCourseService studentCourseServ = new StudentCourseServiceImpl(studentCourseDAO);
	
	IStudentDAO studentDAO = new StudentDAOImpl();
	IStudentService studentServ = new StudentServiceImpl(studentDAO);

	ICourseDAO courseDAO = new CourseDAOImpl();
	ICourseService courseServ = new CourseServiceImpl(courseDAO);   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html, charset=UTF-8");
		int studentid = Integer.parseInt(request.getParameter("studentid").trim());
		int courseid = Integer.parseInt(request.getParameter("courseid").trim());
		String returnUrl = request.getParameter("jspname").trim();
		
		StudentCourseDTO studentCourseDTO= new StudentCourseDTO();
		studentCourseDTO.setStudentid(studentid);
		studentCourseDTO.setCourseid(courseid);
		
		List<Course> courses = null;
		List<Course> allCourses = null;
		List<Student> students = null;
		List<Student> allStudents = null;		
		Student student = new Student();
		Course course = new Course();
		
		try {
			
			if (returnUrl.equals("/jsps/student.jsp")) {
				
				student = studentServ.getStudentById(studentid);
				request.setAttribute("student", student);	
				
				courses = studentCourseServ.getCourseByStudentId(studentid);
				request.setAttribute("courses", courses);	
				
				allCourses = courseServ.getAllCourses();
				request.setAttribute("allcourses", allCourses);						
			} else {
				
				course = courseServ.getCourseById(courseid);
				request.setAttribute("course", course);	
				
				students = studentCourseServ.getStudentByCourseId(courseid);
				request.setAttribute("students", students);	

				allStudents = studentServ.getAllStudents();	
				request.setAttribute("allstudents", allStudents);	

			}
			
			/*
			 * allCourses = courseServ.getAllCourses(); request.setAttribute("allcourses",
			 * allCourses);
			 * 
			 * allStudents = studentServ.getAllStudents();
			 * request.setAttribute("allstudents", allStudents);
			 */
			
			studentCourseServ.enroll(studentCourseDTO);			
			request.setAttribute("studentenrolled", true);
			
			request.getRequestDispatcher(returnUrl).forward(request, response);

		} catch (StudentAlreadyEnrolledException e) {
			
			request.setAttribute("studentalreadyenrolled", true);			
			request.setAttribute("student", student);
			request.setAttribute("courses", courses);			
			request.setAttribute("allcourses", allCourses);			

			request.getRequestDispatcher(returnUrl).forward(request, response);
		} catch (StudentNotFoundException e) {
			
			request.setAttribute("studentnotfound", true);			
			request.setAttribute("course", course);
			request.setAttribute("students", students);			
			request.setAttribute("allstudents", allStudents);
			
			request.getRequestDispatcher(returnUrl).forward(request, response);
		} catch (CourseNotFoundException e) {
			
			request.setAttribute("coursenotfound", true);			
			request.setAttribute("student", student);
			request.setAttribute("courses", courses);			
			request.setAttribute("allcourses", allCourses);
			
			request.getRequestDispatcher(returnUrl).forward(request, response);
		} catch (SQLException e) {
			
			request.setAttribute("insertAPIerror", true);
			
			if (returnUrl.equals("/jsps/student.jsp")) {
				request.setAttribute("student", student);
				request.setAttribute("courses", courses);			
				request.setAttribute("allcourses", allCourses);				
			} else {
				request.setAttribute("course", course);	
				request.setAttribute("students", students);	
				request.setAttribute("allstudents", allStudents);	

			}
			
			request.getRequestDispatcher(returnUrl).forward(request, response);
		}
		
	}
}
