package gr.aueb.sev.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.sev.dao.IStudentDAO;
import gr.aueb.sev.dao.StudentDAOImpl;
import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.IStudentService;
import gr.aueb.sev.service.StudentServiceImpl;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;

/**
 * Servlet implementation class DeleteStudentController
 */
@WebServlet("/studentdelete")
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;      

	IStudentDAO studentDAO = new StudentDAOImpl();
	IStudentService studentServ = new StudentServiceImpl(studentDAO);  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html, charset=UTF-8");

		int id = Integer.parseInt(request.getParameter("id").trim());
		String firstname = request.getParameter("firstname").trim();
		String lastname = request.getParameter("lastname").trim();
		String jspName = request.getParameter("jspname").trim();
		
		StudentDTO studentDTO= new StudentDTO();
		studentDTO.setId(id);
		studentDTO.setFirstname(firstname);
		studentDTO.setLastname(lastname);
		
		try {

			studentServ.deleteStudent(studentDTO);	

			if (jspName.equals("/jsps/student.jsp")) {
				
				request.setAttribute("student", studentDTO);
				request.getRequestDispatcher("/jsps/studentdeleted.jsp").forward(request, response);				
			} else {
				
				List<Student> students = studentServ.getStudentByLastname(lastname);
				request.setAttribute("students", students);
				request.setAttribute("studentdeleted", true);
				request.getRequestDispatcher("/jsps/students.jsp").forward(request, response);				
			}
		
		} catch (StudentNotFoundException e) {
			
			request.setAttribute("studentnotfound", true);	
	
			request.getRequestDispatcher(jspName).forward(request, response);	
			
		}catch (SQLException e) {
			
			request.setAttribute("deleteStudentError", true);

			request.getRequestDispatcher(jspName).forward(request, response);			
		}

	}

}
