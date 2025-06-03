package com.example.demo.dao;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetails;

public interface AppDao {

	void save(Instructor instructor);
	Instructor getInstructorById(int id);
	void deleteInstructorById(int id);
	InstructorDetails getInstructorDetailsById(int theId);
	void deleteInstructorDetailsById(int theId);
}
