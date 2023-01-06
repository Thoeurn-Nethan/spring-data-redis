package com.redis.springdataredis.repository;

import java.util.List;

import com.redis.springdataredis.model.Student;

public interface StudentDAO {

	boolean saveUser(Student student);

	List<Student> fetchAllStudent();

	Student fetchStudentById(Long id);

    void deleteStudent(Long id);
    List<Object> findAll();

}
