package com.redis.springdataredis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.springdataredis.model.Student;
import com.redis.springdataredis.service.StudentService;

@RestController
public class StudentController {

    @Autowired 
    private StudentService studentService;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody Student student){
        boolean result= studentService.saveUser(student);
        if(result) {
        	return ResponseEntity.ok("Student created successully!!");
        }
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<Student>> fetchAllStudent(){
        List<Student> student;
        student= studentService.fetchAllStudent();
        return ResponseEntity.ok(student);
    }

    @GetMapping("users")
    public ResponseEntity<List<Object>> findAll(){
        List<Object> obj;
        obj=studentService.findAll();
        return ResponseEntity.ok(obj);
    }
    @GetMapping("/user/{id}")
    public Student fetchStudentById(@PathVariable Long id){
        return studentService.fetchStudentById(id);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "Deleted";
    }

 
}
