package com.mvp.springboot.hospital.controller;

import com.mvp.springboot.hospital.entities.Patient;
import com.mvp.springboot.hospital.service.PatientService;
import com.mvp.springboot.hospital.service.converter.PatientConverter;
import com.mvp.springboot.hospital.service.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientConverter patientConverter;

    @GetMapping
    public List<PatientDto> getPatients(){
        List<Patient> patients = patientService.findAll();
        return patientConverter.toDto(patients);
    }

}
