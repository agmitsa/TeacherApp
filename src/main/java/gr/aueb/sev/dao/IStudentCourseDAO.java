package gr.aueb.sev.dao;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;
import gr.aueb.sev.service.exceptions.StudentAlreadyEnrolledException;

public interface IStudentCourseDAO {
	void insert(StudentCourse studentCourse) throws SQLException, StudentAlreadyEnrolledException;
	void delete(StudentCourse studentCourse) throws SQLException;
	List<Course> getCourseByStudentId(int id) throws SQLException;
	List<Student> getStudentByCourseId(int id) throws SQLException;
}
