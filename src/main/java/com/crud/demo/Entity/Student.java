package com.crud.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor 
//@NoArgsConstructor
@Entity
public class Student {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String studentName;
	private String studentAge;
	private String branch;
	private String address;
	
	public Student() {
		super();
		
	}

	public Student(long id, String studentName, String studentAge, String branch, String address) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.branch = branch;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "id:" + id + ",Name :" + studentName+ ",Age :" + studentAge + ",branch :" + branch + ",Address :" + address;
		
	} 

}
