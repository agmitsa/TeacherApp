package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.StudentDTO;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.exceptions.StudentNotFoundException;

public interface IStudentService {
	
	/**
	 * Inserts a {@link Student} based on the data carried by the {@link StudentDTO}
	 * @param studentDTO
	 * 			DTO object that contains the data
	 * @throws SQLException
	 * 			if any error happens during SQL insert 
	 */
	void insertStudent(StudentDTO studentDTO) throws SQLException;
	/**
	 * Deletes a {@link Student} based on the data carried by the {@link StudentDTO}
	 * @param studentDTO
	 * 			DTO object that contains the data (the student's id)
	 * @throws SQLException, StudentNotFoundException 
	 * 						if any student identified by their id, not found
	 */						
	void deleteStudent(StudentDTO studentDTO) throws SQLException, StudentNotFoundException;
	
	/**
	 * Updates a {@link Student} based on the data carried by new StudentDTO, identified by their id, carried by old StudentDTO.
	 * 
	 * @param oldStudentDTO
	 * 			DTO object that contains the data of the student to be updated
	 * @param newStudentDTO
	 * @throws SQLException
	 */
	void updateStudent(StudentDTO oldStudentDTO, StudentDTO newStudentDTO) throws SQLException;
	
	/**
	 * Gets back to the caller a list of the {@link Student} objects identified by their lastname
	 * @param lastname
	 * 			a string object that contains the initial letters of student's last name
	 * @return
	 * 			a list that contains the result of the called method or empty list
	 * @throws SQLException
	 * 			if any error happens during the SQL search
	 */
	List<Student> getStudentByLastname(String lastname) throws SQLException;
	
	/**
	 * Get back the student identified by their id 
	 * @param id
	 * 			Student's id 
	 * @return
	 * 		The student object or null if the student not found
	 * @throws SQLException
	 * 		If any error happens during the sql search
	 * @throws StudentNotFoundException
	 * 			if student not found
	 */

	Student getStudentById(int id) throws SQLException, StudentNotFoundException;
	/**
	 * Gets the list of all courses
	 * @return list of courses
	 * @throws SQLException
	 * @throws CourseNotFoundException if no courses are found
	 */
	List<Student> getAllStudents() throws SQLException, CourseNotFoundException;

}
