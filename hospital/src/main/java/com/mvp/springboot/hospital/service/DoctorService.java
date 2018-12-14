package com.mvp.springboot.hospital.service;

import com.mvp.springboot.hospital.entities.Doctor;
import com.mvp.springboot.hospital.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

}
