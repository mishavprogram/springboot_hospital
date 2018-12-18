package com.mvp.springboot.hospital.controller;

import com.mvp.springboot.hospital.entities.Result;
import com.mvp.springboot.hospital.service.ResultService;
import com.mvp.springboot.hospital.service.converter.ResultConverter;
import com.mvp.springboot.hospital.service.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/results")
@CrossOrigin
public class ResultController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private ResultConverter resultConverter;

    @GetMapping
    public List<ResultDto> getResults(){
        List<Result> results = resultService.findAll();
        return resultConverter.toDto(results);
    }

    @PostMapping
    public ResultDto create(@RequestBody ResultDto resultDto){
        Result result = resultConverter.toEntity(resultDto);
        result = resultService.create(result);
        return resultConverter.toDto(result);
    }
}
