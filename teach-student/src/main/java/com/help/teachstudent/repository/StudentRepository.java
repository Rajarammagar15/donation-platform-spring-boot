package com.help.teachstudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.help.teachstudent.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	boolean existsByAadhaarNumber(String aadhaarNumber);
    boolean existsByBankAccountNumber(String bankAccountNumber);
}
