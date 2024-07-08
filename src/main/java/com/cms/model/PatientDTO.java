package com.cms.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

import lombok.Data;

@Data
public class PatientDTO
{
    
    private Long patientid;
    
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name should have a minimum of 2 characters")
    private String name;
    
    @NotNull(message = "Diagnosis cannot be null")
    @Min(value = 0, message = "Diagnosis must be a positive number")
    @Max(value = 100, message = "Diagnosis must be less than or equal to 100")
    private Double diagnosis;
    
    @NotNull(message = "Address cannot be null")
    @Size(min = 5, message = "Address should have a minimum of 5 characters")
    private String address;
    
}