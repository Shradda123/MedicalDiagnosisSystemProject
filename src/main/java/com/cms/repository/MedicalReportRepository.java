package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cms.entity.MedicalReport;

@Repository
public interface MedicalReportRepository extends JpaRepository<MedicalReport, Long>
{
    
    @Query("SELECT mr FROM MedicalReport mr WHERE mr.type = :type")
    MedicalReport findByType(String type);
    
    @Query("SELECT mr FROM MedicalReport mr WHERE mr.description = :description")
    MedicalReport findByDescription(String description);
    
    @Query("SELECT mr FROM MedicalReport mr WHERE mr.patient.id = :patientId")
    MedicalReport findByPatientId(Long patientId);
    
    @Query("SELECT mr FROM MedicalReport mr WHERE mr.tests.id = :testsId")
    MedicalReport findByTestsId(Long testsId);
    
}