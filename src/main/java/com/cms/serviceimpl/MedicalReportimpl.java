package com.cms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.MedicalReport;
import com.cms.exception.ResourceNotFoundException;
import com.cms.model.MedicalReportDTO;
import com.cms.repository.MedicalReportRepository;
import com.cms.service.MedicalReportService;
import com.cms.util.Converter;

@Service
public class MedicalReportServiceImpl implements MedicalReportService 
{

    @Autowired
    private MedicalReportRepository medicalReportRepository;

    @Autowired
    private Converter converter;

    @Override
    public String createMedicalReport(MedicalReportDTO medicalReportDTO) 
    {
        MedicalReport medicalReport = converter.convertToMedicalReportEntity(medicalReportDTO);
        medicalReportRepository.save(medicalReport);
        return "Medical report created successfully!";
    }

    @Override
    public String deleteMedicalReport(Long reportId)
    {
        Optional<MedicalReport> medicalReport = medicalReportRepository.findById(reportId);
        if (medicalReport.isPresent())
        {
            medicalReportRepository.deleteById(reportId);
            return "Medical report deleted successfully!";
        } 
        else 
        {
            throw new ResourceNotFoundException("Medical Report", "Id", reportId);
        }
    }

    @Override
    public MedicalReportDTO updateMedicalReport(Long reportId, MedicalReportDTO medicalReportDTO)
    {
        MedicalReport existingReport = medicalReportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("Medical Report", "Id", reportId));

        existingReport.setReportType(medicalReportDTO.getReportType());
        existingReport.setReportDescription(medicalReportDTO.getReportDescription());
        existingReport.setPatientId(medicalReportDTO.getPatientId());
        existingReport.setTestId(medicalReportDTO.getTestId());

        medicalReportRepository.save(existingReport);
        return converter.convertToMedicalReportDTO(existingReport);
    }

    @Override
    public MedicalReportDTO getMedicalReportById(Long reportId) 
    {
        MedicalReport medicalReport = medicalReportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException("Medical Report", "Id", reportId));
        return converter.convertToMedicalReportDTO(medicalReport);
    }

    @Override
    public List<MedicalReportDTO> getAllMedicalReports()
    {
        List<MedicalReport> medicalReports = medicalReportRepository.findAll();
        List<MedicalReportDTO> medicalReportDTOs = new ArrayList<>();
        for (MedicalReport medicalReport : medicalReports) {
            medicalReportDTOs.add(converter.convertToMedicalReportDTO(medicalReport));
        }
        return medicalReportDTOs;
    }

    @Override
    public List<MedicalReportDTO> getMedicalReportsByType(String reportType) 
    {
        List<MedicalReport> medicalReports = medicalReportRepository.findByReportType(reportType);
        List<MedicalReportDTO> medicalReportDTOs = new ArrayList<>();
        for (MedicalReport medicalReport : medicalReports)
        {
            medicalReportDTOs.add(converter.convertToMedicalReportDTO(medicalReport));
        }
        return medicalReportDTOs;
    }

    // Implementing the new methods

    @Override
    public List<MedicalReportDTO> getMedicalReportsByPatientId(Long patientId) 
    {
        List<MedicalReport> medicalReports = medicalReportRepository.findByPatientId(patientId);
        List<MedicalReportDTO> medicalReportDTOs = new ArrayList<>();
        for (MedicalReport medicalReport : medicalReports) {
            medicalReportDTOs.add(converter.convertToMedicalReportDTO(medicalReport));
        }
        return medicalReportDTOs;
    }

    @Override
    public List<MedicalReportDTO> getMedicalReportsByTestId(Long testId) 
    {
        List<MedicalReport> medicalReports = medicalReportRepository.findByTestId(testId);
        List<MedicalReportDTO> medicalReportDTOs = new ArrayList<>();
        for (MedicalReport medicalReport : medicalReports) {
            medicalReportDTOs.add(converter.convertToMedicalReportDTO(medicalReport));
        }
        return medicalReportDTOs;
    }
}
