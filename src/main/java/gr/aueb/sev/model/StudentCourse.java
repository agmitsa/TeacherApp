package gr.aueb.sev.model;

public class StudentCourse {
	private int studentid;
	private int courseid;
	
	
	public StudentCourse() {

	}


	public StudentCourse(int studentid, int courseid) {
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
