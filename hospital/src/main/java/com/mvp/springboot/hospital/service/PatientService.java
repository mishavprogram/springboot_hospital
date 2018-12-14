package com.mvp.springboot.hospital.service;

import com.mvp.springboot.hospital.entities.Patient;
import com.mvp.springboot.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public Patient create(Patient patient){
        return patientRepository.save(patient);
    }

}
