package com.lt.crs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lt.crs.entity.Student;

public interface StundentRepository extends JpaRepository<Student, Integer> {
}
