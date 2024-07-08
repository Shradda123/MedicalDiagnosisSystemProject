package com.cms.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MedicalReportDTO 
{
    
    private Long Reportid; // Unique identifier for the medical report

    @NotNull(message = "Report type cannot be null")
    @Size(min = 2, message = "Report type should have a minimum of 2 characters")
    private String ReportType; // Type of the medical report (e.g., Blood Test, X-ray Report)

    @NotNull(message = "Report description cannot be null")
    @Size(min = 10, message = "Report description should have a minimum of 10 characters")
    private String ReportDescription; // Detailed description of the report

    @NotNull(message = "Patient ID cannot be null")
    private Long Patientid; // ID of the patient associated with this report

    @NotNull(message = "Test ID cannot be null")
    private Long Testid; // ID of the test associated with this report
}