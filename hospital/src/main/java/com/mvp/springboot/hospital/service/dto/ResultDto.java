package com.mvp.springboot.hospital.service.dto;

import com.mvp.springboot.hospital.entities.Reception;
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
public class ResultDto {

    private Long id;

    private Reception reception;

    private String info;

}
