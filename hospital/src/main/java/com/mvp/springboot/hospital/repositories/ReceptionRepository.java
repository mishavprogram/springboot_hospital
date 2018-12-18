package com.mvp.springboot.hospital.repositories;

import com.mvp.springboot.hospital.entities.Reception;
import com.mvp.springboot.hospital.entities.ReceptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceptionRepository extends JpaRepository<Reception, Long> {

    public List<Reception> findAllByStatusIn(ReceptionStatus status);

}
