package com.lt.crs.service;

import java.util.List;

import com.lt.crs.dao.StudentCourseDetailsDto;
import com.lt.crs.entity.StudentGrade;
/**
 * 
 * @author G1
 *ProfessorService interface
 */
public interface ProfessorService {
	/**
	 * 
	 * @param studentGrade
	 * @return
	 */
	public String addGradeForStudent(StudentGrade studentGrade);
	/**
	 * 
	 * @param professorId
	 * @return
	 */
	public List<StudentCourseDetailsDto> viewEnrolledStudents(int professorId);

}
