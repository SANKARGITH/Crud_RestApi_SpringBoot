package com.crud.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.Entity.Student;
import com.crud.demo.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/api/student")
	public ResponseEntity<Student> postStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentRepository.save(student),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/student")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<>(studentRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/api/student/{id}")
	public ResponseEntity<Student> getstudent(@PathVariable Long id) {
	     Optional<Student> student = studentRepository.findById(id);
 		if(student.isPresent()) {
 			return new ResponseEntity<>(student.get(),HttpStatus.OK);
 		}else {
 			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 		}
		
	}
	
	@PutMapping("/api/student/{id}")
	public ResponseEntity<Student> editStudent(@PathVariable Long id,@RequestBody Student st) {
	     Optional<Student> student = studentRepository.findById(id);
 		if(student.isPresent()) {
 			student.get().setStudentName(st.getStudentName());
 			student.get().setStudentAge(st.getStudentAge());
 			student.get().setAddress(st.getAddress());
 			student.get().setBranch(st.getBranch());
 			return new ResponseEntity<>(studentRepository.save(student.get()),HttpStatus.OK);
 		}else {
 			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 		}
		
	}
	
	@DeleteMapping("/api/student/delete/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable Long id){
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) {
			studentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	

}
