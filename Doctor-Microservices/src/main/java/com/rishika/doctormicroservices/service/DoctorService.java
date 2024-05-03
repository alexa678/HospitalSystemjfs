package com.rishika.doctormicroservices.service;

import java.util.List;

import com.rishika.doctormicroservices.entity.DoctorDetails;

public interface DoctorService {
	public DoctorDetails registerDoctor(DoctorDetails doctordetails);
	
	public List<DoctorDetails> getAllDoctors();
}
