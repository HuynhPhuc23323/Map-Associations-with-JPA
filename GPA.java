package com.javainuse.springbootcrudstudent.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class GPA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGPA;
	
	@OneToOne
	@Autowired
	private Student student;
	
	private double gpa;
	
	
	public Long getIdGPA() {
		return idGPA;
	}

	public void setIdGPA(Long idGPA) {
		this.idGPA = idGPA;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	
	
}
