package com.javainuse.springbootcrudstudent.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "db_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="student_name", nullable = false)
	private String studentName;

	//quan he
	//Don huong va da huong la gi??
	
	//one-many
	@OneToMany(mappedBy ="student")
	@Autowired
	private List<Address> Addresses = new ArrayList<Address>();
	
	@OneToOne
	@JoinColumn(name="fk_gpa")
	@Autowired
	private GPA gpaOfStudent;	
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="fk_course")
	private Course course;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public List<Address> getAddresses() {
		return Addresses;
	}

	public void setAddresses(List<Address> addresses) {
		Addresses = addresses;
	}	
	
	public GPA getGpaOfStudent() {
		return gpaOfStudent;
	}

	public void setGpaOfStudent(GPA gpaOfStudent) {
		this.gpaOfStudent = gpaOfStudent;
	}	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	//quan he
	public void addAddress(Address add) {
		this.Addresses.add(add);
		add.setStudent(this);
	}
	
}
