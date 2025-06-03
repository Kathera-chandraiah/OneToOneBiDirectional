package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetails;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImpl implements AppDao {

	// create an object entitymanager class

	private EntityManager entityManager;

	// constructor injection for entitymanager class

	@Autowired
	public AppDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
	}

	@Override
	public Instructor getInstructorById(int id) {
		return entityManager.find(Instructor.class, id);

	}

	@Override
	@Transactional
	public void deleteInstructorById(int id) {

		// get the instructor details by id
		// remove instructor details and as well as associated instructor details
		Instructor tempInstructor = entityManager.find(Instructor.class, id);
		entityManager.remove(tempInstructor);
	}

	@Override
	public InstructorDetails getInstructorDetailsById(int theId) {
		// get the instructorDetails of the following id
		InstructorDetails tempInstructorDetails = entityManager.find(InstructorDetails.class, theId);

		return tempInstructorDetails;
	}

	@Override
	@Transactional
	public void deleteInstructorDetailsById(int theId) {

		// get the instructorDetails by id
		InstructorDetails tempInstructorDetails = entityManager.find(InstructorDetails.class, theId);
		
		// get the instructor and breaking bidirection relationship
		tempInstructorDetails.getInstructor().setInstructorDetails(null);
		
		// remove the instructordetails .Here the associated instructor also deleted
		entityManager.remove(tempInstructorDetails);

	}

}
