package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dao.IStudentCourseDAO;
import gr.aueb.sev.dto.StudentCourseDTO;
import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;
import gr.aueb.sev.service.exceptions.StudentAlreadyEnrolledException;

public class StudentCourseServiceImpl implements IStudentCourseService{
	
	private final IStudentCourseDAO studentCourseDAO;
	
	public StudentCourseServiceImpl(IStudentCourseDAO studentCourseDAO) {
		
		this.studentCourseDAO = studentCourseDAO;
	}
	@Override
	public void enroll(StudentCourseDTO studentCourseDTO) throws SQLException, StudentAlreadyEnrolledException {
		StudentCourse studentCourse = map(studentCourseDTO);
		try {
			studentCourseDAO.insert(studentCourse);
		} catch (StudentAlreadyEnrolledException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			throw e;
		} 				
	}

	@Override
	public void delete(StudentCourseDTO studentCourseDTO) throws SQLException {
		StudentCourse studentCourseToDelete = map(studentCourseDTO);
		try {
			studentCourseDAO.delete(studentCourseToDelete);
		} catch (SQLException e) {
			throw e;
		} 	
	}

	@Override
	public List<Course> getCourseByStudentId(int id) throws SQLException {
		try {
			return studentCourseDAO.getCourseByStudentId(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Student> getStudentByCourseId(int id) throws SQLException {
		try {
			return studentCourseDAO.getStudentByCourseId(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private StudentCourse map(StudentCourseDTO studentCourseDTO) {
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setStudentid(studentCourseDTO.getStudentid());
		studentCourse.setCourseid(studentCourseDTO.getCourseid());
		
		return studentCourse;
	}
}
