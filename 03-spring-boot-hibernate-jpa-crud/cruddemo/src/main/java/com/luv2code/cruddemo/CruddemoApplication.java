package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
			return runner -> {
				//createStudent(studentDAO);
				createMultipleStudents(studentDAO);
				//findStudentById(studentDAO);
				//findAllStudents(studentDAO);
				//findStudentByLastName(studentDAO);
				//updateStudentById(studentDAO);
				//deleteStudentById(studentDAO);
				//deleteAllStudents(studentDAO);

			};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numberOfDeletedStudents = studentDAO.deleteAll();
		System.out.println("Deleted rows count = " + numberOfDeletedStudents);
	}

	private void deleteStudentById(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Looking for student with id = " + studentId + "...");
		System.out.println("Deleting the student...");
		studentDAO.delete(studentId);
		System.out.println("Student deleted successfully.");
	}

	private void updateStudentById(StudentDAO studentDAO) {
		String firstNameToUpdate = "Scooby";
		System.out.println("Looking for student to update");
		Student myStudent = studentDAO.findById(1);
		System.out.println("Student found performing update");
		myStudent.setFirstName(firstNameToUpdate);
		System.out.println("Saving updated student to database");
		System.out.println("Student updated: " + myStudent);

	}

	private void findStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Chornobai");
		for(Student student : theStudents){
			System.out.println(student);
		}
	}

	private void findAllStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void findStudentById(StudentDAO studentDAO) {
		System.out.println("Creating new student");
		Student tempStudent = new Student("Tania","Borovyk","tania@someserv.com");
		studentDAO.save(tempStudent);
		int myStudentId = tempStudent.getId();
		System.out.println("New student is created with generated id " + myStudentId);
		Student myStudent = studentDAO.findById(myStudentId);
		System.out.println("Retrieving student created student " + myStudent);

	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 students objects ...");
		Student tempStudent1 = new Student("Vovk", "Vovkiv", "vovk@someserv.com");
		Student tempStudent2 = new Student("Vedmid", "Vedmediv", "vedmid@someserv.com");
		Student tempStudent3 = new Student("Lys", "Lysiv", "lys@someserv.com");

		System.out.println("Saving 3 students into database ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.printf("3 students successfully saved with id: %d, %d, %d", tempStudent1.getId(), tempStudent2.getId(), tempStudent3.getId()).println();
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student tempStudent = new Student("Vovk", "Vovkiv", "vovk@someserv.com");

		System.out.println("Saving student...");
		studentDAO.save(tempStudent);

		System.out.println("Student successfully saved with id " + tempStudent.getId());
	}

}
