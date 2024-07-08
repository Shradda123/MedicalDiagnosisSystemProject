package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import java.util.List;

import com.cms.entity.Charges;

@Repository
public interface ChargesRepository extends JpaRepository<Charges, Long>
{
/*
	@Query("SELECT c FROM Charges c WHERE c.id = :chargesId")
    Charges findById(Long chargesId);
	
    @Query("SELECT c FROM Charges c WHERE c.type = :type")
    Charges findByType(String type);
    
    @Query("SELECT c FROM Charges c WHERE c.totalAmount = :totalAmount")
    Charges findByTotalAmount(Double totalAmount);
    
    */
    
    @Query("SELECT c FROM Charges c WHERE c.patient.id = :patientId")
    List<Charges> findByPatientId(Long patientId);
    
}