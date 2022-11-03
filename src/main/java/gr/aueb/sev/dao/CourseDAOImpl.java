package gr.aueb.sev.dao;

import static gr.aueb.sev.dao.dbutil.DBUtil.closeConnection;
import static gr.aueb.sev.dao.dbutil.DBUtil.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.sev.model.Course;
import gr.aueb.sev.model.Teacher;
import gr.aueb.sev.service.exceptions.CourseAlreadyExistException;
import gr.aueb.sev.service.exceptions.TeacherAlreadyTeachException;
import gr.aueb.sev.service.exceptions.TeacherNotFoundException;

public class CourseDAOImpl implements ICourseDAO{

	public void insert(Course course) throws SQLException, TeacherAlreadyTeachException, CourseAlreadyExistException, TeacherNotFoundException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		String description = course.getDescription();
		int teacherid = course.getTeacherid();
		try {
			
			if (checkIfTeacherAlreadyTeach(teacherid, description) == true) {
				throw new TeacherAlreadyTeachException();
			}
			
			if (checkIfTeacherExists(teacherid) == false) {
				throw new TeacherNotFoundException();
			}
			
			if (checkIfCourseExists(description) == true) {
				throw new CourseAlreadyExistException();
			}
			
			String sql = "INSERT INTO COURSES (DESCRIPTION,TEACHERID) VALUES (?,?)";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, description);
			pst.setInt(2, teacherid);
			
			pst.executeUpdate();

		} catch (TeacherAlreadyTeachException e) {
			e.printStackTrace();
			throw e;
		} catch (TeacherNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (CourseAlreadyExistException e) {
			e.printStackTrace();
			throw e;

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (conn != null) closeConnection();
		}
		
	}

	@Override
	public Course delete(Course course) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();

		try {
			String sql = "DELETE FROM COURSES WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, course.getId());
			
			int n = pst.executeUpdate();
			
			if (n == 0) {
				return null;
			} else {
				return course;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (conn != null) closeConnection();
		}		
	}

	@Override
	public void update(Course oldCourse, Course newCourse) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();

		try {
			String sql = "UPDATE COURSES SET DESCRIPTION = ?, TEACHERID = ? WHERE ID = ?";
			// + "'" + teacher.getFirstname() + "'" + teacher.getLaststname() + "'"  			
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, newCourse.getDescription());
			pst.setInt(2, newCourse.getTeacherid());
			pst.setInt(3, oldCourse.getId());

			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (conn != null) closeConnection();
		}						
	}

	@Override
	public Course getCourseById(int id) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		ResultSet rs = null;
		Course course = null;
		
		try {
			String sql = "SELECT * FROM COURSES WHERE ID = ?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				course = new Course();
				course.setId(rs.getInt("ID"));
				course.setDescription(rs.getString("DESCRIPTION"));
				course.setTeacherid(rs.getInt("TEACHERID"));			
			}
			
			return course;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (conn != null) closeConnection();
		}	
	}

	@Override
	public List<Course> getCourseByTeacherId(int teacherId) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		List<Course> courses = new ArrayList<>();
		ResultSet rs = null;

		try {
			String sql = "SELECT ID, DESCRIPTION, TEACHERID FROM COURSES WHERE TEACHERID = ?";
			// + "'" + teacher.getFirstname() + "'" + teacher.getLaststname() + "'"  			
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, teacherId);
			
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("ID"));
				course.setDescription(rs.getString("DESCRIPTION"));
				course.setTeacherid(rs.getInt("TEACHERID"));

				courses.add(course);
			
			}
			return (courses.size() > 0) ? courses : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (conn != null) closeConnection();
		}	
	}

	@Override
	public List<Course> getAllCourses() throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		List<Course> courses = new ArrayList<>();
		ResultSet rs = null;

		try {
			String sql = "SELECT ID, DESCRIPTION FROM COURSES";
			// + "'" + teacher.getFirstname() + "'" + teacher.getLaststname() + "'"  			
			
			pst = conn.prepareStatement(sql);	
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("ID"));
				course.setDescription(rs.getString("DESCRIPTION"));

				courses.add(course);
			
			}
			return (courses.size() > 0) ? courses : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (conn != null) closeConnection();
		}	
	}

	private boolean checkIfCourseExists(String description) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = null;
		boolean courseExists = false;
		String sql = "SELECT DESCRIPTION FROM COURSES WHERE DESCRIPTION = " + "'" + description + "'";
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			if (rs.next()) {
				courseExists = true;
			}
			
			return courseExists;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (stmt != null) stmt.close();
			if (conn != null) closeConnection();
		}			
	}		

	private boolean checkIfTeacherExists(int teacherid) throws SQLException {
		ITeacherDAO iTeacherDAO = new TeacherDAOImpl();
		Teacher teacher = iTeacherDAO.getTeacherById(teacherid);
		return (teacher != null) ? true : false;
	}
	
	private boolean checkIfTeacherAlreadyTeach(int teacherid, String description) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = null;
		boolean teacherAlreadyTeach = false;
		String sql = "SELECT * FROM COURSES WHERE DESCRIPTION = " + "'" + description + "'" + " AND TEACHERID = " + teacherid;
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			if (rs.next()) {
				teacherAlreadyTeach = true;
			}
			
			return teacherAlreadyTeach;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (stmt != null) stmt.close();
			if (conn != null) closeConnection();
		}			
	}

}
