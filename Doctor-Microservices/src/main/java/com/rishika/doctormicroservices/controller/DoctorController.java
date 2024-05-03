package com.rishika.doctormicroservices.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rishika.doctormicroservices.dto.Appointment;
import com.rishika.doctormicroservices.dto.Patient;
import com.rishika.doctormicroservices.entity.DoctorDetails;
import com.rishika.doctormicroservices.feignclient.PatientFeignClient;
import com.rishika.doctormicroservices.service.DoctorService;


@RestController
@RequestMapping("/api")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientFeignClient patientFeignClient;
	
	@PostMapping("/register/doctor")
	public DoctorDetails registerDoctor(@RequestBody DoctorDetails doctordetails) {
		return doctorService.registerDoctor(doctordetails);
	}
	
	@GetMapping("/getalldoctors")
	public List<DoctorDetails> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	@GetMapping("/getpatient/id/{id}")
	public Optional<Patient> getPatientById(@PathVariable int id) {
		return patientFeignClient.getPatientById(id);
	}
	
	@GetMapping("/getallpatient")
	public List<Patient> getAllPatient() {
		return patientFeignClient.getAllPatients();
	}
	
	@GetMapping("/display")
	public List<Appointment> displayAppointments(){
		return patientFeignClient.displayAppointments();
	}
}
