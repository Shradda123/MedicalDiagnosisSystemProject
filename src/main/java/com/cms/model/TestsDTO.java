package com.cms.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class TestsDTO 
{
    
    private Long id; // Unique identifier for the test
    
    @NotNull(message = "Description cannot be null")
    @Size(min = 10, message = "Description should have a minimum of 10 characters")
    private String description; // Description of the test
    
    @NotNull(message = "Type cannot be null")
    @Size(min = 3, message = "Type should have a minimum of 3 characters")
    private String type; // Type of the test (e.g., Blood, X-ray)
    
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name should have a minimum of 2 characters")
    private String name; // Name of the test
    
    @NotNull(message = "Patient ID cannot be null")
    private Long patientid; // ID of the patient to whom the test belongs
}