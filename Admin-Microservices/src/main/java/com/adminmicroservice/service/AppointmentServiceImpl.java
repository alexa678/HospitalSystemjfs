package com.adminmicroservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminmicroservice.entity.Appointment;
import com.adminmicroservice.exception.InvalidAppointmentException;
import com.adminmicroservice.repository.AppointmentRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService{
	
	
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	public Appointment bookAppointment(Appointment appointment) {
		log.info("booking appointment");
		return appointmentRepository.save(appointment);
		
	}

	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	public Optional<Appointment> getById(int id) {
		log.info("getting appointment by id {}",id);
		return appointmentRepository.findById(id);
	}
	
	@Override
	public void deleteAppointmentById(int id) throws InvalidAppointmentException {
	        if (!appointmentRepository.existsById(id)) {
	        	log.error("ID doesn't exits");
	            throw new InvalidAppointmentException("Appointment with ID " + id + " does not exist");
	        }
	        appointmentRepository.deleteById(id);
	    
	}
}
