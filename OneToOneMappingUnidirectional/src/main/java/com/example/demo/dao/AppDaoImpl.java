package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;

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

		//get the instructor details by id
		//remove instructor details and as well as associated instructor details 
		Instructor tempInstructor = entityManager.find(Instructor.class, id);
		entityManager.remove(tempInstructor);
	}

}
