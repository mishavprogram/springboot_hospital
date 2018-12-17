package com.mvp.springboot.hospital.controller;

import com.mvp.springboot.hospital.entities.Doctor;
import com.mvp.springboot.hospital.service.DoctorService;
import com.mvp.springboot.hospital.service.converter.DoctorConverter;
import com.mvp.springboot.hospital.service.dto.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/doctors")
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorConverter doctorConverter;

    @GetMapping
    public List<DoctorDto> getDoctor(){
        List<Doctor> doctors = doctorService.findAll();
        return doctorConverter.toDto(doctors);
    }

}
