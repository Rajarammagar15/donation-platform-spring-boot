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

import com.help.teachstudent.model.Donor;
import com.help.teachstudent.service.DonorService;

@RestController
@RequestMapping("/donors")
public class DonorController {

	@Autowired
	private DonorService donorService;

	@PostMapping("/register")
	public ResponseEntity<String> registerDonor(@Validated @RequestBody Donor donor) {
		try {
			donorService.registerDonor(donor);
			return ResponseEntity.ok("Donor registered successfully");
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/list")
	public List<Donor> getAllDonors() {
		return donorService.getAllDonors();
	}
}
