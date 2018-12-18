package com.mvp.springboot.hospital.service.converter;

import com.mvp.springboot.hospital.entities.Reception;
import com.mvp.springboot.hospital.service.dto.ReceptionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
            .doctor(entity.getDoctor())
            .patient(entity.getPatient())
            .localDate(localDateTime)
            .build();
    }
}
