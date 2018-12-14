package com.mvp.springboot.hospital.service;

import com.mvp.springboot.hospital.entities.Reception;
import com.mvp.springboot.hospital.repositories.ReceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionService {

    @Autowired
    private ReceptionRepository receptionRepository;

    public List<Reception> findAll(){
        return receptionRepository.findAll();
    }

    public Reception create(Reception reception){
        return receptionRepository.save(reception);
    }

}
