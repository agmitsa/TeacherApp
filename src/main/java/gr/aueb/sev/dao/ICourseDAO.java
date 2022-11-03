package gr.aueb.sev.dao;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.exceptions.CourseAlreadyExistException;
import gr.aueb.sev.service.exceptions.TeacherAlreadyTeachException;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

public interface ICourseDAO {
	void insert(Course course) throws SQLException, TeacherAlreadyTeachException, CourseAlreadyExistException, TeacherNotFoundException;
	Course delete(Course course) throws SQLException;
	void update(Course oldCourse, Course newCourse) throws SQLException;
	Course getCourseById(int id) throws SQLException;
	List<Course> getAllCourses() throws SQLException;
	List<Course> getCourseByTeacherId(int teacherId) throws SQLException;

}
