package com.help.teachstudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.help.teachstudent.model.Student;
import com.help.teachstudent.service.StudentService;

@RestController
@RequestMapping("/help-students-to-grow")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/register-student")
	public ResponseEntity<String> registerStudent(@Validated @RequestBody Student student){
		try {
	        studentService.registerStudent(student);
	        return ResponseEntity.ok("Student registered successfully.");
	    } catch (RuntimeException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}
	
	@GetMapping("/list")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
