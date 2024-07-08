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

public class Tests
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="TestId",length= 20)
	    private Long testid;
	    
	    @Column(name="TestDescription",length= 20)
	    private String testdescription;
	    
	    @Column(name="TestType",length= 20)
	    private Double testtype;
	    
	    @Column(name="TestName",length= 20)
	    private String testname;
	    
	    @Column(name="PatientId",length= 20)
	    private String patientid;
	    
	    
}

   