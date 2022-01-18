package com.lt.crs.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.dao.CourseProfessorDto;
import com.lt.crs.dao.EnrolledCourseDto;
import com.lt.crs.dao.PaymentDto;
import com.lt.crs.entity.Payment;
import com.lt.crs.entity.StudentCourse;
import com.lt.crs.entity.StudentGrade;
import com.lt.crs.service.StudentService;
/**
 * 
 * @author G1
 * 
 *StudentController class includes all the rest endpoints of student operations
 */
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	/**
	 * 
	 * @param student
	 * @return
	 */
	@RequestMapping( method = RequestMethod.POST,value = "/enrollCourse")
	public ResponseEntity<String> addCourse(@RequestBody StudentCourse student) {
		studentService.addCourseToTheStudent(student);
		return new ResponseEntity<String>("Course added", HttpStatus.OK);
	}
	/**
	 * 
	 * @return CourseProfessorDto
	 */
	@RequestMapping( method = RequestMethod.GET,value = "/viewCourses")
	public ResponseEntity<List<CourseProfessorDto>> getAllCourese() {
	List<CourseProfessorDto> courses=studentService.getAllCourses();
	 return new ResponseEntity <List<CourseProfessorDto>>(courses, HttpStatus.OK);
		
	}
	/**
	 * 
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	@RequestMapping( method = RequestMethod.DELETE,value = "/dropCourse")
	public ResponseEntity<String> dropCourse(@RequestParam int studentId ,@RequestParam int  courseId) {
		studentService.dropCourse(studentId ,courseId);
		return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
	}
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@RequestMapping( method = RequestMethod.GET,value = "/viewMyCourse")
	public ResponseEntity<List<EnrolledCourseDto>> viewEnrolledCourses(@RequestParam int studentId) {
		List<EnrolledCourseDto> viewStudentsDto=studentService.viewEnrolledCourses(studentId);
		return new ResponseEntity<List<EnrolledCourseDto>>(viewStudentsDto, HttpStatus.OK);
	}
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	@RequestMapping( method = RequestMethod.GET,value = "/viewReportcard")

	public ResponseEntity<List<StudentGrade>> viewReportCard(@RequestParam int studentId) {
		List<StudentGrade> studentGrades=studentService.viewReportCard(studentId);
		return new ResponseEntity<List<StudentGrade>>(studentGrades, HttpStatus.OK);
	}
	/**
	 * 
	 * @param paymentDto
	 * @return
	 */
	@RequestMapping( method = RequestMethod.POST,value = "/makePayment")
	public ResponseEntity<String> payment(@RequestBody PaymentDto paymentDto) {
		Payment payment=studentService.makePayment(paymentDto);
		return new ResponseEntity<String>("Payment Done Successfully with Payment ID: "+payment.getPaymentId()+" "+"Amount :"+payment.getAmount(), HttpStatus.OK);
	}
}
