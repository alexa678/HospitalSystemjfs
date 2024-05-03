package com.coderdot.proxy;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coderdot.dto.AppointmentResponse;
import com.coderdot.dto.PatientResponse;

@FeignClient(value="Admin-Microservices")
public interface AdminProxy {
	
	

	@PostMapping("/api/book")
	public AppointmentResponse bookAppointment(@RequestBody AppointmentResponse appointment);

	@GetMapping(value="/api/display")
	public List<AppointmentResponse> displayAppointments();

	@PostMapping("/api/patients/register/patient")
	public PatientResponse registerPatient(PatientResponse patient);

	@GetMapping("/api/patients/getallpatient")
	public List<PatientResponse> getAllPatients();

	@GetMapping("/api/patients/getpatientbyid/{id}")
	public Optional<PatientResponse> getById(int id);
}
