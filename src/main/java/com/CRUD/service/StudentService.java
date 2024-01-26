package com.CRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUD.Repository.StudentRepository;
import com.CRUD.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentrepo;
	
	public List<Student> getAllStudents(){
		return studentrepo.findAll();	
	}
	public Optional<Student> getStudentById(Long Id){
		return studentrepo.findById(Id);
	}
	public Student createStudent(Student student) {
        return studentrepo.save(student);
    }
	public Student updateStudent(Long id, Student updatedStudent) {
        Optional<Student> existingStudent = studentrepo.findById(id);

        if (existingStudent.isPresent()) {
            Student student = existingStudent.get();
            student.setName(updatedStudent.getName());
            student.setAge(updatedStudent.getAge());
            student.setCity(updatedStudent.getCity());
            student.setMarks(updatedStudent.getMarks());
            return studentrepo.save(student);
        } else {
            return null;
        }
    }
	 public void deleteStudent(Long id) {
	        studentrepo.deleteById(id);
	    }
	public List<Student> saveMultipleStudents(List<Student> students) {
		studentrepo.saveAll(students);
		return students;
	}
	 

	
	
	

}
