package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.service.exceptions.StudentAlreadyEnrolledException;

public interface IStudentCourseService {
	/**
	 * enroll a student to a course
	 * @param studentCourse the new entry that will be created 
	 * @throws SQLException if something bad happens during the insert
	 * @throws StudentAlreadyEnrolledException 
	 */
	void enroll(StudentCourseDTO studentCourseDTO) throws SQLException, StudentAlreadyEnrolledException;
	/**
	 * Delete a student from a course
	 * @param studentCourse the object to be deleted
	 * @throws SQLException
	 */
	void delete(StudentCourseDTO studentCourseDTO) throws SQLException;
	/**
	 * Gets a list of courses that the student is enrolled
	 * @param id the student id
	 * @return the list of courses
	 * @throws SQLException
	 */
	List<Course> getCourseByStudentId(int id) throws SQLException;
	/**
	 * Gets a list of students that enrolled the course
	 * @param id course id
	 * @return the list of students
	 * @throws SQLException
	 */
	List<Student> getStudentByCourseId(int id) throws SQLException;
}
