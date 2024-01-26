package com.CRUD.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CRUD.entity.Student;
import com.CRUD.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentservice;

	@GetMapping(value = "/fetchdata")
	public List<Student> getStudent() {
		LOGGER.info("Fetching all student data ");
		List<Student> students = new ArrayList<Student>();
		students = studentservice.getAllStudents();
		return students;
	}

	@GetMapping(value = "/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id) {
		LOGGER.info("Fetching student data for : ", id);
		Optional<Student> student = Optional.of(new Student());
		student = studentservice.getStudentById(id);
		return student;
	}

	@PostMapping(value = "/save")
	public Student createStudent(@RequestBody Student student) {
		LOGGER.info("save student data of : ", student.getName());
		return studentservice.createStudent(student);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
		LOGGER.info("Fetching student data  for id :", id);
		return studentservice.updateStudent(id, updatedStudent);
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		LOGGER.info("deleting student data for id : ", id);
		String name = studentservice.getStudentById(id).get().getName();
		studentservice.deleteStudent(id);
		return name + "'s data deleted";
	}

	@PostMapping(value = "/savemultiple")
	public List<Student> saveMultipleStudents(@RequestBody List<Student> students) {
		List<Student> studentsList = new ArrayList<Student>();
		LOGGER.info("Fetching all student data ");
		studentsList = studentservice.saveMultipleStudents(students);
		return studentsList;
	}

}
