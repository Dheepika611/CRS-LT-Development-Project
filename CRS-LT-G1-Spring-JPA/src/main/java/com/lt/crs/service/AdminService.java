package com.lt.crs.service;


import java.util.List;

import com.lt.crs.dao.ProfessorDto;
import com.lt.crs.entity.Course;
import com.lt.crs.entity.Professor;
import com.lt.crs.entity.Student;
import com.lt.crs.entity.StudentGrade;
/**
 * 
 * @author G1
 * 
 *AdminService interface includes the admin operations
 */
public interface AdminService {
/**
 * 
 * @param course
 * @return
 */
	Course saveCourse(Course course);
/**
 * 
 * @param id
 */
	void deleteCourseById(int id);
	/**
	 * 
	 * @param professorDto
	 * @return
	 */

	Professor saveProfessor(ProfessorDto professorDto);
/**
 * 
 * @param professorId
 */
	void deleteProfessorById(int professorId);
	/**
	 * 
	 * @param studentId
	 * @return
	 */

	Student approveStudent(int studentId);
	/**
	 * 
	 * @param studentId
	 * @return
	 */

	Student rejectStudent(int studentId);

/**
 * 
 * @return
 */
	List<StudentGrade> generateReportCard();

}
