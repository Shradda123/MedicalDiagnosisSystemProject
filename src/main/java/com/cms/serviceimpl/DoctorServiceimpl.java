package com.cms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Doctor;
import com.cms.exception.ResourceNotFoundException;
import com.cms.model.DoctorDTO;
import com.cms.repository.DoctorRepository;
import com.cms.service.DoctorService;
import com.cms.util.Converter;

@Service
public class DoctorServiceimpl implements DoctorService
{

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private Converter converter;

    @Override
    public String createDoctor(DoctorDTO doctorDTO)
    {
        Doctor doctor = converter.convertToDoctorEntity(doctorDTO);
        doctorRepository.save(doctor);
        return "Doctor created successfully!";
    }

    @Override
    public String deleteDoctor(Long doctorId)
    {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        if (doctor.isPresent()) {
            doctorRepository.deleteById(doctorId);
            return "Doctor deleted successfully!";
        } 
        else 
        {
            throw new ResourceNotFoundException("Doctor", "Id", doctorId);
        }
    }

    @Override
    public DoctorDTO updateDoctor(Long doctorId, DoctorDTO doctorDTO)
    {
        // Ensure the method signature matches the interface
        Doctor existingDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));

        existingDoctor.setName(doctorDTO.getName());
        existingDoctor.setMobile(doctorDTO.getMobile());
        existingDoctor.setEmail(doctorDTO.getEmail());
        existingDoctor.setAddress(doctorDTO.getAddress());
        existingDoctor.setPassword(doctorDTO.getPassword());

        doctorRepository.save(existingDoctor);
        return converter.convertToDoctorDTO(existingDoctor);
    }

    @Override
    public DoctorDTO getDoctorById(Long doctorId)
    {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", "Id", doctorId));
        return converter.convertToDoctorDTO(doctor);
    }

    @Override
    public List<DoctorDTO> getAllDoctors()
    {
        List<Doctor> doctors = doctorRepository.findAll();
        List<DoctorDTO> doctorDTOs = new ArrayList<>();
        for (Doctor doctor : doctors)
        {
            doctorDTOs.add(converter.convertToDoctorDTO(doctor));
        }
        return doctorDTOs;
    }

    @Override
    public List<DoctorDTO> getDoctorsByName(String name) {
        List<Doctor> doctors = doctorRepository.findByName(name);
        List<DoctorDTO> doctorDTOs = new ArrayList<>();
        for (Doctor doctor : doctors) {
            doctorDTOs.add(converter.convertToDoctorDTO(doctor));
        }
        return doctorDTOs;
    }

    @Override
    public DoctorDTO getDoctorByEmail(String email) 
    {
        Doctor doctor = doctorRepository.findByEmail(email);
        if (doctor != null)
        {
            return converter.convertToDoctorDTO(doctor);
        } 
        else
        {
            throw new ResourceNotFoundException("Doctor", "Email", email);
        }
    }

    @Override
    public DoctorDTO getDoctorByMobile(String mobile) 
    {
        Doctor doctor = doctorRepository.findByMobile(mobile);
        if (doctor != null) 
        {
            return converter.convertToDoctorDTO(doctor);
        }
        else 
        {
            throw new ResourceNotFoundException("Doctor", "Mobile", mobile);
        }
    }

	public String createDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorDTO updateDoctor(Long id, Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorDTO getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorDTO getByMobile(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorDTO getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorDTO getByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorDTO getByPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
