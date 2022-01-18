/**
 * 
 */
package com.lt.crs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.crs.entity.CourseProfessor;

/**
 * @author G1
 *
 */
public interface CourseProfessorRepository extends JpaRepository<CourseProfessor, Integer> {

	List<CourseProfessor> findByCourseIdAndProfessorId(int courseId, int professorId);

	List<CourseProfessor> findByProfessorId(int professorId);

}
