package com.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cms.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>
{
    
    @Query("SELECT p FROM Patient p WHERE p.name = ?1")
    Patient findByName(String name);
    
  
    // Custom query methods for additional fields
    @Query("SELECT p FROM Patient p WHERE p.id = ?1")
    Patient findByid(Long id);
    
    /*
    @Query("SELECT p FROM Patient p WHERE p.diagnosis = ?1")
    Patient findByDiagnosis(String diagnosis);
    */
    
    @Query("SELECT p FROM Patient p WHERE p.address = ?1")
    List<Patient> findByAddress(String address);
    
}