package edu.handong.csee.java.javaFinalProject.datamodel;

public class summaryT<T> {
	
	public summaryT(T studentId) { // constructor

		this.setStudentId(studentId);
		// coursesTaken = new ArrayList<Course>();
		// semestersByYearAndSemester = new HashMap<String,Integer>();

	}

	public String toString() {
		return "summary [" + "studentId =" + studentId + ", title =" + title + ", summarys =" + summarys + ", keyword ="
				+ keyword + ", date =" + date + ", link =" + link + ", sourse =" + sourse + ", copyRight =" + copyRight
				+ "]";
	}

	private T studentId;
	public T getStudentId() {
		return studentId;
	}

	public void setStudentId(T studentId) {
		this.studentId = studentId;
	}

	public T getTitle() {
		return title;
	}

	public void setTitle(T title) {
		this.title = title;
	}

	public T getSummarys() {
		return summarys;
	}

	public void setSummarys(T summarys) {
		this.summarys = summarys;
	}

	public T getKeyword() {
		return keyword;
	}

	public void setKeyword(T keyword) {
		this.keyword = keyword;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}

	public T getLink() {
		return link;
	}

	public void setLink(T link) {
		this.link = link;
	}

	public T getSourse() {
		return sourse;
	}

	public void setSourse(T sourse) {
		this.sourse = sourse;
	}

	public T getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(T copyRight) {
		this.copyRight = copyRight;
	}

	private T title;
	private T summarys;
	private T keyword;
	private T date;
	private T link;
	private T sourse;
	private T copyRight;

	

}
