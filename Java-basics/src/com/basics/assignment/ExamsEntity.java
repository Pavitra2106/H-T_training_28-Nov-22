package com.basics.assignment;

public class ExamsEntity {
	private int courseId;
	private String courseName;
    private String courseTeacher;
    private int courseDuration;
    private int totalFees;
    
    public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseTeacher() {
		return courseTeacher;
	}
	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	public int getTotalFees() {
		return totalFees;
	}
	public void setTotalFees(int totalFees) {
		this.totalFees = totalFees;
	}
	public ExamsEntity(int courseId, String courseTeacher, String courseName, int courseDuration, int totalFees) {
		super();
		this.courseId = courseId;
		this.courseTeacher = courseTeacher;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.totalFees = totalFees;
	}
	@Override
	public String toString() {
		return "ExamsEntity [courseId=" + courseId + ", courseTeacher=" + courseTeacher + ", courseName=" + courseName
				+ ", courseDuration=" + courseDuration + ", totalFees=" + totalFees + "]";
	}

}
