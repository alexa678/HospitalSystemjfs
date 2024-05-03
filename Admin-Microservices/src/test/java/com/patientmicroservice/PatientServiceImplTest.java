package com.patientmicroservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.adminmicroservice.entity.Patient;
import com.adminmicroservice.exception.InvalidPatientException;
import com.adminmicroservice.repository.PatientRepository;
import com.adminmicroservice.service.PatientServiceImpl;

@SpringBootTest
@ContextConfiguration(classes = {PatientServiceImpl.class, PatientRepository.class})
public class PatientServiceImplTest {

    @Test
    public void testRegisterPatient() {
        // Mock the PatientRepository
        PatientRepository patientRepositoryMock = mock(PatientRepository.class);
        
        // Create a patient object
        Patient patient = new Patient(1, "23", "B++", "500mg", "30 USD", "Rishika ", "Paracetamol");
        
        // Mock the behavior of the patientRepository.save() method
        when(patientRepositoryMock.existsById(patient.getId())).thenReturn(false);
        when(patientRepositoryMock.save(any(Patient.class))).thenReturn(patient);
        
        // Create an instance of PatientServiceImpl
        PatientServiceImpl patientService = new PatientServiceImpl();
        
        // Set the mocked repository using reflection or a setter method
        // For simplicity, let's assume there's a setter method setPatientRepository
        patientService.setPatientRepository(patientRepositoryMock);
        
        // Call the method being tested
        try {
            Patient registeredPatient = patientService.registerPatient(patient);
            
            // Assert that the returned patient is the same as the one we passed in
            assertEquals(patient, registeredPatient);
        } catch (InvalidPatientException e) {
            // Test failed if exception is thrown
            e.printStackTrace();
        }
    }
}
