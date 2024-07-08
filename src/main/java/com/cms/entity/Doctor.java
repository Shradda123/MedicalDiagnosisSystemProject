package com.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class Doctor 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="Doctorid",length= 20)
	    private Long doctorid;
	    
	    @Column(name="DoctorName",length= 20)
	    private String doctorname;
	    
	    @Column(name="DoctorMobile",length= 20)
	    private Double doctormobile;
	    
	    @Column(name="DoctorEmail",length= 20)
	    private Double doctoremail;
	    
	   @Column(name="DoctorAddress",length= 20)
	    private String doctoraddress;
	    
	    @Column(name="DoctorPassword",length= 20)
	    private String doctorpassword;
	    
	    
}

   