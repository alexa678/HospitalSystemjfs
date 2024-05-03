package com.adminmicroservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminmicroservice.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

	Optional<Patient> findByName(String name);

}
