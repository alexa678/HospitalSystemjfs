package com.rishika.doctormicroservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rishika.doctormicroservices.entity.DoctorDetails;

@Repository
public interface DoctorRepository  extends JpaRepository<DoctorDetails, Long>{

}
