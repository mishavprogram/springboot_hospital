package com.mvp.springboot.hospital.service;

import com.mvp.springboot.hospital.entities.Patient;
import com.mvp.springboot.hospital.repositories.PatientRepository;
import com.mvp.springboot.hospital.service.converter.PatientConverter;
import com.mvp.springboot.hospital.service.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientConverter patientConverter;

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public Patient create(Patient patient){
        System.out.println(patient.toString());
        return patientRepository.save(patient);
    }

    public PatientDto findById(Long id){
        Patient patient = patientRepository.getOne(id);
        return patientConverter.toDto(patient);
    }

}
