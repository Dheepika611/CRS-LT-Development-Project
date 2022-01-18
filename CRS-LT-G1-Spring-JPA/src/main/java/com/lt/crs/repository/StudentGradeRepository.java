package com.lt.crs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lt.crs.entity.StudentGrade;

@Repository
public interface StudentGradeRepository extends JpaRepository<StudentGrade, Integer> {

	List<StudentGrade> findByStudentId(int studentId);
	

}
