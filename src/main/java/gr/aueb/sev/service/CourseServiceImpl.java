package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dao.ICourseDAO;
import gr.aueb.sev.dto.CourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.service.exceptions.CourseAlreadyExistException;
import gr.aueb.sev.service.exceptions.CourseNotFoundException;
import gr.aueb.sev.service.exceptions.TeacherAlreadyTeachException;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

public class CourseServiceImpl implements ICourseService{

	private final ICourseDAO courseDAO;
	
	public CourseServiceImpl(ICourseDAO courseDAO) {
		
		this.courseDAO = courseDAO;
	}
	@Override
	public void insertCourse(CourseDTO courseDTO) throws SQLException, TeacherAlreadyTeachException, CourseAlreadyExistException, TeacherNotFoundException {
		Course course = map(courseDTO);
		try {
			courseDAO.insert(course);
		} catch (TeacherAlreadyTeachException e) {
			throw e;
		} catch (CourseAlreadyExistException e) {
			throw e;
		} catch (TeacherNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		}	
	}

	@Override
	public void deleteCourse(CourseDTO courseDTO) throws SQLException, CourseNotFoundException {
		Course courseToDelete = map(courseDTO);
		try {
			if (courseDAO.delete(courseToDelete) == null) {
				throw new CourseNotFoundException();}
		} catch (SQLException e) {
			throw e;
		} catch (CourseNotFoundException e) {
			e.printStackTrace();
			throw e;
		}			
	}

	@Override
	public void updateCourse(CourseDTO oldCourseDTO, CourseDTO newCourseDTO) throws SQLException {
		Course oldCourse = map(oldCourseDTO);
		Course newCourse = map(newCourseDTO);
		
		try {
			courseDAO.update(oldCourse, newCourse);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}		
	}

	@Override
	public Course getCourseById(int id) throws SQLException, CourseNotFoundException {
		try {
			Course course = courseDAO.getCourseById(id);
			if (course == null) {
				throw new CourseNotFoundException();
			} else {
				return course;
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}  catch (CourseNotFoundException e) {
			e.printStackTrace();
			throw e;
		}	
	}

	@Override
	public List<Course> getCourseByTeacherId(int teacherId) throws SQLException, CourseNotFoundException {

		try {
			return courseDAO.getCourseByTeacherId(teacherId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public List<Course> getAllCourses() throws SQLException, CourseNotFoundException {
		try {
			return courseDAO.getAllCourses();

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}	
	 
	private Course map(CourseDTO courseDTO) {
		Course course = new Course();
		course.setId(courseDTO.getId());
		course.setDescription(courseDTO.getDescription());
		course.setTeacherid(courseDTO.getTeacherid());
		
		return course;
	}


}
