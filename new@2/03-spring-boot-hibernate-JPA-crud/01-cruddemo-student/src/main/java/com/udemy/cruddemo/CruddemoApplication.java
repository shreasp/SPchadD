package com.udemy.cruddemo;

import com.udemy.cruddemo.dao.StudentDAO;
import com.udemy.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{

			//createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);
			
			//queryForStudentsByLastName(studentDAO);


		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List <Student> theStudents= studentDAO.findByLastName("Duck");

		// display the list of students
		for(Student tempStudent :theStudents){
			System.out.println(tempStudent);
		}



	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get a list of students \
		List <Student> theStudents =studentDAO.findAll();
		// Display the list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating Student object....");
		Student tempStudent= new Student("Daffy ","Duck ", "daffy@udemy.com");


		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved Student . Generated id : "+ theId);


		// retrieve the student based on the primary key : id
		System.out.println("Retriving the student with id :"+ theId);
		Student myStudent =studentDAO.findById(theId);

		// display student
		System.out.println("Found the student :"+ myStudent);


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
