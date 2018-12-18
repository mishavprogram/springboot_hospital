package com.mvp.springboot.hospital.service;

import com.mvp.springboot.hospital.entities.Doctor;
import com.mvp.springboot.hospital.repositories.DoctorRepository;
import com.mvp.springboot.hospital.service.converter.DoctorConverter;
import com.mvp.springboot.hospital.service.dto.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorConverter doctorConverter;

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    /*public FormDto findById(Long id) {
        Form form = formRepository.getOne(id);
        return formConverter.toDto(form);
    }*/

    public DoctorDto findById(Long id){
        Doctor doctor = doctorRepository.getOne(id);
        return doctorConverter.toDto(doctor);
    }

}
