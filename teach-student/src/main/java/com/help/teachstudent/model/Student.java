package com.help.teachstudent.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Aadhaar number is required")
    @Column(unique = true, length = 12)
    private String aadhaarNumber;

    @NotNull(message = "Parent's bank account is required")
    @Column(unique = true)
    private String bankAccountNumber;

    @NotNull(message = "Standard is required")
    private String standard;

    @NotNull(message = "Parent's contact is required")
    private String parentContact;
    
    @NotNull(message = "school name is required")
    private String school;
    
    @NotNull(message = "address is required")
    private String address;
    
    @NotNull(message = "amount is required")
    private String amount;
    
    @NotNull(message = "upiId is required")
    private String upiId;
}
