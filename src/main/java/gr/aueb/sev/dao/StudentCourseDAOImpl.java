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
import gr.aueb.sev.model.Student;
import gr.aueb.sev.model.StudentCourse;
import gr.aueb.sev.service.exceptions.StudentAlreadyEnrolledException;

public class StudentCourseDAOImpl implements IStudentCourseDAO{
	
	@Override
	public void insert(StudentCourse studentCourse) throws SQLException, StudentAlreadyEnrolledException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		int courseid = studentCourse.getCourseid();
		int studentid = studentCourse.getStudentid();
		try {
			if (checkIfStudentAlreadyEnrolled(studentid, courseid) == true) {
				throw new StudentAlreadyEnrolledException();
			}			
			String sql = "INSERT INTO COURSES_STUDENTS VALUES (?, ?)";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, courseid);
			pst.setInt(2, studentid);
			pst.executeUpdate();
			
		} catch (StudentAlreadyEnrolledException e) {
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
	public void delete(StudentCourse studentCourse) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();

		try {
			String sql = "DELETE FROM COURSES_STUDENTS WHERE STUDENTID = ? AND COURSEID = ?";
			// + "'" + student.getFirstname() + "'" + student.getLaststname() + "'"  			
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, studentCourse.getStudentid());
			pst.setInt(2, studentCourse.getCourseid());

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
	public List<Course> getCourseByStudentId(int id) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		List<Course> courses = new ArrayList<>();
		ResultSet rs = null;

		try {
			String sql = "SELECT COURSEID, DESCRIPTION, TEACHERID FROM COURSES_STUDENTS, COURSES "
					+ "WHERE COURSES_STUDENTS.COURSEID = COURSES.ID"
					+ " AND STUDENTID = ?";
			// + "'" + student.getFirstname() + "'" + student.getLaststname() + "'"  			
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("COURSEID"));
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
	public List<Student> getStudentByCourseId(int id) throws SQLException {
		PreparedStatement pst = null;
		Connection conn = getConnection();
		List<Student> students = new ArrayList<>();
		ResultSet rs = null;

		try {
			String sql = "SELECT STUDENTID, FIRSTNAME, LASTNAME FROM COURSES_STUDENTS, STUDENTS"
					+ " WHERE COURSES_STUDENTS.STUDENTID = STUDENTS.ID"
					+ " AND COURSEID = ?";
			// + "'" + student.getFirstname() + "'" + student.getLaststname() + "'"  			
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			
			
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("STUDENTID"));
				student.setFirstname(rs.getString("FIRSTNAME"));
				student.setLastname(rs.getString("LASTNAME"));

				students.add(student);
			
			}
			return (students.size() > 0) ? students : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (conn != null) closeConnection();
		}	
	}
	private boolean checkIfStudentAlreadyEnrolled(int studentid, int courseid) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = null;
		boolean studentAlreadyEnrolled = false;
		String sql = "SELECT * FROM COURSES_STUDENTS WHERE STUDENTID = " + studentid + " AND COURSEID = " + courseid;
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			
			if (rs.next()) {
				studentAlreadyEnrolled = true;
			}
			
			return studentAlreadyEnrolled;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (stmt != null) stmt.close();
			if (conn != null) closeConnection();
		}			
	}

}
