package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor_details")
public class InstructorDetails {

	// make this class as a table and map this to the db table

	// create fields of the class and map those fields as db columns

	// create field of instructor class and make the bidirection relationship

	// create setter and getter method

	// create a constructor for constructor injection

	// create setter and getter methods

	// create tostring method

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "instructor_hobby")
	private String instructorHobby;
	@Column(name = "instructor_address")
	private String instructorAddress;

	@OneToOne(mappedBy = "instructorDetails", cascade = { CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH })
	private Instructor instructor;

	public InstructorDetails() {

	}

	public InstructorDetails(String instructorHobby, String instructorAddress) {
		this.instructorHobby = instructorHobby;
		this.instructorAddress = instructorAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstructorHobby() {
		return instructorHobby;
	}

	public void setInstructorHobby(String instructorHobby) {
		this.instructorHobby = instructorHobby;
	}

	public String getInstructorAddress() {
		return instructorAddress;
	}

	public void setInstructorAddress(String instructorAddress) {
		this.instructorAddress = instructorAddress;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", instructorHobby=" + instructorHobby + ", instructorAddress="
				+ instructorAddress + "]";
	}

}
