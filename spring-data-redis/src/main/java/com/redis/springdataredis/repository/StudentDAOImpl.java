package com.redis.springdataredis.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.redis.springdataredis.model.Student;

@Repository
public class StudentDAOImpl  implements StudentDAO{
	
	private final String KEY= "STUDENT";
	
	@Autowired 
	private RedisTemplate<String,Object> redisTemplate;
	
	@Override
	public boolean saveUser(Student student) {
		try {
			redisTemplate.opsForHash().put(KEY, student.getId(), student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<Student> fetchAllStudent(){
		// return redisTemplate.opsForHash().values(KEY);
		return null;
	}

	@Override
	public Student fetchStudentById(Long id) {
		// List<Student> students;
		// students.add(redisTemplate.opsForHash().get(KEY,id));
		return (Student) redisTemplate.opsForHash().get(KEY,id);
	}

	@Override
	public void deleteStudent(Long id) {
		redisTemplate.opsForHash().delete(KEY,id);
	}

	@Override
	public List<Object> findAll() {
		return redisTemplate.opsForHash().values(KEY);
	}

    
}
