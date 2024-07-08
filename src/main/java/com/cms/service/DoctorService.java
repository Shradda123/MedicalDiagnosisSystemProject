 package com.cms.service;

import java.util.List;

import com.cms.entity.Doctor;
import com.cms.model.DoctorDTO;

public interface DoctorService 
{

    // Create a new doctor record
    public String createDoctor(DoctorDTO doctor);

    // Delete a doctor record by its ID
    public String deleteDoctor(Long id);

    // Update a doctor record by its ID
    public DoctorDTO updateDoctor(long id, Doctor doctor);

    // Get a doctor record by its ID
    public DoctorDTO getDoctorById(Long id);

    // Get all doctor records
    List<DoctorDTO> getAllDoctors();

    // Get a doctor record by its name
    DoctorDTO getByName(String name);

    // Get a doctor record by its mobile number
    DoctorDTO getByMobile(String mobile);

    // Get a doctor record by its email address
    DoctorDTO getByEmail(String email);

    // Get a doctor record by its address
    DoctorDTO getByAddress(String address);

    // Get a doctor record by its password
    DoctorDTO getByPassword(String password);

}