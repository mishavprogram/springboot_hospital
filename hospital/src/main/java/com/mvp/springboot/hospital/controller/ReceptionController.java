package com.mvp.springboot.hospital.controller;

import com.mvp.springboot.hospital.entities.Reception;
import com.mvp.springboot.hospital.service.ReceptionService;
import com.mvp.springboot.hospital.service.converter.ReceptionConverter;
import com.mvp.springboot.hospital.service.dto.ReceptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/receptions")
public class ReceptionController {

    @Autowired
    private ReceptionService receptionService;

    @Autowired
    private ReceptionConverter receptionConverter;

    @GetMapping
    public List<ReceptionDto> getReceptions(){
        List<Reception> receptions = receptionService.findAll();
        return receptionConverter.toDto(receptions);
    }

}
