package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cms.entity.Doctor;
import com.cms.model.DoctorDTO;
import com.cms.service.DoctorService;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController
{

    @Autowired
    private DoctorService doctorService;

    // Create a new doctor
    @PostMapping
    public ResponseEntity<String> createDoctor(@RequestBody DoctorDTO doctorDTO)
    {
        String response = doctorService.createDoctor(doctorDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get a doctor by ID
    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long doctorId) 
    {
        DoctorDTO doctorDTO = doctorService.getDoctorById(doctorId);
        return new ResponseEntity<>(doctorDTO, HttpStatus.OK);
    }

    // Get all doctors
    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        List<DoctorDTO> doctorsList = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctorsList, HttpStatus.OK);
    }

    // Update an existing doctor by ID
    @PutMapping("/{doctorId}")
    public ResponseEntity<DoctorDTO> updateDoctor(@PathVariable Long doctorId, 
    		@RequestBody DoctorDTO doctorDTO)
    {
        DoctorDTO updatedDoctor = doctorService.updateDoctor(long id, Doctor doctor);
        return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
    }

    // Delete a doctor by ID
    @DeleteMapping("/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long doctorId) 
    {
        String response = doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get doctor by email
    @GetMapping("/email/{email}")
    public ResponseEntity<DoctorDTO> getDoctorByEmail(@PathVariable String email)
    {
        DoctorDTO doctorDTO = doctorService.getByEmail(email);
        return new ResponseEntity<>(doctorDTO, HttpStatus.OK);
    }

    // Get doctors by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByName(@PathVariable String name)
    {
        List<DoctorDTO> doctorsList = doctorService.getByName(name);
        return new ResponseEntity<>(doctorsList, HttpStatus.OK);
    }

    // Get doctor by mobile
    @GetMapping("/mobile/{mobile}")	
    public ResponseEntity<DoctorDTO> getDoctorByMobile(@PathVariable String mobile)
    {
        DoctorDTO doctorDTO = doctorService.getByMobile(mobile);
        return new ResponseEntity<>(doctorDTO, HttpStatus.OK);
    }

    // Get doctors by address
    @GetMapping("/address/{address}")
    public ResponseEntity<List<DoctorDTO>> getDoctorsByAddress(@PathVariable String address)
    {
        List<DoctorDTO> doctorsList = doctorService.getByAddress(address);
        return new ResponseEntity<>(doctorsList, HttpStatus.OK);
    }
}
