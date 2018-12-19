package com.mvp.springboot.hospital.service.dto;

import com.mvp.springboot.hospital.entities.Doctor;
import com.mvp.springboot.hospital.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceptionDto {

    private Long id;

    private DoctorDto doctor;

    private PatientDto patient;

    private LocalDateTime localDate;

}