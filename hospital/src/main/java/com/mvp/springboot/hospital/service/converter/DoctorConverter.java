package com.mvp.springboot.hospital.service.converter;

import com.mvp.springboot.hospital.entities.Doctor;
import com.mvp.springboot.hospital.service.dto.DoctorDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DoctorConverter implements Converter<DoctorDto, Doctor> {

    @Override
    public Doctor toEntity(DoctorDto dto) {
        if (dto == null){
            return null;
        }

        return Doctor.builder()
            .id(dto.getId())
            .name(dto.getName())
            .speciality(dto.getSpeciality())
            .build();
    }

    @Override
    public DoctorDto toDto(Doctor entity) {
        if (entity == null){
            return null;
        }

        return DoctorDto.builder()
            .id(entity.getId())
            .name(entity.getName())
            .speciality(entity.getSpeciality())
            .build();
    }
}
