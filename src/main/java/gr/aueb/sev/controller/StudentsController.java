package gr.aueb.sev.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.model.Student;

@WebServlet("/StudentsController")
public class StudentsController extends HttpServlet{
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students = new ArrayList<>();
		
		students.add(new Student(1, "Aggeliki", "M."));
		students.add(new Student(2, "Eftichia", "M."));
		students.add(new Student(3, "Georgia", "M."));
		students.add(new Student(4, "Thanassis", "M."));

		request.setAttribute("students", students);
		request.getRequestDispatcher("/jsps/students.jsp").forward(request, response);
	}

}
