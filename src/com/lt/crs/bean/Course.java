package com.lt.crs.bean;
/**
 * 
 * @author Dheepika, Himanshu, Sai, Nisha, Mamata
 * This is the bean class for Course
 *
 */
public class Course extends Student{

	private int courseId;
	private String courseName;
	private int semester;
	private String prereq;
	
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
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public String getPrereq() {
		return prereq;
	}
	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}
//	public int getMax() {
//		return max;
//	}
//	public int getMin() {
//		return min;
//	}
}
