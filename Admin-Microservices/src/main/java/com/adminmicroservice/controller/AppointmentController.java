package com.adminmicroservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminmicroservice.entity.Appointment;
import com.adminmicroservice.exception.InvalidAppointmentException;
import com.adminmicroservice.service.AppointmentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/book")
	public Appointment bookAppointment(@RequestBody Appointment appointment) {
		return appointmentService.bookAppointment(appointment);
		
	}
	
	@GetMapping("/display")
	public List<Appointment> displayAppointments(){
		return appointmentService.getAllAppointments();
	}
	
	 @GetMapping("/{id}")
	    public Optional<Appointment> getAppointmentById(@PathVariable int id) {
	        return appointmentService.getById(id);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteAppointmentById(@PathVariable int id) throws InvalidAppointmentException {
	        appointmentService.deleteAppointmentById(id);
	    }
}
