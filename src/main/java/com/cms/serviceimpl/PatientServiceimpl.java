package com.cms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Patient;
import com.cms.exception.ResourceNotFoundException;
import com.cms.model.PatientDTO;
import com.cms.repository.PatientRepository;
import com.cms.service.PatientService;
import com.cms.util.Converter;

@Service 
public class PatientServiceimpl implements PatientService 
{

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private Converter converter;  // Assuming a utility to convert between entity and DTO

    @Override
    public String createPatient(PatientDTO patientDTO)
    {
        Patient patient = converter.convertToPatientEntity(patientDTO);
        patientRepository.save(patient);
        return "Patient created successfully!";
    }

    @Override
    public String deletePatient(Long patientId)
    {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isPresent()) 
        {
            patientRepository.deleteById(patientId);
            return "Patient deleted successfully!";
        } 
        else
        {
            throw new ResourceNotFoundException("Patient", "Id", patientId);
        }
    }

    @Override
    public PatientDTO updatePatient(Long patientId, Patient patientDTO) 
    {
        Patient existingPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));
        
        existingPatient.setName(patientDTO.getName());
        existingPatient.setDiagnosis(patientDTO.getDiagnosis());
        existingPatient.setAddress(patientDTO.getAddress());
        // Update other fields as necessary

        patientRepository.save(existingPatient);
        return converter.convertToPatientDTO(existingPatient);
    }

    @Override
    public PatientDTO getPatientById(Long patientId) 
    {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "Id", patientId));
        return converter.convertToPatientDTO(patient);
    }

    @Override
    public List<PatientDTO> getAllPatients() 
    {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDTO> patientDTOs = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOs.add(converter.convertToPatientDTO(patient));
        }
        return patientDTOs;
    }

    @Override
    public PatientDTO getByName(String name)
    {
        Patient patient = patientRepository.findByName(name);
        if (patient != null)
        {
            return converter.convertToPatientDTO(patient);
        }
        else 
        {
            throw new ResourceNotFoundException("Patient", "Name", name);
        }
    }

    @Override
    public List<PatientDTO> getPatientsByAddress(String address)
    {
        List<Patient> patients = patientRepository.findByAddress(address);
        List<PatientDTO> patientDTOs = new ArrayList<>();
        for (Patient patient : patients) 
        {
            patientDTOs.add(converter.convertToPatientDTO(patient));
        }
        return patientDTOs;
    }

	@Override
	public List<PatientDTO> getByDiagnosis(String diagnosis)
	{
		// TODO Auto-generated method stub
		return null;
	}
}

