package com.mvp.springboot.hospital.service.converter;

import com.mvp.springboot.hospital.entities.Reception;
import com.mvp.springboot.hospital.service.dto.ReceptionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReceptionConverter implements Converter<ReceptionDto, Reception> {

    @Override
    public Reception toEntity(ReceptionDto dto) {
        if (dto == null){
            return null;
        }

        return Reception.builder()
            .id(dto.getId())
            .doctor(dto.getDoctor())
            .patient(dto.getPatient())
            .build();
    }

    @Override
    public ReceptionDto toDto(Reception entity) {
        if (entity == null){
            return null;
        }

        return ReceptionDto.builder()
            .id(entity.getId())
            .doctor(entity.getDoctor())
            .patient(entity.getPatient())
            .build();
    }
}
