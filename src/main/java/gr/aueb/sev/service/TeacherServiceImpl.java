package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dao.ITeacherDAO;
import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

public class TeacherServiceImpl implements ITeacherService{

	private final ITeacherDAO teacherDAO;
	
	public TeacherServiceImpl(ITeacherDAO teacherDAO) {
		
		this.teacherDAO = teacherDAO;
	}
	@Override
	public void insertTeacher(TeacherDTO teacherDTO) throws SQLException {

		Teacher teacher = map(teacherDTO);
		try {
			teacherDAO.insert(teacher);
		} catch (SQLException e) {
			throw e;
		}
		
	}

	@Override
	public void deleteTeacher(TeacherDTO teacherDTO) throws SQLException, TeacherNotFoundException {
		Teacher teacherToDelete = map(teacherDTO);
		try {
			
			if (teacherDAO.delete(teacherToDelete) == null) {
				throw new TeacherNotFoundException();
			}
			
		} catch (SQLException e) {
			throw e;
		} catch (TeacherNotFoundException e) {
			e.printStackTrace();
			throw e;
		}	
		
		
		
	}

	@Override
	public void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) throws SQLException {
		Teacher oldTeacher = map(oldTeacherDTO);
		Teacher newTeacher = map(newTeacherDTO);
		
		try {
			teacherDAO.update(oldTeacher, newTeacher);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public List<Teacher> getTeacherByLastname(String lastname) throws SQLException {

		try {
			return teacherDAO.getTeacherByLastname(lastname);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Teacher getTeacherById(int id) throws SQLException, TeacherNotFoundException{
		try {
			Teacher teacher = teacherDAO.getTeacherById(id);
			if (teacher == null) {
				throw new TeacherNotFoundException();
			} else {
				return teacher;
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}  catch (TeacherNotFoundException e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	private Teacher map(TeacherDTO teacherDTO) {
		Teacher teacher = new Teacher();
		teacher.setId(teacherDTO.getId());
		teacher.setFirstname(teacherDTO.getFirstname());
		teacher.setLastname(teacherDTO.getLastname());
		
		return teacher;
	}

}
