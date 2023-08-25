package com.day4_portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.day4_portal.model.Student;


public interface StudentRepo extends JpaRepository<Student,Integer>{

	Optional<Student>findById(Long id);
	Optional<Student>deleteById(Long id);
	boolean existsByMailid(String mailid);

}