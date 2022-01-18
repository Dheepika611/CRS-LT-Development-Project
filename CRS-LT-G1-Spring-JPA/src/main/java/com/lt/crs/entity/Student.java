package com.lt.crs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author G1
 *
 */
@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentID;
	private String studentName;
	@JsonIgnore
	private String password;
	private String studentDepartment;
	private boolean isApproved;
	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}
	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
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
	/**
	 * @return the isApproved
	 */
	public boolean isApproved() {
		return isApproved;
	}
	/**
	 * @param isApproved the isApproved to set
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
}
