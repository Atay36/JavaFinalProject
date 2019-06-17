package edu.handong.csee.java.javaFinalProject.datamodel;

public class graphT<T> {

	private T studentId;
	private T number;
	private T type;
	private T comment;
	private T page;

	public void setStudentId(T studentId) {
		this.studentId = studentId;
	}

	public void setTitle(T title) {
		this.title = title;
	}

	public void setNumber(T number) {
		this.number = number;
	}

	public void setType(T type) {
		this.type = type;
	}

	public void setComment(T comment) {
		this.comment = comment;
	}

	public void setPage(T page) {
		this.page = page;
	}

	private T title;

	public T getStudentId() {
		return studentId;
	}

	public T getTitle() {
		return title;
	}

	public T getNumber() {
		return number;
	}

	public T getType() {
		return type;
	}

	public T getComment() {
		return comment;
	}

	public T getPage() {
		return page;
	}

	public graphT(T studentId) { // constructor

		this.setStudentId(studentId);
		// coursesTaken = new ArrayList<Course>();
		// semestersByYearAndSemester = new HashMap<String,Integer>();

	}

	public String toString() {
		return "graph [" + "studentId =" + studentId + ", title =" + title + ", number =" + number + ", type =" + type
				+ ", comment =" + comment + ", page =" + page + "]";
	}

}
