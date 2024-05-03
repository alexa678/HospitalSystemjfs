package com.adminmicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminmicroservice.entity.Patient;
import com.adminmicroservice.exception.InvalidPatientException;
import com.adminmicroservice.repository.PatientRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public Patient registerPatient(Patient patient) throws InvalidPatientException {
	        if (patientRepository.existsById(patient.getId())) {
	        	log.error("Patient Id already exists.");
	            throw new InvalidPatientException("Patient with ID " + patient.getId() + " already exists");
	        }
	        log.info("Patient registration successful");
	        return patientRepository.save(patient);
	}


	@Override
	public List<Patient> getAllPatients() {
		log.info("Showing all Patient details");
		return patientRepository.findAll();
	}

	@Override
	public Optional<Patient> getById(int id) {
		log.info("Showing Patient details By Id");
		return patientRepository.findById(id);
	}
	
	@Override
	public Patient updatePrescriptionByName(String name, String prescription) throws InvalidPatientException {
	    Optional<Patient> optionalPatient = patientRepository.findByName(name);
	    
	    if (optionalPatient.isPresent()) {
	        Patient patient = optionalPatient.get();
	        patient.setPrescription(prescription);
	        log.info("Update prescription By Patient name");
	        return patientRepository.save(patient);
	    } else {
	    	log.error("Patient name is not present");
	        throw new InvalidPatientException("Patient with name " + name + " not found");
	    }
	}


	@Override
	public void deletePatientById(int id) throws InvalidPatientException {
	        if (!patientRepository.existsById(id)) {
	        	log.error("Patient id does not exists");
	            throw new InvalidPatientException("Patient with ID " + id + " does not exist");
	        }
	        patientRepository.deleteById(id);
	    
	}

}
