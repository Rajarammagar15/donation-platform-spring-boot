package com.help.teachstudent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.teachstudent.model.Donor;
import com.help.teachstudent.repository.DonorRepository;

@Service
public class DonorService {

	@Autowired
    private DonorRepository donorRepository;

    public Donor registerDonor(Donor donor) {
        if (donorRepository.existsByEmail(donor.getEmail())) {
            throw new IllegalArgumentException("Email is already registered");
        }
        if (donorRepository.existsByPhoneNumber(donor.getPhoneNumber())) {
            throw new IllegalArgumentException("Phone number is already registered");
        }
        return donorRepository.save(donor);
    }

	public List<Donor> getAllDonors() {
		return donorRepository.findAll();
	}
}
