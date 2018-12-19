package com.mvp.springboot.hospital.service.converter;

import com.mvp.springboot.hospital.entities.Reception;
import com.mvp.springboot.hospital.service.dto.ReceptionDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class ReceptionConverter implements Converter<ReceptionDto, Reception> {

    @Autowired
    private DoctorConverter doctorConverter;

    @Autowired
    private PatientConverter patientConverter;

    @Override
    public Reception toEntity(ReceptionDto dto) {
        if (dto == null){
            return null;
        }

        return Reception.builder()
            .id(dto.getId())
            .doctor(doctorConverter.toEntity(dto.getDoctor()))
            .patient(patientConverter.toEntity(dto.getPatient()))
            .year(dto.getLocalDate().getYear())
            .month(dto.getLocalDate().getMonth().getValue())
            .day(dto.getLocalDate().getDayOfMonth())
            .hour(dto.getLocalDate().getHour())//чи треба %24?
            .build();
    }

    @Override
    public ReceptionDto toDto(Reception entity) {
        if (entity == null){
            return null;
        }

        LocalDateTime localDateTime = LocalDateTime.of(entity.getYear(),
                                                       entity.getMonth(),
                                                       entity.getDay(),
                                                       entity.getHour(),
                                                       0);

        return ReceptionDto.builder()
            .id(entity.getId())
            .doctor(doctorConverter.toDto(entity.getDoctor()))
            .patient(patientConverter.toDto(entity.getPatient()))
            .localDate(localDateTime)
            .build();
    }
}
