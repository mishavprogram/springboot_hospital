package com.mvp.springboot.hospital.service.converter;

import com.mvp.springboot.hospital.entities.Result;
import com.mvp.springboot.hospital.service.dto.ResultDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ResultConverter implements Converter<ResultDto, Result> {

    @Override
    public Result toEntity(ResultDto dto) {
        if (dto == null){
            return null;
        }

        return Result.builder()
            .id(dto.getId())
            .reception(dto.getReception())
            .info(dto.getInfo())
            .build();
    }

    @Override
    public ResultDto toDto(Result entity) {
        if (entity == null){
            return null;
        }

        return ResultDto.builder()
            .id(entity.getId())
            .reception(entity.getReception())
            .info(entity.getInfo())
            .build();
    }
}
