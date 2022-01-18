package com.lt.crs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.dao.ProfessorDto;
import com.lt.crs.entity.Course;
import com.lt.crs.entity.Professor;
import com.lt.crs.entity.Student;
import com.lt.crs.entity.StudentGrade;
import com.lt.crs.service.AdminService;

/**
 * This is AdminController class where admin related end points are there
 * 
 * @author G1
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	AdminService adminService;

	/**
	 * Add course restEndPoint is used by the admin to add the new course details
	 * into database
	 * 
	 * @param course
	 * @return
	 */
	@RequestMapping( method = RequestMethod.POST,value = "/addCourse")
	public ResponseEntity<String> saveCourse(@RequestBody Course course) {
		course = adminService.saveCourse(course);
		logger.info("Course added"+ course.getCourseId());
		return new ResponseEntity<String>("New Course# "+course.getCourseId() +"added successfully",HttpStatus.OK);
	}

	/**
	 * Delete the course by course id by the admin
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping( method = RequestMethod.DELETE,value = "/removeCourse/{id}")
	public ResponseEntity<String> deleteCourseById(@PathVariable int id) {
		adminService.deleteCourseById(id);
		logger.info("Course deleted Id:" + id);
		return new ResponseEntity<String>("Course# "+id+" removed successfully", HttpStatus.OK);
	}

	/**
	 * Admin adds the professor
	 * 
	 * @param professorDto
	 * @return
	 */
	@RequestMapping( method = RequestMethod.POST,value = "/addProfessor")
	public ResponseEntity<String> saveProfessor(@RequestBody ProfessorDto professorDto) {
		Professor professor = adminService.saveProfessor(professorDto);
		logger.info("Professor is saved with Id :" + professor.getProfessorId());
		return new ResponseEntity<String>(
				"Professor# "+professor.getProfessorId()+" added successfully", HttpStatus.OK);
	}

	/**
	 * Deletes the professor from the professor table
	 * 
	 * @param professorId
	 * @return
	 */

	@RequestMapping( method = RequestMethod.DELETE,value = "/removeProfessor/{professorId}")
	public ResponseEntity<String> deleteProfessorById(@PathVariable int professorId) {
		logger.info("In Remove professor method admin controller class");
		adminService.deleteProfessorById(professorId);
		logger.info("Professor is deleted with Id :" + professorId);
		return new ResponseEntity<String>("professor is deleted successfully with Id" + " " + professorId,
				HttpStatus.OK);
	}

	/**
	 * Admin approves the admin registration
	 * 
	 * @param studentId
	 * @return
	 */

	//@GetMapping("/approveStudent")
	@RequestMapping( method = RequestMethod.GET,value = "/approveStudent")
	public ResponseEntity<String> approveStudent(@RequestParam int studentId) {
		logger.info("In approveStudent method admin controller class");
		Student student = adminService.approveStudent(studentId);
		logger.info("Approved student Id :"+studentId);
		return new ResponseEntity<String>("Student# "+student.getStudentID()+" Successfully Approved." ,HttpStatus.OK);
	}

	/**
	 * This RestEndPoint is for Rejecting the student registration
	 * 
	 * @param studentId
	 * @return
	 */

	//@DeleteMapping("/rejectStudent")
	@RequestMapping( method = RequestMethod.DELETE,value = "/rejectStudent")
	public ResponseEntity<String> rejectStudent(@RequestParam int studentId) {
		logger.info("In rejectStudent method admin controller class");
		Student student = adminService.rejectStudent(studentId);
		logger.info("Rejected student Id:"+studentId);
		return new ResponseEntity<String>("Student# "+student.getStudentID()+" Rejected..",
				HttpStatus.OK);
	}

	/**
	 * This endpoint is used for genarating the report card for the students by the
	 * admin.
	 * 
	 * @return Report card
	 */
	//@GetMapping("/generateReportCard")
	@RequestMapping( method = RequestMethod.GET,value = "/generateReportCard")
	public ResponseEntity<List<StudentGrade>> generateReportCard() {
		logger.info("In generateReportCard method admin controller class");
		List<StudentGrade> grades = adminService.generateReportCard();
		logger.info("Generating Report card"+grades);
		return new ResponseEntity<List<StudentGrade>>(grades, HttpStatus.OK);
	}

}
