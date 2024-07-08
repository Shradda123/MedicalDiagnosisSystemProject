package com.cms.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class ChargesDTO 
{
    
    private Long chargesid; // Unique identifier for the charge
    
    @NotNull(message = "Charges type cannot be null")
    @Size(min = 2, message = "Charges type should have a minimum of 2 characters")
    private String chargestype; // Type of the charges (e.g., Consultation, Lab Test)
    
    @NotNull(message = "Total amount cannot be null")
    @Positive(message = "Total amount must be positive")
    private Double chargestotalamount; // Total amount for the charges
    
    @NotNull(message = "Patient ID cannot be null")
    private Long patientid; // ID of the patient associated with these charges
}