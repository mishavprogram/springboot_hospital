package com.mvp.springboot.hospital.controller;

import com.mvp.springboot.hospital.entities.Reception;
import com.mvp.springboot.hospital.service.ReceptionService;
import com.mvp.springboot.hospital.service.converter.ReceptionConverter;
import com.mvp.springboot.hospital.service.dto.ReceptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/receptions")
@CrossOrigin
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

    @PostMapping
    public ReceptionDto create(@RequestBody ReceptionDto receptionDto){
        Reception reception = receptionConverter.toEntity(receptionDto);
        reception = receptionService.create(reception);
        return receptionConverter.toDto(reception);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceptionDto> getForm(@PathVariable
                                                 long id) {
        ReceptionDto receptionDto = receptionService.findById(id);
        return ResponseEntity.ok(receptionDto);
    }

}
