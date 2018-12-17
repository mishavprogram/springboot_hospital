package com.mvp.springboot.hospital.config;

import com.mvp.springboot.hospital.entities.Doctor;
import com.mvp.springboot.hospital.entities.Patient;
import com.mvp.springboot.hospital.entities.Reception;
import com.mvp.springboot.hospital.repositories.DoctorRepository;
import com.mvp.springboot.hospital.repositories.PatientRepository;
import com.mvp.springboot.hospital.repositories.ReceptionRepository;
import com.mvp.springboot.hospital.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private DoctorRepository doctorRepository;

    private PatientRepository patientRepository;

    private ReceptionRepository receptionRepository;

    private ResultRepository resultRepository;

    @Autowired
    public DataLoader(DoctorRepository doctorRepository, PatientRepository patientRepository, ReceptionRepository receptionRepository, ResultRepository resultRepository){
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.receptionRepository = receptionRepository;
        this.resultRepository = resultRepository;

        init();
    }

    private void init(){
        Doctor doctor1 = Doctor.builder()
            .name("MishaDoc")
            .speciality("killer")
            .build();

        Doctor doctor2 = Doctor.builder()
            .name("VitalikDoc")
            .speciality("vitalik")
            .build();

        Patient patient1 = Patient.builder()
            .name("Jackyyy")
            .build();

        Reception reception1 = Reception.builder()
            .doctor(doctor1)
            .patient(patient1)
            .year(2018)
            .month(10)
            .day(5)
            .hour(15)
            .build();

        Reception reception2 = Reception.builder()
            .doctor(doctor2)
            .patient(patient1)
            .year(2018)
            .month(10)
            .day(5)
            .hour(10)
            .build();
        reception2.setDoctor(doctor2);
        reception2.setPatient(patient1);

        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);

        patientRepository.save(patient1);

        receptionRepository.save(reception1);
        receptionRepository.save(reception2);
    }


}
