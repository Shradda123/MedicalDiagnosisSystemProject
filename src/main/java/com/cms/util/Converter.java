package com.cms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cms.entity.Doctor;
import com.cms.entity.Patient;
import com.cms.model.DoctorDTO;
import com.cms.model.PatientDTO;

@Component
public class Converter
{

	//convert from DTO  to entity
	
	public Patient convertToPatientEntity(PatientDTO instructorDTO)
	{
		Patient instructor=new Patient();
		if(instructorDTO!=null)
		{
			BeanUtils.copyProperties(instructorDTO, instructor);
		}
		return instructor;
	}
	
	
	//covert from Entity to DTO
	public PatientDTO convertToPatientDTO(Patient instructor)
	{
		PatientDTO instructorDTO=new PatientDTO();
		if(instructor!=null)
		{
			BeanUtils.copyProperties(instructor, instructorDTO);
		}
		return instructorDTO;
	}
	
	
	//convert from DTO  to entity
	
		public Doctor covertToCourseEntity(DoctorDTO courseDTO)
		{
			Doctor course=new Doctor();
			if(courseDTO!=null)
			{
				BeanUtils.copyProperties(courseDTO, course);
			}
			return course;
		}
		
		//covert from Entity to DTO
			public DoctorDTO convertToCourseDTO(Doctor course)
			{
				DoctorDTO courseDTO=new DoctorDTO();
				if(course!=null)
				{
					BeanUtils.copyProperties(course, courseDTO);
				}
				return courseDTO;
			}
}
