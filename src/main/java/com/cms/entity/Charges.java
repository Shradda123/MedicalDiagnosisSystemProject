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

public class Charges 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ChargesId",length= 20)
	    private Long chargesid;
	    
	    @Column(name="CharegesType",length= 20)
	    private String chargestype;
	    
	    @Column(name="ChargesTotalAmount",length= 20)
	    private Double chargestotalamount;
	    
	    @Column(name="PatientId",length= 20)
	    private String patientid;
	    
}

   