package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

	// make this class as instructor as table and map this class to that table

	// create fields in the class for table columns

	// define the columns names

	// add field of the constructorDetails class for making foreign key relation

	// create constructor for constructor injection

	// setter and getter methods

	// to string method

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "instructor_name")
	private String instructorName;
	@Column(name = "instructor_email")
	private String instructorEmail;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_details_id")
	private InstructorDetails instructorDetails;

	public Instructor() {
	}

	public Instructor(String instructorName, String instructorEmail) {
		this.instructorEmail = instructorEmail;
		this.instructorName = instructorName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}

	public int getId() {
		return this.id;
	}

	public String getInstructorName() {
		return this.instructorName;
	}

	public String getInstructorEmail() {
		return this.instructorEmail;
	}

	public InstructorDetails getInstructorDetails() {
		return instructorDetails;
	}

	public void setInstructorDetails(InstructorDetails instructorDetails) {
		this.instructorDetails = instructorDetails;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", instructorName=" + instructorName + ", instructorEmail=" + instructorEmail
				+ ", instructorDetails=" + instructorDetails + "]";
	}

}
