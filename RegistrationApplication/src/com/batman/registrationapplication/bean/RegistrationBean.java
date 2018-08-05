package com.batman.registrationapplication.bean;

import java.util.Date;

public class RegistrationBean {
	private StudentBean sobj;
	private CourseBean cobj;
	private Date DOJ;
	private String grade;
	private String status;
	
	public StudentBean getSobj() {
		return sobj;
	}
	public void setSobj(StudentBean sobj) {
		this.sobj = sobj;
	}
	
	public CourseBean getCobj() {
		return cobj;
	}
	public void setCobj(CourseBean cobj) {
		this.cobj = cobj;
	}
	public Date getDOJ() {
		return DOJ;
	}
	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String string) {
		this.grade = string;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public RegistrationBean(StudentBean sobj, CourseBean cobj, Date dOJ,
			String grade) {
		super();
		this.sobj = sobj;
		this.cobj = cobj;
		this.DOJ = dOJ;
		this.grade = grade;
		this.status = "Active";
	}
	public RegistrationBean() {
		
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Printing Registration Details \n");
		sb.append("Student Id    : "+ sobj.getStudentId());
		sb.append("Course Id     : "+ cobj.getCourseId());
		sb.append("Date of joinig: "+ DOJ +"\n");
		sb.append("Grade         : "+ grade +"\n");
		sb.append("Status        : "+ status +"\n");
		
		return sb.toString();
	}
	
}
