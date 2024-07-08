package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.cms.entity.Tests;

import java.util.List;

@Repository
public interface TestsRepository extends JpaRepository<Tests, Long> 
{

    @Query("SELECT t FROM Tests t WHERE t.testId = :testId")
    Tests findByTestId(Long testId);
    
    @Query("SELECT t FROM Tests t WHERE t.description = :description")
    Tests findByDescription(String description);
    
    @Query("SELECT t FROM Tests t WHERE t.type = :type")
    Tests findByType(String type);
    
    @Query("SELECT t FROM Tests t WHERE t.name = :name")
    Tests findByName(String name);
    
    @Query("SELECT t FROM Tests t WHERE t.patient.id = :patientId")
    List<Tests> findByPatientId(Long patientId);
    
}