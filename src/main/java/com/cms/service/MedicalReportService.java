package com.cms.service;

import java.util.List;

import com.cms.model.MedicalReportDTO;

public interface MedicalReportService
{

    // Create a new medical report
    public String createMedicalReport(MedicalReportDTO medicalReportDTO);

    // Delete a medical report by its ID
    public String deleteMedicalReport(Long id);

    // Update a medical report by its ID
    public MedicalReportDTO updateMedicalReport(Long id, MedicalReportDTO medicalReportDTO);

    // Get a medical report by its ID
    public MedicalReportDTO getMedicalReportById(Long id);

    // Get all medical reports
    public List<MedicalReportDTO> getAllMedicalReports();

    // Get medical reports by report type
    public List<MedicalReportDTO> getMedicalReportsByType(String reportType);

    // Get medical reports by patient ID
    public List<MedicalReportDTO> getMedicalReportsByPatientId(Long patientId);

    // Get medical reports by test ID
    public List<MedicalReportDTO> getMedicalReportsByTestId(Long testId);
}