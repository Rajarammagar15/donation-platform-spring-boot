package com.help.teachstudent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.help.teachstudent.model.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {

	boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
}
