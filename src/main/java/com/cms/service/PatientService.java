package com.cms.service;

import java.util.List;

import com.cms.entity.Patient;
import com.cms.model.PatientDTO;

public interface PatientService
{

    // Create a new patient record
    public String createPatient(PatientDTO patient);

    // Delete a patient record by its ID
    public String deletePatient(Long id);

    // Update a patient record by its ID
    public PatientDTO updatePatient(Long id,PatientDTO patient);

    // Get a patient record by its ID
    public PatientDTO getPatientById(Long id);

    // Get all patient records
    List<PatientDTO> getAllPatients();

    // Get a patient record by its name
    PatientDTO getByName(String name);

    // Get a list of patients by their diagnosis
    List<PatientDTO> getByDiagnosis(String diagnosis);
    
    List<PatientDTO> getPatientsByAddress(String address);

    
    List<PatientDTO> getPatientsByDiagnosis(String diagnosis);
    
    
    
    
}