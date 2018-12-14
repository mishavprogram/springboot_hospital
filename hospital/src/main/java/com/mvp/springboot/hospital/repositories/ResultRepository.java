package com.mvp.springboot.hospital.repositories;

import com.mvp.springboot.hospital.entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
