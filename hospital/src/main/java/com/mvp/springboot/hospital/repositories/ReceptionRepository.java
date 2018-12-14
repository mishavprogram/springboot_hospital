package com.mvp.springboot.hospital.repositories;

import com.mvp.springboot.hospital.entities.Reception;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionRepository extends JpaRepository<Reception, Long> {
}
