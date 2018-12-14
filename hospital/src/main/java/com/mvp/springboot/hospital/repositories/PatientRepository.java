package com.mvp.springboot.hospital.repositories;

import com.mvp.springboot.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
