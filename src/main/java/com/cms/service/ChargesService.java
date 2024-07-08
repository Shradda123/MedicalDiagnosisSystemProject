 package com.cms.service;

import java.util.List;

import com.cms.model.ChargesDTO;

public interface ChargesService
{
    // Create a new charge record
    public String createCharges(ChargesDTO chargesDTO);

    // Delete a charge record by its ID
    public String deleteCharges(Long chargesId);

    // Update a charge record by its ID
    public ChargesDTO updateCharges(Long chargesId, ChargesDTO chargesDTO);

    // Get a charge record by its ID
    public ChargesDTO getChargesById(Long chargesId);

    // Get all charge records
    public List<ChargesDTO> getAllCharges();

    // Get charges by charge type
    public List<ChargesDTO> getChargesByType(String chargesType);

    // Get charges by patient ID
    public List<ChargesDTO> getChargesByPatientId(Long patientId);
}
