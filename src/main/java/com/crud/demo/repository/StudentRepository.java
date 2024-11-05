package com.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
