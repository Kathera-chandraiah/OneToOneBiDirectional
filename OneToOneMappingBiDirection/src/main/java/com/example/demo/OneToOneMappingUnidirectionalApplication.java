package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDao;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetails;

@SpringBootApplication
public class OneToOneMappingUnidirectionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingUnidirectionalApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner ->{
	//		createInstructor(appDao);
//			getInstructorById(appDao);
//			deleteInstructorById(appDao);
	//		getInstructorDetailsById(appDao);
			deleteInstructorDetailsById(appDao);
			
		};
	}
	
	private void getInstructorDetailsById(AppDao appDao) {
		
		int theId=1;
		
		System.out.println("InstructorDetails id"+ theId);
		
		InstructorDetails tempInstructorDetails =appDao.getInstructorDetailsById(theId);

		//print the instructorDetails 
		System.out.println("TempInstructorDetails"+tempInstructorDetails);
		
		//print the assosiate instructor
		System.out.println("instructor details"+ tempInstructorDetails.getInstructor());
		
	}

	private void deleteInstructorById(AppDao appDao) {

		int theId=1;
		System.out.println("Instructor id :"+theId);
		appDao.deleteInstructorById(theId);
	}

	public void createInstructor(AppDao appDao) {
		
		//create instructor object
		//create instructor details object
		
		//set instructor details object into the instructor object
		//save the instructor object
		
//		Instructor instructor = new Instructor("chandu","chandu123@gmail.com");
//		InstructorDetails instructorDetails= new InstructorDetails("games","rechini");
		Instructor instructor = new Instructor("mallesh","mallesh123@gmail.com");
		InstructorDetails instructorDetails= new InstructorDetails("books","rechini");
		instructor.setInstructorDetails(instructorDetails);
		appDao.save(instructor);
		
	}

	public void getInstructorById(AppDao appDao) {
		Instructor instructor=appDao.getInstructorById(1);
		System.out.println("instructor details"+instructor);
		System.out.println("instructor details info"+instructor.getInstructorDetails());
		System.out.println("*****done*********");
	}
	
	public void deleteInstructorDetailsById(AppDao appDao) {
		int theId=2;
		appDao.deleteInstructorDetailsById(theId);
	}
}
