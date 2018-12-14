package com.mvp.springboot.hospital.service.converter;

import com.mvp.springboot.hospital.entities.Patient;
import com.mvp.springboot.hospital.service.dto.PatientDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatientConverter implements Converter<PatientDto, Patient> {

    @Override
    public Patient toEntity(PatientDto dto) {
        if (dto == null){
            return null;
        }

        return Patient.builder()
            .id(dto.getId())
            .name(dto.getName())
            .build();
    }

    @Override
    public PatientDto toDto(Patient entity) {
        if (entity == null){
            return null;
        }

        return PatientDto.builder()
            .id(entity.getId())
            .name(entity.getName())
            .build();
    }
}
