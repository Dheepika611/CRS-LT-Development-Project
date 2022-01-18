package com.lt.crs.service;

import java.util.List;

import com.lt.crs.dao.CourseProfessorDto;
import com.lt.crs.dao.EnrolledCourseDto;
import com.lt.crs.dao.PaymentDto;
import com.lt.crs.entity.Payment;
import com.lt.crs.entity.StudentCourse;
import com.lt.crs.entity.StudentGrade;
/**
 * 
 * @author G1
 *StudentService interface includes student abstract methods
 */
public interface StudentService {
	/**
	 * 
	 * @param student
	 */
	public void addCourseToTheStudent(StudentCourse student) ;
	/**
	 * 
	 * @param studentId
	 * @param courseId
	 */
	public void dropCourse(int studentId, int courseId);
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public List<EnrolledCourseDto> viewEnrolledCourses(int studentId) ;
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public List<StudentGrade> viewReportCard(int studentId);
	/**
	 * 
	 * @param paymentDto
	 * @return
	 */
	public Payment makePayment(PaymentDto paymentDto);
	/**
	 * 
	 * @return
	 */
	public List<CourseProfessorDto> getAllCourses();
	

}
