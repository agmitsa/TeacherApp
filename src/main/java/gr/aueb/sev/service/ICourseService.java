package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.exceptions.CourseAlreadyExistException;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.exceptions.TeacherAlreadyTeachException;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

public interface ICourseService {
	/**
	 * Inserts a {@link Course} based on the data carried by the {@link CourseDTO}
	 * @param courseDTO
	 * 			DTO object that contains the data
	 * @throws SQLException
	 * 			if any error happens during SQL insert 
	 * @throws TeacherAlreadyTeachException 
	 * @throws CourseAlreadyExistException 
	 * @throws TeacherNotFoundException 
	 */
	void insertCourse(CourseDTO courseDTO) throws SQLException, TeacherAlreadyTeachException, CourseAlreadyExistException, TeacherNotFoundException;
	/**
	 * Deletes a {@link Course} based on the data carried by the {@link CourseDTO}
	 * @param courseDTO
	 * 			DTO object that contains the data (the course's id)
	 * @throws SQLException, CourseNotFoundException 
	 * 						if any course identified by its id, not found
	 */						
	void deleteCourse(CourseDTO courseDTO) throws SQLException, CourseNotFoundException;
	
	/**
	 * Updates a {@link Course} based on the data carried by new CourseDTO, identified by their id, carried by old CourseDTO.
	 * 
	 * @param oldCourseDTO
	 * 			DTO object that contains the data of the course to be updated
	 * @param newCourseDTO
	 * @throws SQLException
	 */
	void updateCourse(CourseDTO oldCourseDTO, CourseDTO newCourseDTO) throws SQLException;
	
	/**
	 * Get back the course identified by it's id 
	 * @param id
	 * 			Course's id 
	 * @return
	 * 			a list that contains the result of the called method or empty list
	 * @throws SQLException
	 * 			if any error happens during the SQL search
	 */
	Course getCourseById(int id) throws SQLException, CourseNotFoundException ;
	
	/**
	 * Get back the course identified by it's teacher id 
	 * @param id
	 * 			Course's id 
	 * @return
	 * 		The course object or null if the course not found
	 * @throws SQLException
	 * 		If any error happens during the sql search
	 * @throws CourseNotFoundException
	 * 			if course not found
	 */

	List<Course> getCourseByTeacherId(int teacherId) throws SQLException, CourseNotFoundException;
	/**
	 * Gets the list of all courses
	 * @return list of courses
	 * @throws SQLException
	 * @throws CourseNotFoundException if no courses are found
	 */
	List<Course> getAllCourses() throws SQLException, CourseNotFoundException;

}
