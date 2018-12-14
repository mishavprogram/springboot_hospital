package com.mvp.springboot.hospital.service.dto;

import com.mvp.springboot.hospital.entities.Doctor;
import com.mvp.springboot.hospital.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceptionDto {

    private Long id;

    private Doctor doctor;

    private Patient patient;

    /*private Date date;*/

}