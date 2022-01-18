package com.lt.crs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.dao.StudentCourseDetailsDto;
import com.lt.crs.entity.StudentGrade;
import com.lt.crs.service.ProfessorService;
/**
 * 
 * This is ProfessorController which contains professor related rest endpoints
 * 
 * @author G1
 *
 */
@RestController
@RequestMapping("/professor")
public class ProfessorController {
	public static final Logger logger = LoggerFactory.getLogger(ProfessorController.class);

	@Autowired
	ProfessorService professorService;
	/**
	 * This is viewEnrolledStudents endpoint student operation
	 * @param professorId
	 * @return
	 */
	//@GetMapping("/EnrolledStudents")
	@RequestMapping( method = RequestMethod.GET,value = "/EnrolledStudents")
	public ResponseEntity<List<StudentCourseDetailsDto> > viewEnrolledStudents(@RequestParam int professorId) {
		logger.info("Inside viewEnrolledStudents method");
		List<StudentCourseDetailsDto> studentCourseDetailsList=professorService.viewEnrolledStudents(professorId);
		logger.info("Enrolled student list :"+studentCourseDetailsList);
		return new ResponseEntity<List<StudentCourseDetailsDto> >(studentCourseDetailsList, HttpStatus.OK);
	}
	/**
	 * Add Grade Rest End point to add the grade for the studnet
	 * @param studentGrade
	 * @return
	 */
	//@PostMapping("grade")
	@RequestMapping( method = RequestMethod.POST,value = "/grade")
	public ResponseEntity<String > addGrade(@RequestBody StudentGrade studentGrade) {
		logger.info("Inside ADD GRADE method");
		String result=professorService.addGradeForStudent(studentGrade);
		logger.info("GRADE added for the student Id:"+result);
		return new ResponseEntity<String>("Grade has been added sucessFully for This student Id: "+" "+result, HttpStatus.OK);
	}

}
