package com.adminmicroservice.service;

import java.util.List;
import java.util.Optional;

import com.adminmicroservice.entity.Appointment;

import com.adminmicroservice.exception.InvalidAppointmentException;


public interface AppointmentService {

	public Appointment bookAppointment(Appointment appointment);

	public List<Appointment> getAllAppointments();
	
	public Optional<Appointment> getById(int id);

	void deleteAppointmentById(int id) throws InvalidAppointmentException;

}
