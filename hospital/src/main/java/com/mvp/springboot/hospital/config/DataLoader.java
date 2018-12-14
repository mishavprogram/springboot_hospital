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
        Doctor doctor1 = Doctor.builder().name("MishaDoc").speciality("killer").build();

        Doctor doctor2 = new Doctor();
        doctor2.setName("VitalikDoc");
        doctor2.setSpeciality("vitalik");

        Patient patient1 = new Patient();
        patient1.setName("Jackyyy");

        Reception reception1 = new Reception();
        reception1.setDoctor(doctor1);
        reception1.setPatient(patient1);

        Reception reception2 = new Reception();
        reception2.setDoctor(doctor2);
        reception2.setPatient(patient1);

        doctorRepository.save(doctor1);
        doctorRepository.save(doctor2);

        patientRepository.save(patient1);

        receptionRepository.save(reception1);
        receptionRepository.save(reception2);
    }


}
