package gr.aueb.sev.dto;

public class CourseDTO {
	private int id;
	private String description;
	private int teacherid;
	
	public CourseDTO() {}
	
	public CourseDTO(int id, String description, int teacherid) {
		this.id = id;
		this.description = description;
		this.teacherid = teacherid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

}
