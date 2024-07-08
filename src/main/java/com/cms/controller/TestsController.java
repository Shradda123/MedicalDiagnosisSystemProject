package com.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cms.model.TestsDTO;
import com.cms.service.TestsService;

@RestController
@RequestMapping("/api/tests")
public class TestsController {

    @Autowired
    private TestsService testsService;

    // Create a new test
    @PostMapping
    public ResponseEntity<String> createTest(@RequestBody TestsDTO testsDTO)
    {
        String response = testsService.createTest(testsDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get a test by ID
    @GetMapping("/{testId}")
    public ResponseEntity<TestsDTO> getTestById(@PathVariable Long testId) 
    {
        TestsDTO testsDTO = testsService.getTestById(testId);
        return new ResponseEntity<>(testsDTO, HttpStatus.OK);
    }

    // Get all tests
    @GetMapping
    public ResponseEntity<List<TestsDTO>> getAllTests()
    {
        List<TestsDTO> testsList = testsService.getAllTests();
        return new ResponseEntity<>(testsList, HttpStatus.OK);
    }

    // Update an existing test by ID
    @PutMapping("/{testId}")
    public ResponseEntity<TestsDTO> updateTest(@PathVariable Long testId, @RequestBody TestsDTO testsDTO) 
    {
        TestsDTO updatedTest = testsService.updateTest(testId, testsDTO);
        return new ResponseEntity<>(updatedTest, HttpStatus.OK);
    }

    // Delete a test by ID
    @DeleteMapping("/{testId}")
    public ResponseEntity<String> deleteTest(@PathVariable Long testId)
    {
        String response = testsService.deleteTest(testId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get tests by patient ID
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<TestsDTO>> getTestsByPatientId(@PathVariable Long patientId)
    {
        List<TestsDTO> testsList = testsService.getTestsByPatientId(patientId);
        return new ResponseEntity<>(testsList, HttpStatus.OK);
    }

    // Get tests by doctor ID
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<TestsDTO>> getTestsByDoctorId(@PathVariable Long doctorId) 
    {
        List<TestsDTO> testsList = testsService.getTestsByDoctorId(doctorId);
        return new ResponseEntity<>(testsList, HttpStatus.OK);
    }
}
