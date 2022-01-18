/**
 * 
 */
package com.lt.crs.dao;


/**
 * @author G1
 *
 */
public class StudentDto {
	private String studentName;
	
	private String password;
	private String studentDepartment;
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the studentDepartment
	 */
	public String getStudentDepartment() {
		return studentDepartment;
	}
	/**
	 * @param studentDepartment the studentDepartment to set
	 */
	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	

}
