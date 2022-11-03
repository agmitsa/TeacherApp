package gr.aueb.sev.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.sev.dto.TeacherDTO;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

public interface ITeacherService {
	
	/**
	 * Inserts a {@link Teacher} based on the data carried by the {@link TeacherDTO}
	 * @param teacherDTO
	 * 			DTO object that contains the data
	 * @throws SQLException
	 * 			if any error happens during SQL insert 
	 */
	void insertTeacher(TeacherDTO teacherDTO) throws SQLException;
	/**
	 * Deletes a {@link Teacher} based on the data carried by the {@link TeacherDTO}
	 * @param teacherDTO
	 * 			DTO object that contains the data (the teacher's id)
	 * @throws SQLException, TeacherNotFoundException 
	 * 						if any teacher identified by their id, not found
	 */						
	void deleteTeacher(TeacherDTO teacherDTO) throws SQLException, TeacherNotFoundException;	
	/**
	 * Updates a {@link Teacher} based on the data carried by new TeacherDTO, identified by their id, carried by old TeacherDTO.
	 * 
	 * @param oldTeacherDTO
	 * 			DTO object that contains the data of the teacher to be updated
	 * @param newTeacherDTO
	 * @throws SQLException
	 */
	void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO) throws SQLException;	
	/**
	 * Gets back to the caller a list of the {@link Teacher} objects identified by their lastname
	 * @param lastname
	 * 			a string object that contains the initial letters of teacher's last name
	 * @return
	 * 			a list that contains the result of the called method or empty list
	 * @throws SQLException
	 * 			if any error happens during the SQL search
	 */
	List<Teacher> getTeacherByLastname(String lastname) throws SQLException;	
	/**
	 * Get back the teacher identified by their id 
	 * @param id
	 * 			Teacher's id 
	 * @return
	 * 		The teacher object or null if the teacher not found
	 * @throws SQLException
	 * 		If any error happens during the sql search
	 * @throws TeacherNotFoundException
	 * 			if teacher not found
	 */
	Teacher getTeacherById(int id) throws SQLException, TeacherNotFoundException;
}
