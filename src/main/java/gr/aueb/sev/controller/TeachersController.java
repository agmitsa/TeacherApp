package gr.aueb.sev.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.model.Teacher;


@WebServlet("/TeachersController")
public class TeachersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Teacher> teachers = new ArrayList<>();
		
		/*
		 * teachers.add(new Teacher(1, "Alice", "W.")); teachers.add(new Teacher(2,
		 * "Bob", "M.")); teachers.add(new Teacher(3, "John", "D."));
		 */

		request.setAttribute("teachers", teachers);
		request.getRequestDispatcher("/jsps/teachers.jsp").forward(request, response);
	}


}
