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

public class Patient 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="Patientid",length= 20)
	    private Long patientid;
	    
	    @Column(name="Name",length= 20)
	    private String name;
	    
	    @Column(name="Diagnosis",length= 20)
	    private Double diagnosis;
	    
	    @Column(name="Address",length= 20)
	    private String address;

		public Long getPatientid()
		{
			return patientid;
		}

		public void setPatientid(Long patientid)
		{
			this.patientid = patientid;
		}

		public String getName() 
		{
			return name;
		}

		public void setName(String name) 
		{
			this.name = name;
		}

		public Double getDiagnosis()
		{
			return diagnosis;
		}

		public void setDiagnosis(Double diagnosis) 
		{
			this.diagnosis = diagnosis;
		}

		public String getAddress() 
		{
			return address;
		}

		public void setAddress(String address) 
		{
			this.address = address;
		}
}

   