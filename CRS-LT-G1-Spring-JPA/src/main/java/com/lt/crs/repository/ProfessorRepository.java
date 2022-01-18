package com.lt.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.crs.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
