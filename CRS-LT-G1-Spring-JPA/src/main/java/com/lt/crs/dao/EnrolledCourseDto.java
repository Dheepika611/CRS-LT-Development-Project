package com.lt.crs.dao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lt.crs.entity.Student;

public class EnrolledCourseDto {
	@JsonIgnore
	private Student student;
	private int courseId;
	private String courseName;
	private int professorId;
	private String professorName;
	public Student getStudent() {
		return student;
	}
		public void setStudent(Student student) {
		this.student = student;
	}
		/**
		 * @return the courseId
		 */
		public int getCourseId() {
			return courseId;
		}
		/**
		 * @param courseId the courseId to set
		 */
		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}
		/**
		 * @return the courseName
		 */
		public String getCourseName() {
			return courseName;
		}
		/**
		 * @param courseName the courseName to set
		 */
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		/**
		 * @return the professorId
		 */
		public int getProfessorId() {
			return professorId;
		}
		/**
		 * @param professorId the professorId to set
		 */
		public void setProfessorId(int professorId) {
			this.professorId = professorId;
		}
		/**
		 * @return the professorName
		 */
		public String getProfessorName() {
			return professorName;
		}
		/**
		 * @param professorName the professorName to set
		 */
		public void setProfessorName(String professorName) {
			this.professorName = professorName;
		}
		
}
