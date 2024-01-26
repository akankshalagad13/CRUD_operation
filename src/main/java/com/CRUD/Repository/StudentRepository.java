package com.CRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
