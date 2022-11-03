package gr.aueb.sev.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.model.StudentCourse;

public class StudentCourseController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<StudentCourse> courses = new ArrayList<>();
		
		courses.add(new StudentCourse(1, 2));
		courses.add(new StudentCourse(2, 1));
		courses.add(new StudentCourse(2, 3));

		request.setAttribute("courses", courses);
		request.getRequestDispatcher("/jsps/courses.jsp").forward(request, response);
	}
}
