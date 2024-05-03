package com.coderdot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderdot.dto.AppointmentResponse;
import com.coderdot.dto.PatientResponse;
import com.coderdot.proxy.AdminProxy;



@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	private AdminProxy adminproxy;
	
	
	@PostMapping("/patients/register/patient")
	public PatientResponse registerPatient(@RequestBody PatientResponse patient){
		return adminproxy.registerPatient(patient);
		
	}
	
	@GetMapping("/patients/getallpatient")
	public List<PatientResponse> getAllPatients(){
		return adminproxy.getAllPatients();
	}
	
	@GetMapping("/patients/getpatientbyid/{id}")
	public Optional<PatientResponse> getPatientById(@PathVariable int id) {
		return adminproxy.getById(id);
	}
	
	@PostMapping("/book")
	public AppointmentResponse bookAppointment(@RequestBody AppointmentResponse appointment) {
		return adminproxy.bookAppointment(appointment);
		
	}
	
	@GetMapping("/display")
	public List<AppointmentResponse> displayAppointments(){
		return adminproxy.displayAppointments();
	}
}
