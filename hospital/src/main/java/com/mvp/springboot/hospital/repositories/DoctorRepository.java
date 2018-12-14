package com.mvp.springboot.hospital.repositories;

import com.mvp.springboot.hospital.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
