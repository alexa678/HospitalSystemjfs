package com.adminmicroservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminmicroservice.entity.Patient;
import com.adminmicroservice.exception.InvalidPatientException;
import com.adminmicroservice.service.PatientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("/register/patient")
	public Patient registerPatient(@RequestBody Patient patient) throws InvalidPatientException {
		return patientService.registerPatient(patient);
		
	}
	
	@GetMapping("/getallpatient")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	@GetMapping("/getpatientbyid/{id}")
	public Optional<Patient> getPatientById(@PathVariable int id) {
		return patientService.getById(id);
	}
	
	@PutMapping("/updateByName/{name}")
	public Patient updatePrescriptionsByName(@PathVariable String name, @RequestBody String prescription) throws InvalidPatientException {
		return patientService.updatePrescriptionByName(name, prescription);
		
	}
	
	@DeleteMapping("deletebyid/{id}")
	public void deletePatientsById(@PathVariable int id) throws InvalidPatientException{
		patientService.deletePatientById(id);
	}
}