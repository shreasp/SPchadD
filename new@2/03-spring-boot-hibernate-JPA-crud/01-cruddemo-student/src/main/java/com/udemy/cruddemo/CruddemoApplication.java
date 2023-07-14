package com.udemy.cruddemo;

import com.udemy.cruddemo.dao.StudentDAO;
import com.udemy.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Hey!..Creating a new student object");
		Student tempStudent1 = new Student("john","Doe","john@udemy.com");
		Student tempStudent2 = new Student("johny","Doe","johny@udemy.com");
		Student tempStudent3 = new Student("johnson","Doe","johnson@udemy.com");

		//save those students
		System.out.println("saving the Students....data...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Hey!..Creating a new student object");
		Student tempStudent = new Student("Paul","Doe","paul@udemy.com");


		// save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);


		// display the id of the saved student
		System.out.println("Saved student. Generated id is :" + tempStudent.getId());


	}
}
