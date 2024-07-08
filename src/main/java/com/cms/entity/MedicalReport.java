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

public class MedicalReport 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="Reporttid",length= 20)
	    private Long reportid;
	    
	    @Column(name="ReportType",length= 20)
	    private String reporttype;
	    
	    @Column(name="ReportDescription",length= 20)
	    private Double reportdescription;
	    
	    //foreign key
	    @Column(name="PatientId",length= 20)
	    private String patientid;
	    
	    
	  //foreign key
	    @Column(name="TestId",length= 20)
	    private String testid;
	    
	    
}

   