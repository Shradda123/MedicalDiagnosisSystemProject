package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cms.model.PatientDTO;
import com.cms.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Create a new patient
    @PostMapping
    public ResponseEntity<String> createPatient(@RequestBody PatientDTO patientDTO) 
    {
        String response = patientService.createPatient(patientDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get a patient by ID
    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long patientId)
    {
        PatientDTO patientDTO = patientService.getPatientById(patientId);
        return new ResponseEntity<>(patientDTO, HttpStatus.OK);
    }

    // Get all patients
    @GetMapping
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        List<PatientDTO> patientsList = patientService.getAllPatients();
        return new ResponseEntity<>(patientsList, HttpStatus.OK);
    }

    // Update an existing patient by ID
    @PutMapping("/{patientId}")
    public ResponseEntity<PatientDTO> updatePatient(@PathVariable Long patientId, @RequestBody PatientDTO patientDTO) {
        PatientDTO updatedPatient = patientService.updatePatient(patientId, patientDTO);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    // Delete a patient by ID
    @DeleteMapping("/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
        String response = patientService.deletePatient(patientId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get patients by diagnosis
    @GetMapping("/diagnosis/{diagnosis}")
    public ResponseEntity<List<PatientDTO>> getPatientsByDiagnosis(@PathVariable String diagnosis) {
        List<PatientDTO> patientsList = patientService.getPatientsByDiagnosis(diagnosis);
        return new ResponseEntity<>(patientsList, HttpStatus.OK);
    }

    // Get patients by address
    @GetMapping("/address/{address}")
    public ResponseEntity<List<PatientDTO>> getPatientsByAddress(@PathVariable String address) 
    {
        List<PatientDTO> patientsList = patientService.getPatientsByAddress(address);
        return new ResponseEntity<>(patientsList, HttpStatus.OK);
    }
}
