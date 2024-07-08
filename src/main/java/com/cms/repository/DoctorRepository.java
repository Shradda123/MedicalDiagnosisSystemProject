package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cms.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>
{
    
    @Query("SELECT d FROM Doctor d WHERE d.name = :name")
    Doctor findByName(@Param("name") String name);
    
    
    @Query("SELECT d FROM Doctor d WHERE d.id = :doctorId")
    Doctor findById(@Param("doctorId") Long doctorId);
    
   
    @Query("SELECT d FROM Doctor d WHERE d.mobile = :mobile")
    Doctor findByMobile(@Param("mobile") String mobile);
    
    @Query("SELECT d FROM Doctor d WHERE d.email = :email")
    Doctor findByEmail(@Param("email") String email);
    
    @Query("SELECT d FROM Doctor d WHERE d.address = :address")
    Doctor findByAddress(@Param("address") String address);
    
    @Query("SELECT d FROM Doctor d WHERE d.password = :password")
    Doctor findByPassword(@Param("password") String password);
    
    
}

