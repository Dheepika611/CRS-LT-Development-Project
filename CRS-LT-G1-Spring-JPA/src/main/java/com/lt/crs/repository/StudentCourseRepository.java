package com.lt.crs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.crs.entity.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
	/*
	 * @Query(value = "SELECT s FROM Student_Course where s.studentId=?1") public
	 * List<Student_Course> findByStudentId(int studentId);
	 */

	public StudentCourse findByCourseIdAndStudentId(int courseId, int studentId);

	public void deleteByStudentIdAndCourseId(int studentId, int courseId);

	public List<StudentCourse> findByStudentId(int studentId);

	public List<StudentCourse> findByProfessorId(int professorId);

	public int countByCourseId(int id);

}
