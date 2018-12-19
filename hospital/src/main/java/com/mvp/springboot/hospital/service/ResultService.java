package com.mvp.springboot.hospital.service;

import com.mvp.springboot.hospital.entities.Reception;
import com.mvp.springboot.hospital.entities.ReceptionStatus;
import com.mvp.springboot.hospital.entities.Result;
import com.mvp.springboot.hospital.repositories.ReceptionRepository;
import com.mvp.springboot.hospital.repositories.ResultRepository;
import com.mvp.springboot.hospital.service.converter.ResultConverter;
import com.mvp.springboot.hospital.service.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ReceptionRepository receptionRepository;

    @Autowired
    private ResultConverter resultConverter;

    public List<Result> findAll(){
        return resultRepository.findAll();
    }

    public Result create(Result result){
        Reception reception = result.getReception();
        reception.setStatus(ReceptionStatus.HAS_RESULT);
        receptionRepository.save(reception);
        return resultRepository.save(result);
    }

    public ResultDto findById(Long id){
        Result result = resultRepository.getOne(id);
        return resultConverter.toDto(result);
    }
}
