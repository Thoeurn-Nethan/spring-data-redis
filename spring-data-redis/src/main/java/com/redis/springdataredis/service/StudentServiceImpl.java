package com.redis.springdataredis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.springdataredis.model.Student;
import com.redis.springdataredis.repository.StudentDAO;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired 
	private StudentDAO studentDAO;
	
	@Override
	public boolean saveUser(Student student) {
		return studentDAO.saveUser(student);
	}

	@Override
	public List<Student> fetchAllStudent() {
		return studentDAO.fetchAllStudent();
	}

	@Override
	public Student fetchStudentById(Long id) {
		return studentDAO.fetchStudentById(id);
	}

	@Override
	public void deleteStudent(Long id) {
		studentDAO.deleteStudent(id);
	}

	@Override
	public List<Object> findAll() {
		return studentDAO.findAll();
	}
    
}
