package edu.handong.csee.java.javaFinalProject.datamodel;

public class graph {

	private String studentId;
	private String title;
	private String number;
	private String type;
	private String comment;
	private String page;

	public graph(String studentId) { // constructor
			
			this.setStudentId(studentId);
			//coursesTaken = new ArrayList<Course>();
			//semestersByYearAndSemester = new HashMap<String,Integer>();
			
		}
	
	public String toString() {
        return "graph ["
        		+   "studentId ="  	+ studentId 
    		    + ", title ="  		+ title
    		    + ", number ="  	+ number
    		    + ", type ="  		+ type
    		    + ", comment ="  	+ comment
    		    + ", page ="  		+ page
       		    + "]";
    }
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	
}
