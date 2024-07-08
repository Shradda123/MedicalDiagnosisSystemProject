package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cms.model.MedicalReportDTO;
import com.cms.service.MedicalReportService;

@RestController
@RequestMapping("/api/medical-reports")
public class MedicalReportController
{

    @Autowired
    private MedicalReportService medicalReportService;

    // Create a new medical report
    @PostMapping
    public ResponseEntity<String> createMedicalReport(@RequestBody MedicalReportDTO medicalReportDTO)
    {
        String response = medicalReportService.createMedicalReport(medicalReportDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get a medical report by ID
    @GetMapping("/{reportId}")
    public ResponseEntity<MedicalReportDTO> getMedicalReportById(@PathVariable Long reportId)
    {
        MedicalReportDTO medicalReportDTO = medicalReportService.getMedicalReportById(reportId);
        return new ResponseEntity<>(medicalReportDTO, HttpStatus.OK);
    }

    // Get all medical reports
    @GetMapping
    public ResponseEntity<List<MedicalReportDTO>> getAllMedicalReports() 
    {
        List<MedicalReportDTO> reportsList = medicalReportService.getAllMedicalReports();
        return new ResponseEntity<>(reportsList, HttpStatus.OK);
    }

    // Update an existing medical report by ID
    @PutMapping("/{reportId}")
    public ResponseEntity<MedicalReportDTO> updateMedicalReport(@PathVariable Long reportId, 
    		@RequestBody MedicalReportDTO medicalReportDTO)
    {
        MedicalReportDTO updatedReport = medicalReportService.updateMedicalReport(reportId, medicalReportDTO);
        return new ResponseEntity<>(updatedReport, HttpStatus.OK);
    }

    // Delete a medical report by ID
    @DeleteMapping("/{reportId}")
    public ResponseEntity<String> deleteMedicalReport(@PathVariable Long reportId)
    {
        String response = medicalReportService.deleteMedicalReport(reportId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get medical reports by patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalReportDTO>> getMedicalReportsByPatientId(@PathVariable Long patientId)
    {
        List<MedicalReportDTO> reportsList = medicalReportService.getMedicalReportsByPatientId(patientId);
        return new ResponseEntity<>(reportsList, HttpStatus.OK);
    }

    // Get medical reports by test ID
    @GetMapping("/test/{testId}")
    public ResponseEntity<List<MedicalReportDTO>> getMedicalReportsByTestId(@PathVariable Long testId)
    {
        List<MedicalReportDTO> reportsList = medicalReportService.getMedicalReportsByTestId(testId);
        return new ResponseEntity<>(reportsList, HttpStatus.OK);
    }
}
