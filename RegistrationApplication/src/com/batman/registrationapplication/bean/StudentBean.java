package com.batman.registrationapplication.bean;


import java.util.Date;

public class StudentBean 
{
private int studentId;
private String studentName;
private String address;
private long phoneNumber;
private Date DOB;
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public Date getDOB() {
	return DOB;
}
public void setDOB(Date dOB) {
	DOB = dOB;
}
public String toString()
{
 StringBuilder sb = new StringBuilder();
 
 sb.append("Printing Student Details\n");
 sb.append("Student Id :" +studentId +"\n");
 sb.append("Student Name: " +studentName +"\n");
 sb.append("Student Address: "+ address +"\n");
 sb.append("Phone Number: "+ phoneNumber +"\n");
 sb.append("Date of Birth : "+DOB);
 return sb.toString();
}

}
