package com.rishika.doctormicroservices.feignclient;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rishika.doctormicroservices.dto.Appointment;
import com.rishika.doctormicroservices.dto.Patient;

@FeignClient(name = "Admin-Microservices")
public interface PatientFeignClient {
	
	@GetMapping("/api/getallpatient")
	public List<Patient> getAllPatients();
	
	@GetMapping("/api/getpatientbyid/{id}")
	public Optional<Patient> getPatientById(@PathVariable int id);
	
	@GetMapping("/api/display")
	public List<Appointment> displayAppointments();

}
