package com.cms.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class DoctorDTO
{
    
    private Long id; // Unique identifier for the doctor
    
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name should have a minimum of 2 characters")
    private String name; // Doctor's name
    
    @NotNull(message = "Mobile number cannot be null")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobile; // Doctor's mobile number
    
    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email; // Doctor's email address
    
    @NotNull(message = "Address cannot be null")
    @Size(min = 5, message = "Address should have a minimum of 5 characters")
    private String address; // Doctor's address
    
    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password should have a minimum of 8 characters")
    private String password; // Doctor's password
    
}