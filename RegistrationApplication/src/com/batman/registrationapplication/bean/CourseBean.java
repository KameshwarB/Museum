package com.batman.registrationapplication.bean;




public class CourseBean {
	private int courseId;
	private String courseName;
	private int courseDuration;
	private float courseFees;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
	public float getCourseFees() {
		return courseFees;
	}
	public void setCourseFees(float courseFees) {
		this.courseFees = courseFees;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Printing Course Details \n");
		sb.append("Course Id: " +courseId +"\n");
		sb.append("Course Name: "+ courseName +"\n");
		sb.append("Course Duration: "+ courseDuration +"\n");
		sb.append("Course Fees: "+ courseFees +"\n");
		return sb.toString();
	}


}
