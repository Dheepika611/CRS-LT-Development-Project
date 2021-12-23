package com.lt.crs.bean;
/**
 * 
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This is the bean class for Student
 *
 */
public class Student {
	
private int studentId;
private static String studentName;
private String dept;

public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public static String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
}
