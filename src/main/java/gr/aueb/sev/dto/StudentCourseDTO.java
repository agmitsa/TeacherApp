package gr.aueb.sev.dto;

public class StudentCourseDTO {
	private int studentid;
	private int courseid;
	
	public StudentCourseDTO() {
		
	}
	
	public StudentCourseDTO(int studentid, int courseid) {
		super();
		this.studentid = studentid;
		this.courseid = courseid;
	}
	
	public int getStudentid() {
		return studentid;
	}
	
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	public int getCourseid() {
		return courseid;
	}
	
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	
}
