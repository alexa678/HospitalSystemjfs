package com.adminmicroservice.service;

import java.util.List;
import java.util.Optional;

import com.adminmicroservice.entity.Patient;
import com.adminmicroservice.exception.InvalidPatientException;


public interface PatientService {

	public Patient registerPatient(Patient patient)throws InvalidPatientException;
	public List<Patient> getAllPatients();
	public Optional<Patient> getById(int id);
	public Patient updatePrescriptionByName(String name, String prescription) throws InvalidPatientException;
	void deletePatientById(int id) throws InvalidPatientException;
	

}