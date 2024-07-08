package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cms.model.ChargesDTO;
import com.cms.service.ChargesService;

@RestController
@RequestMapping("/api/charges")
public class ChargesController
{

    @Autowired
    private ChargesService chargesService;

    // Create a new charge
    @PostMapping
    public ResponseEntity<String> createCharge(@RequestBody ChargesDTO chargesDTO)
    {
        String response = chargesService.createCharges(chargesDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get a charge by ID
    @GetMapping("/{chargesId}")
    public ResponseEntity<ChargesDTO> getChargeById(@PathVariable Long chargesId) 
    {
        ChargesDTO chargesDTO = chargesService.getChargesById(chargesId);
        return new ResponseEntity<>(chargesDTO, HttpStatus.OK);
    }

    // Get all charges
    @GetMapping
    public ResponseEntity<List<ChargesDTO>> getAllCharges() {
        List<ChargesDTO> chargesList = chargesService.getAllCharges();
        return new ResponseEntity<>(chargesList, HttpStatus.OK);
    }

    // Update an existing charge by ID
    @PutMapping("/{chargesId}")
    public ResponseEntity<ChargesDTO> updateCharge(@PathVariable Long chargesId, @RequestBody ChargesDTO chargesDTO) {
        ChargesDTO updatedCharges = chargesService.updateCharges(chargesId, chargesDTO);
        return new ResponseEntity<>(updatedCharges, HttpStatus.OK);
    }

    // Delete a charge by ID
    @DeleteMapping("/{chargesId}")
    public ResponseEntity<String> deleteCharge(@PathVariable Long chargesId)
    {
        String response = chargesService.deleteCharges(chargesId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get charges by type
    @GetMapping("/type/{chargesType}")
    public ResponseEntity<List<ChargesDTO>> getChargesByType(@PathVariable String chargesType) 
    {
        List<ChargesDTO> chargesList = chargesService.getChargesByType(chargesType);
        return new ResponseEntity<>(chargesList, HttpStatus.OK);
    }

    // Get charges by patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<ChargesDTO>> getChargesByPatientId(@PathVariable Long patientId)
    {
        List<ChargesDTO> chargesList = chargesService.getChargesByPatientId(patientId);
        return new ResponseEntity<>(chargesList, HttpStatus.OK);
    }
}
