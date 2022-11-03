package gr.aueb.sev.model;

public class Course {
	private int id;
	private String description;
	private int teacherid;
	
	public Course() {}
	
	public Course(int id, String description, int teacherid) {
		super();
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
