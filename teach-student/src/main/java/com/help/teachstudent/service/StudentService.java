package com.help.teachstudent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.teachstudent.model.Student;
import com.help.teachstudent.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student registerStudent(Student student) {
        if (studentRepository.existsByAadhaarNumber(student.getAadhaarNumber())) {
            throw new IllegalArgumentException("Aadhaar number already exists");
        }
        if (studentRepository.existsByBankAccountNumber(student.getBankAccountNumber())) {
            throw new IllegalArgumentException("Bank account is already linked to another Aadhaar");
        }
        return studentRepository.save(student);
    }

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
}
