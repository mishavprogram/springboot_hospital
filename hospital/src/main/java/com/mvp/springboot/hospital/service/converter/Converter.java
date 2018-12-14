package com.mvp.springboot.hospital.service.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter <D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    default List<E> toEntity(List<D> dtos){
        return dtos.stream()
            .map(this::toEntity)
            .collect(Collectors.toList());
    }

    default List<D> toDto(List<E> entities){
        return entities.stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

}
