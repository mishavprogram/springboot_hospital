package com.mvp.springboot.hospital.service;

import com.mvp.springboot.hospital.entities.Result;
import com.mvp.springboot.hospital.repositories.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> findAll(){
        return resultRepository.findAll();
    }

    public Result create(Result result){
        return resultRepository.save(result);
    }

}
