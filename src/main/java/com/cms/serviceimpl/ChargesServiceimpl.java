package com.cms.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.Charges;
import com.cms.exception.ResourceNotFoundException;
import com.cms.model.ChargesDTO;
import com.cms.repository.ChargesRepository;
import com.cms.service.ChargesService;
import com.cms.util.Converter;

@Service
public class ChargesServiceimpl implements ChargesService 
{

    @Autowired
    private ChargesRepository chargesRepository;

    @Autowired
    private Converter converter;

    @Override
    public String createCharge(ChargesDTO chargesDTO) 
    {
        Charges charges = converter.convertToChargesEntity(chargesDTO);
        chargesRepository.save(charges);
        return "Charge created successfully!";
    }

    @Override
    public String deleteCharge(Long chargesId)
    {
        Optional<Charges> charges = chargesRepository.findById(chargesId);
        if (charges.isPresent()) {
            chargesRepository.deleteById(chargesId);
            return "Charge deleted successfully!";
        } else {
            throw new ResourceNotFoundException("Charges", "Id", chargesId);
        }
    }

    @Override
    public ChargesDTO updateCharge(Long chargesId, ChargesDTO chargesDTO)
    {
        Charges existingCharge = chargesRepository.findById(chargesId)
                .orElseThrow(() -> new ResourceNotFoundException("Charges", "Id", chargesId));

        existingCharge.setChargesType(chargesDTO.getChargesType());
        existingCharge.setChargesTotalAmount(chargesDTO.getChargesTotalAmount());
        existingCharge.setPatientId(chargesDTO.getPatientId());

        chargesRepository.save(existingCharge);
        return converter.convertToChargesDTO(existingCharge);
    }

    @Override
    public ChargesDTO getChargeById(Long chargesId) {
        Charges charges = chargesRepository.findById(chargesId)
                .orElseThrow(() -> new ResourceNotFoundException("Charges", "Id", chargesId));
        return converter.convertToChargesDTO(charges);
    }

    @Override
    public List<ChargesDTO> getAllCharges()
    {
        List<Charges> chargesList = chargesRepository.findAll();
        List<ChargesDTO> chargesDTOs = new ArrayList<>();
        for (Charges charges : chargesList)
        {
            chargesDTOs.add(converter.convertToChargesDTO(charges));
        }
        return chargesDTOs;
    }

    @Override
    public List<ChargesDTO> getChargesByType(String chargesType) {
        List<Charges> chargesList = chargesRepository.findByChargesType(chargesType);
        List<ChargesDTO> chargesDTOs = new ArrayList<>();
        for (Charges charges : chargesList) {
            chargesDTOs.add(converter.convertToChargesDTO(charges));
        }
        return chargesDTOs;
    }

    @Override
    public List<ChargesDTO> getChargesByPatientId(Long patientId) {
        List<Charges> chargesList = chargesRepository.findByPatientId(patientId);
        List<ChargesDTO> chargesDTOs = new ArrayList<>();
        for (Charges charges : chargesList) 
        {
            chargesDTOs.add(converter.convertToChargesDTO(charges));
        }
        return chargesDTOs;
    }
}
