package com.cms.service;
import java.util.List;

import com.cms.model.TestsDTO;


public interface TestsService
{

    // Create a new test record
    String createTest(TestsDTO testsDTO);

    // Delete a test record by its ID
    String deleteTest(Long testId);

    // Update a test record by its ID
    TestsDTO updateTest(Long testId, TestsDTO testsDTO);

    // Get a test record by its ID
    TestsDTO getTestById(Long testId);

    // Get all test records
    List<TestsDTO> getAllTests();

    // Get tests by type
    List<TestsDTO> getTestsByType(String type);

    // Get tests by patient ID
    List<TestsDTO> getTestsByPatientId(Long patientId);

	List<TestsDTO> getTestsByDoctorId(Long doctorId);
}
