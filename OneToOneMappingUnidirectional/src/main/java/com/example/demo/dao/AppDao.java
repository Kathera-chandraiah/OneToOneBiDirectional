package com.example.demo.dao;

import com.example.demo.entity.Instructor;

public interface AppDao {

	void save(Instructor instructor);
	Instructor getInstructorById(int id);
	void deleteInstructorById(int id);
}
